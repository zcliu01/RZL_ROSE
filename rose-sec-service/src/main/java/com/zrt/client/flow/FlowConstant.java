package com.zrt.client.flow;

public interface FlowConstant {
	String HYSTRIX_TIMEOUT = "3000";

	String FLOW_INSTANCE = "flow";
    
	/**审批角色新增*/
	String FB_BUS_ROLE_SAVE="/v1.0/roleCheck/roleSave";
	
	/**审批角色更新*/
	String FB_BUS_ROLE_UPDATE="/v1.0/roleCheck/roleUpdate";
	/**审批角色删除*/
	String FB_BUS_ROLE_DELETE="/v1.0/roleCheck/roleDelete";
	/**审批角色员工绑定*/
	String FB_BUS_USER_ROLE_SAVE="/v1.0/roleCheck/roleEmpAdd";
	/**审批角色员工删除*/
	String FB_BUS_USER_ROLE_DELETE="/v1.0/roleCheck/roleEmpBatchDelete";
	/**流程角色列表查询*/
	String FB_ROLE_TEMPLATE_SEARCH="/v1.0/secFlow/roleFlowList";
	/**流程角色绑定*/
	String FB_ROLE_TEMPLATE_SET="/v1.0/secFlow/roleFlowSet";
}
