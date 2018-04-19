package com.zrt.flow.service.roleCheck;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.zrt.commons.MapEntityConverter;
import com.zrt.flow.mapper.roleFlow.RoleFlowMapper;
import com.zrt.mybatis.domain.FbBusRole;
import com.zrt.mybatis.domain.FbBusType;
import com.zrt.mybatis.domain.FbBusTypeExample;
import com.zrt.mybatis.domain.FbBusUserRole;
import com.zrt.mybatis.domain.FbBusUserRoleExample;
import com.zrt.mybatis.domain.FbBusUserRoleExample.Criteria;
import com.zrt.mybatis.domain.FbRoleTemplate;
import com.zrt.mybatis.domain.FbRoleTemplateExample;
import com.zrt.mybatis.mapper.FbBusRoleMapper;
import com.zrt.mybatis.mapper.FbBusTemplateMapper;
import com.zrt.mybatis.mapper.FbBusTypeMapper;
import com.zrt.mybatis.mapper.FbBusUserRoleMapper;
import com.zrt.mybatis.mapper.FbRoleTemplateMapper;

@Service
public class RoleCheckServiceImpl implements RoleCheckService {

	@Autowired
	private FbBusRoleMapper fbBusRoleMapper;
	@Autowired
	private FbBusUserRoleMapper fbBusUserRoleMapper;
	@Autowired
	private FbRoleTemplateMapper fbRoleTemplateMapper;
	@Autowired
	private RoleFlowMapper roleFlowMapper;
	@Autowired
	private FbBusTemplateMapper fbBusTemplateMapper;
	@Autowired
	private FbBusTypeMapper fbBusTypeMapper;

	@Override
	@Transactional(rollbackFor = { Throwable.class }, propagation = Propagation.REQUIRED)
	public void roleSave(Map<String, Object> appMap) throws Exception {
		FbBusRole fbBusRole = (FbBusRole) MapEntityConverter.getEntityFromMap(appMap, FbBusRole.class);
		fbBusRoleMapper.insert(fbBusRole);
	}

	@Override
	@Transactional(rollbackFor = { Throwable.class }, propagation = Propagation.REQUIRED)
	public void roleUpdate(Map<String, Object> appMap) throws Exception {
		FbBusRole fbBusRole = (FbBusRole) MapEntityConverter.getEntityFromMap(appMap, FbBusRole.class);
		fbBusRoleMapper.updateByPrimaryKey(fbBusRole);
	}

	@Override
	@Transactional(rollbackFor = { Throwable.class }, propagation = Propagation.REQUIRED)
	public void roleDelete(Map<String, Object> appMap) throws Exception {

		// 删除角色同时删除该角色下绑定的员工
		FbBusUserRoleExample example = new FbBusUserRoleExample();
		Criteria criteria = example.createCriteria();
		criteria.andRoleIdEqualTo((String) (String) appMap.get("role_id"));
		fbBusUserRoleMapper.deleteByExample(example);
		// 删除角色信息
		fbBusRoleMapper.deleteByPrimaryKey((String) appMap.get("role_id"));
		// 获取角色类型
		String roleType = (String) appMap.get("role_type");
		if ("2".equals(roleType)) {
			// 如果是流程权限，则还要删除流程权限信息
			FbRoleTemplateExample fbRoleTemplateExample = new FbRoleTemplateExample();
			com.zrt.mybatis.domain.FbRoleTemplateExample.Criteria fbRoleTemplateCriteria = fbRoleTemplateExample
					.createCriteria();
			fbRoleTemplateCriteria.andRoleIdEqualTo((String) appMap.get("role_id"));
			fbRoleTemplateMapper.deleteByExample(fbRoleTemplateExample);
		}

	}

	@Override
	@Transactional(rollbackFor = { Throwable.class }, propagation = Propagation.REQUIRED)
	public void roleEmpAdd(Map<String, Object> appMap) throws Exception {
		FbBusUserRole fbBusUserRole = (FbBusUserRole) MapEntityConverter.getEntityFromMap(appMap, FbBusUserRole.class);
		fbBusUserRoleMapper.insert(fbBusUserRole);

	}

	@Override
	@Transactional(rollbackFor = { Throwable.class }, propagation = Propagation.REQUIRED)
	public void roleEmpBatchDelete(Map<String, Object> appMap) throws Exception {
		@SuppressWarnings("unchecked")
		List<Map<String, Object>> empids = (List<Map<String, Object>>) appMap.get("param");
		for (Map<String, Object> empidmap : empids) {
			FbBusUserRoleExample example = new FbBusUserRoleExample();
			Criteria criteria = example.createCriteria();
			criteria.andRoleIdEqualTo((String) appMap.get("role_id"));
			criteria.andEmpIdEqualTo((String) empidmap.get("emp_id"));
			fbBusUserRoleMapper.deleteByExample(example);
		}

	}

	/**
	 * 角色流程功能查询
	 */
	@Transactional(rollbackFor = { Throwable.class }, propagation = Propagation.REQUIRED)
	@Override
	public Map<String, Object> roleFlowList(Map<String, Object> appMap) throws Exception {
		// 根据用户查询该用户拥有的流程角色
		// List<Map<String, Object>>
		// hasRoleList=roleFlowMapper.roleFlowList(appMap);
		String roleId = (String) appMap.get("role_id");
		FbRoleTemplateExample example = new FbRoleTemplateExample();
		example.createCriteria().andRoleIdEqualTo(roleId);
		List<FbRoleTemplate> fbRoleTemplateList = fbRoleTemplateMapper.selectByExample(example);
		// 查询运行中的流程
		List<Map<String, Object>> roleList = roleFlowMapper.flowList(appMap);
		// 查询类型列表
		FbBusTypeExample fbBusTypeExample = new FbBusTypeExample();
		fbBusTypeExample.createCriteria().andTEnabledEqualTo("1");
		List<FbBusType> list = fbBusTypeMapper.selectByExample(fbBusTypeExample);

		if (list != null && list.size() > 0) {
			for (FbBusType fbBusType : list) {
				Map<String, Object> dataMap = new HashMap<String, Object>();
				dataMap.put("is_role", false);
				dataMap.put("t_name", fbBusType.gettName());
				dataMap.put("t_code", fbBusType.getId());
				dataMap.put("parent_id", fbBusType.getParentId());
				roleList.add(dataMap);
			}
		}
		for (Map<String, Object> map : roleList) {
			String tCode = (String) map.get("t_code");
			map.put("is_role", false);
			for (FbRoleTemplate tt : fbRoleTemplateList) {
				String ttCode = tt.gettCode();
				if (tCode.equals(ttCode)) {
					map.put("is_role", true);
					break;
				}

			}
		}

		Map<String, Object> resMap = new HashMap<String, Object>();
		resMap.put("role_id", appMap.get("role_id"));
		resMap.put("list", roleList);
		return resMap;
	}

	/**
	 * 角色流程绑定
	 */
	@Transactional(rollbackFor = { Throwable.class }, propagation = Propagation.REQUIRED)
	@Override
	public Map<String, Object> roleFlowSet(Map<String, Object> appMap) throws Exception {
		// 先删除该角色绑定已有的流程功能
		String roleId = (String) appMap.get("role_id");
		FbRoleTemplateExample example = new FbRoleTemplateExample();
		com.zrt.mybatis.domain.FbRoleTemplateExample.Criteria criteria = example.createCriteria();
		criteria.andRoleIdEqualTo(roleId);
		fbRoleTemplateMapper.deleteByExample(example);
		// 然后在新增绑定的流程
		List<Map<String, Object>> tempList = (List<Map<String, Object>>) appMap.get("param");
		for (Map<String, Object> map : tempList) {
			String tCode = (String) map.get("t_code");// 流程模版编号
			FbRoleTemplate fbRoleTemplate = new FbRoleTemplate();
			fbRoleTemplate.setRoleId(roleId);
			fbRoleTemplate.settCode(tCode);
			fbRoleTemplateMapper.insert(fbRoleTemplate);
		}
		return null;
	}

}
