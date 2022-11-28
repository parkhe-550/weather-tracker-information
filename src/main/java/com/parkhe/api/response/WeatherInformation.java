package com.parkhe.api.response;

import java.util.List;

public class WeatherInformation {
	List<CurrentCondition> current_condition;
	List<Area>nearest_area;
	List<TimeZone>time_zone;
	public List<CurrentCondition> getCurrent_condition() {
		return current_condition;
	}
	public void setCurrent_condition(List<CurrentCondition> current_condition) {
		this.current_condition = current_condition;
	}
	public List<Area> getNearest_area() {
		return nearest_area;
	}
	public void setNearest_area(List<Area> nearest_area) {
		this.nearest_area = nearest_area;
	}
	public List<TimeZone> getTime_zone() {
		return time_zone;
	}
	public void setTime_zone(List<TimeZone> time_zone) {
		this.time_zone = time_zone;
	}
	@Override
	public String toString() {
		return "WeatherInformation [current_condition=" + current_condition + ", nearest_area=" + nearest_area
				+ ", time_zone=" + time_zone + "]";
	}
	
	
}
