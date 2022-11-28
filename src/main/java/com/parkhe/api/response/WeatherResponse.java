package com.parkhe.api.response;

public class WeatherResponse {
	private WeatherInformation data;

	public WeatherInformation getData() {
		return data;
	}

	public void setData(WeatherInformation data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "WeatherResponse [data=" + data + "]";
	}
	
	
}
