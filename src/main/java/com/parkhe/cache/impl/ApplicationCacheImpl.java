package com.parkhe.cache.impl;

import java.util.Map;

import com.parkhe.cache.ApplicationCache;
import com.parkhe.cache.store.Cache;
import com.parkhe.model.UserDetails;

public class ApplicationCacheImpl implements ApplicationCache<String, UserDetails> {
	private final Cache<String, UserDetails> cache;

	public ApplicationCacheImpl(Cache<String, UserDetails> cache) {
		this.cache = cache;
	}

	@Override
	public boolean put(String key, UserDetails value) {
		cache.put(key, value);
		return true;
	}

	@Override
	public UserDetails get(String key) {
		return cache.get(key);
	}

	@Override
	public UserDetails delete(String key) {
		return cache.delete(key);
	}

	@Override
	public Map<String, UserDetails> getAll() {
		return cache.getAll();
	}

	@Override
	public void putAll(Map<String, UserDetails> map) {
		cache.putAll(map);
	}

}
