package com.zrt.configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

import redis.clients.jedis.JedisPoolConfig;

/**
 * 
 * @author wwfu
 *
 */
//@Configuration
//@EnableAutoConfiguration
public class RedisConfig {  
	private static final Logger logger = LoggerFactory.getLogger(RedisConfig.class);  
      
    @Bean
    @ConfigurationProperties(prefix="spring.redis.pool")  
    public JedisPoolConfig getRedisConfig(){  
        JedisPoolConfig config = new JedisPoolConfig();  
        return config;  
    }  
      
    @Bean
    @ConfigurationProperties(prefix="spring.redis") 
    public JedisConnectionFactory getConnectionFactory(){  
        JedisConnectionFactory factory = new JedisConnectionFactory();  
        JedisPoolConfig config = getRedisConfig();  
        factory.setPoolConfig(config);  
        logger.info("JedisConnectionFactory bean init success.");  
        return factory;  
    }  
      
      
    @Bean  
    public RedisTemplate<?, ?> getRedisTemplate(){  
        RedisTemplate<?,?> template = new StringRedisTemplate(getConnectionFactory());  
        return template;  
    }  
}  
