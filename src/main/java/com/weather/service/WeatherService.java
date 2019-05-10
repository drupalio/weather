package com.weather.service;

import com.weather.controller.dto.OpenWeatherResponse;

public interface WeatherService {
	OpenWeatherResponse getWeatherByCityId(String cityId);
}
