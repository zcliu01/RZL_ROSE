package com.zrt.configuration;

import javax.xml.ws.Endpoint;

import org.springframework.boot.context.embedded.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;

import com.zrt.vif.service.tcmp.OaToTcmpService;
import com.zrt.vif.service.tcmp.impl.OaToTcmpServiceImpl;

//@Configuration
public class WebServiceConfig {

	// @Bean
	// public ServletRegistrationBean dispatcherServlet() {
	// return new ServletRegistrationBean(new CXFServlet(), "/zrt/*");
	// }
	//
	// @Bean(name = Bus.DEFAULT_BUS_ID)
	// public SpringBus springBus() {
	// return new SpringBus();
	// }
	//
	// @Bean
	// public OaToTcmpService oaToTcmpService() {
	// return new OaToTcmpServiceImpl();
	// }
	//
	// @Bean
	// public Endpoint endpoint() {
	// EndpointImpl endpoint = new EndpointImpl(springBus(), oaToTcmpService());
	// endpoint.publish("/tcmp");
	// return endpoint;
	// }

}
