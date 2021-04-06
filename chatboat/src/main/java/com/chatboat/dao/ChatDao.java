package com.chatboat.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.chatboat.database.MySqlConnectionUtil;
import com.chatboat.model.ChatFeedParams;
import com.chatboat.model.ChatFeedRequest;
import com.chatboat.model.ChatRasaResponse;
import com.chatboat.model.ChatRequest;
import com.chatboat.model.Questions;
import com.chatboat.model.SearchFeeds;
import com.chatboat.model.UserModel;
import com.chatboat.model.ValidateRequest;
import com.chatboat.model.ValidateResponse;
import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;

@Repository
public class ChatDao {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ChatDao.class);
	
	@Autowired
	private DataSource dataSource;
	
	
	public String userRegistration(UserModel userModel) {
		String status = null;
		PreparedStatement pstmt = null;
		Connection conn = null;
		try {
			String sql = "INSERT INTO  user_master_account (first_name, middle_name, last_name, mobile_no, email_id, ldap, register_date, register_datetime, sync_date, sync_datetime)"
					+ "values(?,?,?,?,?,?,?,?,?,?)";

			conn = dataSource.getConnection();
			LOGGER.debug("[{}] Query user registration for chat boat : {}", sql);

			if (conn != null) {
				Date date = new Date();
				pstmt = conn.prepareStatement(sql);

				pstmt.setString(1, userModel.getfName());
				pstmt.setString(2, userModel.getmName());
				pstmt.setString(3, userModel.getlName());
				pstmt.setLong(4, userModel.getMobileNo());
				pstmt.setString(5, userModel.getEmailId());
				pstmt.setString(6, userModel.getLdap());
				pstmt.setDate(7, new java.sql.Date(userModel.getTimestamp()));
				pstmt.setTimestamp(8, new java.sql.Timestamp(userModel.getTimestamp()));
				pstmt.setDate(9, new java.sql.Date(date.getTime()));
				pstmt.setTimestamp(10, new java.sql.Timestamp(date.getTime()));

				pstmt.executeUpdate();
				status = "200";
			}

		} catch (MySQLIntegrityConstraintViolationException exp) {
			LOGGER.error("[{}] Exception while user registration for chat boat : {} ", exp);
			exp.printStackTrace();
			status = "201";
		} catch (SQLException exp) {
			LOGGER.error("[{}] Exception while user registration for chat boat : {} ", exp);
			exp.printStackTrace();
			status = "101";
		} catch (Exception exp) {
			LOGGER.error("[{}] Exception while user registration for chat boat : {} ", exp);
			exp.printStackTrace();
			status = "101";
		} finally {

			MySqlConnectionUtil.closedbConnection(pstmt, conn);
		}
		return status;
	}
	

	public boolean isValidate(ValidateRequest validateRequest) {
		boolean isValidate = false;
		Connection conn = null;
		ResultSet result = null;
		PreparedStatement pstmt = null;
		try {
			String sql = "select count(*) from user_master_account where email_id='" + validateRequest.getEmailId() + "' AND ldap = '" + validateRequest.getLdap() + "'";
			LOGGER.debug("[{}] Query for check user validation for chat boat application -> {}", sql);
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			if (conn != null) {
				result = pstmt.executeQuery();
				while (result.next()) {
					int numberRow = result.getInt("count(*)");
					if (numberRow > 0) {
						isValidate = true;
					}
				}
			}
		} catch (SQLException exp) {
			LOGGER.error("[{}] Exception while check user validation for chat boat application : {} ", exp);
			exp.printStackTrace();
		} catch (Exception exp) {
			LOGGER.error("[{}] Exception while check user validation for chat boat application : {} ", exp);
			exp.printStackTrace();
		} finally {
			MySqlConnectionUtil.closedbConnection(pstmt, conn);
		}
		
		return isValidate;
	}

	public ValidateResponse getUserDetails(ValidateRequest validateRequest) {
		ValidateResponse validateResponse = new ValidateResponse();
		Connection conn = null;
		ResultSet result = null;
		PreparedStatement pstmt = null;
		try {
			String sql = "select * from user_master_account where email_id='" + validateRequest.getEmailId() + "' AND ldap = '" + validateRequest.getLdap() + "'";
			LOGGER.debug("[{}] get  user details for chat boat application Query -> {}", sql);
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			if (conn != null) {
				result = pstmt.executeQuery();
				if (conn != null) {
					while (result.next()) {
						validateResponse.setId(result.getInt("id"));
						validateResponse.setFirstName(result.getString("first_name"));
						validateResponse.setMiddleName(result.getString("middle_name"));
						validateResponse.setLastName(result.getString("last_name"));
						validateResponse.setEmailId(result.getString("email_id"));
						validateResponse.setLdap(result.getString("ldap"));
						validateResponse.setMobileNo(result.getLong("mobile_no"));
						validateResponse.setStatus("200");
						validateResponse.setMessage("valid user, please go ahead...");
					}
				}
			}
		} catch (SQLException exp) {
			LOGGER.error("[{}] Exception while get user details for chat boat application : {} ", exp);
			exp.printStackTrace();
			validateResponse.setStatus("101");
		} catch (Exception exp) {
			LOGGER.error("[{}] Exception while get user details for chat boat application : {} ", exp);
			exp.printStackTrace();
			validateResponse.setStatus("101");
		} finally {
			MySqlConnectionUtil.closedbConnection(pstmt, conn);
		}
		
		return validateResponse;
	}

	public boolean isEmailIdExixt(ChatRequest chatRequest) {
		Connection conn = null;
		ResultSet result = null;
		PreparedStatement pstmt = null;
		boolean isEmailId = false;
		try {
			String sql = "select count(*) from user_master_account where email_id='"+chatRequest.getEmailId()+"'";
			LOGGER.debug("[{}] Query for check user is valid or not for chat boat application -> {}", sql);
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			if (conn != null) {
				result = pstmt.executeQuery();
				while(result.next()){
			        int numberRow = result.getInt("count(*)");
			        if (numberRow > 0)
			        {
			        	isEmailId = true;
			        }	
			    }
			}
		} catch (SQLException exp) {
			LOGGER.error("[{}] Exception while check user is valid or not for chat boat application : {} ", exp);
			exp.printStackTrace();
		} catch (Exception exp) {
			LOGGER.error("[{}] Exception while check user is valid or not for chat boat application : {} ", exp);
			exp.printStackTrace();
		} finally {
			MySqlConnectionUtil.closedbConnection(pstmt, conn);
		}
		return isEmailId;
	}
	
	public String track(ChatRequest chatRequest,  ChatRasaResponse chatRasaResponse) {
		String status = null;
		PreparedStatement pstmt = null;
		Connection conn = null;
		try {
			
			String sql = "INSERT INTO  chat_boat_tracker (question, question_timestamp, question_date, question_datetime, device_id, interface, model, mac, imei, version, sync_timestamp, sync_date, sync_datetime, flag, message, email_id)"
						+ " values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			conn = dataSource.getConnection();
			LOGGER.debug("[{}] sql query for user chat for chat boat application : {}", sql);
			if (conn != null) {
				Date date = new Date();
				pstmt = conn.prepareStatement(sql);

				pstmt.setString(1, chatRequest.getQuestion());
				pstmt.setLong(2, chatRequest.getTimestamp());
				pstmt.setDate(3, new java.sql.Date(chatRequest.getTimestamp()));
				pstmt.setTimestamp(4, new java.sql.Timestamp(chatRequest.getTimestamp()));
				pstmt.setString(5, chatRequest.getDeviceId());
				pstmt.setString(6, chatRequest.get_interface());
				pstmt.setString(7, chatRequest.getModel());
				pstmt.setString(8, chatRequest.getMacId());
				pstmt.setString(9, chatRequest.getImei());
				pstmt.setString(10, chatRequest.getVersion());
				pstmt.setLong(11, date.getTime());
				pstmt.setDate(12, new java.sql.Date(date.getTime()));
				pstmt.setTimestamp(13, new java.sql.Timestamp(date.getTime()));
				pstmt.setString(14, chatRasaResponse.getFlag());
				pstmt.setString(15, chatRasaResponse.getMessage());
				pstmt.setString(16, chatRequest.getEmailId());
				
				pstmt.executeUpdate();
				status = "200";
			}
		} catch (SQLException exp) {
			LOGGER.error("[{}] Exception while user chat for chat boat application : {} ", exp);
			exp.printStackTrace();
			status = "101";
		} catch (Exception exp) {
			LOGGER.error("[{}] Exception while user chat for chat boat application : {} ", exp);
			exp.printStackTrace();
			status = "101";
		} finally {

			MySqlConnectionUtil.closedbConnection(pstmt, conn);
		}
		return status;
	}

	public List<ChatFeedParams> getChatFeeds(ChatFeedRequest chatFeedRequest) {
		List<ChatFeedParams> chatFeedList = new ArrayList<ChatFeedParams>();
		Connection conn = null;
		ResultSet result = null;
		PreparedStatement pstmt = null;
		try {

			String sql = "SELECT id, email_id, question, message as answer, sync_date, sync_datetime "
						+ " FROM chatboat.chat_boat_tracker where email_id = '" + chatFeedRequest.getEmailId() + "' order by sync_datetime desc";
			LOGGER.debug("[{}] get chat feeds list for chat boat application Query -> {}", sql);
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			if (conn != null) {
				result = pstmt.executeQuery();
				if (conn != null) {
					while (result.next()) {
						ChatFeedParams chatFeedParams = new ChatFeedParams();
						chatFeedParams.setId(result.getInt("id"));
						chatFeedParams.setQuestion(result.getString("question"));
						chatFeedParams.setAnswer(result.getString("answer"));
						chatFeedParams.setDate(result.getString("sync_date"));
						chatFeedParams.setDatetime(result.getString("sync_datetime"));
						
						chatFeedList.add(chatFeedParams);
					}
				}
			}
		} catch (SQLException exp) {
			LOGGER.error("[{}] Exception while get chat feeds list for chat boat application : {} ", exp);
			exp.printStackTrace();
		} catch (Exception exp) {
			LOGGER.error("[{}] Exception while get chat feeds list for chat boat application : {} ", exp);
			exp.printStackTrace();
		} finally {
			MySqlConnectionUtil.closedbConnection(pstmt, conn);
		}
		return chatFeedList;
	}

	public List<Questions> searchQuestions(SearchFeeds searchFeeds) {
		List<Questions> questionList = new ArrayList<Questions>();
		Questions questions = new Questions();
		Connection conn = null;
		ResultSet result = null;
		PreparedStatement pstmt = null;
		try {
			String sql = "SELECT * FROM chatbot.chat_bot_questions where question like '" + searchFeeds.getSearchKey() + "%' OR question like '%" + searchFeeds.getSearchKey() + "%' OR question like '%" + searchFeeds.getSearchKey() + "'";
			LOGGER.debug("[{}] get question list for chat bot application Query -> {}", sql);
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			if (conn != null) {
				result = pstmt.executeQuery();
				if (conn != null) {
					while (result.next()) 
					{
						questions = new Questions();
						questions.setQuestion(result.getString("question"));
						
						questionList.add(questions);
					}
					MySqlConnectionUtil.closedbConnection(pstmt, conn);
				}
			}
		} catch (SQLException exp) {
			LOGGER.error("[{}] Exception while get question list for chat bot application : {} ", exp);
			exp.printStackTrace();
		} catch (Exception exp) {
			LOGGER.error("[{}] Exception while get question list for chat bot application : {} ", exp);
			exp.printStackTrace();
		} finally {
			MySqlConnectionUtil.closedbConnection(pstmt, conn);
		}
		return questionList;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public static void main(String[] args) {
		
		ChatDao countWordTest = new ChatDao();
        countWordTest.countWords("find spring tutorial, java tutorial how to java articles spring articles and may more");
    }
 
    public void countWords(String input) {
        Map <String, String> map = new HashMap <String, String> ();
 
        if (input != null) {
            String[] separatedWords = input.split(" ");
            for (String str: separatedWords) {
                if (map.containsKey(str)) {
                    int count = Integer.parseInt(map.get(str));
                    map.put(str, String.valueOf(count + 1));
                } else {
                    map.put(str, "1");
                }
            }
        }
 
        System.out.println("Count :- " + map);
    }
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
