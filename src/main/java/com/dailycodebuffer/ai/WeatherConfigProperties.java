package com.dailycodebuffer.ai;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("x-rapidapi")
public record WeatherConfigProperties(String key, String host, String url) {
}
