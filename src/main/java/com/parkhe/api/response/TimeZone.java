package com.parkhe.api.response;

import com.parkhe.util.DateUtils;

public class TimeZone {
private String localtime,utcOffset,zone,dayHours;

public String getLocaltime() {
	return localtime;
}

public void setLocaltime(String localtime) {
	this.localtime = localtime;
	this.setDayHours(DateUtils.covertIntoDayHours(localtime));
}

public String getUtcOffset() {
	return utcOffset;
}

public void setUtcOffset(String utcOffset) {
	this.utcOffset = utcOffset;
}

public String getZone() {
	return zone;
}

public void setZone(String zone) {
	this.zone = zone;
}


public String getDayHours() {
	return dayHours;
}

public void setDayHours(String dayHours) {
	this.dayHours = dayHours;
}

@Override
public String toString() {
	return "TimeZone [localtime=" + localtime + ", utcOffset=" + utcOffset + ", zone=" + zone + "]";
}

}
