package org.activiti.editor.language.json.converter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.activiti.bpmn.model.BaseElement;
import org.activiti.bpmn.model.BpmnModel;
import org.activiti.bpmn.model.ExclusiveGateway;
import org.activiti.bpmn.model.ExtensionElement;
import org.activiti.bpmn.model.FlowElement;
import org.activiti.bpmn.model.FlowElementsContainer;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;

/**
 * 自定义解析节点属性
 * @author wwfu
 *
 */
public class SelfExclusiveGatewayJsonConverter extends ExclusiveGatewayJsonConverter{

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
		convertersToBpmnMap.put(STENCIL_GATEWAY_EXCLUSIVE,SelfExclusiveGatewayJsonConverter.class);
	}

	public static void fillBpmnTypes(Map<Class<? extends BaseElement>, Class<? extends BaseBpmnJsonConverter>> convertersToJsonMap) {
		convertersToJsonMap.put(ExclusiveGateway.class, SelfExclusiveGatewayJsonConverter.class);
	}
	
	
	
	public void UserTaskExtensions(FlowElement flowElement,JsonNode elementNode) {
        //获取扩展属性标签元素
		Map<String, List<ExtensionElement>> extensionElements=new HashMap<String, List<ExtensionElement>>();
		List<ExtensionElement> listExtension=new ArrayList<ExtensionElement>();
		System.out.println("elementNode fbexpression"+getPropertyValueAsString(SelfExtensionConstans.FB_EXPRESSION, elementNode));

		//流程规则节点属性
		ExtensionElement fbrule=new ExtensionElement();
		fbrule.setNamespace("http://activiti.org/bpmn");//默认activiti 的命名空间,得指定，不然校验不过去
		//fbrule.setNamespacePrefix("activiti");//用默认的命名空间前缀，可以不指定
		fbrule.setName(SelfExtensionConstans.FB_EXPRESSION);
		fbrule.setElementText(getPropertyValueAsString(SelfExtensionConstans.FB_EXPRESSION, elementNode));//接收人value
		
		listExtension.add(fbrule);
		extensionElements.put(SelfExtensionConstans.EXTENSION_ELEMENT_OPERATIONS, listExtension);
		flowElement.setExtensionElements(extensionElements);
    }
}
