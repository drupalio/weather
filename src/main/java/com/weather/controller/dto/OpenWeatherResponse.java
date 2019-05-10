package com.weather.controller.dto;

import com.weather.service.model.WeatherServiceResponse;
import com.weather.utils.Utils;

public class OpenWeatherResponse {
	private String date;
	private String city;
	private String weather;
	private String weatherDesc;
	private String tempFa;
	private String tempCe;
	private String sunrise;
	private String sunset;
	
	public OpenWeatherResponse mapResponse(WeatherServiceResponse apiresponse) {
		OpenWeatherResponse response=new OpenWeatherResponse();
		response.setCity(apiresponse.getName());
		response.setDate(Utils.convertDate(apiresponse.getDt()));
		response.setSunrise(Utils.convertToTime(apiresponse.getSys().getSunrise()));
		response.setSunset(Utils.convertToTime(apiresponse.getSys().getSunset()));
		response.setTempCe(Utils.convertToCelsius(apiresponse.getMain().getTemp()));
		response.setTempFa(String.valueOf(apiresponse.getMain().getTemp()));
		response.setWeather(apiresponse.getWeather().get(0).getMain());
		response.setWeatherDesc(apiresponse.getWeather().get(0).getDescription());
		return response;
	}
	
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getWeather() {
		return weather;
	}
	public void setWeather(String weather) {
		this.weather = weather;
	}
	public String getWeatherDesc() {
		return weatherDesc;
	}
	public void setWeatherDesc(String weatherDesc) {
		this.weatherDesc = weatherDesc;
	}
	public String getTempFa() {
		return tempFa;
	}
	public void setTempFa(String tempFa) {
		this.tempFa = tempFa;
	}
	public String getTempCe() {
		return tempCe;
	}
	public void setTempCe(String tempCe) {
		this.tempCe = tempCe;
	}
	public String getSunrise() {
		return sunrise;
	}
	public void setSunrise(String sunrise) {
		this.sunrise = sunrise;
	}
	public String getSunset() {
		return sunset;
	}
	public void setSunset(String sunset) {
		this.sunset = sunset;
	}
	
	
}
