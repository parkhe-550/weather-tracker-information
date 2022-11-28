package com.parkhe.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.parkhe.model.WeatherStatus;
import com.parkhe.properties.ApplicationProperties;
import com.parkhe.request.WeatherRequest;
import com.parkhe.service.WeatherService;

@Service("worldWeatherService")
public class WorldWeatherServiceImpl implements WeatherService {
	private static final Logger LOGGER = LoggerFactory.getLogger(WorldWeatherServiceImpl.class);
	@Autowired
	private ApplicationProperties worldWeatherProperties;
	private RestTemplate template;
	private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");

	public WorldWeatherServiceImpl() {
		template = new RestTemplate();
	}

	@Override
	public WeatherStatus findWeatherStatus(float lat, float lon) {
		LOGGER.info("Weather Status API process started for lat:{} and lon:{}", lat, lon);
		StringBuilder builder = new StringBuilder(worldWeatherProperties.getBaseUrl());
		builder.append('?').append("key=").append(worldWeatherProperties.getClientKey()).append("&q=").append(lat)
				.append(',').append(lon).append("&num_of_days=1&format=json&&includelocation=yes&showlocaltime=yes")
				.append("&date=").append(DATE_FORMAT.format(new Date()));
		WeatherStatus response = template.getForObject(builder.toString(), WeatherStatus.class);
		LOGGER.info("Weather Status API process is completed for lat:{} and lon:{} with response:{}", lat, lon, response);
		return response;
	}

	@Override
	public WeatherStatus findWeatherStatus(WeatherRequest request) {
		LOGGER.info("Weather Status searching process started for user {}", request.getUserRequest().getEmailId());
		WeatherStatus status = findWeatherStatus(request.getLat(), request.getLon());
		return status;
	}


}
