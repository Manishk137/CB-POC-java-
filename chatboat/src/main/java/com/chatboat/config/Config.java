package com.chatboat.config;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Config {

	@SuppressWarnings("unused")
	private static final Logger LOGGER = LoggerFactory.getLogger(Config.class);

	public static Config config;
	static Map<String, String> CMAP = new ConcurrentHashMap<String, String>();
	
	// For Binge TV Param
	public String  SMS_URL_PREFIX;
	public String  SMS_URL_POSTFIX;
	public String  SENDER_EMAIL_ID;
	public String  EMAIL_ID_PASSWORD;
	public String  SET_FROM_EMAIL_ID;
	public String  AADHAR_IMAGE_UPLOAD_LOCATION;
	public String  AADHAR_IMAGE_BASE_URL;
	public String  SERIAL_IMAGE_UPLOAD_LOCATION;
	public String  SERIAL_IMAGE_BASE_URL;
	public String DEFAULT_LANGUAGE;

	public List<String> LANGUAGE;
	public String TRANSACTION_DATE_FORMAT;
	

	public Config() {
		// TODO Auto-generated constructor stub
	}

	static void setRefrence(Config configData) {
		config = configData;
	}

	public static String getMessage(String msg) {
		String val = CMAP.get(msg);
		if (val == null)
			System.out.println("No variable named [{}] is configured in configuration" + msg);
		return val;
	}

}
