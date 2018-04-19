package com.zrt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
@EnableDiscoveryClient
@EnableFeignClients(basePackages = "com.zrt.client")
@SpringBootApplication
@ComponentScan("com.zrt")
public class SecApplication {
	
	public static void main(String[] args) {
		System.setProperty("java.net.preferIPv4Stack","true");
		SpringApplication.run(SecApplication.class, args);
	}

}
