package com.weather.service.impl;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.weather.client.OpenWeatherApiClient;
import com.weather.controller.dto.OpenWeatherResponse;
import com.weather.exception.ResponseStatusException;
import com.weather.service.WeatherService;
import com.weather.service.model.WeatherServiceResponse;

@Component
public class WeatherServiceImpl implements WeatherService{
	@Autowired
	private OpenWeatherApiClient restclient;
	
	@Override
	public OpenWeatherResponse getWeatherByCityId(String cityId) {
		OpenWeatherResponse response = null;
		ObjectMapper mapper = new ObjectMapper();
		HashMap <String, String> parameters = new HashMap<>();
		parameters.put("id",cityId);
		try {
			ResponseEntity<String> entity=restclient.callOpenWeatherService(parameters);
			WeatherServiceResponse apiresponse = mapper.readValue(entity.getBody(), WeatherServiceResponse.class);
			response= mapResponse(apiresponse);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,e.getMessage());
		}
		
		return response;
	}

	private OpenWeatherResponse mapResponse(WeatherServiceResponse apiresponse) {
		return new OpenWeatherResponse().mapResponse(apiresponse);
	}
	
	
}
