package com.assignment.spring.util;

import com.assignment.spring.api.dto.Main;
import com.assignment.spring.api.dto.Sys;
import com.assignment.spring.api.dto.WeatherResponse;
import com.assignment.spring.persistence.entity.WeatherEntity;
import com.assignment.spring.web.dto.WeatherDto;

public class TestUtil {

    public static final String CITY = "city";
    public static final String API_KEY = "api-key";
    public static final double TEMP = 10d;
    public static final String COUNTRY = "RO";

    public static WeatherResponse getMockWeatherResponse() {

        WeatherResponse response = new WeatherResponse();
        response.setName(CITY);
        Main main = new Main();
        main.setTemp(TEMP);
        response.setMain(main);
        Sys sys = new Sys();
        sys.setCountry(COUNTRY);
        response.setSys(sys);
        return response;
    }
}
