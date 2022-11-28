package com.parkhe.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.parkhe.model.UserDetails;
import com.parkhe.request.UserRequest;
import com.parkhe.response.ResponseDetails;
import com.parkhe.service.UserDetailsService;

@CrossOrigin(origins = { "http://localhost:3000" }, allowedHeaders = "*", methods = { RequestMethod.DELETE,
		RequestMethod.GET, RequestMethod.POST })
@Controller
public class UserController {
	private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);
	@Autowired
	private UserDetailsService cacheUserService;
	@Value("${weather.api.key}")
	private String key;

	@GetMapping
	public String start() {
		return "index";
	}

	@ResponseBody
	@GetMapping("/login")
	public ResponseDetails login(@RequestParam String email) {
		try {
			LOGGER.info("Request received for search user with {}", email);
			return new ResponseDetails(cacheUserService.searchUser(email), HttpStatus.OK);
		} catch (Exception e) {
			LOGGER.error("Exception occured due to something went wrong with {} and ", email, e);
			return new ResponseDetails(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

	@ResponseBody
	@PostMapping("/preference")
	public ResponseDetails create(@RequestBody UserRequest request) {
		LOGGER.info("Request received for user creation with {}", request);
		cacheUserService.createUser(UserDetails.getDetails(request));
		LOGGER.info("User creation request completed successfully for {}", request);
		return new ResponseDetails("success", HttpStatus.OK);
	}
}
