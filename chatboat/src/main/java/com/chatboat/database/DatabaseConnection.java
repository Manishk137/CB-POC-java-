package com.chatboat.database;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ResourceBundle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@SuppressWarnings("unused")
public class DatabaseConnection {
	private static final Logger LOGGER = LoggerFactory.getLogger(DatabaseConnection.class);
	private static ComboPooledDataSource cpds = null;
	private static ComboPooledDataSource cpdsOnline = null;
	private static DatabaseConnection datasource = null;
	private static final ResourceBundle rs = ResourceBundle.getBundle("public");

	
	private DatabaseConnection() throws PropertyVetoException {
		String DRIVER_NAME = null;
		String URL = null;
		String URL_ONLINE = null;
		String USERNAME = null;
		String PASSWORD = null;
		int MINPOOL = 0;
		int ACQUIRE_INCREMENT = 0;
		int MAXPOOL = 0;
		int MAXSTATEMENT = 0;
		int ACQUIRE_RETRY_ATTEMPT = 0;
		int ACQUIRE_RETRY_DELAY = 0;
		boolean BREAK_AFTER_ACQUIRE_FAILURE = false;
		int MAX_CONNECTION_AGE = 0;
		int MAX_IDLE_TIME = 0;
		int MAX_IDLE_TIME_EXCESS_CONNECTION = 0;
		int IDLE_CONNECTION_TEST_PERIOD = 0;
		boolean TEST_CONNECTION_ON_CHECKOUT = false;
		String PREFERRED_TEST_QUERY = null;
		try {
			DRIVER_NAME = rs.getString("DRIVER_NAME");
			URL = rs.getString("URL");
			URL_ONLINE = rs.getString("URL_ONLINE");
			USERNAME = rs.getString("USERNAME");
			PASSWORD = rs.getString("PASSWORD");
			MINPOOL = Integer.parseInt(rs.getString("MINPOOL"));
			ACQUIRE_INCREMENT = Integer.parseInt(rs.getString("ACQUIRE_INCREMENT"));
			MAXPOOL = Integer.parseInt(rs.getString("MAXPOOL"));
			MAXSTATEMENT = Integer.parseInt(rs.getString("MAXSTATEMENT"));
			ACQUIRE_RETRY_ATTEMPT = Integer.parseInt(rs.getString("ACQUIRE_RETRY_ATTEMPT"));
			ACQUIRE_RETRY_DELAY = Integer.parseInt(rs.getString("ACQUIRE_RETRY_DELAY"));
			BREAK_AFTER_ACQUIRE_FAILURE = Boolean.valueOf(rs.getString("BREAK_AFTER_ACQUIRE_FAILURE"));
			MAX_CONNECTION_AGE = Integer.parseInt(rs.getString("MAX_CONNECTION_AGE"));
			MAX_IDLE_TIME = Integer.parseInt(rs.getString("MAX_IDLE_TIME"));
			MAX_IDLE_TIME_EXCESS_CONNECTION = Integer.parseInt(rs.getString("MAX_IDLE_TIME_EXCESS_CONNECTION"));
			IDLE_CONNECTION_TEST_PERIOD = Integer.parseInt(rs.getString("IDLE_CONNECTION_TEST_PERIOD"));
			TEST_CONNECTION_ON_CHECKOUT = Boolean.valueOf(rs.getString("TEST_CONNECTION_ON_CHECKOUT"));
			PREFERRED_TEST_QUERY = rs.getString("PREFERRED_TEST_QUERY");
		} catch (Exception exp) {
			LOGGER.error("ERROR WHILE INTIALIZING DB DETAILS FROM CONFIG {} ", exp);
			exp.printStackTrace();
		}
		cpds = new ComboPooledDataSource();
		cpds.setDriverClass(DRIVER_NAME); // loacpds the jdbc driver
		cpds.setJdbcUrl(URL);
		cpds.setUser(USERNAME);
		cpds.setPassword(PASSWORD);
		cpds.setMinPoolSize(MINPOOL);
		cpds.setAcquireIncrement(ACQUIRE_INCREMENT);
		cpds.setMaxPoolSize(MAXPOOL);
		cpds.setMaxStatements(MAXSTATEMENT);
		cpds.setAcquireRetryAttempts(ACQUIRE_RETRY_ATTEMPT);
		cpds.setAcquireRetryDelay(ACQUIRE_RETRY_DELAY);
		cpds.setBreakAfterAcquireFailure(BREAK_AFTER_ACQUIRE_FAILURE);
		cpds.setMaxConnectionAge(MAX_CONNECTION_AGE);
		cpds.setMaxIdleTime(MAX_IDLE_TIME);
		cpds.setMaxIdleTimeExcessConnections(MAX_IDLE_TIME_EXCESS_CONNECTION);
		cpds.setIdleConnectionTestPeriod(IDLE_CONNECTION_TEST_PERIOD);
		cpds.setTestConnectionOnCheckout(TEST_CONNECTION_ON_CHECKOUT);
		cpds.setPreferredTestQuery(PREFERRED_TEST_QUERY);
		/*cpdsOnline = new ComboPooledDataSource();
		cpdsOnline.setDriverClass(DRIVER_NAME);
		cpdsOnline.setJdbcUrl(URL_ONLINE);
		cpdsOnline.setUser(USERNAME);
		cpdsOnline.setPassword(PASSWORD);
		cpdsOnline.setMinPoolSize(MINPOOL);
		cpdsOnline.setAcquireIncrement(ACQUIRE_INCREMENT);
		cpdsOnline.setMaxPoolSize(MAXPOOL);
		cpdsOnline.setMaxStatements(MAXSTATEMENT);
		cpdsOnline.setAcquireRetryAttempts(ACQUIRE_RETRY_ATTEMPT);
		cpdsOnline.setAcquireRetryDelay(ACQUIRE_RETRY_DELAY);
		cpdsOnline.setBreakAfterAcquireFailure(BREAK_AFTER_ACQUIRE_FAILURE);
		cpdsOnline.setMaxConnectionAge(MAX_CONNECTION_AGE);
		cpdsOnline.setMaxIdleTime(MAX_IDLE_TIME);
		cpdsOnline.setMaxIdleTimeExcessConnections(MAX_IDLE_TIME_EXCESS_CONNECTION);
		cpdsOnline.setIdleConnectionTestPeriod(IDLE_CONNECTION_TEST_PERIOD);
		cpdsOnline.setTestConnectionOnCheckout(TEST_CONNECTION_ON_CHECKOUT);
		cpdsOnline.setPreferredTestQuery(PREFERRED_TEST_QUERY);*/
	}

	public static DatabaseConnection getInstance() throws IOException, SQLException, PropertyVetoException {
		if (datasource == null) {
			datasource = new DatabaseConnection();
		}
		return datasource;
	}

	public Connection getConnection() throws SQLException, PropertyVetoException {
		LOGGER.debug("Connetion :: busy " + cpds.getNumBusyConnectionsDefaultUser() + " Idle: "
				+ cpds.getNumIdleConnectionsDefaultUser() + " Total: " + cpds.getNumConnectionsDefaultUser());
		return cpds.getConnection();
	}

	/*public Connection getConnectionOnline() throws SQLException, PropertyVetoException {
		LOGGER.debug("Connetion Online :: busy " + cpds.getNumBusyConnectionsDefaultUser() + " Idle: "
				+ cpdsOnline.getNumIdleConnectionsDefaultUser() + " Total: "
				+ cpdsOnline.getNumConnectionsDefaultUser());
		return cpdsOnline.getConnection();
	}*/
}
