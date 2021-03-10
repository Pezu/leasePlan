package com.assignment.spring.service;

import com.assignment.spring.api.WeatherClient;
import com.assignment.spring.api.dto.WeatherResponse;
import com.assignment.spring.exception.UnknownException;
import com.assignment.spring.persistence.entity.WeatherEntity;
import com.assignment.spring.persistence.repository.WeatherRepository;
import com.assignment.spring.util.TestUtil;
import com.assignment.spring.web.dto.WeatherDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;

import org.mockito.junit.MockitoJUnitRunner;

import java.util.HashMap;
import java.util.Optional;

@RunWith(MockitoJUnitRunner.class)
public class WeatherServiceTest {



	@InjectMocks
	private WeatherService weatherService;

	@Mock
	private WeatherRepository weatherRepository;

	@Mock
	private WeatherClient weatherClient;

	@Captor
	private ArgumentCaptor<WeatherEntity> weatherCaptor;

	@Test
	public void getWeather_noResponse() {

		when(weatherClient.getWeather(any(), any())).thenReturn(Optional.empty());
		assertThrows(UnknownException.class, () -> {
			weatherService.getWeather(TestUtil.CITY);
		});

	}


	@Test
	public void getWeather_withResponse() {

		WeatherResponse response = TestUtil.getMockWeatherResponse();

		when(weatherClient.getWeather(any(), any())).thenReturn(Optional.of(response));
		when(weatherRepository.save(any())).then(AdditionalAnswers.returnsFirstArg());

		WeatherDto dto = weatherService.getWeather(TestUtil.CITY);

		assertEquals(dto.getCity(), TestUtil.CITY);
		assertEquals(dto.getTemperature(), TestUtil.TEMP);
		assertEquals(dto.getCountry(), TestUtil.COUNTRY);

	}

	@Test
	public void getWeather_savedEntity() {

		WeatherResponse response = TestUtil.getMockWeatherResponse();

		when(weatherClient.getWeather(any(), any())).thenReturn(Optional.of(response));
		when(weatherRepository.save(weatherCaptor.capture())).then(AdditionalAnswers.returnsFirstArg());

		weatherService.getWeather(TestUtil.CITY);

		WeatherEntity captured = weatherCaptor.getValue();
		assertEquals(captured.getCity(), TestUtil.CITY);
		assertEquals(captured.getCountry(), TestUtil.COUNTRY);
		assertEquals(captured.getTemperature(), TestUtil.TEMP);

	}

}
