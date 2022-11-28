package com.parkhe.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {
	private static final SimpleDateFormat YYYY_MM_DD_HH_MM_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm");
	private static final SimpleDateFormat DAY_HH_MM_FORMAT = new SimpleDateFormat("EEE, hh:mm aa");
	
	public static String covertIntoDayHours(String stringDate) {
		try {
			Date date = YYYY_MM_DD_HH_MM_FORMAT.parse(stringDate);
			return DAY_HH_MM_FORMAT.format(date);
		} catch (ParseException e) {
			return stringDate;
		}
	}
	public static String getDayHours() {
		return DAY_HH_MM_FORMAT.format(new Date());
	}
}
