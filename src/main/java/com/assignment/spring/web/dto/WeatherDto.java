package com.assignment.spring.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Builder
@Data
public class WeatherDto {

    private String city;

    private String country;

    private Double temperature;
}
