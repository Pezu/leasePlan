package com.assignment.spring.util;

import com.assignment.spring.api.dto.Weather;
import com.assignment.spring.persistence.entity.WeatherEntity;
import com.assignment.spring.api.dto.WeatherResponse;
import com.assignment.spring.web.dto.WeatherDto;

public class Mapper {

    public static WeatherEntity apiToEntity(WeatherResponse response) {

        return WeatherEntity.builder()
                .city(response.getName())
                .temperature(response.getMain().getTemp())
                .country(response.getSys().getCountry())
                .build();
    }

    public static WeatherDto entityToDto(WeatherEntity entity) {

        return WeatherDto.builder()
                .city(entity.getCity())
                .temperature(entity.getTemperature())
                .country(entity.getCountry())
                .build();
    }
}
