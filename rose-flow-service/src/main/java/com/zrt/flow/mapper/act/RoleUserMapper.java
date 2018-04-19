package com.zrt.flow.mapper.act;

import java.util.List;
import java.util.Map;

public interface RoleUserMapper {

	//查询审批角色包含的审批人员
	List<Map<String, Object>> roleUserList(Map<String, Object> map);
	

}