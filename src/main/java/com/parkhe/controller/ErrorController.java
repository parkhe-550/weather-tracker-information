package com.parkhe.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.parkhe.response.ErrorResponse;

@RestControllerAdvice
public class ErrorController {
	private static final Logger LOGGER = LoggerFactory.getLogger(ErrorController.class);
	@ExceptionHandler(value = {Exception.class})
	public @ResponseBody ErrorResponse handle(Exception exception) {
		LOGGER.error("Global exception occurred ",exception);
		return new ErrorResponse(exception.getMessage());
		
	}
}
