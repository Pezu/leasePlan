package com.assignment.spring.service;

import com.assignment.spring.exception.UnknownException;
import com.assignment.spring.persistence.repository.WeatherRepository;
import com.assignment.spring.api.WeatherClient;
import com.assignment.spring.api.dto.WeatherResponse;
import com.assignment.spring.util.Mapper;
import com.assignment.spring.web.dto.WeatherDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class WeatherService{

    private final WeatherRepository weatherRepository;

    private final WeatherClient weatherClient;

    @Value("${weather.api-key}")
    private String apiKey;

    public WeatherDto getWeather(String city) {

        Optional<WeatherResponse> response = weatherClient.getWeather(city, apiKey);

        return response.map(Mapper::apiToEntity)
                .map(weatherRepository::save)
                .map(Mapper::entityToDto)
                .orElseThrow(() -> new UnknownException());



    }
}
