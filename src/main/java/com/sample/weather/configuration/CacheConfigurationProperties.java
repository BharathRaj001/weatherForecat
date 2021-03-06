package com.sample.weather.configuration;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cache.annotation.EnableCaching;

import lombok.Data;



@EnableCaching
@Data
@ConfigurationProperties(prefix = "cache")
class CacheConfigurationProperties {

	private long timeoutSeconds;
	private int redisPort;
	private String redisHost;
	private Map<String, Long> cacheExpirations = new HashMap<>();
}
