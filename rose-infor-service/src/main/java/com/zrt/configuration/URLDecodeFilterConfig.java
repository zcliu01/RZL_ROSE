package com.zrt.configuration;

import com.zrt.commons.URLDecodeFilter;
import org.springframework.boot.context.embedded.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;


@Configuration
public class URLDecodeFilterConfig {
	
	@Bean
    public FilterRegistrationBean someFilterRegistration() {

        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(urlDecodeFilter());
        registration.addUrlPatterns("/*");
//        registration.addInitParameter("paramName", "paramValue");
        registration.setName("urlDecodeFilter");
        return registration;
    }

    @Bean(name = "urlDecodeFilter")
    public Filter urlDecodeFilter() {
        return new URLDecodeFilter();
    }
}
