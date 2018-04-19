package com.zrt.contacts.web.manage.friendgroup;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.zrt.commons.AppException;
import com.zrt.commons.ResultMap;
import com.zrt.commons.utils.PreConditionHandleUtils;
import com.zrt.contacts.service.friend.FriendService;
import com.zrt.contacts.service.friendgroup.FriendGroupService;
import com.zrt.contacts.service.serial.SerialService;
import com.zrt.contacts.service.sys.SysSecOrgService;
import com.zrt.mybatis.domain.EmpContactsFriendGroup;

/**
 * Created by msKui on 2017/3/6.
 */
@RestController
@RequestMapping("/v1.0/friendGroup")
public class FriendGroupController {
    private static final Logger log = LoggerFactory.getLogger(FriendGroupController.class);

    @Autowired
    FriendGroupService friendGroupService;
    @Autowired
    FriendService friendService;
    @Autowired
    SysSecOrgService sysSecOrgService;
    @Autowired
    private SerialService serialService;

    /**
     * 创建群组窗口
     * @param map
     * @return
     * @throws AppException
     */
    @RequestMapping(value="/friendGroupSavePage", method = RequestMethod.POST, headers = "Accept=application/json")
    public Map<String, Object> friendGroupSavePage(@RequestBody Map<String, Object> map) throws AppException {
        log.info("Server端的FriendGroupController中friendGroupSavePage方法");
        ResultMap resultMap = new ResultMap();
        
        try {
        	String empId = map.get("emp_id").toString();
        	
        	PreConditionHandleUtils.searchConditionHandle(map);//对搜索条件预处理
        	String search = map.get("search").toString();//获取搜索内容
        	if(StringUtils.isBlank(empId)){
        		resultMap.failure().sucmsg("获取不到当前登录员工的ID!");
        	}else if(StringUtils.isNotBlank(empId)){
        		
        		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        		//"type": " ",列表类型,0:常用联系人1：组织结构  2：我的群组 3：待撤销部门
        		//1.查询常用联系人列表
        	    //  map.put("status","1");//默认查询在职员工
        			List<Map<String, Object>> friendList = friendService.friendList(map);
        			map.put("friendList", friendList);
        		//2.组织结构列表
        			List<Map<String,Object>> orgEmpList = friendService.orgAllList(map);
        			map.put("orgEmpList", orgEmpList);
        		//3.我的群组列表
        			List<Map<String, Object>> friendGroupList = friendGroupService.selectFriendGroupTree(map);
        			map.put("friendGroupList", friendGroupList);
        		//4.待撤销部门列表
        		    List<Map<String, Object>> preCancelOrgList = sysSecOrgService.preCancelOrgList(map);
        			map.put("preCancelOrgList", preCancelOrgList);
        			
        			list.add(map);
        			resultMap.success().data(list);
        	        
        	}
        	return resultMap.map();
        } catch (Exception e) {
            log.error("json error", e);
            throw new AppException("创建群组页面加载失败!");
        }
		

    }
    
    
    /**
     * 新增群组--第2次迭代(ok)
     * @param map
     * @return
     * @throws AppException
     */
    @RequestMapping(value="/friendGroupSave", method = RequestMethod.POST, headers = "Accept=application/json")
    public Map<String, Object> friendGroupSave(@RequestBody Map<String, Object> map) throws AppException {
        log.info("Server端的FriendGroupController中friendGroupSave方法");
        ResultMap resultMap = new ResultMap();

        try {
        	
        	 friendGroupService.friendGroupSave(map);
        	 resultMap.success().sucmsg("新增成功!");
            return resultMap.map();
        }  catch (AppException e) {
			log.error("json error", e);
			return resultMap.failure().errmsg(e.getMessage()).map();
		}catch (Exception e) {
			log.error("json error", e);
			return resultMap.failure().errmsg("群组创建失败!").map();
		}

    }

    /**
     * 群组详情--第2次迭代(ok)
     * @param map
     * @return
     * @throws AppException
     */
    @RequestMapping(value="/friendGroupDetails", method = RequestMethod.POST, headers = "Accept=application/json")
    public Map<String, Object> friendGroupDetails(@RequestBody Map<String, Object> map) throws AppException {
        log.info("Server端的FriendGroupController中friendGroupDetails方法");
        ResultMap resultMap = new ResultMap();

        try {
        	String empId = map.get("emp_id").toString();
        	/*String friendGroupId = map.get("friend_group_id").toString();
        	if(map.get("friend_group_id")==null||StringUtils.isBlank(friendGroupId)){
        		throw new AppException("当前传入的friend_group_id有错误！");
        	}*/
        	if(map.get("emp_id")==null||StringUtils.isBlank(empId)){
        		throw new AppException("当前传入的emp_id有错误！");
        	}
        	List<Map<String,Object>>  list = friendGroupService.friendGroupDetails(map);
             
            resultMap.success().data(list);
            return resultMap.map();
        } catch (Exception e) {
            log.error("json error", e);
            throw new AppException("获取群组详情失败!");
        }

    }
    
    /**
     * 解散群组或者退出群组--第2次迭代(ok)
     * @param map
     * @return
     * @throws AppException
     */
    @RequestMapping(value="/groupDismissOrQuit", method = RequestMethod.POST, headers = "Accept=application/json")
    public Map<String, Object> groupDismissOrQuit(@RequestBody Map<String, Object> map) throws Exception {
        log.info("Server端的FriendGroupController中groupDismissOrQuit方法");
        ResultMap resultMap = new ResultMap();

        try {
        	
        	friendGroupService.groupDismissOrQuit(map);
        	 resultMap.success().sucmsg("解散该群或者退出该群成功!");
             return resultMap.map();
        }  catch (AppException e) {
			log.error("json error", e);
			return resultMap.failure().errmsg(e.getMessage()).map();
		}catch (Exception e) {
			log.error("json error", e);
			return resultMap.failure().errmsg("解散或者退出群组失败!").map();
		}
    }

    
    /**
     * 删除群组
     * @param map
     * @return
     * @throws AppException
     */
    @RequestMapping(value="/friendGroupDelete", method = RequestMethod.POST, headers = "Accept=application/json")
    public Map<String, Object> friendGroupDelete(@RequestBody Map<String, Object> map) throws AppException {
        log.info("Server端的FriendGroupController中friendGroupDelete方法");
        ResultMap resultMap = new ResultMap();

        try {
            if(map.size() <= 0 || map.get("friend_group_id") == null || map.get("friend_group_id").toString().equals(""))
                throw new AppException("传入的参数错误");

            EmpContactsFriendGroup contactsFriendGroup = new EmpContactsFriendGroup();
            contactsFriendGroup.setFriendGroupId(map.get("friend_group_id").toString());

            friendGroupService.friendGroupDelete(contactsFriendGroup);

            resultMap.success().sucmsg("删除成功");
            return resultMap.map();
        } catch (Exception e) {
            log.error("json error", e);
            throw new AppException("群组删除失败!");
        }
    }

    /**
     * 更新群组
     * @param map
     * @return
     * @throws AppException
     */
    @RequestMapping(value="/friendGroupUpdate", method = RequestMethod.POST, headers = "Accept=application/json")
    public Map<String, Object> friendGroupUpdate(@RequestBody Map<String, Object> map) throws AppException {
        log.info("Server端的FriendGroupController中friendGroupUpdate方法");
        ResultMap resultMap = new ResultMap();

        try {
            friendGroupService.friendGroupUpdate(map);
            resultMap.success().sucmsg("更新成功");
            return resultMap.map();
        }  catch (AppException e) {
			log.error("json error", e);
			return resultMap.failure().errmsg(e.getMessage()).map();
		}catch (Exception e) {
			log.error("json error", e);
			return resultMap.failure().errmsg("更新群组信息失败!").map();
		}
    }

    /**
     * 查找群组树
     * @param map
     * @return
     * @throws AppException
     */
    @RequestMapping(value="/friendGroupTree", method = RequestMethod.POST, headers = "Accept=application/json")
    public Map<String, Object> friendGroupTree(@RequestBody Map<String, Object> map) throws AppException {
        log.info("Server端的FriendGroupController中friendGroupTree方法");
        ResultMap resultMap = new ResultMap();

        try {
        	List<Map<String,Object>> list = friendGroupService.friendGroupTree(map);
            resultMap.success().data(list);
            return resultMap.map();
        }  catch (AppException e) {
			log.error("json error", e);
			return resultMap.failure().errmsg(e.getMessage()).map();
		}catch (Exception e) {
			log.error("json error", e);
			return resultMap.failure().errmsg("查询我的群组列表失败!").map();
		}
       
    }

}
