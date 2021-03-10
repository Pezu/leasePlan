package com.assignment.spring.web;

import com.assignment.spring.api.WeatherClient;
import com.assignment.spring.api.dto.WeatherResponse;
import com.assignment.spring.persistence.entity.WeatherEntity;
import com.assignment.spring.persistence.repository.WeatherRepository;
import com.assignment.spring.service.WeatherService;
import com.assignment.spring.web.dto.WeatherDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequiredArgsConstructor
public class WeatherController {

    private final RestTemplate restTemplate;

    private final WeatherRepository weatherRepository;

    private final WeatherClient weatherClient;

    private final WeatherService weatherService;

    @GetMapping("/weather/{city}")
    public WeatherDto test(@PathVariable String city) {

        return weatherService.getWeather(city);
    }
}
