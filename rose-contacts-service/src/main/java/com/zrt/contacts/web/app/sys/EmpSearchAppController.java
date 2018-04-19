package com.zrt.contacts.web.app.sys;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.zrt.commons.AppException;
import com.zrt.commons.ResultMap;
import com.zrt.commons.utils.PreConditionHandleUtils;
import com.zrt.contacts.service.empsearchwindow.EmpSearchWindowService;
import com.zrt.contacts.service.friend.FriendService;
import com.zrt.contacts.service.friendgroup.FriendGroupService;
import com.zrt.contacts.service.sys.SysSecEmpService;
import com.zrt.contacts.service.sys.SysSecOrgService;

/**
 * @author aizhou
 * @ClassName:EmpContactsController
 * @Description:<p>通讯录控制器 </p>
 */
@RestController
@RequestMapping(value = "/v1.0/empSearchApp")
public class EmpSearchAppController {

    /**
     * 日志记录
     */
    private static final Logger log = LoggerFactory.getLogger(EmpSearchAppController.class);

    @Resource
    private SysSecOrgService sysSecOrgService;
    @Resource
    private SysSecEmpService sysSecEmpService;
    @Resource
    private FriendService friendService;
    @Resource
    private FriendGroupService friendGroupService;
    @Resource
    private EmpSearchWindowService empSearchWindowService;

    /**
     * @throws AppException
     * @Title: searchContancts
     * @Description: 通讯录下 按员工和按部门查询 void
     */
    @RequestMapping(value = "/contactsList", method = RequestMethod.POST, headers = "Accept=application/json")
    @ResponseBody
    public Map<String, Object> contactsList(@RequestBody Map<String, Object> map) throws Exception {
        log.info("appServer端的EmpSearchAppController中contactsList方法");

        // 响应结果集封装
        ResultMap resultMap = new ResultMap();

        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        try {
            String empId = (String) map.get("emp_id");
            PreConditionHandleUtils.searchConditionHandle(map);

            if (map.get("status") == null) {
                map.put("status", "1");
            }
            String status = map.get("status").toString();

            if (StringUtils.isNotBlank(map.get("type").toString())) {
                if ("0".equals(map.get("type"))) {// type 0 按人员

                    // 1.常用联系人统计总数
                    Integer contactsCount = friendService.contactsCount(empId, status);
                    map.put("contactsCount", contactsCount);
                    // 2.我的群组 统计总数
                    Integer friendGroupCount = friendGroupService.friendGroupCount(empId);
                    // 上述参数中map.get("memberStatus").toString()暂时设为null
                    map.put("friendGroupCount", friendGroupCount);
                    // 3.所有通讯录员工明细 (如果有检索词，通过检索词查询，若没有，则查询所有联系人)
                    List<Map<String, Object>> empList = sysSecEmpService.empsList(map);
                    map.put("empList", empList);
                    list.add(map);
                }

                if ("1".equals(map.get("type"))) {// 按部门：部门名称+部门包含人员数

                    // 获取组织机构信息
                    List<Map<String, Object>> orgList = sysSecOrgService.orgList(map);
                    map.put("orgList", orgList);
                    list.add(map);

                }
            }
            resultMap.success().sucmsg("通讯录下的员工和部门查询成功!");
            resultMap.success().data(list);
            return resultMap.map();
        } catch (Exception e) {
            log.error("json error", e);
            throw new AppException("通讯录下的员工和部门查询失败!");
        }

    }

    /**
     * @throws AppException
     * @Title:
     * @Description: 根据部门查询员工列表 void
     */
    @RequestMapping(value = "/empListByOrg", method = RequestMethod.POST, headers = "Accept=application/json")
    @ResponseBody
    public Map<String, Object> empListByOrg(@RequestBody Map<String, Object> map) throws Exception {
        log.info("appServer端的EmpSearchAppController中empListByOrg方法");

        ResultMap resultMap = new ResultMap();
    /*	String orgId = map.get("org_id").toString();*/
        try {
            List<Map<String, Object>> list = sysSecEmpService.empListByOrg(map);
			/*String status = (String)map.get("status");
			if (StringUtils.isNotBlank(orgId)) {
				Map<String, Object> data = sysSecEmpService.empListByOrg(orgId,status);
				resultMap.success().data(data);
				return resultMap.map();
			} else {
				return null;
			}*/
            resultMap.success().data(list);
            return resultMap.map();
        } catch (AppException e) {
            log.error("json error", e);
            return resultMap.failure().errmsg(e.getMessage()).map();
        } catch (Exception e) {
            log.error("json error", e);
            return resultMap.failure().errmsg("通讯录 下 按照部门查询员工列表失败!").map();
        }
    }

    /**
     * App端根据员工id 查询个人详情
     *
     * @param map
     * @return
     * @throws AppException
     */
    @RequestMapping(value = "/selectEmpDetails", method = RequestMethod.POST, headers = "Accept=application/json")
    public Map<String, Object> selectEmpDetails(@RequestBody Map<String, Object> map) throws AppException {
        log.info("App端的EmpSearchAppController中selectEmpDetails方法");

        String userEmpId = (String) map.get("emp_id");//获取当前登录用户的员工ID
        String friendEmpId = (String) map.get("friend_emp_id");//获取需要查看员工个人详情的员工ID
        if (StringUtils.isBlank(friendEmpId)) {
            throw new AppException("获取不到员工ID!");
        }
        ResultMap resultMap = new ResultMap();
        try {
            Map<String, Object> returnMap = new HashMap<String, Object>();
            returnMap = sysSecEmpService.selectEmpDetails(friendEmpId);
            //判断两人是否是常用联系人的关系
            String is_friend_status = "";
            if (userEmpId == friendEmpId || friendEmpId.equals(userEmpId)) {
                is_friend_status = "-1"; //表示点击的是自己的个人详情
            } else {
                int count = friendService.selectIsNotFriend(friendEmpId, userEmpId);
                System.out.println(count);
                is_friend_status = (count > 0) ? "1" : "0";//1表示常用联系人,0表示不是常用联系人

            }
            returnMap.put("is_friend_status", is_friend_status);

            String empSex = returnMap.get("emp_sex").toString();
            if (StringUtils.isNotBlank(empSex)) {
                if ("M".equals(empSex)) {
                    returnMap.put("emp_sex", "男");
                }
                if ("F".equals(empSex)) {
                    returnMap.put("emp_sex", "女");
                }
            }

            Map<String, Object> upEmpMap = sysSecEmpService.selectUpEmpDetails(friendEmpId);
            if (upEmpMap != null) {
                returnMap.put("manage_emp_id", upEmpMap.get("manage_emp_id"));
                returnMap.put("manage_emp_name", upEmpMap.get("manage_emp_name"));
                returnMap.put("charge_emp_id", upEmpMap.get("charge_emp_id"));
                returnMap.put("charge_emp_name", upEmpMap.get("charge_emp_name"));
            } else {
                returnMap.put("manage_emp_id", "");
                returnMap.put("manage_emp_name", "");
                returnMap.put("charge_emp_id", "");
                returnMap.put("charge_emp_name", "");
            }
//				String upEmpName = sysSecEmpService.selectUpEmpName(friendEmpId);//查询直接上级姓名
            resultMap.success().data(returnMap);
            return resultMap.map();

        } catch (Exception e) {
            log.error("json error", e);
            throw new AppException("获取个人详情失败!");
        }
    }


    /**
     * @throws AppException
     * @Title:
     * @Description: 根据员工ID 获取 个人履历 void
     */
    @RequestMapping(value = "/selectEmpWorkRedeploy", method = RequestMethod.POST, headers = "Accept=application/json")
    @ResponseBody
    public Map<String, Object> selectEmpWorkRedeploy(@RequestBody Map<String, Object> map) throws AppException {
        log.info("appServer端的EmpSearchAppController中selectEmpWorkRedeploy方法");

        ResultMap resultMap = new ResultMap();
        String empId = map.get("friend_emp_id").toString();
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        try {
            if (StringUtils.isNotBlank(empId)) {
                list = sysSecEmpService.selectEmpWorkRedeploy(empId);
                resultMap.success().data(list);
                return resultMap.map();
            } else {
                return null;
            }
        } catch (Exception e) {
            log.error("json error", e);
            throw new AppException("获取个人履历列表失败!");
        }

    }

    /**
     * @throws AppException
     * @Title:
     * @Description: 根据用户ID 获取职位讯息 void
     */
    @RequestMapping(value = "/selectEmpPositionDetails", method = RequestMethod.POST, headers = "Accept=application/json")
    @ResponseBody
    public Map<String, Object> selectEmpPositionDetails(@RequestBody Map<String, Object> map) throws AppException {
        log.info("App端的EmpSearchAppController中selectEmpPositionDetails方法");

        ResultMap resultMap = new ResultMap();
        String friendEmpId = map.get("friend_emp_id").toString();

        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        try {
            if (StringUtils.isNotBlank(friendEmpId)) {
                list = sysSecEmpService.selectEmpPositionDetails(friendEmpId, null);
                resultMap.success().data(list);
                return resultMap.map();
            } else {
                return null;
            }
        } catch (Exception e) {
            log.error("json error", e);
            throw new AppException("获取职位讯息列表失败!");
        }

    }

    /**
     * 通用的联系人搜索功能,可根据员工id、员工编号、员工全拼、员工简写、员工姓名、部门姓名、部门Id
     *
     * @param map
     * @return
     * @throws AppException
     */
    @RequestMapping(value = "/commonEmpSearch", method = RequestMethod.POST, headers = "Accept=application/json")
    public Map<String, Object> commonEmpSearch(@RequestBody Map<String, Object> map) throws Exception {
        log.info("App端的EmpSearchWindowController中commonEmpSearch方法");
        ResultMap resultMap = new ResultMap();

        try {
            List<Map<String, Object>> list = empSearchWindowService.commonEmpSearch(map);
            resultMap.success().data(list);
            return resultMap.map();
        } catch (AppException e) {
            log.error("json error", e);
            return resultMap.failure().errmsg(e.getMessage()).map();
        } catch (Exception e) {
            log.error("json error", e);
            return resultMap.failure().errmsg("通用的联系人搜索查询失败!").map();
        }

    }

    /**
     * 讯息收件人按职级排序--迭代4
     *
     * @param map
     * @return
     * @throws AppException
     */
    @RequestMapping(value = "/infoReceiverOrderByRank", method = RequestMethod.POST, headers = "Accept=application/json")
    public Map<String, Object> infoReceiverOrderByRank(@RequestBody Map<String, Object> map) throws Exception {
        log.info("App端的EmpSearchWindowController中infoReceiverOrderByRank方法");
        ResultMap resultMap = new ResultMap();

        try {
            List<Map<String, Object>> list = empSearchWindowService.infoReceiverOrderByRank(map);
            resultMap.success().data(list);
            return resultMap.map();
        } catch (AppException e) {
            log.error("json error", e);
            return resultMap.failure().errmsg(e.getMessage()).map();
        } catch (Exception e) {
            log.error("json error", e);
            return resultMap.failure().errmsg("通用的联系人搜索查询失败!").map();
        }

    }

    /**
     * IM组织通讯录同步
     *
     * @param map
     * @return
     * @throws AppException
     */
    @RequestMapping(value = "/contactsImList", method = RequestMethod.POST, headers = "Accept=application/json")
    public Map<String, Object> contactsImList(@RequestBody Map<String, Object> map) throws Exception {
        log.info("App端的EmpSearchWindowController中contactsImList方法");
        ResultMap resultMap = new ResultMap();

        try {
            Map<String, Object> resMap = empSearchWindowService.contactsImList(map);
            resultMap.success().data(resMap);
            return resultMap.map();
        } catch (AppException e) {
            log.error("json error", e);
            return resultMap.failure().errmsg(e.getMessage()).map();
        } catch (Exception e) {
            log.error("json error", e);
            return resultMap.failure().errmsg("IM组织通讯录同步失败!").map();
        }

    }
}
