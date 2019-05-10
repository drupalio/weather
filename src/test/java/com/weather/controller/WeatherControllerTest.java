/**
 * 
 */
package com.weather.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.ModelAndView;

import com.weather.controller.dto.OpenWeatherResponse;
import com.weather.exception.ResponseStatusException;
import com.weather.service.WeatherService;

/**
 * @author jose.luna
 *
 */
@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class WeatherControllerTest {
	
	@InjectMocks
	private WeatherController weatherController;
	
	@Mock
	private WeatherService weatherService;
	
	@Test
	public void requestToHomePageTest() throws Exception {
		ModelAndView modelAndView = weatherController.index();
		assertNotNull(modelAndView);
		assertEquals("index", modelAndView.getViewName());	
	}
	
	
	@Test
	public void requestToValidResultPageTest() throws Exception {
		Mockito.when(weatherService.getWeatherByCityId("2643743"))
			.thenReturn(this.createValidWeatherResponse());

		ModelAndView modelAndView = weatherController.getWeatherByCityId("2643743");
		assertNotNull(modelAndView.getModel().get("response"));
		assertEquals("weather", modelAndView.getViewName());
		
	}
	

	@Test(expected = ResponseStatusException.class)
	public void requestToErrorPageTest() throws Exception {
		Mockito.when(weatherService.getWeatherByCityId("2643743")).thenThrow(new ResponseStatusException(HttpStatus.BAD_REQUEST,"Mock Error"));

		ModelAndView modelAndView = weatherController.getWeatherByCityId("2643743");
		assertNotNull(modelAndView.getModel().get("message"));
		assertEquals("error", modelAndView.getViewName());
	}
	
	private OpenWeatherResponse createValidWeatherResponse() {
		OpenWeatherResponse response=new OpenWeatherResponse();
		response.setCity("London");
		response.setDate("Fri May 10 17:00:01 CDT 2019");
		response.setSunrise("Thu May 09 23:17:05 CDT 2019");
		response.setSunset("Fri May 10 14:36:50 CDT 2019");
		response.setTempCe("139.16666666666666");
		response.setTempFa("282.5");
		response.setWeather("Rain");
		response.setWeatherDesc("light rain");
		return response;
	}

}
