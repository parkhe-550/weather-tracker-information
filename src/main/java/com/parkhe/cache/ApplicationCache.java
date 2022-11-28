package com.parkhe.cache;

import java.util.Map;

public interface ApplicationCache<K, V> {
	boolean put(K key, V value);

	V get(K key);

	V delete(K key);

	Map<K, V> getAll();

	void putAll(Map<K, V> map);

}
