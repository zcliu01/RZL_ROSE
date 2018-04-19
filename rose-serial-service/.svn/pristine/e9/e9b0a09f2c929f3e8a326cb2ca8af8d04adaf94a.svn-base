package com.zrt.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.zrt.commons.SimpleHandlerExceptionResolver;



@Configuration
public class HandlerExceptionResolverConfig {

	@Bean
	public SimpleHandlerExceptionResolver simpleHandlerExceptionResolver(){
		SimpleHandlerExceptionResolver resolver = new SimpleHandlerExceptionResolver();
		resolver.setOrder(-1);
		return resolver;
	}
}
