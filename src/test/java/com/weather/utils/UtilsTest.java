package com.weather.utils;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class UtilsTest {

	@Test
	public void convertDate() {
		Integer dt=1557527584;
		String date=Utils.convertDate(dt);
		assertEquals("Fri May 10 17:33:04 CDT 2019", date);
	}

	@Test
	public void convertToCelsius() {
		double farenheit =282.5;
		String celcius = Utils.convertToCelsius(farenheit);
		assertEquals("139.16666666666666", celcius);
	}
}
