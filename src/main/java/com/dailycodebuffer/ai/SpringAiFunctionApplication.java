package com.dailycodebuffer.ai;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@EnableConfigurationProperties(WeatherConfigProperties.class)
@SpringBootApplication
public class SpringAiFunctionApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringAiFunctionApplication.class, args);
	}

}
