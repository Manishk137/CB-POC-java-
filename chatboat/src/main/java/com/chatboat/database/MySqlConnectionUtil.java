package com.chatboat.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MySqlConnectionUtil {

	private static final Logger LOGGER = LoggerFactory.getLogger(MySqlConnectionUtil.class);

	public static void closedbConnection(PreparedStatement pstmt, Connection conn,
			ResultSet result) {
		try {
			if (result != null) {
				result.close();
			}
			if (pstmt != null) {
				pstmt.close();
			}
			if (conn != null) {
				conn.close();

			}
		} catch (SQLException e) {
			LOGGER.debug("Unable to close connection : ", e);

			e.printStackTrace();
		}

	}

	public static void closedbConnection(Statement stmt, Connection conn,
			ResultSet result) {
		try {
			if (result != null) {
				result.close();
			}
			if (stmt != null) {
				stmt.close();
			}
			if (conn != null) {
				conn.close();

			}
		} catch (SQLException e) {
			LOGGER.debug("Unable to close connection : ", e);

			e.printStackTrace();
		}

	}

	public static void closedbConnection(Statement stmt, Connection conn) {
		try {
			if (stmt != null) {
				stmt.close();
			}
			if (conn != null) {
				conn.close();

			}
		} catch (SQLException e) {
			LOGGER.debug("Unable to close connection : ", e);

			e.printStackTrace();
		}

	}

	public static void closedbConnection(Statement stmt, ResultSet result) {
		try {
			if (stmt != null) {
				stmt.close();
			}
			if (result != null) {
				result.close();

			}
		} catch (SQLException e) {
			LOGGER.debug("Unable to close connection : ", e);

			e.printStackTrace();
		}

	}

	public static void closedbConnection(PreparedStatement pstmt, Connection conn) {
		try {
			if (pstmt != null) {
				pstmt.close();
			}
			if (conn != null) {
				conn.close();

			}
		} catch (SQLException e) {
			LOGGER.debug("Unable to close connection : ", e);

			e.printStackTrace();
		}

	}

}
