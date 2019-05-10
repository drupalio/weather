/**
 * 
 */
package com.weather.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.weather.controller.dto.OpenWeatherResponse;
import com.weather.service.WeatherService;

/**
 * Controller for Weather App. petitions
 * @author ricardo.morales
 *
 */
@Controller
public class WeatherController {
	private static final Logger LOGGER = LogManager.getLogger(WeatherController.class);
	
	@Autowired
	private WeatherService weatherService;
	
	@GetMapping(value = "/")
	public ModelAndView index() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("index");   
	    return modelAndView;
	}

	@GetMapping(value = "/weather")
	public ModelAndView getWeatherByCityId(@RequestParam("city")  String cityId) {
		LOGGER.info("Call - method: Get - Path: wather");
		OpenWeatherResponse response= weatherService.getWeatherByCityId(cityId);
		return new ModelAndView("weather").addObject("response", response);
	}
}
