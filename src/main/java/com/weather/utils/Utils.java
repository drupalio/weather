package com.weather.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Utils {
	private Utils() {
	}

	public static String convertDate(final Integer utc) {
		return String.valueOf(new Date(Long.parseLong(utc.toString()) * 1000L));
	}

	public static String convertToCelsius(final Double temperature) {
		return String.valueOf(((temperature - 32) * 5) / 9);
	}
	
	public static String convertToTime(Integer utc) {
		DateFormat dateFormat = new SimpleDateFormat("hh:mm a");
		return dateFormat.format(new Date(Long.parseLong(utc.toString()) * 1000L));
		
	}
}
