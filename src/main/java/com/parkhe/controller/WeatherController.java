package com.parkhe.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.parkhe.api.response.WeatherResponse;
import com.parkhe.messanger.MessageSender;
import com.parkhe.request.WeatherRequest;
import com.parkhe.response.ResponseDetails;
import com.parkhe.service.WeatherService;
import com.parkhe.util.DateUtils;

@CrossOrigin(origins = { "http://localhost:3000" }, allowedHeaders = "*", methods = { RequestMethod.DELETE,
		RequestMethod.GET, RequestMethod.POST })
@RestController
@RequestMapping("/weather")
public class WeatherController {
	private static final Logger LOGGER = LoggerFactory.getLogger(WeatherController.class);
	@Autowired
	private WeatherService worldWeatherService;
	@Autowired
	private MessageSender messageSender;

	@PostMapping("/status")
	public ResponseDetails weatherStatus(@RequestBody WeatherRequest request) {
		LOGGER.info("weather request received for user:{} with lat:{} and lon:{}",
				request.getUserRequest().getEmailId(), request.getLat(), request.getLon());
		WeatherResponse status = worldWeatherService.findWeatherStatus(request);
		LOGGER.info("weather request completed for user:{} with lat:{} and lon:{}",
				request.getUserRequest().getEmailId(), request.getLat(), request.getLon());
		ResponseDetails details=new ResponseDetails(status, HttpStatus.OK);
		details.getElement().put("notification", messageSender.sendMessage(request.getUserRequest(),status));
		details.getElement().put("time", DateUtils.getDayHours());
		return details;
	}
}
