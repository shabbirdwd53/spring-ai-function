package com.dailycodebuffer.ai;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Description;

import java.util.function.Function;

@Configuration
public class Config {

    private final WeatherConfigProperties weatherConfigProperties;

    public Config(WeatherConfigProperties weatherConfigProperties) {
        this.weatherConfigProperties = weatherConfigProperties;
    }

    @Bean
    @Description("Get the weather in location")
    public Function<WeatherService.Request, WeatherService.Response>
    getWeather() {
        return new WeatherService(weatherConfigProperties);
    }
}
