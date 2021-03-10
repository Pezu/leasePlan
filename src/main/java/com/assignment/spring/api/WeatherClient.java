package com.assignment.spring.api;

import com.assignment.spring.api.dto.WeatherResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@FeignClient(value = "weatherClient", url = "${weather.url}")
public interface WeatherClient {

    @GetMapping
    Optional<WeatherResponse> getWeather(@RequestParam("q") String cityName,
                                        @RequestParam("APPID") String applicationKey);
}
