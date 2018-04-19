package org.activiti.engine.impl.bpmn.parser.handler;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.activiti.bpmn.model.ExtensionElement;
import org.activiti.bpmn.model.UserTask;
import org.activiti.editor.language.json.converter.SelfExtensionConstans;
import org.activiti.engine.impl.bpmn.parser.BpmnParse;
import org.activiti.engine.impl.bpmn.parser.handler.UserTaskParseHandler;
import org.activiti.engine.impl.pvm.process.ActivityImpl;

public class SelfUserTaskParseHandler extends UserTaskParseHandler{

	@Override
	protected void executeParse(BpmnParse bpmnParse, UserTask userTask) {
	//调用上层的解析
	super.executeParse(bpmnParse, userTask);
	ActivityImpl activity = bpmnParse.getCurrentScope().findActivity(userTask.getId());
	//Map<String, Object> operationMap = parseUserTaskOperations(bpmnParse, userTask);
	//将扩展属性设置给activity
	activity.setProperty(SelfExtensionConstans.EXTENSION_ELEMENT_OPERATIONS, userTask.getExtensionElements());
	}
	
	public Map<String, Object> parseUserTaskOperations(BpmnParse bpmnParse, UserTask userTask) {
		Map<String, Object> operationMap = new HashMap<String, Object>();
		userTask.getExtensionElements();
		//获取扩展属性标签元素
		 List<ExtensionElement> ExtensionList = userTask.getExtensionElements().get(SelfExtensionConstans.EXTENSION_ELEMENT_OPERATIONS);
		//获取扩展属性标签元素
		operationMap.put("self", "self");
		return operationMap;
		}
		
}
