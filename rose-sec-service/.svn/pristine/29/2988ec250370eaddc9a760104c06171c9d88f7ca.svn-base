package com.zrt.sec.web.org;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zrt.commons.AppException;
import com.zrt.commons.PageInit;
import com.zrt.commons.ResultMap;
import com.zrt.commons.utils.MapEntityConverter;
import com.zrt.mybatis.domain.SysSecOrg;
import com.zrt.sec.service.org.OrgService;

@RestController
@RequestMapping("/v1.0/sec")
public class OrgController {
	private static final Logger log = LoggerFactory.getLogger(OrgController.class);
	@Resource(name="orgServiceImpl")
	private OrgService orgService;
	/**
	 * 组织机构管理-组织机构列表查询
	 * @param jsonMap
	 * @return
	 * @throws AppException
	 */
    @RequestMapping(value="/orgList", method = RequestMethod.POST, headers = "Accept=application/json")
	public Map<String, Object> orgList(@RequestBody Map<String, Object> appMap) throws Exception{
		log.info("Server端的OrgController中orgList方法");
		ResultMap resultMap=new ResultMap();
		try {
			PageInit.setPage(appMap);
			PageHelper.startPage(Integer.parseInt(appMap.get("pageNo").toString()), 
								 Integer.parseInt(appMap.get("maxResult").toString()));
			appMap.put("group_type", "1");//状态正常的
			appMap.put("sec_enabled", "1");//状态为1正常的
			//获取组织机构列表
			List<SysSecOrg> dataList=orgService.orgList(appMap);
			
			List<Map<String,Object>> list = MapEntityConverter.getMapFromList(new String[]{"org_id","root_org_id","parent_org_id","org_code","org_name","org_enabled","org_desc","create_date_time"}, 
																			  dataList, 
																			  SysSecOrg.class);
			
			PageInfo<SysSecOrg> pageInfo = new PageInfo<>(dataList);
			
			resultMap.data(list);
			resultMap.success().map().put("count", pageInfo.getTotal());
			
			return resultMap.map();
		} catch (AppException e) {
			log.error("json error", e);
			throw new AppException("查询组织机构列表信息失败!");
		}
	}

	/**
	 * 组织机构管理-组织机构信息查询
	 * @param jsonMap
	 * @return
	 * @throws AppException
	 */
    @RequestMapping(value="/orgSearch", method = RequestMethod.POST, headers = "Accept=application/json")
	public Map<String, Object> orgSearch(@RequestBody Map<String, Object> appMap) throws Exception{
		log.info("Server端的OrgController中orgSearch方法");
		ResultMap resultMap=new ResultMap();
		try {
			//获取组织机构信息
			Map<String, Object> data=orgService.orgSearch(appMap);
			resultMap.success().data(data);
			return resultMap.map();
		} catch (Exception e) {
			log.error("json error", e);
			throw new AppException("查询组织机构信息失败!");
		}
	}
	
	/**
	 * 组织机构管理-组织机构新增
	 * @param jsonMap
	 * @return
	 * @throws AppException
	 */
    @RequestMapping(value="/orgSave", method = RequestMethod.POST, headers = "Accept=application/json")
	public Map<String, Object> orgSave(@RequestBody Map<String, Object> appMap) throws Exception{
		log.info("Server端的OrgController中orgSave方法");
		ResultMap resultMap=new ResultMap();
		try {
			//组织机构新增
			orgService.orgSave(appMap);
			resultMap.success().sucmsg("新增成功!");
			return resultMap.map();
		} catch (Exception e) {
			log.error("json error", e);
			throw new AppException("组织机构新增失败!");
		}
	}
	

	/**
	 * 机构模糊检索
	 * @param jsonMap
	 * @return
	 * @throws AppException
	 */
    @RequestMapping(value="/orgNameSearch", method = RequestMethod.POST, headers = "Accept=application/json")
	public Map<String, Object> orgNameSearch(@RequestBody Map<String, Object> appMap) throws Exception{
		log.info("Server端的OrgController中orgNameSearch方法");
		ResultMap resultMap=new ResultMap();
		try {
			//获取组织机构信息
			List<Map<String,Object>> dataList = orgService.orgNameSearch(appMap);
			resultMap.success().data(dataList);
			return resultMap.map();
		} catch (Exception e) {
			log.error("json error", e);
			throw new AppException("机构模糊检索失败!");
		}
	}
    
	/**
	 * 组织机构管理-组织机构更新
	 * @param jsonMap
	 * @return
	 * @throws AppException
	 */
    @RequestMapping(value="/orgUpdate", method = RequestMethod.POST, headers = "Accept=application/json")
	public Map<String, Object> orgUpdate(@RequestBody Map<String, Object> appMap) throws Exception{
		log.info("Server端的OrgController中orgUpdate方法");
		ResultMap resultMap=new ResultMap();
		try {
			//组织机构更新
			orgService.orgUpdate(appMap);
			resultMap.success().sucmsg("更新成功!");
			return resultMap.map();
		} catch (Exception e) {
			log.error("json error", e);
			throw new AppException("更新组织机构信息失败!");
		}
	}
	
	/**
	 * 组织机构删除
	 * @param appMap
	 * @return
	 * @throws Exception
	 *//*
    @RequestMapping(value="/orgDelete", method = RequestMethod.POST, headers = "Accept=application/json")
	@Transactional(rollbackFor={Throwable.class},propagation=Propagation.REQUIRED)
	public Map<String, Object> orgDelete(@RequestBody Map<String, Object> appMap) throws Exception{
		log.info("Server端的OrgController中orgDelete方法");
		ResultMap resultMap=new ResultMap();
		try {
			//组织机构新增
			orgService.orgDelete(appMap);
			resultMap.success().sucmsg("删除成功!");
			return resultMap.map();
		} catch (Exception e) {
			log.error("json error", e);
			throw new AppException("删除组织机构信息失败!");
		}
	}*/
    
    /**
     * 所有机构列表树形
     * @param appMap
     * @return
     * @throws Exception
     */
    @RequestMapping(value="/orgAllList", method = RequestMethod.POST, headers = "Accept=application/json")
   	public Map<String, Object> orgAllList(@RequestBody Map<String, Object> appMap) throws Exception{
   		log.info("Server端的OrgController中orgAllList方法");
   		ResultMap resultMap=new ResultMap();
   		try {
   			
   			appMap.put("group_type", "1");//状态正常的
			appMap.put("sec_enabled", "1");//状态为1正常的
   			//获取组织机构列表
   			List<Map<String, Object>> dataList=orgService.orgAllList(appMap);
   			
   			resultMap.success().data(dataList);
   			return resultMap.map();
   		} catch (AppException e) {
   			log.error("json error", e);
   			throw new AppException("查询组织机构列表信息失败!");
   		}
   	}

    /**
     * 待撤销部门列表
     * @param map
     * @return
     * @throws AppException
     */
    @RequestMapping(value="/preCancelOrgList", method = RequestMethod.POST, headers = "Accept=application/json")
    public Map<String, Object> preCancelOrgList(@RequestBody Map<String, Object> appMap) throws AppException {
        log.info("Server端的FriendController中preCancelOrgList方法");
        ResultMap resultMap = new ResultMap();

        try {
			appMap.put("group_type", "0");//待撤销状态的
			appMap.put("sec_enabled", "1");//状态为1正常的
			//获取组织机构列表
			List<Map<String, Object>> dataList=orgService.orgAllList(appMap);
			resultMap.success().data(dataList);
			return resultMap.map();
        } catch (AppException e) {
            log.error("json error", e);
            throw new AppException("获取待撤销部门列表信息失败!");
        }
        catch (Exception e) {
            log.error("json error", e);
            throw new AppException("获取待撤销部门列表信息失败!");
        }
    }
}
