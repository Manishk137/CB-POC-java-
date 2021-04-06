package com.chatboat.config;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ConfigReader {

	private static final Logger LOGGER = LoggerFactory
			.getLogger(ConfigReader.class);
	private static HashMap<String, String> hashMap = new LinkedHashMap<String, String>();

	// static String configPath;

	@Autowired
	private DataSource dataSource;

	public void init() {
		try {
			// configPath = filePath;
			Config confdata = new Config();
			//disableSslVerification();
			getFieldNamesAndType((Object) confdata);
			//populateObject(confdata);
			Config.setRefrence(confdata);
			rearrange();
			//ConfigIntialization.propertyInitialization();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public static void getFieldNamesAndType(final Object valueObj)
			throws IllegalArgumentException, IllegalAccessException {

		Class<? extends Object> c1 = valueObj.getClass();
		Field[] valueObjFields = c1.getDeclaredFields();
		for (int i = 0; i < valueObjFields.length; i++) {
			String fieldName = valueObjFields[i].getName();
			Class<?> c = valueObjFields[i].getType();
			hashMap.put(fieldName, c.getName());
		}
	}

	public boolean populateObject(Config configData) {
		/*
		 * Properties prop = new Properties(); FileInputStream fis = null;
		 */
		String sql = "";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {

			sql = "select conf_key,conf_value from server_configurations;";
			LOGGER.debug("Server Configuration Query :: " + sql);
			//conn = DatabaseConnection.getInstance().getConnection();
			conn = dataSource.getConnection();
			Config ft = new Config();
			Class<? extends Config> ftClass = ft.getClass();
			if (conn != null) {
				pstmt = conn.prepareStatement(sql);
				ResultSet result = pstmt.executeQuery();
				while (result.next()) {
					String key = result.getString("conf_key");
					String value = result.getString("conf_value");

					//System.out.println("key : " + key + ", value : " + value);
					// LOGGER.debug("*** key *** {} *** value *** {} ",key,value);
					Config.CMAP.put(key, value);
					if (hashMap.containsKey(key)) {
						String dataTypeValue = hashMap.get(key);
//						System.out.println("key :: " + key
//								+ ", dataTypeValue :: " + dataTypeValue);
						try {
							if (dataTypeValue.equals("int")) {
								Field f1 = ftClass.getField(key);
//								System.out.println(f1);
//								System.out.println(value);

								f1.set(configData,
										Integer.parseInt(value.trim()));
							} else if (dataTypeValue.equals("java.lang.String")) {
								Field f1 = ftClass.getField(key);
								if (value.equals("-1"))
									value = "";
								f1.set(configData, (value.trim()));
							} else if (dataTypeValue.equals("long")) {
								Field f1 = ftClass.getField(key);
								f1.set(configData, Long.valueOf(value.trim()));
							} else if (dataTypeValue.equals("boolean")) {
								Field f1 = ftClass.getField(key);
								f1.set(configData,
										Boolean.valueOf(value.trim()));
							} else if (dataTypeValue.equals("float")) {
								Field f1 = ftClass.getField(key);
								f1.set(configData, Float.valueOf(value.trim()));
							}
						} catch (Exception ex) {
							LOGGER.debug("SERVER ERROR {}", ex);
							ex.printStackTrace();
						}
						//LOGGER.info("Config key : " + key + ", value : "
						//		+ value);
					}

				}

			}
		} catch (SQLException exp) {
			exp.printStackTrace();
			LOGGER.debug("SERVER ERROR {}", exp);
		} catch (Exception ex) {
			ex.printStackTrace();
			LOGGER.debug("SERVER ERROR {}", ex);

		} finally {

			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

		}
		return true;
	}

	public static void rearrange() {
		Config cfg = Config.config;
		// cfg.channel = cfg.channels.split(",");
		cfg.LANGUAGE = Arrays.asList(cfg.DEFAULT_LANGUAGE.split(","));
	}
	
	/*private static void disableSslVerification() {
	    try
	    {
	        // Create a trust manager that does not validate certificate chains
	        TrustManager[] trustAllCerts = new TrustManager[] {new X509TrustManager() {
	            public java.security.cert.X509Certificate[] getAcceptedIssuers() {
	                return null;
	            }
	            public void checkClientTrusted(X509Certificate[] certs, String authType) {
	            }
	            public void checkServerTrusted(X509Certificate[] certs, String authType) {
	            }
	        }
	        };

	        // Install the all-trusting trust manager
	        SSLContext sc = SSLContext.getInstance("SSL");
	        sc.init(null, trustAllCerts, new java.security.SecureRandom());
	        HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());

	        // Create all-trusting host name verifier
	        HostnameVerifier allHostsValid = new HostnameVerifier() {
	            public boolean verify(String hostname, SSLSession session) {
	                return true;
	            }
	        };

	        // Install the all-trusting host verifier
	        HttpsURLConnection.setDefaultHostnameVerifier(allHostsValid);
	    } catch (NoSuchAlgorithmException e) {
	        e.printStackTrace();
	    } catch (KeyManagementException e) {
	        e.printStackTrace();
	    }
	}*/
	
	
	
	
	
	

}
