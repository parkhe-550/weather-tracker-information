package com.parkhe.cache.store;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Cache<K, V> {
	private Cache() {
		store = new ConcurrentHashMap<>();
	}

	private static volatile Cache<?, ?> cache;
	private static final Object LOCK = new Object();
	private Map<K, V> store;

	public static Cache<?, ?> getCache() {
		Cache<?, ?> local = cache;
		if (local == null) {
			synchronized (LOCK) {
				local = cache;
				if (local == null) {
					local = cache = new Cache<>();
				}
			}
		}

		return local;
	}

	public void  put(K key, V value) {
		store.put(key, value);
	}

	public V get(K key) {
		return store.get(key);
	}

	public V delete(K key) {
		return store.remove(key);
	}

	public Map<K, V> getAll() {
		return new ConcurrentHashMap<>(store);
	}

	public void putAll(Map<K, V> map) {
		store.putAll(map);
	}

}
