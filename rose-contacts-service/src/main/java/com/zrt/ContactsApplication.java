package com.zrt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;
@EnableCircuitBreaker
@EnableDiscoveryClient
@SpringBootApplication
@ComponentScan("com.zrt")
@EnableFeignClients(basePackages = "com.zrt.client")
@EnableScheduling
public class ContactsApplication {

	public static void main(String[] args) {
		System.setProperty("java.net.preferIPv4Stack","true");
		SpringApplication.run(ContactsApplication.class, args);
	}
}