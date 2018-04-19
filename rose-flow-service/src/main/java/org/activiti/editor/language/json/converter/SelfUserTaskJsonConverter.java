package org.activiti.editor.language.json.converter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.activiti.bpmn.model.BaseElement;
import org.activiti.bpmn.model.BpmnModel;
import org.activiti.bpmn.model.ExtensionElement;
import org.activiti.bpmn.model.FlowElement;
import org.activiti.bpmn.model.FlowElementsContainer;
import org.activiti.bpmn.model.UserTask;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;

/**
 * 自定义解析节点属性
 * @author wwfu
 *
 */
public class SelfUserTaskJsonConverter extends UserTaskJsonConverter{

	public void convertToJson(BaseElement baseElement,
			ActivityProcessor processor, BpmnModel model,
			FlowElementsContainer container, ArrayNode shapesArrayNode,
			double subProcessX, double subProcessY) {
		super.convertToJson(baseElement, processor, model, container,
				shapesArrayNode, subProcessX, subProcessY);
	}
	
	
	/**
	 * 解析自定义的扩展属性信息
	 */
	@Override
	protected FlowElement convertJsonToElement(JsonNode elementNode, JsonNode modelNode, Map<String, JsonNode> shapeMap) {
		FlowElement flowElement = super.convertJsonToElement(elementNode,modelNode, shapeMap);
		//把json里面的数据，扩展到节点里面去
		UserTaskExtensions(flowElement,elementNode);
		return flowElement;
	}
	public static void fillTypes(Map<String, Class<? extends BaseBpmnJsonConverter>> convertersToBpmnMap,
            Map<Class<? extends BaseElement>, Class<? extends BaseBpmnJsonConverter>> convertersToJsonMap) {
		fillJsonTypes(convertersToBpmnMap);
		fillBpmnTypes(convertersToJsonMap);
	}
	public static void fillJsonTypes(Map<String, Class<? extends BaseBpmnJsonConverter>> convertersToBpmnMap) {
		convertersToBpmnMap.put(STENCIL_TASK_USER,SelfUserTaskJsonConverter.class);
	}

	public static void fillBpmnTypes(Map<Class<? extends BaseElement>, Class<? extends BaseBpmnJsonConverter>> convertersToJsonMap) {
		convertersToJsonMap.put(UserTask.class, SelfUserTaskJsonConverter.class);
	}
	
	
	
	public void UserTaskExtensions(FlowElement flowElement,JsonNode elementNode) {
        //获取扩展属性标签元素
		Map<String, List<ExtensionElement>> extensionElements=new HashMap<String, List<ExtensionElement>>();
		List<ExtensionElement> listExtension=new ArrayList<ExtensionElement>();
		System.out.println("elementNode receiverids"+getPropertyValueAsString("receiverids", elementNode));

		//接收人属性
		ExtensionElement receiverids=new ExtensionElement();
		receiverids.setNamespace("http://activiti.org/bpmn");//默认activiti 的命名空间,得指定，不然校验不过去
		//receiverids.setNamespacePrefix("activiti");//用默认的命名空间前缀，可以不指定
		receiverids.setName(SelfExtensionConstans.USER_TASK_RECEIVERIDS);
		receiverids.setElementText(getPropertyValueAsString(SelfExtensionConstans.USER_TASK_RECEIVERIDS, elementNode));//接收人value
		//是否提醒节点属性
		ExtensionElement isremind=new ExtensionElement();
		isremind.setNamespace("http://activiti.org/bpmn");//默认activiti 的命名空间,得指定，不然校验不过去
		isremind.setName(SelfExtensionConstans.USER_TASK_ISREMIND);
		isremind.setElementText(getPropertyValueAsString(SelfExtensionConstans.USER_TASK_ISREMIND, elementNode));//是否提醒value
		//提醒方式节点属性
		ExtensionElement remindtype=new ExtensionElement();
		remindtype.setNamespace("http://activiti.org/bpmn");//默认activiti 的命名空间,得指定，不然校验不过去
		remindtype.setName(SelfExtensionConstans.USER_TASK_REMINDTYPE);
		remindtype.setElementText(getPropertyValueAsString(SelfExtensionConstans.USER_TASK_REMINDTYPE, elementNode));//提醒方式value
		//提醒周期节点属性
		ExtensionElement remindcycle=new ExtensionElement();
		remindcycle.setNamespace("http://activiti.org/bpmn");//默认activiti 的命名空间,得指定，不然校验不过去
		remindcycle.setName(SelfExtensionConstans.USER_TASK_REMINDCYCLE);
		remindcycle.setElementText(getPropertyValueAsString(SelfExtensionConstans.USER_TASK_REMINDCYCLE, elementNode));//提醒周期value
		//流程规则节点属性
		ExtensionElement fbrule=new ExtensionElement();
		fbrule.setNamespace("http://activiti.org/bpmn");//默认activiti 的命名空间,得指定，不然校验不过去
		fbrule.setName(SelfExtensionConstans.USER_TASK_FBRULE);
		fbrule.setElementText(getPropertyValueAsString(SelfExtensionConstans.USER_TASK_FBRULE, elementNode));;//流程规则value
		//是否提前审批节点属性
		ExtensionElement isadvance=new ExtensionElement();
		isadvance.setNamespace("http://activiti.org/bpmn");//默认activiti 的命名空间,得指定，不然校验不过去
		isadvance.setName(SelfExtensionConstans.USER_TASK_ISADVANCE);
		isadvance.setElementText(getPropertyValueAsString(SelfExtensionConstans.USER_TASK_ISADVANCE, elementNode));;//是否提前审批value
		//是否通知流程所有人节点属性
		ExtensionElement isnotify=new ExtensionElement();
		isnotify.setNamespace("http://activiti.org/bpmn");//默认activiti 的命名空间,得指定，不然校验不过去
		isnotify.setName(SelfExtensionConstans.USER_TASK_ISNOTIFY);
		isnotify.setElementText(getPropertyValueAsString(SelfExtensionConstans.USER_TASK_ISNOTIFY, elementNode));;//是否通知流程所有人value
		//通知方式节点属性
		ExtensionElement notifytype=new ExtensionElement();
		notifytype.setNamespace("http://activiti.org/bpmn");//默认activiti 的命名空间,得指定，不然校验不过去
		notifytype.setName(SelfExtensionConstans.USER_TASK_NOTIFYTYPE);
		notifytype.setElementText(getPropertyValueAsString(SelfExtensionConstans.USER_TASK_NOTIFYTYPE, elementNode));;//通知方式value

		//主分管设置
		ExtensionElement upmanage=new ExtensionElement();
		upmanage.setNamespace("http://activiti.org/bpmn");//默认activiti 的命名空间,得指定，不然校验不过去
		upmanage.setName(SelfExtensionConstans.USER_TASK_UPMANAGE);
		upmanage.setElementText(getPropertyValueAsString(SelfExtensionConstans.USER_TASK_UPMANAGE, elementNode));;//主分管

		//是否支持指定审批人
		ExtensionElement isassignee=new ExtensionElement();
		isassignee.setNamespace("http://activiti.org/bpmn");//默认activiti 的命名空间,得指定，不然校验不过去
		isassignee.setName(SelfExtensionConstans.USER_TASK_ISASSIGNEE);
		isassignee.setElementText(getPropertyValueAsString(SelfExtensionConstans.USER_TASK_ISASSIGNEE, elementNode));;//主分管

		
		listExtension.add(receiverids);
		listExtension.add(isremind);
		listExtension.add(remindtype);
		listExtension.add(remindcycle);
		listExtension.add(fbrule);
		listExtension.add(isadvance);
		listExtension.add(isnotify);
		listExtension.add(notifytype);
		listExtension.add(upmanage);
		listExtension.add(isassignee);
		extensionElements.put(SelfExtensionConstans.EXTENSION_ELEMENT_OPERATIONS, listExtension);
		flowElement.setExtensionElements(extensionElements);
    }
}
