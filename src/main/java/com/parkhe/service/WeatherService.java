package com.parkhe.service;

import com.parkhe.api.response.WeatherResponse;
import com.parkhe.request.WeatherRequest;

public interface WeatherService {
	WeatherResponse findWeatherStatus(float lat, float lon);
	WeatherResponse findWeatherStatus(WeatherRequest request);
}
