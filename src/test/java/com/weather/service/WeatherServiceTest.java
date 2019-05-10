package com.weather.service;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.weather.client.OpenWeatherApiClient;
import com.weather.controller.dto.OpenWeatherResponse;
import com.weather.exception.ResponseStatusException;
import com.weather.service.impl.WeatherServiceImpl;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class WeatherServiceTest {
	@InjectMocks
	private WeatherServiceImpl service;
	
	@Mock
	private OpenWeatherApiClient restclient;
	

	private HashMap <String, String> parameters;
	
	@Before
	public void setUp() {			
		parameters = new HashMap<>();
		parameters.put("id", "2643743");
	} 
	
	@Test
	public void request200ValidResponseTest() throws Exception {
		
		Mockito.when(restclient.callOpenWeatherService(parameters))
			.thenReturn(this.buildValidOpenWeatherCorrectResponse());
		
		OpenWeatherResponse response = this.service.getWeatherByCityId("2643743");
		
		assertEquals("London",response.getCity());
		assertEquals("Rain", response.getWeather());
		assertEquals("light rain", response.getWeatherDesc());
		assertEquals("138.97222222222223", response.getTempCe());
		assertEquals("282.15", response.getTempFa());
		assertEquals("11:17 PM", response.getSunrise());
		assertEquals("02:36 PM", response.getSunset());
	}
	
	@Test(expected = ResponseStatusException.class)
	public void request404ExceptionResponseTest() throws Exception {
		
		Mockito.when(restclient.callOpenWeatherService(parameters))
			.thenReturn(this.buildNotFoundResponse());
		
		this.service.getWeatherByCityId("2643743");
	}
	
	@Test(expected = ResponseStatusException.class)
	public void request500ExceptionResponseTest() throws Exception {
		
		Mockito.when(restclient.callOpenWeatherService(parameters))
			.thenReturn(this.buildInternalServerErrorResponse());
		
		this.service.getWeatherByCityId("2643743");
	}
	
	private ResponseEntity<String> buildValidOpenWeatherCorrectResponse() {

		return new ResponseEntity<String>("{\"coord\":{\"lon\":-0.13,\"lat\":51.51},\"weather\":[{\"id\":500,\"main\":\"Rain\",\"description\":\"light rain\",\"icon\":\"10n\"}],\"base\":\"stations\",\"main\":{\"temp\":282.15,\"pressure\":1009,\"humidity\":93,\"temp_min\":279.82,\"temp_max\":284.26},\"visibility\":9000,\"wind\":{\"speed\":3.1,\"deg\":210},\"clouds\":{\"all\":93},\"dt\":1557527584,\"sys\":{\"type\":1,\"id\":1502,\"message\":0.0084,\"country\":\"GB\",\"sunrise\":1557461825,\"sunset\":1557517010},\"id\":2643743,\"name\":\"London\",\"cod\":200}", HttpStatus.OK);
	}
	
	private ResponseEntity<String> buildNotFoundResponse() {

		return new ResponseEntity<String>("{\"cod\": \"404\",\"message\": \"city not found\"}", HttpStatus.NOT_FOUND);
	}
	
	private ResponseEntity<String> buildInternalServerErrorResponse() {

		return new ResponseEntity<String>("{\"cod\": \"500\",\"message\": \"Internal Server Error\"}", HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
