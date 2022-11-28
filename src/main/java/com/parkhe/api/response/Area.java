package com.parkhe.api.response;

import java.util.List;

public class Area {
	private String city, countryName, state;

	public String getCity() {
		return city;
	}

	public String getCountryName() {
		return countryName;
	}

	public String getState() {
		return state;
	}

	public void setAreaName(List<Content> areaName) {
		this.city = getValue(areaName);
	}

	public void setCountry(List<Content> country) {
		this.countryName = getValue(country);
	}

	public void setRegion(List<Content> region) {
		this.state = getValue(region);
	}

	private String getValue(List<Content> content) {
		if (content != null && !content.isEmpty()) {
			return content.get(0).getValue();
		}
		return null;
	}

	@Override
	public String toString() {
		return "Area [city=" + city + ", countryName=" + countryName + ", state=" + state + "]";
	}

}
