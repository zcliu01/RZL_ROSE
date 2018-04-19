package org.activiti.engine.impl.bpmn.parser.handler;

import org.activiti.bpmn.model.ExclusiveGateway;
import org.activiti.editor.language.json.converter.SelfExtensionConstans;
import org.activiti.engine.impl.bpmn.parser.BpmnParse;
import org.activiti.engine.impl.pvm.process.ActivityImpl;

public class SelfExclusiveGatewayParseHandler extends ExclusiveGatewayParseHandler{

	@Override
	protected void executeParse(BpmnParse bpmnParse, ExclusiveGateway gateway) {
	//调用上层的解析
	super.executeParse(bpmnParse, gateway);
	ActivityImpl activity = bpmnParse.getCurrentScope().findActivity(gateway.getId());
	//Map<String, Object> operationMap = parseUserTaskOperations(bpmnParse, userTask);
	//将扩展属性设置给activity
	activity.setProperty(SelfExtensionConstans.EXTENSION_ELEMENT_OPERATIONS, gateway.getExtensionElements());
	}
		
}
