package com.chatboat.utils;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//import static java.time.temporal.TemporalAdjusters.nextOrSame;
//import static java.time.temporal.TemporalAdjusters.previousOrSame;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
//import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.chatboat.config.ChatBoatConfiguration;
import com.chatboat.database.DatabaseConnection;
import com.chatboat.database.MySqlConnectionUtil;

@Component
public class UtilFunction {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(UtilFunction.class);
	
	private static ChatBoatConfiguration chatBoatConfiguration;

	@Autowired
	public void setVuScreenPointsConfig(ChatBoatConfiguration vuscreenConfiguration) {
		UtilFunction.chatBoatConfiguration = vuscreenConfiguration;
	}
	
	public static long getUsedMemory() {
		return Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
	}
	
	public static boolean isEmpty(String param) {

		if (param != null && param.trim().length() > 0) {
			return false;
		}
		return true;
	}
	
	public static Timestamp getCurrentTimeStamp() {
		SimpleDateFormat gmtDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return Timestamp.valueOf(gmtDateFormat.format(new Date()));

	}
	
	public static String[] getStartEndTimes(String arg1) {
		Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("IST"));
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String[] startEndtimeArray = new String[2];
		if (arg1.equalsIgnoreCase("weekly")) {
			if(calendar.get(Calendar.DAY_OF_WEEK) >= Week.MONDAY.getDayAsInt() || calendar.get(Calendar.DAY_OF_WEEK) <= Week.FRIDAY.getDayAsInt()){
			   int mondayOffset = calendar.get(Calendar.DAY_OF_WEEK) - Calendar.MONDAY;
			   int fridayOffset = calendar.get(Calendar.DAY_OF_WEEK) - Calendar.FRIDAY;
			   calendar.setTime(new Date());
			   calendar.add(Calendar.DAY_OF_WEEK, -fridayOffset);			   
			   LOGGER.info("coming friday is : {}",simpleDateFormat.format(calendar.getTime()));
			   startEndtimeArray[0] = simpleDateFormat.format(calendar.getTime());
			   calendar.setTime(new Date());
			   calendar.add(Calendar.DAY_OF_WEEK, -mondayOffset);
			   LOGGER.info("Monday is/was : {}",simpleDateFormat.format(calendar.getTime()));
			   startEndtimeArray[1] = simpleDateFormat.format(calendar.getTime());
			   return startEndtimeArray;
			} else
				return null;
		} else if (arg1.equalsIgnoreCase("all")) {
			String start_date = UtilFunction.chatBoatConfiguration.getProperty("POINTS_START_DATE");
			String end_date = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
			return new String[] { start_date, end_date };
		}
		return null;

	}
	
	//USE BELOW METHOD FOR JAVA 8
	
	// public static String[] getStartEndTimes(String arg1) {
	// LocalDate today = LocalDate.now();
	// if (arg1.equalsIgnoreCase("weekly")) {
	// if (today.getDayOfWeek().getValue() >= Week.MONDAY.getDayAsInt()
	// && today.getDayOfWeek().getValue() <= Week.FRIDAY.getDayAsInt()) {
	// LocalDate monday =
	// today.with(previousOrSame(java.time.DayOfWeek.MONDAY));
	// LocalDate friday = today.with(nextOrSame(java.time.DayOfWeek.FRIDAY));
	// return new String[] { monday.toString(), friday.toString() };
	// } else
	// return null;
	// } else if (arg1.equalsIgnoreCase("all")) {
	// String start_date =
	// UtilFunction.vuscreenConfiguration.getProperty("POINTS_START_DATE");
	// String end_date = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
	// return new String[] { start_date, end_date };
	// }
	// return null;
	//
	// }
	
	public static boolean isValidUid(String uid, boolean dBCheck) {
		try {
			if (isEmpty(uid) | 46 != uid.length() | !uid.contains("T")) {
				LOGGER.debug("[{}] Invalid UID!", uid);
				return false;
			} else if (dBCheck & !UtilFunction.verifyUidFromDB(uid)) {
				return false;
			}
		} catch (Exception e) {
			LOGGER.debug("[{}] Exception in UID Verification:: {}", uid, e);
			e.printStackTrace();
		}
		return true;
	}
	
	private static boolean verifyUidFromDB(String uid) throws SQLException, PropertyVetoException, IOException {

		Connection conn = null;
		Statement stmt = null;
		ResultSet result = null;
		try {
			String sql = "select count(1) from user_profile_info where uid = '" + uid + "'";
			LOGGER.debug("[{}] UID Verification Query -> {}", uid, sql);
			conn = DatabaseConnection.getInstance().getConnection();
			if (conn != null) {
				stmt = conn.createStatement();
				result = stmt.executeQuery(sql);
				if (result.next()) {
					return true;
				}
			}
		} finally {
			MySqlConnectionUtil.closedbConnection(stmt, conn, result);
		}

		return false;
	}

	
	
}
