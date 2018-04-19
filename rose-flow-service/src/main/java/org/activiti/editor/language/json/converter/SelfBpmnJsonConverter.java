package org.activiti.editor.language.json.converter;

import java.util.Map;

import org.activiti.bpmn.model.BaseElement;
import org.activiti.editor.language.json.converter.BpmnJsonConverter;

public class SelfBpmnJsonConverter extends BpmnJsonConverter{
	 
	public static Map<String, Class<? extends BaseBpmnJsonConverter>> getConvertersToBpmnMap(){

		return convertersToBpmnMap;
	}
	
	public static Map<Class<? extends BaseElement>, Class<? extends BaseBpmnJsonConverter>> getConvertersToJsonMap(){

		return convertersToJsonMap;
	}
	
}
