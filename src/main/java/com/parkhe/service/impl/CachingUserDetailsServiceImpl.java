package com.parkhe.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.parkhe.cache.ApplicationCache;
import com.parkhe.cache.impl.ApplicationCacheImpl;
import com.parkhe.cache.store.Cache;
import com.parkhe.model.UserDetails;
import com.parkhe.service.UserDetailsService;

@Service("cacheUserService")
public class CachingUserDetailsServiceImpl implements UserDetailsService {
	private static final Logger LOGGER = LoggerFactory.getLogger(CachingUserDetailsServiceImpl.class);
	private ApplicationCache<String, UserDetails> applicationCache;

	@SuppressWarnings("unchecked")
	public CachingUserDetailsServiceImpl() {
		LOGGER.info("CachingUserDetailsServiceImpl instace created");
		applicationCache = new ApplicationCacheImpl((Cache<String, UserDetails>) Cache.getCache());
	}

	@Override
	public UserDetails searchUser(String emailId) {
		LOGGER.info("User searching process started for {}", emailId);
		UserDetails details = applicationCache.get(emailId);
		LOGGER.info("User details: {} found for {}", details, emailId);
		if (details == null) {
			details = new UserDetails(emailId);
			createUser(details);
		}
		return details;
	}

	@Override
	public void createUser(UserDetails details) {
		LOGGER.info("User creating process started for {}", details);
		applicationCache.put(details.getEmailId(), details);
		LOGGER.info("User creating process completed for {}", details);
	}

}
