package com.zrt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigServer
@EnableDiscoveryClient
@EnableAutoConfiguration
public class ConfigServerApplication {
	
	public static void main(String[] args) {
		System.setProperty("jsse.enableSNIExtension", "false");
		SpringApplication.run(ConfigServerApplication.class, args);
	}
}
