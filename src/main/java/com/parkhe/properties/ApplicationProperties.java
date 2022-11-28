package com.parkhe.properties;

public class ApplicationProperties {
	private String baseUrl;
	private String clientKey;
	
	public ApplicationProperties(String baseUrl, String clientKey) {
		super();
		this.baseUrl = baseUrl;
		this.clientKey = clientKey;
	}
	public String getBaseUrl() {
		return baseUrl;
	}
	public String getClientKey() {
		return clientKey;
	}
	
}
