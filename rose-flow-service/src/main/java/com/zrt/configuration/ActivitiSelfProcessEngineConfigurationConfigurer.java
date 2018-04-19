package com.zrt.configuration;

import java.util.ArrayList;
import java.util.List;

import org.activiti.engine.impl.bpmn.parser.handler.SelfExclusiveGatewayParseHandler;
import org.activiti.engine.impl.bpmn.parser.handler.SelfUserTaskParseHandler;
import org.activiti.engine.impl.persistence.StrongUuidGenerator;
import org.activiti.engine.parse.BpmnParseHandler;
import org.activiti.spring.SpringProcessEngineConfiguration;
import org.activiti.spring.boot.ProcessEngineConfigurationConfigurer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class ActivitiSelfProcessEngineConfigurationConfigurer implements ProcessEngineConfigurationConfigurer{

	private static final Logger log = LoggerFactory.getLogger(ActivitiSelfProcessEngineConfigurationConfigurer.class);
	@Override
	public void configure(SpringProcessEngineConfiguration processEngineConfiguration) {
		processEngineConfiguration.setActivityFontName("宋体");
		processEngineConfiguration.setLabelFontName("宋体");
		processEngineConfiguration.setAnnotationFontName("宋体");
		processEngineConfiguration.setIdGenerator(new StrongUuidGenerator());
		
		 
		//自定义json类型
		//List<VariableType> listVariableType= processEngineConfiguration.getCustomPreVariableTypes();
//		if(listVariableType==null){
//			listVariableType=new ArrayList<VariableType>();
//		}
//		listVariableType.add(new SelfJsonType());
//		processEngineConfiguration.setCustomPreVariableTypes(listVariableType);
//		
		//自定义解析类
		List<BpmnParseHandler> bpmnParseHandlerList= processEngineConfiguration.getCustomDefaultBpmnParseHandlers();
		if(bpmnParseHandlerList==null){
			bpmnParseHandlerList=new ArrayList<BpmnParseHandler>();
		}
		bpmnParseHandlerList.add(new SelfUserTaskParseHandler());
		bpmnParseHandlerList.add(new SelfExclusiveGatewayParseHandler());

		processEngineConfiguration.setCustomDefaultBpmnParseHandlers(bpmnParseHandlerList);
		log.info("SelftProcessEngineConfigurationConfigurer#############");
		log.info("fontName="+processEngineConfiguration.getActivityFontName());
		log.info("IdGenerator="+processEngineConfiguration.getIdGenerator().getNextId());
//		log.info("selfJson size="+processEngineConfiguration.getCustomPreVariableTypes().size());
		log.info("self SelfUserTaskParseHandler="+processEngineConfiguration.getCustomDefaultBpmnParseHandlers().size());



	}

}
