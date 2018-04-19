package com.zrt.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@EnableCircuitBreaker
@EnableDiscoveryClient
@EnableFeignClients(basePackages = "com.zrt.gateway.api.client")
//@EnableHystrix
@SpringBootApplication
@ComponentScan(basePackages="com.zrt")
@ServletComponentScan
public class GateWayApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(GateWayApplication.class, args);
	}
}
