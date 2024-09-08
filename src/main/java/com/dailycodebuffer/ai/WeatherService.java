package com.dailycodebuffer.ai;

import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestClient;

import java.util.List;
import java.util.function.Function;

public class WeatherService implements Function<WeatherService.Request, WeatherService.Response> {

    private final WeatherConfigProperties weatherConfigProperties;
    private final RestClient restClient;

    public WeatherService(WeatherConfigProperties weatherConfigProperties) {
        this.weatherConfigProperties = weatherConfigProperties;
        this.restClient = RestClient.create(weatherConfigProperties.url());
    }

    @Override
    public Response apply(Request request) {
        //return new Response(30.0, Unit.C);
        MultiValueMap<String, String> map
                = new LinkedMultiValueMap<>();

        map.add("x-rapidapi-host",weatherConfigProperties.host());
        map.add("x-rapidapi-key",weatherConfigProperties.key());

        Response response
                = restClient.get()
                .uri("/{city}/EN", request.location())
                .headers(httpHeaders -> httpHeaders.addAll(map))
                .retrieve()
                .body(Response.class);
        return response;
    }

    public record Request(String location) {}
    public record Response(Main main, List<Weather> weather) {}

    public record Main(double temp,
                       double feels_like,
                       double temp_min,
                       double temp_max) {}

    public record Weather(String description) {}

}
