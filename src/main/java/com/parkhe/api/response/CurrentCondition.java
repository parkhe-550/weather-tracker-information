package com.parkhe.api.response;

import java.util.List;

public class CurrentCondition {
	private double FeelsLikeC, FeelsLikeF, temp_C, temp_F;
	private List<Content> weatherIconUrl, weatherDesc;

	public double getFeelsLikeC() {
		return FeelsLikeC;
	}

	public void setFeelsLikeC(double feelsLikeC) {
		FeelsLikeC = feelsLikeC;
	}

	public double getFeelsLikeF() {
		return FeelsLikeF;
	}

	public void setFeelsLikeF(double feelsLikeF) {
		FeelsLikeF = feelsLikeF;
	}

	public double getTemp_C() {
		return temp_C;
	}

	public void setTemp_C(double temp_C) {
		this.temp_C = temp_C;
	}

	public double getTemp_F() {
		return temp_F;
	}

	public void setTemp_F(double temp_F) {
		this.temp_F = temp_F;
	}

	public List<Content> getWeatherIconUrl() {
		return weatherIconUrl;
	}

	public void setWeatherIconUrl(List<Content> weatherIconUrl) {
		this.weatherIconUrl = weatherIconUrl;
	}

	public List<Content> getWeatherDesc() {
		return weatherDesc;
	}

	public void setWeatherDesc(List<Content> weatherDesc) {
		this.weatherDesc = weatherDesc;
	}

	@Override
	public String toString() {
		return "CurrentCondition [FeelsLikeC=" + FeelsLikeC + ", FeelsLikeF=" + FeelsLikeF + ", temp_C=" + temp_C
				+ ", temp_F=" + temp_F + ", weatherIconUrl=" + weatherIconUrl + ", weatherDesc=" + weatherDesc + "]";
	}

}
