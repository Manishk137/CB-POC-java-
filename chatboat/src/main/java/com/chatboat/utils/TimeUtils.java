package com.chatboat.utils;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.chatboat.config.Config;


public class TimeUtils {
	public static long getSystemCurrentTimeMillis() throws ParseException {
		return System.currentTimeMillis();

	}
	public static String getCurrentTimeStamp(Long date) {
		Date newdate = new Date(date);
		SimpleDateFormat df2 = new SimpleDateFormat(Config.config.TRANSACTION_DATE_FORMAT);
		String dateText = df2.format(newdate);
		return dateText;
	}

	public static Timestamp getCurrentTimeStamp() {
		SimpleDateFormat gmtDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return Timestamp.valueOf(gmtDateFormat.format(new Date()));

}

}
