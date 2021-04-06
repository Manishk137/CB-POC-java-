package com.chatboat.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.chatboat.database.MySqlConnectionUtil;
import com.chatboat.model.Employee;
import com.chatboat.model.OverallCompanyMoodParam;

@Repository
public class DashbordDao {
	
private static final Logger LOGGER = LoggerFactory.getLogger(SurveyDao.class);
	
	@Autowired
	private DataSource dataSource;

	public int getStronglyDisagreeCount(String Department, String Location, String Technology) {
		int stronglyDisagreeCount = 0;
		Connection conn = null;
		ResultSet result = null;
		PreparedStatement pstmt = null;
		try {
			StringBuilder sb = new StringBuilder(); 
			sb.append("SELECT count(A.email_id) as count FROM user_master_account A JOIN survey_response_sum B ON A.email_id = B.email_id Where B.survey_name = 'Strongly disagree'");
			if(Department != null && Department != "")
			{
				sb.append(" AND A.business_unit='"+ Department +"'");
			}	
			if(Location != null && Location != "")
			{
				sb.append(" AND A.location='"+ Location +"'");
			}
			if(Technology != null && Technology != "")
			{
				sb.append(" AND A.technology='"+ Technology +"'");
			}
			LOGGER.debug("[{}] get the rating count of the company pulse score view for dashbord of survey of chat bot application Query -> {}", sb.toString());
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sb.toString());
			if (conn != null) {
				result = pstmt.executeQuery();
				if (conn != null) {
					while (result.next()) {
						stronglyDisagreeCount = result.getInt("count");
					}
				}
			}
		} catch (SQLException exp) {
			LOGGER.error("[{}] Exception while get rating count of company pulse score view for dashbord of survey of chat bot application : {} ", exp);
			exp.printStackTrace();
		} catch (Exception exp) {
			LOGGER.error("[{}] Exception while get rating count of company pulse score view for dashbord of survey of chat bot application : {} ", exp);
			exp.printStackTrace();
		} finally {
			MySqlConnectionUtil.closedbConnection(pstmt, conn);
		}
		return stronglyDisagreeCount;
	}

	public int getDisagreeCount(String Department, String Location, String Technology) {
		int disagreeCount = 0;
		Connection conn = null;
		ResultSet result = null;
		PreparedStatement pstmt = null;
		try {
			StringBuilder sb = new StringBuilder(); 
			sb.append("SELECT count(A.email_id) as count FROM user_master_account A JOIN survey_response_sum B ON A.email_id = B.email_id Where B.survey_name = 'Disagree'");
			if(Department != null && Department != "")
			{
				sb.append(" AND A.business_unit='"+ Department +"'");
			}	
			if(Location != null && Location != "")
			{
				sb.append(" AND A.location='"+ Location +"'");
			}
			if(Technology != null && Technology != "")
			{
				sb.append(" AND A.technology='"+ Technology +"'");
			}
			LOGGER.debug("[{}] get the rating count of the company pulse score view for dashbord of survey of chat bot application Query -> {}", sb.toString());
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sb.toString());
			if (conn != null) {
				result = pstmt.executeQuery();
				if (conn != null) {
					while (result.next()) {
						disagreeCount =result.getInt("count");
					}
				}
			}
		} catch (SQLException exp) {
			LOGGER.error("[{}] Exception while get rating count of company pulse score view for dashbord of survey of chat bot application : {} ", exp);
			exp.printStackTrace();
		} catch (Exception exp) {
			LOGGER.error("[{}] Exception while get rating count of company pulse score view for dashbord of survey of chat bot application : {} ", exp);
			exp.printStackTrace();
		} finally {
			MySqlConnectionUtil.closedbConnection(pstmt, conn);
		}
		return disagreeCount;
	}

	public int getSomewhatDisagreeCount(String Department, String Location, String Technology) {
		int somewhatDisagreeCount = 0;
		Connection conn = null;
		ResultSet result = null;
		PreparedStatement pstmt = null;
		try {
			StringBuilder sb = new StringBuilder(); 
			sb.append("SELECT count(A.email_id) as count FROM user_master_account A JOIN survey_response_sum B ON A.email_id = B.email_id Where B.survey_name = 'Somewhat disagree'");
			if(Department != null && Department != "")
			{
				sb.append(" AND A.business_unit='"+ Department +"'");
			}	
			if(Location != null && Location != "")
			{
				sb.append(" AND A.location='"+ Location +"'");
			}
			if(Technology != null && Technology != "")
			{
				sb.append(" AND A.technology='"+ Technology +"'");
			}
			
			LOGGER.debug("[{}] get the rating count of the company pulse score view for dashbord of survey of chat bot application Query -> {}", sb.toString());
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sb.toString());
			if (conn != null) {
				result = pstmt.executeQuery();
				if (conn != null) {
					while (result.next()) {
						somewhatDisagreeCount =result.getInt("count");
					}
				}
			}
		} catch (SQLException exp) {
			LOGGER.error("[{}] Exception while get rating count of company pulse score view for dashbord of survey of chat bot application : {} ", exp);
			exp.printStackTrace();
		} catch (Exception exp) {
			LOGGER.error("[{}] Exception while get rating count of company pulse score view for dashbord of survey of chat bot application : {} ", exp);
			exp.printStackTrace();
		} finally {
			MySqlConnectionUtil.closedbConnection(pstmt, conn);
		}
		return somewhatDisagreeCount;
	}

	public int getSomewhatAgreeCount(String Department, String Location, String Technology) {
		int somewhatAgreeCount = 0;
		Connection conn = null;
		ResultSet result = null;
		PreparedStatement pstmt = null;
		try {
			StringBuilder sb = new StringBuilder(); 
			sb.append("SELECT count(A.email_id) as count FROM user_master_account A JOIN survey_response_sum B ON A.email_id = B.email_id Where B.survey_name = 'Somewhat agree'");
			if(Department != null && Department != "")
			{
				sb.append(" AND A.business_unit='"+ Department +"'");
			}	
			if(Location != null && Location != "")
			{
				sb.append(" AND A.location='"+ Location +"'");
			}
			if(Technology != null && Technology != "")
			{
				sb.append(" AND A.technology='"+ Technology +"'");
			}
			
			LOGGER.debug("[{}] get the rating count of the company pulse score view for dashbord of survey of chat bot application Query -> {}", sb.toString());
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sb.toString());
			if (conn != null) {
				result = pstmt.executeQuery();
				if (conn != null) {
					while (result.next()) {
						somewhatAgreeCount =result.getInt("count");
					}
				}
			}
		} catch (SQLException exp) {
			LOGGER.error("[{}] Exception while get rating count of company pulse score view for dashbord of survey of chat bot application : {} ", exp);
			exp.printStackTrace();
		} catch (Exception exp) {
			LOGGER.error("[{}] Exception while get rating count of company pulse score view for dashbord of survey of chat bot application : {} ", exp);
			exp.printStackTrace();
		} finally {
			MySqlConnectionUtil.closedbConnection(pstmt, conn);
		}
		return somewhatAgreeCount;
	}

	public int getAgreeCount(String Department, String Location, String Technology) {
		int agreeCount = 0;
		Connection conn = null;
		ResultSet result = null;
		PreparedStatement pstmt = null;
		try {
			StringBuilder sb = new StringBuilder(); 
			sb.append("SELECT count(A.email_id) as count FROM user_master_account A JOIN survey_response_sum B ON A.email_id = B.email_id Where B.survey_name = 'Agree'");
			if(Department != null && Department != "")
			{
				sb.append(" AND A.business_unit='"+ Department +"'");
			}	
			if(Location != null && Location != "")
			{
				sb.append(" AND A.location='"+ Location +"'");
			}
			if(Technology != null && Technology != "")
			{
				sb.append(" AND A.technology='"+ Technology +"'");
			}
			
			LOGGER.debug("[{}] get the rating count of the company pulse score view for dashbord of survey of chat bot application Query -> {}", sb.toString());
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sb.toString());
			if (conn != null) {
				result = pstmt.executeQuery();
				if (conn != null) {
					while (result.next()) {
						agreeCount =result.getInt("count");
					}
				}
			}
		} catch (SQLException exp) {
			LOGGER.error("[{}] Exception while get rating count of company pulse score view for dashbord of survey of chat bot application : {} ", exp);
			exp.printStackTrace();
		} catch (Exception exp) {
			LOGGER.error("[{}] Exception while get rating count of company pulse score view for dashbord of survey of chat bot application : {} ", exp);
			exp.printStackTrace();
		} finally {
			MySqlConnectionUtil.closedbConnection(pstmt, conn);
		}
		return agreeCount;
	}

	public int getStronglyAgreeCount(String Department, String Location, String Technology) {
		int stronglyAgreeCount = 0;
		Connection conn = null;
		ResultSet result = null;
		PreparedStatement pstmt = null;
		try {
			StringBuilder sb = new StringBuilder(); 
			sb.append("SELECT count(A.email_id) as count FROM user_master_account A JOIN survey_response_sum B ON A.email_id = B.email_id Where B.survey_name = 'Strongly agree'");
			if(Department != null && Department != "")
			{
				sb.append(" AND A.business_unit='"+ Department +"'");
			}	
			if(Location != null && Location != "")
			{
				sb.append(" AND A.location='"+ Location +"'");
			}
			if(Technology != null && Technology != "")
			{
				sb.append(" AND A.technology='"+ Technology +"'");
			}
			
			LOGGER.debug("[{}] get the rating count of the company pulse score view for dashbord of survey of chat bot application Query -> {}", sb.toString());
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sb.toString());
			if (conn != null) {
				result = pstmt.executeQuery();
				if (conn != null) {
					while (result.next()) {
						stronglyAgreeCount =result.getInt("count");
					}
				}
			}
		} catch (SQLException exp) {
			LOGGER.error("[{}] Exception while get rating count of company pulse score view for dashbord of survey of chat bot application : {} ", exp);
			exp.printStackTrace();
		} catch (Exception exp) {
			LOGGER.error("[{}] Exception while get rating count of company pulse score view for dashbord of survey of chat bot application : {} ", exp);
			exp.printStackTrace();
		} finally {
			MySqlConnectionUtil.closedbConnection(pstmt, conn);
		}
		return stronglyAgreeCount;
	}
	
	public int getTotalEmployee() {
		int totalEmployee = 0;
		Connection conn = null;
		ResultSet result = null;
		PreparedStatement pstmt = null;
		try {
			String sql = "SELECT count(A.email_id) as total_employee FROM user_master_account A JOIN survey_response_sum B ON A.email_id = B.email_id WHERE A.status=1";
			LOGGER.debug("[{}] Query for get the total employee associate response view for dashbord of survey of chat bot application -> {}", sql);
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			if (conn != null) {
				result = pstmt.executeQuery();
				while (result.next()) {
					totalEmployee = result.getInt("total_employee");
				}
			}
		} catch (SQLException exp) {
			LOGGER.error("[{}] Exception while  get the total employee of associate response view for dashbord of survey of chat bot application : {} ", exp);
			exp.printStackTrace();
		} catch (Exception exp) {
			LOGGER.error("[{}] Exception while  get the total employee associate response view for dashbord of survey of chat bot application : {} ", exp);
			exp.printStackTrace();
		} finally {
			MySqlConnectionUtil.closedbConnection(pstmt, conn);
		}
		
		return totalEmployee;
	}
	
	public int getTotalEmployeeFilter(String Department, String Location, String Technology) {
		int totalEmployee = 0;
		Connection conn = null;
		ResultSet result = null;
		PreparedStatement pstmt = null;
		try {
			StringBuilder sb = new StringBuilder(); 
			sb.append("SELECT count(A.email_id) as total_employee FROM user_master_account A JOIN survey_response_sum B ON A.email_id = B.email_id WHERE A.status=1");
			if(Department != null && Department != "")
			{
				sb.append(" AND A.business_unit='"+ Department +"'");
			}	
			if(Location != null && Location != "")
			{
				sb.append(" AND A.location='"+ Location +"'");
			}
			if(Technology != null && Technology != "")
			{
				sb.append(" AND A.technology='"+ Technology +"'");
			}
			LOGGER.debug("[{}] Query for get the total employee associate response view for dashbord of survey of chat bot application -> {}", sb.toString());
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sb.toString());
			if (conn != null) {
				result = pstmt.executeQuery();
				while (result.next()) {
					totalEmployee = result.getInt("total_employee");
				}
			}
		} catch (SQLException exp) {
			LOGGER.error("[{}] Exception while  get the total employee of associate response view for dashbord of survey of chat bot application : {} ", exp);
			exp.printStackTrace();
		} catch (Exception exp) {
			LOGGER.error("[{}] Exception while  get the total employee associate response view for dashbord of survey of chat bot application : {} ", exp);
			exp.printStackTrace();
		} finally {
			MySqlConnectionUtil.closedbConnection(pstmt, conn);
		}
		
		return totalEmployee;
	}

	public int getTotalResponse() {
		int totalResponse = 0;
		Connection conn = null;
		ResultSet result = null;
		PreparedStatement pstmt = null;
		try {
			String sql = "SELECT count(distinct B.email_id) as total_response FROM user_master_account A JOIN survey_response_sum B ON A.email_id = B.email_id";
			LOGGER.debug("[{}] Query for get total response of associate response view for dashbord of survey of chat bot application -> {}", sql);
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			if (conn != null) {
				result = pstmt.executeQuery();
				while (result.next()) {
					totalResponse = result.getInt("total_response");
				}
			}
		} catch (SQLException exp) {
			LOGGER.error("[{}] Exception while  get the total response of associate response view for dashbord of survey of chat bot application : {} ", exp);
			exp.printStackTrace();
		} catch (Exception exp) {
			LOGGER.error("[{}] Exception while  get the total response of associate response view for dashbord of survey of chat bot application : {} ", exp);
			exp.printStackTrace();
		} finally {
			MySqlConnectionUtil.closedbConnection(pstmt, conn);
		}
		return totalResponse;
	}

	/*public List<String> getlocations() {
		List<String> locations = new ArrayList<String>();
		Connection conn = null;
		ResultSet result = null;
		PreparedStatement pstmt = null;
		try {
			String sql = "SELECT distinct A.location as location FROM user_master_account A JOIN survey_response_sum B ON A.email_id = B.email_id";
			LOGGER.debug("[{}] get location  details for associate response view for dashbord of survey of chat bot application Query -> {}", sql);
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			if (conn != null) {
				result = pstmt.executeQuery();
				if (conn != null) {
					while (result.next()) 
					{
						String location = result.getString("location");
						locations.add(location);
					}
					MySqlConnectionUtil.closedbConnection(pstmt, conn);
				}
			}
		} catch (SQLException exp) {
			LOGGER.error("[{}] Exception while get location  details for associate response view for dashbord of survey of chat bot application : {} ", exp);
			exp.printStackTrace();
		} catch (Exception exp) {
			LOGGER.error("[{}] Exception while get location  details for associate response view for dashbord of survey of chat bot application : {} ", exp);
			exp.printStackTrace();
		} finally {
			MySqlConnectionUtil.closedbConnection(pstmt, conn);
		}
		
		return locations;
	}
	*/

	public int getDelhiPositive(String Department, String Location, String Technology) {
		int count = 0;
		Connection conn = null;
		ResultSet result = null;
		PreparedStatement pstmt = null;
		try {
			StringBuilder sb = new StringBuilder(); 
			sb.append("SELECT count(A.email_id) as positive FROM user_master_account A JOIN survey_response_sum B ON A.email_id = B.email_id  where A.location = 'Noida' AND B.survey_name IN ('Somewhat agree','Agree','Strongly agree')");
			if(Department != null && Department != "")
			{
				sb.append(" AND A.business_unit='"+ Department +"'");
			}	
			if(Technology != null && Technology != "")
			{
				sb.append(" AND A.technology='"+ Technology +"'");
			}
			
			LOGGER.debug("[{}] Query for get delhi positive of associate response view for dashbord of survey of chat bot application -> {}", sb.toString());
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sb.toString());
			if (conn != null) {
				result = pstmt.executeQuery();
				while (result.next()) {
					count = result.getInt("positive");
				}
			}
		} catch (SQLException exp) {
			LOGGER.error("[{}] Exception while  get the delhi positive for dashbord of survey of chat bot application : {} ", exp);
			exp.printStackTrace();
		} catch (Exception exp) {
			LOGGER.error("[{}] Exception while  get the delhi positive of associate response view for dashbord of survey of chat bot application : {} ", exp);
			exp.printStackTrace();
		} finally {
			MySqlConnectionUtil.closedbConnection(pstmt, conn);
		}
		return count;
	}
	
	public int getNoidaPositive(String Department, String Location, String Technology) {
		int count = 0;
		Connection conn = null;
		ResultSet result = null;
		PreparedStatement pstmt = null;
		try {
			StringBuilder sb = new StringBuilder(); 
			sb.append("SELECT count(A.email_id) as positive FROM user_master_account A JOIN survey_response_sum B ON A.email_id = B.email_id  where B.survey_name IN ('Somewhat agree','Agree','Strongly agree')");
			if(Department != null && Department != "")
			{
				sb.append(" AND A.business_unit='"+ Department +"'");
			}
			if(Location != null && Location != "")
			{
				sb.append(" AND A.location='"+ Location +"'");
			}
			if(Technology != null && Technology != "")
			{
				sb.append(" AND A.technology='"+ Technology +"'");
			}
			LOGGER.debug("[{}] Query for get delhi positive of associate response view for dashbord of survey of chat bot application -> {}", sb.toString());
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sb.toString());
			if (conn != null) {
				result = pstmt.executeQuery();
				while (result.next()) {
					count = result.getInt("positive");
				}
			}
		} catch (SQLException exp) {
			LOGGER.error("[{}] Exception while  get the delhi positive for dashbord of survey of chat bot application : {} ", exp);
			exp.printStackTrace();
		} catch (Exception exp) {
			LOGGER.error("[{}] Exception while  get the delhi positive of associate response view for dashbord of survey of chat bot application : {} ", exp);
			exp.printStackTrace();
		} finally {
			MySqlConnectionUtil.closedbConnection(pstmt, conn);
		}
		return count;
	}
	
	public int getNoidaNegative(String Department, String Location, String Technology) {
		int count = 0;
		Connection conn = null;
		ResultSet result = null;
		PreparedStatement pstmt = null;
		try {
			StringBuilder sb = new StringBuilder(); 
			sb.append("SELECT count(A.email_id) as negative FROM user_master_account A JOIN survey_response_sum B ON A.email_id = B.email_id  where B.survey_name IN ('Strongly disagree','Disagree','Somewhat disagree')");
			if (Department != null && Department != "") 
			{
				sb.append(" AND A.business_unit='" + Department + "'");
			}
			if (Location != null && Location != "") 
			{
				sb.append(" AND A.location='" + Location + "'");
			}
			if (Technology != null && Technology != "") 
			{
				sb.append(" AND A.technology='" + Technology + "'");
			}
			LOGGER.debug("[{}] Query for get delhi negative of associate response view for dashbord of survey of chat bot application -> {}", sb.toString());
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sb.toString());
			if (conn != null) {
				result = pstmt.executeQuery();
				while (result.next()) {
					count = result.getInt("negative");
				}
			}
		} catch (SQLException exp) {
			LOGGER.error("[{}] Exception while  get the delhi negative of associate response view for dashbord of survey of chat bot application : {} ", exp);
			exp.printStackTrace();
		} catch (Exception exp) {
			LOGGER.error("[{}] Exception while  get the delhi negative of associate response view for dashbord of survey of chat bot application : {} ", exp);
			exp.printStackTrace();
		} finally {
			MySqlConnectionUtil.closedbConnection(pstmt, conn);
		}
		return count;
	}
	

	public int getDelhiNegative(String Department, String Location, String Technology) {
		int count = 0;
		Connection conn = null;
		ResultSet result = null;
		PreparedStatement pstmt = null;
		try {
			StringBuilder sb = new StringBuilder(); 
			sb.append("SELECT count(A.email_id) as negative FROM user_master_account A JOIN survey_response_sum B ON A.email_id = B.email_id  where A.location = 'Noida' AND B.survey_name IN ('Strongly disagree','Disagree','Somewhat disagree')");
			if(Department != null && Department != "")
			{
				sb.append(" AND A.business_unit='"+ Department +"'");
			}	
			if(Technology != null && Technology != "")
			{
				sb.append(" AND A.technology='"+ Technology +"'");
			}
			
			LOGGER.debug("[{}] Query for get delhi negative of associate response view for dashbord of survey of chat bot application -> {}", sb.toString());
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sb.toString());
			if (conn != null) {
				result = pstmt.executeQuery();
				while (result.next()) {
					count = result.getInt("negative");
				}
			}
		} catch (SQLException exp) {
			LOGGER.error("[{}] Exception while  get the delhi negative of associate response view for dashbord of survey of chat bot application : {} ", exp);
			exp.printStackTrace();
		} catch (Exception exp) {
			LOGGER.error("[{}] Exception while  get the delhi negative of associate response view for dashbord of survey of chat bot application : {} ", exp);
			exp.printStackTrace();
		} finally {
			MySqlConnectionUtil.closedbConnection(pstmt, conn);
		}
		return count;
	}
	
	
	public int getMumbaiPositiveFilter(String Department, String Location, String Technology) {
		int count = 0;
		Connection conn = null;
		ResultSet result = null;
		PreparedStatement pstmt = null;
		try {
			StringBuilder sb = new StringBuilder(); 
			sb.append("SELECT count(A.email_id) as positive FROM user_master_account A JOIN survey_response_sum B ON A.email_id = B.email_id  where B.survey_name IN ('Somewhat agree','Agree','Strongly agree')");
			if(Department != null && Department != "")
			{
				sb.append(" AND A.business_unit='"+ Department +"'");
			}
			if(Location != null && Location != "")
			{
				sb.append(" AND A.location='"+ Location +"'");
			}
			if(Technology != null && Technology != "")
			{
				sb.append(" AND A.technology='"+ Technology +"'");
			}
			LOGGER.debug("[{}] Query for get mumbai positive of associate response view for dashbord of survey of chat bot application -> {}", sb.toString());
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sb.toString());
			if (conn != null) {
				result = pstmt.executeQuery();
				while (result.next()) {
					count = result.getInt("positive");
				}
			}
		} catch (SQLException exp) {
			LOGGER.error("[{}] Exception while  get the mumbai positive for dashbord of survey of chat bot application : {} ", exp);
			exp.printStackTrace();
		} catch (Exception exp) {
			LOGGER.error("[{}] Exception while  get the mumbai positive of associate response view for dashbord of survey of chat bot application : {} ", exp);
			exp.printStackTrace();
		} finally {
			MySqlConnectionUtil.closedbConnection(pstmt, conn);
		}
		return count;
	}
	
	public int getMumbaiNegativeFilter(String Department, String Location, String Technology) {
		int count = 0;
		Connection conn = null;
		ResultSet result = null;
		PreparedStatement pstmt = null;
		try {
			StringBuilder sb = new StringBuilder(); 
			sb.append("SELECT count(A.email_id) as negative FROM user_master_account A JOIN survey_response_sum B ON A.email_id = B.email_id  where B.survey_name IN ('Strongly disagree','Disagree','Somewhat disagree')");
			if (Department != null && Department != "") 
			{
				sb.append(" AND A.business_unit='" + Department + "'");
			}
			if (Location != null && Location != "") 
			{
				sb.append(" AND A.location='" + Location + "'");
			}
			if (Technology != null && Technology != "") 
			{
				sb.append(" AND A.technology='" + Technology + "'");
			}
			LOGGER.debug("[{}] Query for get mumbai negative of associate response view for dashbord of survey of chat bot application -> {}", sb.toString());
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sb.toString());
			if (conn != null) {
				result = pstmt.executeQuery();
				while (result.next()) {
					count = result.getInt("negative");
				}
			}
		} catch (SQLException exp) {
			LOGGER.error("[{}] Exception while  get the mumbai negative of associate response view for dashbord of survey of chat bot application : {} ", exp);
			exp.printStackTrace();
		} catch (Exception exp) {
			LOGGER.error("[{}] Exception while  get the mumbai negative of associate response view for dashbord of survey of chat bot application : {} ", exp);
			exp.printStackTrace();
		} finally {
			MySqlConnectionUtil.closedbConnection(pstmt, conn);
		}
		return count;
	}
	
	
	public int getChennaiPositiveFilter(String Department, String Location, String Technology) {
		int count = 0;
		Connection conn = null;
		ResultSet result = null;
		PreparedStatement pstmt = null;
		try {
			StringBuilder sb = new StringBuilder(); 
			sb.append("SELECT count(A.email_id) as positive FROM user_master_account A JOIN survey_response_sum B ON A.email_id = B.email_id  where B.survey_name IN ('Somewhat agree','Agree','Strongly agree')");
			if(Department != null && Department != "")
			{
				sb.append(" AND A.business_unit='"+ Department +"'");
			}
			if(Location != null && Location != "")
			{
				sb.append(" AND A.location='"+ Location +"'");
			}
			if(Technology != null && Technology != "")
			{
				sb.append(" AND A.technology='"+ Technology +"'");
			}
			LOGGER.debug("[{}] Query for get Chennai positive of associate response view for dashbord of survey of chat bot application -> {}", sb.toString());
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sb.toString());
			if (conn != null) {
				result = pstmt.executeQuery();
				while (result.next()) {
					count = result.getInt("positive");
				}
			}
		} catch (SQLException exp) {
			LOGGER.error("[{}] Exception while  get the Chennai positive for dashbord of survey of chat bot application : {} ", exp);
			exp.printStackTrace();
		} catch (Exception exp) {
			LOGGER.error("[{}] Exception while  get the Chennai positive of associate response view for dashbord of survey of chat bot application : {} ", exp);
			exp.printStackTrace();
		} finally {
			MySqlConnectionUtil.closedbConnection(pstmt, conn);
		}
		return count;
	}
	
	public int getChennaiNegativeFilter(String Department, String Location, String Technology) {
		int count = 0;
		Connection conn = null;
		ResultSet result = null;
		PreparedStatement pstmt = null;
		try {
			StringBuilder sb = new StringBuilder(); 
			sb.append("SELECT count(A.email_id) as negative FROM user_master_account A JOIN survey_response_sum B ON A.email_id = B.email_id  where B.survey_name IN ('Strongly disagree','Disagree','Somewhat disagree')");
			if (Department != null && Department != "") 
			{
				sb.append(" AND A.business_unit='" + Department + "'");
			}
			if (Location != null && Location != "") 
			{
				sb.append(" AND A.location='" + Location + "'");
			}
			if (Technology != null && Technology != "") 
			{
				sb.append(" AND A.technology='" + Technology + "'");
			}
			LOGGER.debug("[{}] Query for get Chennai negative of associate response view for dashbord of survey of chat bot application -> {}", sb.toString());
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sb.toString());
			if (conn != null) {
				result = pstmt.executeQuery();
				while (result.next()) {
					count = result.getInt("negative");
				}
			}
		} catch (SQLException exp) {
			LOGGER.error("[{}] Exception while  get the Chennai negative of associate response view for dashbord of survey of chat bot application : {} ", exp);
			exp.printStackTrace();
		} catch (Exception exp) {
			LOGGER.error("[{}] Exception while  get the Chennai negative of associate response view for dashbord of survey of chat bot application : {} ", exp);
			exp.printStackTrace();
		} finally {
			MySqlConnectionUtil.closedbConnection(pstmt, conn);
		}
		return count;
	}
	
	
	public int getKolkattaPositiveFilter(String Department, String Location, String Technology) {
		int count = 0;
		Connection conn = null;
		ResultSet result = null;
		PreparedStatement pstmt = null;
		try {
			StringBuilder sb = new StringBuilder(); 
			sb.append("SELECT count(A.email_id) as positive FROM user_master_account A JOIN survey_response_sum B ON A.email_id = B.email_id  where B.survey_name IN ('Somewhat agree','Agree','Strongly agree')");
			if(Department != null && Department != "")
			{
				sb.append(" AND A.business_unit='"+ Department +"'");
			}
			if(Location != null && Location != "")
			{
				sb.append(" AND A.location='"+ Location +"'");
			}
			if(Technology != null && Technology != "")
			{
				sb.append(" AND A.technology='"+ Technology +"'");
			}
			LOGGER.debug("[{}] Query for get Kolkatta positive of associate response view for dashbord of survey of chat bot application -> {}", sb.toString());
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sb.toString());
			if (conn != null) {
				result = pstmt.executeQuery();
				while (result.next()) {
					count = result.getInt("positive");
				}
			}
		} catch (SQLException exp) {
			LOGGER.error("[{}] Exception while  get the Kolkatta positive for dashbord of survey of chat bot application : {} ", exp);
			exp.printStackTrace();
		} catch (Exception exp) {
			LOGGER.error("[{}] Exception while  get the Kolkatta positive of associate response view for dashbord of survey of chat bot application : {} ", exp);
			exp.printStackTrace();
		} finally {
			MySqlConnectionUtil.closedbConnection(pstmt, conn);
		}
		return count;
	}
	
	public int getKolkattaNegativeFilter(String Department, String Location, String Technology) {
		int count = 0;
		Connection conn = null;
		ResultSet result = null;
		PreparedStatement pstmt = null;
		try {
			StringBuilder sb = new StringBuilder(); 
			sb.append("SELECT count(A.email_id) as negative FROM user_master_account A JOIN survey_response_sum B ON A.email_id = B.email_id  where B.survey_name IN ('Strongly disagree','Disagree','Somewhat disagree')");
			if (Department != null && Department != "") 
			{
				sb.append(" AND A.business_unit='" + Department + "'");
			}
			if (Location != null && Location != "") 
			{
				sb.append(" AND A.location='" + Location + "'");
			}
			if (Technology != null && Technology != "") 
			{
				sb.append(" AND A.technology='" + Technology + "'");
			}
			LOGGER.debug("[{}] Query for get Kolkatta negative of associate response view for dashbord of survey of chat bot application -> {}", sb.toString());
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sb.toString());
			if (conn != null) {
				result = pstmt.executeQuery();
				while (result.next()) {
					count = result.getInt("negative");
				}
			}
		} catch (SQLException exp) {
			LOGGER.error("[{}] Exception while  get the Kolkatta negative of associate response view for dashbord of survey of chat bot application : {} ", exp);
			exp.printStackTrace();
		} catch (Exception exp) {
			LOGGER.error("[{}] Exception while  get the Kolkatta negative of associate response view for dashbord of survey of chat bot application : {} ", exp);
			exp.printStackTrace();
		} finally {
			MySqlConnectionUtil.closedbConnection(pstmt, conn);
		}
		return count;
	}
	
	public int getBengaluruPositiveFilter(String Department, String Location, String Technology) {
		int count = 0;
		Connection conn = null;
		ResultSet result = null;
		PreparedStatement pstmt = null;
		try {
			StringBuilder sb = new StringBuilder(); 
			sb.append("SELECT count(A.email_id) as positive FROM user_master_account A JOIN survey_response_sum B ON A.email_id = B.email_id  where B.survey_name IN ('Somewhat agree','Agree','Strongly agree')");
			if(Department != null && Department != "")
			{
				sb.append(" AND A.business_unit='"+ Department +"'");
			}
			if(Location != null && Location != "")
			{
				sb.append(" AND A.location='"+ Location +"'");
			}
			if(Technology != null && Technology != "")
			{
				sb.append(" AND A.technology='"+ Technology +"'");
			}
			LOGGER.debug("[{}] Query for get Bengaluru positive of associate response view for dashbord of survey of chat bot application -> {}", sb.toString());
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sb.toString());
			if (conn != null) {
				result = pstmt.executeQuery();
				while (result.next()) {
					count = result.getInt("positive");
				}
			}
		} catch (SQLException exp) {
			LOGGER.error("[{}] Exception while  get the Bengaluru positive for dashbord of survey of chat bot application : {} ", exp);
			exp.printStackTrace();
		} catch (Exception exp) {
			LOGGER.error("[{}] Exception while  get the Bengaluru positive of associate response view for dashbord of survey of chat bot application : {} ", exp);
			exp.printStackTrace();
		} finally {
			MySqlConnectionUtil.closedbConnection(pstmt, conn);
		}
		return count;
	}
	
	public int getBengaluruNegativeFilter(String Department, String Location, String Technology) {
		int count = 0;
		Connection conn = null;
		ResultSet result = null;
		PreparedStatement pstmt = null;
		try {
			StringBuilder sb = new StringBuilder(); 
			sb.append("SELECT count(A.email_id) as negative FROM user_master_account A JOIN survey_response_sum B ON A.email_id = B.email_id  where B.survey_name IN ('Strongly disagree','Disagree','Somewhat disagree')");
			if (Department != null && Department != "") 
			{
				sb.append(" AND A.business_unit='" + Department + "'");
			}
			if (Location != null && Location != "") 
			{
				sb.append(" AND A.location='" + Location + "'");
			}
			if (Technology != null && Technology != "") 
			{
				sb.append(" AND A.technology='" + Technology + "'");
			}
			LOGGER.debug("[{}] Query for get Bengaluru negative of associate response view for dashbord of survey of chat bot application -> {}", sb.toString());
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sb.toString());
			if (conn != null) {
				result = pstmt.executeQuery();
				while (result.next()) {
					count = result.getInt("negative");
				}
			}
		} catch (SQLException exp) {
			LOGGER.error("[{}] Exception while  get the Bengaluru negative of associate response view for dashbord of survey of chat bot application : {} ", exp);
			exp.printStackTrace();
		} catch (Exception exp) {
			LOGGER.error("[{}] Exception while  get the Bengaluru negative of associate response view for dashbord of survey of chat bot application : {} ", exp);
			exp.printStackTrace();
		} finally {
			MySqlConnectionUtil.closedbConnection(pstmt, conn);
		}
		return count;
	}
	
	

	public int getMumbaiPositive(String Department, String Location, String Technology) {
		int count = 0;
		Connection conn = null;
		ResultSet result = null;
		PreparedStatement pstmt = null;
		try {
			StringBuilder sb = new StringBuilder(); 
			sb.append("SELECT count(A.email_id) as positive FROM user_master_account A JOIN survey_response_sum B ON A.email_id = B.email_id  where A.location = 'Mumbai' AND B.survey_name IN ('Somewhat agree','Agree','Strongly agree')");
			if(Department != null && Department != "")
			{
				sb.append(" AND A.business_unit='"+ Department +"'");
			}	
			if(Technology != null && Technology != "")
			{
				sb.append(" AND A.technology='"+ Technology +"'");
			}
			
			LOGGER.debug("[{}] Query for get Mumbai positive of associate response view for dashbord of survey of chat bot application -> {}", sb.toString());
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sb.toString());
			if (conn != null) {
				result = pstmt.executeQuery();
				while (result.next()) {
					count = result.getInt("positive");
				}
			}
		} catch (SQLException exp) {
			LOGGER.error("[{}] Exception while  get the Mumbai positive for dashbord of survey of chat bot application : {} ", exp);
			exp.printStackTrace();
		} catch (Exception exp) {
			LOGGER.error("[{}] Exception while  get the Mumbai positive of associate response view for dashbord of survey of chat bot application : {} ", exp);
			exp.printStackTrace();
		} finally {
			MySqlConnectionUtil.closedbConnection(pstmt, conn);
		}
		return count;
	}

	public int getMumbaiNegative(String Department, String Location, String Technology) {
		int count = 0;
		Connection conn = null;
		ResultSet result = null;
		PreparedStatement pstmt = null;
		try {
			StringBuilder sb = new StringBuilder(); 
			sb.append("SELECT count(A.email_id) as negative FROM user_master_account A JOIN survey_response_sum B ON A.email_id = B.email_id  where A.location = 'Mumbai' AND B.survey_name IN ('Strongly disagree','Disagree','Somewhat disagree')");
			if(Department != null && Department != "")
			{
				sb.append(" AND A.business_unit='"+ Department +"'");
			}	
			if(Technology != null && Technology != "")
			{
				sb.append(" AND A.technology='"+ Technology +"'");
			}
			
			LOGGER.debug("[{}] Query for get Mumbai negative of associate response view for dashbord of survey of chat bot application -> {}", sb.toString());
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sb.toString());
			if (conn != null) {
				result = pstmt.executeQuery();
				while (result.next()) {
					count = result.getInt("negative");
				}
			}
		} catch (SQLException exp) {
			LOGGER.error("[{}] Exception while  get the Mumbai negative of associate response view for dashbord of survey of chat bot application : {} ", exp);
			exp.printStackTrace();
		} catch (Exception exp) {
			LOGGER.error("[{}] Exception while  get the Mumbai negative of associate response view for dashbord of survey of chat bot application : {} ", exp);
			exp.printStackTrace();
		} finally {
			MySqlConnectionUtil.closedbConnection(pstmt, conn);
		}
		return count;
	}

	public int getChennaiPositive(String Department, String Location, String Technology) {
		int count = 0;
		Connection conn = null;
		ResultSet result = null;
		PreparedStatement pstmt = null;
		try {
			StringBuilder sb = new StringBuilder(); 
			sb.append("SELECT count(A.email_id) as positive FROM user_master_account A JOIN survey_response_sum B ON A.email_id = B.email_id  where A.location = 'Chennai' AND B.survey_name IN ('Somewhat agree','Agree','Strongly agree')");
			if(Department != null && Department != "")
			{
				sb.append(" AND A.business_unit='"+ Department +"'");
			}	
			if(Technology != null && Technology != "")
			{
				sb.append(" AND A.technology='"+ Technology +"'");
			}
			
			LOGGER.debug("[{}] Query for get Chennai positive of associate response view for dashbord of survey of chat bot application -> {}", sb.toString());
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sb.toString());
			if (conn != null) {
				result = pstmt.executeQuery();
				while (result.next()) {
					count = result.getInt("positive");
				}
			}
		} catch (SQLException exp) {
			LOGGER.error("[{}] Exception while  get the Chennai positive for dashbord of survey of chat bot application : {} ", exp);
			exp.printStackTrace();
		} catch (Exception exp) {
			LOGGER.error("[{}] Exception while  get the Chennai positive of associate response view for dashbord of survey of chat bot application : {} ", exp);
			exp.printStackTrace();
		} finally {
			MySqlConnectionUtil.closedbConnection(pstmt, conn);
		}
		return count;
	}

	public int getChennaiNegative(String Department, String Location, String Technology) {
		int count = 0;
		Connection conn = null;
		ResultSet result = null;
		PreparedStatement pstmt = null;
		try {
			StringBuilder sb = new StringBuilder(); 
			sb.append("SELECT count(A.email_id) as negative FROM user_master_account A JOIN survey_response_sum B ON A.email_id = B.email_id  where A.location = 'Chennai' AND B.survey_name IN ('Strongly disagree','Disagree','Somewhat disagree')");
			if(Department != null && Department != "")
			{
				sb.append(" AND A.business_unit='"+ Department +"'");
			}	
			if(Technology != null && Technology != "")
			{
				sb.append(" AND A.technology='"+ Technology +"'");
			}
			
			LOGGER.debug("[{}] Query for get Chennai negative of associate response view for dashbord of survey of chat bot application -> {}", sb.toString());
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sb.toString());
			if (conn != null) {
				result = pstmt.executeQuery();
				while (result.next()) {
					count = result.getInt("negative");
				}
			}
		} catch (SQLException exp) {
			LOGGER.error("[{}] Exception while  get the Chennai negative of associate response view for dashbord of survey of chat bot application : {} ", exp);
			exp.printStackTrace();
		} catch (Exception exp) {
			LOGGER.error("[{}] Exception while  get the Chennai negative of associate response view for dashbord of survey of chat bot application : {} ", exp);
			exp.printStackTrace();
		} finally {
			MySqlConnectionUtil.closedbConnection(pstmt, conn);
		}
		return count;
	}

	public int getKolkataPositive(String Department, String Location, String Technology) {
		int count = 0;
		Connection conn = null;
		ResultSet result = null;
		PreparedStatement pstmt = null;
		try {
			StringBuilder sb = new StringBuilder(); 
			sb.append("SELECT count(A.email_id) as positive FROM user_master_account A JOIN survey_response_sum B ON A.email_id = B.email_id  where A.location = 'Kolkatta' AND B.survey_name IN ('Somewhat agree','Agree','Strongly agree')");
			if(Department != null && Department != "")
			{
				sb.append(" AND A.business_unit='"+ Department +"'");
			}	
			if(Technology != null && Technology != "")
			{
				sb.append(" AND A.technology='"+ Technology +"'");
			}
			
			LOGGER.debug("[{}] Query for get Kolkata positive of associate response view for dashbord of survey of chat bot application -> {}", sb.toString());
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sb.toString());
			if (conn != null) {
				result = pstmt.executeQuery();
				while (result.next()) {
					count = result.getInt("positive");
				}
			}
		} catch (SQLException exp) {
			LOGGER.error("[{}] Exception while  get the Kolkata positive for dashbord of survey of chat bot application : {} ", exp);
			exp.printStackTrace();
		} catch (Exception exp) {
			LOGGER.error("[{}] Exception while  get the Kolkata positive of associate response view for dashbord of survey of chat bot application : {} ", exp);
			exp.printStackTrace();
		} finally {
			MySqlConnectionUtil.closedbConnection(pstmt, conn);
		}
		return count;
	}

	public int getKolkataNegative(String Department, String Location, String Technology) {
			int count = 0;
			Connection conn = null;
			ResultSet result = null;
			PreparedStatement pstmt = null;
			try {
				StringBuilder sb = new StringBuilder(); 
				sb.append("SELECT count(A.email_id) as negative FROM user_master_account A JOIN survey_response_sum B ON A.email_id = B.email_id  where A.location = 'Kolkatta' AND B.survey_name IN ('Strongly disagree','Disagree','Somewhat disagree')");
				if(Department != null && Department != "")
				{
					sb.append(" AND A.business_unit='"+ Department +"'");
				}	
				if(Technology != null && Technology != "")
				{
					sb.append(" AND A.technology='"+ Technology +"'");
				}
				
				LOGGER.debug("[{}] Query for get Kolkata negative of associate response view for dashbord of survey of chat bot application -> {}", sb.toString());
				conn = dataSource.getConnection();
				pstmt = conn.prepareStatement(sb.toString());
				if (conn != null) {
					result = pstmt.executeQuery();
					while (result.next()) {
						count = result.getInt("negative");
					}
				}
			} catch (SQLException exp) {
				LOGGER.error("[{}] Exception while  get the Kolkata negative of associate response view for dashbord of survey of chat bot application : {} ", exp);
				exp.printStackTrace();
			} catch (Exception exp) {
				LOGGER.error("[{}] Exception while  get the Kolkata negative of associate response view for dashbord of survey of chat bot application : {} ", exp);
				exp.printStackTrace();
			} finally {
				MySqlConnectionUtil.closedbConnection(pstmt, conn);
			}
			return count;
	}

	public int getPunePositive() {
		int count = 0;
		Connection conn = null;
		ResultSet result = null;
		PreparedStatement pstmt = null;
		try {
			String sql = "SELECT count(distinct B.email_id) as positive FROM user_master_account A JOIN survey_response_sum B "
						+ " ON A.email_id = B.email_id where A.location = 'Pune' AND survey_name IN ('Somewhat agree','Agree','Strongly agree')";
			LOGGER.debug("[{}] Query for get Pune positive of associate response view for dashbord of survey of chat bot application -> {}", sql);
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			if (conn != null) {
				result = pstmt.executeQuery();
				while (result.next()) {
					count = result.getInt("positive");
				}
			}
		} catch (SQLException exp) {
			LOGGER.error("[{}] Exception while  get the Pune positive for dashbord of survey of chat bot application : {} ", exp);
			exp.printStackTrace();
		} catch (Exception exp) {
			LOGGER.error("[{}] Exception while  get the Pune positive of associate response view for dashbord of survey of chat bot application : {} ", exp);
			exp.printStackTrace();
		} finally {
			MySqlConnectionUtil.closedbConnection(pstmt, conn);
		}
		return count;
	}

	public int getPuneNegative() {
		int count = 0;
		Connection conn = null;
		ResultSet result = null;
		PreparedStatement pstmt = null;
		try {
			String sql = "SELECT count(distinct B.email_id) as negative FROM user_master_account A JOIN survey_response_sum B "
						+ " ON A.email_id = B.email_id where A.location = 'Pune' AND survey_name IN ('Strongly disagree','Disagree','Somewhat disagree')";
			LOGGER.debug("[{}] Query for get Pune negative of associate response view for dashbord of survey of chat bot application -> {}", sql);
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			if (conn != null) {
				result = pstmt.executeQuery();
				while (result.next()) {
					count = result.getInt("negative");
				}
			}
		} catch (SQLException exp) {
			LOGGER.error("[{}] Exception while  get the Pune negative of associate response view for dashbord of survey of chat bot application : {} ", exp);
			exp.printStackTrace();
		} catch (Exception exp) {
			LOGGER.error("[{}] Exception while  get the Pune negative of associate response view for dashbord of survey of chat bot application : {} ", exp);
			exp.printStackTrace();
		} finally {
			MySqlConnectionUtil.closedbConnection(pstmt, conn);
		}
		return count;
	}

	public int getBanglorePositive(String Department, String Location, String Technology) {
		int count = 0;
		Connection conn = null;
		ResultSet result = null;
		PreparedStatement pstmt = null;
		try {
			StringBuilder sb = new StringBuilder(); 
			sb.append("SELECT count(A.email_id) as positive FROM user_master_account A JOIN survey_response_sum B ON A.email_id = B.email_id  where A.location = 'Bengaluru' AND B.survey_name IN ('Somewhat agree','Agree','Strongly agree')");
			if(Department != null && Department != "")
			{
				sb.append(" AND A.business_unit='"+ Department +"'");
			}	
			if(Technology != null && Technology != "")
			{
				sb.append(" AND A.technology='"+ Technology +"'");
			}
			
			LOGGER.debug("[{}] Query for get Banglore positive of associate response view for dashbord of survey of chat bot application -> {}", sb.toString());
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sb.toString());
			if (conn != null) {
				result = pstmt.executeQuery();
				while (result.next()) {
					count = result.getInt("positive");
				}
			}
		} catch (SQLException exp) {
			LOGGER.error("[{}] Exception while  get the Banglore positive for dashbord of survey of chat bot application : {} ", exp);
			exp.printStackTrace();
		} catch (Exception exp) {
			LOGGER.error("[{}] Exception while  get the Banglore positive of associate response view for dashbord of survey of chat bot application : {} ", exp);
			exp.printStackTrace();
		} finally {
			MySqlConnectionUtil.closedbConnection(pstmt, conn);
		}
		return count;
	}

	public int getBangloreNegative(String Department, String Location, String Technology) {
		int count = 0;
		Connection conn = null;
		ResultSet result = null;
		PreparedStatement pstmt = null;
		try {
			StringBuilder sb = new StringBuilder(); 
			sb.append("SELECT count(A.email_id) as negative FROM user_master_account A JOIN survey_response_sum B ON A.email_id = B.email_id  where A.location = 'Bengaluru' AND B.survey_name IN ('Strongly disagree','Disagree','Somewhat disagree')");
			if(Department != null && Department != "")
			{
				sb.append(" AND A.business_unit='"+ Department +"'");
			}	
			if(Technology != null && Technology != "")
			{
				sb.append(" AND A.technology='"+ Technology +"'");
			}
			
			LOGGER.debug("[{}] Query for get Banglore negative of associate response view for dashbord of survey of chat bot application -> {}", sb.toString());
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sb.toString());
			if (conn != null) {
				result = pstmt.executeQuery();
				while (result.next()) {
					count = result.getInt("negative");
				}
			}
		} catch (SQLException exp) {
			LOGGER.error("[{}] Exception while  get the Banglore negative of associate response view for dashbord of survey of chat bot application : {} ", exp);
			exp.printStackTrace();
		} catch (Exception exp) {
			LOGGER.error("[{}] Exception while  get the Banglore negative of associate response view for dashbord of survey of chat bot application : {} ", exp);
			exp.printStackTrace();
		} finally {
			MySqlConnectionUtil.closedbConnection(pstmt, conn);
		}
		return count;
	}

	public int getHydrabadPositive() {
		int count = 0;
		Connection conn = null;
		ResultSet result = null;
		PreparedStatement pstmt = null;
		try {
			String sql = "SELECT count(distinct B.email_id) as positive FROM user_master_account A JOIN survey_response_sum B "
						+ " ON A.email_id = B.email_id where A.location = 'Hydrabad' AND survey_name IN ('Somewhat agree','Agree','Strongly agree')";
			LOGGER.debug("[{}] Query for get Hydrabad positive of associate response view for dashbord of survey of chat bot application -> {}", sql);
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			if (conn != null) {
				result = pstmt.executeQuery();
				while (result.next()) {
					count = result.getInt("positive");
				}
			}
		} catch (SQLException exp) {
			LOGGER.error("[{}] Exception while  get the Hydrabad positive for dashbord of survey of chat bot application : {} ", exp);
			exp.printStackTrace();
		} catch (Exception exp) {
			LOGGER.error("[{}] Exception while  get the Hydrabad positive of associate response view for dashbord of survey of chat bot application : {} ", exp);
			exp.printStackTrace();
		} finally {
			MySqlConnectionUtil.closedbConnection(pstmt, conn);
		}
		return count;
	}

	public int getHydrabadNegative() {
		int count = 0;
		Connection conn = null;
		ResultSet result = null;
		PreparedStatement pstmt = null;
		try {
			String sql = "SELECT count(distinct B.email_id) as negative FROM user_master_account A JOIN survey_response_sum B "
						+ " ON A.email_id = B.email_id where A.location = 'Hydrabad' AND survey_name IN ('Strongly disagree','Disagree','Somewhat disagree')";
			LOGGER.debug("[{}] Query for get Hydrabad negative of associate response view for dashbord of survey of chat bot application -> {}", sql);
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			if (conn != null) {
				result = pstmt.executeQuery();
				while (result.next()) {
					count = result.getInt("negative");
				}
			}
		} catch (SQLException exp) {
			LOGGER.error("[{}] Exception while  get the Hydrabad negative of associate response view for dashbord of survey of chat bot application : {} ", exp);
			exp.printStackTrace();
		} catch (Exception exp) {
			LOGGER.error("[{}] Exception while  get the Hydrabad negative of associate response view for dashbord of survey of chat bot application : {} ", exp);
			exp.printStackTrace();
		} finally {
			MySqlConnectionUtil.closedbConnection(pstmt, conn);
		}
		return count;
	}

	public OverallCompanyMoodParam getOverallCompanyMood() {
		OverallCompanyMoodParam overallCompanyMoodParam = new OverallCompanyMoodParam();
		Connection conn = null;
		ResultSet result = null;
		PreparedStatement pstmt = null;
		try {
			String sql = "SELECT ROUND(avg(survey_average), 1) as companyMood FROM overall_company_mood";
			LOGGER.debug("[{}] get the rating avg of the over all company mood for dashbord of survey of chat bot application Query -> {}", sql);
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			if (conn != null) {
				result = pstmt.executeQuery();
				if (conn != null) {
					while (result.next()) {
						overallCompanyMoodParam.setOverAllMood(result.getInt("companyMood"));
					}
				}
			}
		} catch (SQLException exp) {
			LOGGER.error("[{}] Exception while get rating avg of the over all company mood for dashbord of survey of chat bot application : {} ", exp);
			exp.printStackTrace();
		} catch (Exception exp) {
			LOGGER.error("[{}] Exception while get rating avg of the over all company mood for dashbord of survey of chat bot application : {} ", exp);
			exp.printStackTrace();
		} finally {
			MySqlConnectionUtil.closedbConnection(pstmt, conn);
		}
		return overallCompanyMoodParam;
	}

	public int getTotalSurveyCount(String Department, String Location, String Technology) {
		int count = 0;
		Connection conn = null;
		ResultSet result = null;
		PreparedStatement pstmt = null;
		try {
			StringBuilder sb = new StringBuilder(); 
			sb.append("SELECT count(A.email_id) as count FROM user_master_account A JOIN survey_response_sum B ON A.email_id = B.email_id  where A.status=1");
			if(Department != null && Department != "")
			{
				sb.append(" AND A.business_unit='"+ Department +"'");
			}	
			if(Location != null && Location != "")
			{
				sb.append(" AND A.location='"+ Location +"'");
			}
			if(Technology != null && Technology != "")
			{
				sb.append(" AND A.technology='"+ Technology +"'");
			}
			
			LOGGER.debug("[{}] Query for get Flight Risk Analysis total count for dashbord of survey of chat bot application -> {}", sb.toString());
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sb.toString());
			if (conn != null) {
				result = pstmt.executeQuery();
				while (result.next()) {
					count = result.getInt("count");
				}
			}
		} catch (SQLException exp) {
			LOGGER.error("[{}] Exception while  get the Flight Risk Analysis total count for dashbord of survey of chat bot application : {} ", exp);
			exp.printStackTrace();
		} catch (Exception exp) {
			LOGGER.error("[{}] Exception while  get the Flight Risk Analysis total count for dashbord of survey of chat bot application : {} ", exp);
			exp.printStackTrace();
		} finally {
			MySqlConnectionUtil.closedbConnection(pstmt, conn);
		}
		return count;
	}

	public int getHighRiskCount(String Department, String Location, String Technology) {
		int count = 0;
		Connection conn = null;
		ResultSet result = null;
		PreparedStatement pstmt = null;
		try {
			StringBuilder sb = new StringBuilder(); 
			sb.append("SELECT count(A.email_id) as count FROM user_master_account A JOIN survey_response_sum B ON A.email_id = B.email_id  where A.status=1 AND B.survey_name in ('Strongly disagree','Disagree')");
			if(Department != null && Department != "")
			{
				sb.append(" AND A.business_unit='"+ Department +"'");
			}	
			if(Location != null && Location != "")
			{
				sb.append(" AND A.location='"+ Location +"'");
			}
			if(Technology != null && Technology != "")
			{
				sb.append(" AND A.technology='"+ Technology +"'");
			}
			
			LOGGER.debug("[{}] Query for get High Risk count for dashbord of survey of chat bot application -> {}", sb.toString());
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sb.toString());
			if (conn != null) {
				result = pstmt.executeQuery();
				while (result.next()) {
					count = result.getInt("count");
				}
			}
		} catch (SQLException exp) {
			LOGGER.error("[{}] Exception while  get the High Risk count for dashbord of survey of chat bot application : {} ", exp);
			exp.printStackTrace();
		} catch (Exception exp) {
			LOGGER.error("[{}] Exception while  get the High Risk count for dashbord of survey of chat bot application : {} ", exp);
			exp.printStackTrace();
		} finally {
			MySqlConnectionUtil.closedbConnection(pstmt, conn);
		}
		return count;
	}

	public int getMediumRiskCount(String Department, String Location, String Technology) {
		int count = 0;
		Connection conn = null;
		ResultSet result = null;
		PreparedStatement pstmt = null;
		try {
			StringBuilder sb = new StringBuilder(); 
			sb.append("SELECT count(A.email_id) as count FROM user_master_account A JOIN survey_response_sum B ON A.email_id = B.email_id  where A.status=1 AND B.survey_name in ('Somewhat disagree','Somewhat agree')");
			if(Department != null && Department != "")
			{
				sb.append(" AND A.business_unit='"+ Department +"'");
			}	
			if(Location != null && Location != "")
			{
				sb.append(" AND A.location='"+ Location +"'");
			}
			if(Technology != null && Technology != "")
			{
				sb.append(" AND A.technology='"+ Technology +"'");
			}
			
			LOGGER.debug("[{}] Query for get Medium Risk count for dashbord of survey of chat bot application -> {}", sb.toString());
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sb.toString());
			if (conn != null) {
				result = pstmt.executeQuery();
				while (result.next()) {
					count = result.getInt("count");
				}
			}
		} catch (SQLException exp) {
			LOGGER.error("[{}] Exception while  get the Medium Risk count for dashbord of survey of chat bot application : {} ", exp);
			exp.printStackTrace();
		} catch (Exception exp) {
			LOGGER.error("[{}] Exception while  get the Medium Risk count for dashbord of survey of chat bot application : {} ", exp);
			exp.printStackTrace();
		} finally {
			MySqlConnectionUtil.closedbConnection(pstmt, conn);
		}
		return count;
	}

	public int getNoRiskCount(String Department, String Location, String Technology) {
		int count = 0;
		Connection conn = null;
		ResultSet result = null;
		PreparedStatement pstmt = null;
		try {
			StringBuilder sb = new StringBuilder(); 
			sb.append("SELECT count(A.email_id) as count FROM user_master_account A JOIN survey_response_sum B ON A.email_id = B.email_id  where A.status=1 AND B.survey_name in ('Agree','Strongly agree')");
			if(Department != null && Department != "")
			{
				sb.append(" AND A.business_unit='"+ Department +"'");
			}	
			if(Location != null && Location != "")
			{
				sb.append(" AND A.location='"+ Location +"'");
			}
			if(Technology != null && Technology != "")
			{
				sb.append(" AND A.technology='"+ Technology +"'");
			}
			
			LOGGER.debug("[{}] Query for get No Risk count for dashbord of survey of chat bot application -> {}", sb.toString());
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sb.toString());
			if (conn != null) {
				result = pstmt.executeQuery();
				while (result.next()) {
					count = result.getInt("count");
				}
			}
		} catch (SQLException exp) {
			LOGGER.error("[{}] Exception while  get the No Risk count for dashbord of survey of chat bot application : {} ", exp);
			exp.printStackTrace();
		} catch (Exception exp) {
			LOGGER.error("[{}] Exception while  get the No Risk count for dashbord of survey of chat bot application : {} ", exp);
			exp.printStackTrace();
		} finally {
			MySqlConnectionUtil.closedbConnection(pstmt, conn);
		}
		return count;
	}

	public int getTotalAssociates() {
		int totalEmployee = 0;
		Connection conn = null;
		ResultSet result = null;
		PreparedStatement pstmt = null;
		try {
			String sql = "SELECT COUNT(*) AS total_employee FROM user_master_account";
			LOGGER.debug("[{}] Query for get the total associate  for dashbord of survey of chat bot application -> {}", sql);
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			if (conn != null) {
				result = pstmt.executeQuery();
				while (result.next()) {
					totalEmployee = result.getInt("total_employee");
				}
			}
		} catch (SQLException exp) {
			LOGGER.error("[{}] Exception while  get the total associate for dashbord of survey of chat bot application : {} ", exp);
			exp.printStackTrace();
		} catch (Exception exp) {
			LOGGER.error("[{}] Exception while  get the total associate for dashbord of survey of chat bot application : {} ", exp);
			exp.printStackTrace();
		} finally {
			MySqlConnectionUtil.closedbConnection(pstmt, conn);
		}
		
		return totalEmployee;
	}

	public int getTotalBusinesUnit() {
		int totalResponse = 0;
		Connection conn = null;
		ResultSet result = null;
		PreparedStatement pstmt = null;
		try {
			String sql = "SELECT count(distinct `function/bu`) as total_business_unit FROM user_master_account";
			LOGGER.debug("[{}] Query for get total business unit for dashbord of survey of chat bot application -> {}", sql);
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			if (conn != null) {
				result = pstmt.executeQuery();
				while (result.next()) {
					totalResponse = result.getInt("total_business_unit");
				}
			}
		} catch (SQLException exp) {
			LOGGER.error("[{}] Exception while  get the total business unit for dashbord of survey of chat bot application : {} ", exp);
			exp.printStackTrace();
		} catch (Exception exp) {
			LOGGER.error("[{}] Exception while  get the total business unit for dashbord of survey of chat bot application : {} ", exp);
			exp.printStackTrace();
		} finally {
			MySqlConnectionUtil.closedbConnection(pstmt, conn);
		}
		return totalResponse;
	}

	/*public List<BusinesUnitA> getBuA() {
		List<BusinesUnitA> buA = new ArrayList<BusinesUnitA>();
		BusinesUnitA businesUnitA = new BusinesUnitA();
		Connection conn = null;
		ResultSet result = null;
		PreparedStatement pstmt = null;
		try {
			String sql = "SELECT A.`function/bu`, B.survey_name, count(*) as survey_conunt "
					+ " FROM user_master_account A JOIN survey_response_sum B ON A.email_id = B.email_id Where A.`function/bu` = 1"
					+ " group by A.`function/bu` ,B.survey_name order by A.`function/bu` asc";
			LOGGER.debug("[{}] Query for get the business A count of severy name count for dashbord of survey of chat bot application -> {}", sql);
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			if (conn != null) {
				result = pstmt.executeQuery();
				while (result.next()) {
					businesUnitA = new BusinesUnitA();
					
					businesUnitA.setBusinesUnitNo(result.getInt("function/bu"));
					businesUnitA.setSurveyName(result.getString("survey_name"));
					businesUnitA.setSurveyCount(result.getInt("survey_conunt"));
					
					buA.add(businesUnitA);
				}
			}
		} catch (SQLException exp) {
			LOGGER.error("[{}] Exception while  get the business A count of severy name count of chat bot application : {} ", exp);
			exp.printStackTrace();
		} catch (Exception exp) {
			LOGGER.error("[{}] Exception while  get the business A count of severy name count of chat bot application : {} ", exp);
			exp.printStackTrace();
		} finally {
			MySqlConnectionUtil.closedbConnection(pstmt, conn);
		}
		return buA;
	}

	public List<BusinesUnitB> getBuB() {
		List<BusinesUnitB> buB = new ArrayList<BusinesUnitB>();
		BusinesUnitB businesUnitB = new BusinesUnitB();
		Connection conn = null;
		ResultSet result = null;
		PreparedStatement pstmt = null;
		try {
			String sql = "SELECT A.`function/bu`, B.survey_name, count(*) as survey_conunt "
					+ " FROM user_master_account A JOIN survey_response_sum B ON A.email_id = B.email_id Where A.`function/bu` = 2"
					+ " group by A.`function/bu` ,B.survey_name order by A.`function/bu` asc";
			LOGGER.debug("[{}] Query for get the business B count of severy name count for dashbord of survey of chat bot application -> {}", sql);
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			if (conn != null) {
				result = pstmt.executeQuery();
				while (result.next()) {
					businesUnitB = new BusinesUnitB();
					
					businesUnitB.setBusinesUnitNo(result.getInt("function/bu"));
					businesUnitB.setSurveyName(result.getString("survey_name"));
					businesUnitB.setSurveyCount(result.getInt("survey_conunt"));
					
					buB.add(businesUnitB);
				}
			}
		} catch (SQLException exp) {
			LOGGER.error("[{}] Exception while  get the business B count of severy name count of chat bot application : {} ", exp);
			exp.printStackTrace();
		} catch (Exception exp) {
			LOGGER.error("[{}] Exception while  get the business B count of severy name count of chat bot application : {} ", exp);
			exp.printStackTrace();
		} finally {
			MySqlConnectionUtil.closedbConnection(pstmt, conn);
		}
		return buB;
	}

	public List<BusinesUnitC> getBuC() {
		List<BusinesUnitC> buC = new ArrayList<BusinesUnitC>();
		BusinesUnitC businesUnitC = new BusinesUnitC();
		Connection conn = null;
		ResultSet result = null;
		PreparedStatement pstmt = null;
		try {
			String sql = "SELECT A.`function/bu`, B.survey_name, count(*) as survey_conunt "
					+ " FROM user_master_account A JOIN survey_response_sum B ON A.email_id = B.email_id Where A.`function/bu` = 3"
					+ " group by A.`function/bu` ,B.survey_name order by A.`function/bu` asc";
			LOGGER.debug("[{}] Query for get the business C count of severy name count for dashbord of survey of chat bot application -> {}", sql);
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			if (conn != null) {
				result = pstmt.executeQuery();
				while (result.next()) {
					businesUnitC = new BusinesUnitC();
					
					businesUnitC.setBusinesUnitNo(result.getInt("function/bu"));
					businesUnitC.setSurveyName(result.getString("survey_name"));
					businesUnitC.setSurveyCount(result.getInt("survey_conunt"));
					
					buC.add(businesUnitC);
				}
			}
		} catch (SQLException exp) {
			LOGGER.error("[{}] Exception while  get the business C count of severy name count of chat bot application : {} ", exp);
			exp.printStackTrace();
		} catch (Exception exp) {
			LOGGER.error("[{}] Exception while  get the business C count of severy name count of chat bot application : {} ", exp);
			exp.printStackTrace();
		} finally {
			MySqlConnectionUtil.closedbConnection(pstmt, conn);
		}
		return buC;
	}

	public List<BusinesUnitD> getBuD() {
		List<BusinesUnitD> buD = new ArrayList<BusinesUnitD>();
		BusinesUnitD businesUnitD = new BusinesUnitD();
		Connection conn = null;
		ResultSet result = null;
		PreparedStatement pstmt = null;
		try {
			String sql = "SELECT A.`function/bu`, B.survey_name, count(*) as survey_conunt "
					+ " FROM user_master_account A JOIN survey_response_sum B ON A.email_id = B.email_id Where A.`function/bu` = 4"
					+ " group by A.`function/bu` ,B.survey_name order by A.`function/bu` asc";
			LOGGER.debug("[{}] Query for get the business D count of severy name count for dashbord of survey of chat bot application -> {}", sql);
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			if (conn != null) {
				result = pstmt.executeQuery();
				while (result.next()) {
					businesUnitD = new BusinesUnitD();
					
					businesUnitD.setBusinesUnitNo(result.getInt("function/bu"));
					businesUnitD.setSurveyName(result.getString("survey_name"));
					businesUnitD.setSurveyCount(result.getInt("survey_conunt"));
					
					buD.add(businesUnitD);
				}
			}
		} catch (SQLException exp) {
			LOGGER.error("[{}] Exception while  get the business D count of severy name count of chat bot application : {} ", exp);
			exp.printStackTrace();
		} catch (Exception exp) {
			LOGGER.error("[{}] Exception while  get the business D count of severy name count of chat bot application : {} ", exp);
			exp.printStackTrace();
		} finally {
			MySqlConnectionUtil.closedbConnection(pstmt, conn);
		}
		return buD;
	}*/

	public int getStronglyDisengage(int i, String type, String Department, String Location, String Technology) {
		int totalCount = 0;
		Connection conn = null;
		ResultSet result = null;
		PreparedStatement pstmt = null;
		try {
			StringBuilder sb = new StringBuilder(); 
			sb.append("SELECT B.survey_name, count(*) as survey_conunt FROM user_master_account A JOIN survey_response_sum B ON A.email_id = B.email_id  Where A.status = 1 AND A.`function/bu` = " + i + " AND B.survey_name = '" + type + "'");
			/*if(Department != null && Department != "")
			{
				sb.append(" AND A.business_unit='"+ Department +"'");
			}*/	
			if(Location != null && Location != "")
			{
				sb.append(" AND A.location='"+ Location +"'");
			}
			if(Technology != null && Technology != "")
			{
				sb.append(" AND A.technology='"+ Technology +"'");
			}
			LOGGER.debug("[{}] Query for get total count of  StronglyDisengage for unit pulse view of survey of chat bot application -> {}", sb.toString());
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sb.toString());
			if (conn != null) {
				result = pstmt.executeQuery();
				while (result.next()) {
					totalCount = result.getInt("survey_conunt");
				}
			}
		} catch (SQLException exp) {
			LOGGER.error("[{}] Exception while  get the total count of  StronglyDisengage for unit pulse view of survey of chat bot application : {} ", exp);
			exp.printStackTrace();
		} catch (Exception exp) {
			LOGGER.error("[{}] Exception while  get the total count of  StronglyDisengage for unit pulse view of survey of chat bot application : {} ", exp);
			exp.printStackTrace();
		} finally {
			MySqlConnectionUtil.closedbConnection(pstmt, conn);
		}
		return totalCount;
	}

	public int getDisengage(int i, String type, String Department, String Location, String Technology) {
		int totalCount = 0;
		Connection conn = null;
		ResultSet result = null;
		PreparedStatement pstmt = null;
		try {
			StringBuilder sb = new StringBuilder(); 
			sb.append("SELECT B.survey_name, count(*) as survey_conunt FROM user_master_account A JOIN survey_response_sum B ON A.email_id = B.email_id  Where A.status = 1 AND A.`function/bu` = " + i + " AND B.survey_name = '" + type + "'");
			/*if(Department != null && Department != "")
			{
				sb.append(" AND A.business_unit='"+ Department +"'");
			}*/	
			if(Location != null && Location != "")
			{
				sb.append(" AND A.location='"+ Location +"'");
			}
			if(Technology != null && Technology != "")
			{
				sb.append(" AND A.technology='"+ Technology +"'");
			}
			
			LOGGER.debug("[{}] Query for get total count of  Disengage for unit pulse view of survey of chat bot application -> {}", sb.toString());
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sb.toString());
			if (conn != null) {
				result = pstmt.executeQuery();
				while (result.next()) {
					totalCount = result.getInt("survey_conunt");
				}
			}
		} catch (SQLException exp) {
			LOGGER.error("[{}] Exception while  get the total count of  Disengage for unit pulse view of survey of chat bot application : {} ", exp);
			exp.printStackTrace();
		} catch (Exception exp) {
			LOGGER.error("[{}] Exception while  get the total count of  Disengage for unit pulse view of survey of chat bot application : {} ", exp);
			exp.printStackTrace();
		} finally {
			MySqlConnectionUtil.closedbConnection(pstmt, conn);
		}
		return totalCount;
	}

	public int getSomewhatDisengage(int i, String type, String Department, String Location, String Technology) {
		int totalCount = 0;
		Connection conn = null;
		ResultSet result = null;
		PreparedStatement pstmt = null;
		try {
			StringBuilder sb = new StringBuilder(); 
			sb.append("SELECT B.survey_name, count(*) as survey_conunt FROM user_master_account A JOIN survey_response_sum B ON A.email_id = B.email_id  Where A.status = 1 AND A.`function/bu` = " + i + " AND B.survey_name = '" + type + "'");
			/*if(Department != null && Department != "")
			{
				sb.append(" AND A.business_unit='"+ Department +"'");
			}*/	
			if(Location != null && Location != "")
			{
				sb.append(" AND A.location='"+ Location +"'");
			}
			if(Technology != null && Technology != "")
			{
				sb.append(" AND A.technology='"+ Technology +"'");
			}
			LOGGER.debug("[{}] Query for get total count of Somewhat Disengage for unit pulse view of survey of chat bot application -> {}", sb.toString());
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sb.toString());
			if (conn != null) {
				result = pstmt.executeQuery();
				while (result.next()) {
					totalCount = result.getInt("survey_conunt");
				}
			}
		} catch (SQLException exp) {
			LOGGER.error("[{}] Exception while  get the total count of Somewhat  Disengage for unit pulse view of survey of chat bot application : {} ", exp);
			exp.printStackTrace();
		} catch (Exception exp) {
			LOGGER.error("[{}] Exception while  get the total count of Somewhat  Disengage for unit pulse view of survey of chat bot application : {} ", exp);
			exp.printStackTrace();
		} finally {
			MySqlConnectionUtil.closedbConnection(pstmt, conn);
		}
		return totalCount;
	}

	public int getSomewhatEngage(int i, String type, String Department, String Location, String Technology) {
		int totalCount = 0;
		Connection conn = null;
		ResultSet result = null;
		PreparedStatement pstmt = null;
		try {
			StringBuilder sb = new StringBuilder(); 
			sb.append("SELECT B.survey_name, count(*) as survey_conunt FROM user_master_account A JOIN survey_response_sum B ON A.email_id = B.email_id  Where A.status = 1 AND A.`function/bu` = " + i + " AND B.survey_name = '" + type + "'");
			/*if(Department != null && Department != "")
			{
				sb.append(" AND A.business_unit='"+ Department +"'");
			}*/	
			if(Location != null && Location != "")
			{
				sb.append(" AND A.location='"+ Location +"'");
			}
			if(Technology != null && Technology != "")
			{
				sb.append(" AND A.technology='"+ Technology +"'");
			}
			LOGGER.debug("[{}] Query for get total count of Somewhat Agree for unit pulse view of survey of chat bot application -> {}", sb.toString());
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sb.toString());
			if (conn != null) {
				result = pstmt.executeQuery();
				while (result.next()) {
					totalCount = result.getInt("survey_conunt");
				}
			}
		} catch (SQLException exp) {
			LOGGER.error("[{}] Exception while  get the total count of Somewhat  Agree for unit pulse view of survey of chat bot application : {} ", exp);
			exp.printStackTrace();
		} catch (Exception exp) {
			LOGGER.error("[{}] Exception while  get the total count of Somewhat  Agree for unit pulse view of survey of chat bot application : {} ", exp);
			exp.printStackTrace();
		} finally {
			MySqlConnectionUtil.closedbConnection(pstmt, conn);
		}
		return totalCount;
	}

	public int getEngage(int i, String type, String Department, String Location, String Technology) {
		int totalCount = 0;
		Connection conn = null;
		ResultSet result = null;
		PreparedStatement pstmt = null;
		try {
			StringBuilder sb = new StringBuilder(); 
			sb.append("SELECT B.survey_name, count(*) as survey_conunt FROM user_master_account A JOIN survey_response_sum B ON A.email_id = B.email_id  Where A.status = 1 AND A.`function/bu` = " + i + " AND B.survey_name = '" + type + "'");
			/*if(Department != null && Department != "")
			{
				sb.append(" AND A.business_unit='"+ Department +"'");
			}*/	
			if(Location != null && Location != "")
			{
				sb.append(" AND A.location='"+ Location +"'");
			}
			if(Technology != null && Technology != "")
			{
				sb.append(" AND A.technology='"+ Technology +"'");
			}
			LOGGER.debug("[{}] Query for get total count of Agree for unit pulse view of survey of chat bot application -> {}", sb.toString());
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sb.toString());
			if (conn != null) {
				result = pstmt.executeQuery();
				while (result.next()) {
					totalCount = result.getInt("survey_conunt");
				}
			}
		} catch (SQLException exp) {
			LOGGER.error("[{}] Exception while  get the total count of Agree for unit pulse view of survey of chat bot application : {} ", exp);
			exp.printStackTrace();
		} catch (Exception exp) {
			LOGGER.error("[{}] Exception while  get the total count of Agree for unit pulse view of survey of chat bot application : {} ", exp);
			exp.printStackTrace();
		} finally {
			MySqlConnectionUtil.closedbConnection(pstmt, conn);
		}
		return totalCount;
	}

	public int getStronglyEngage(int i, String type, String Department, String Location, String Technology) {
		int totalCount = 0;
		Connection conn = null;
		ResultSet result = null;
		PreparedStatement pstmt = null;
		try {
			StringBuilder sb = new StringBuilder(); 
			sb.append("SELECT B.survey_name, count(*) as survey_conunt FROM user_master_account A JOIN survey_response_sum B ON A.email_id = B.email_id  Where A.status = 1 AND A.`function/bu` = " + i + " AND B.survey_name = '" + type + "'");
			/*if(Department != null && Department != "")
			{
				sb.append(" AND A.business_unit='"+ Department +"'");
			}*/	
			if(Location != null && Location != "")
			{
				sb.append(" AND A.location='"+ Location +"'");
			}
			if(Technology != null && Technology != "")
			{
				sb.append(" AND A.technology='"+ Technology +"'");
			}
			LOGGER.debug("[{}] Query for get total count of Strongly agree for unit pulse view of survey of chat bot application -> {}", sb.toString());
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sb.toString());
			if (conn != null) {
				result = pstmt.executeQuery();
				while (result.next()) {
					totalCount = result.getInt("survey_conunt");
				}
			}
		} catch (SQLException exp) {
			LOGGER.error("[{}] Exception while  get the total count of Strongly agree for unit pulse view of survey of chat bot application : {} ", exp);
			exp.printStackTrace();
		} catch (Exception exp) {
			LOGGER.error("[{}] Exception while  get the total count of Strongly agree for unit pulse view of survey of chat bot application : {} ", exp);
			exp.printStackTrace();
		} finally {
			MySqlConnectionUtil.closedbConnection(pstmt, conn);
		}
		return totalCount;
	}

	public float getStronglyDisengageAvg(String surveyName, String driverName, String Department, String Location, String Technology) {
		float avg = 0;
		Connection conn = null;
		ResultSet result = null;
		PreparedStatement pstmt = null;
		try {
			/*String sql = "SELECT survey_name, ROUND(((select Count(*) from survey_response_sum where survey_name='"+ surveyName +"')/(select sum(survey_response_sum) from survey_response_sum where survey_name='"+ surveyName +"')*100), 1) as avg  "
						+ " FROM survey_response_sum A JOIN survey_response B JOIN survey_questions C "
						+ " ON A.email_id = B.email_id AND  B.question_id = C.question_id"
						+ " Where  A.survey_name = '"+ surveyName +"' AND C.primary_engagement_driver='" + driverName + "'";*/
			
			StringBuilder sb = new StringBuilder(); 
			sb.append("SELECT survey_name, ROUND(((select Count(*) from survey_response_sum where survey_name='"+ surveyName +"')/(select sum(survey_response_sum) from survey_response_sum where survey_name='"+ surveyName +"')*100), 1) as avg   FROM survey_response_sum A JOIN survey_response B JOIN survey_questions C JOIN user_master_account D ON A.email_id = B.email_id AND  B.question_id = C.question_id  AND A.email_id = D.email_id Where  A.survey_name = '"+ surveyName +"' AND C.primary_engagement_driver='" + driverName + "'");
			if(Department != null && Department != "")
			{
				sb.append(" AND D.business_unit='"+ Department +"'");
			}	
			if(Location != null && Location != "")
			{
				sb.append(" AND D.location='"+ Location +"'");
			}
			if(Technology != null && Technology != "")
			{
				sb.append(" AND D.technology='"+ Technology +"'");
			}
			
			LOGGER.debug("[{}] Query for get average of  StronglyDisengage for unit pulse view of survey of chat bot application -> {}", sb.toString());
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sb.toString());
			if (conn != null) {
				result = pstmt.executeQuery();
				while (result.next()) {
					avg = result.getFloat("avg");
				}
			}
		} catch (SQLException exp) {
			LOGGER.error("[{}] Exception while  get the average of  StronglyDisengage for unit pulse view of survey of chat bot application : {} ", exp);
			exp.printStackTrace();
		} catch (Exception exp) {
			LOGGER.error("[{}] Exception while  get the average of  StronglyDisengage for unit pulse view of survey of chat bot application : {} ", exp);
			exp.printStackTrace();
		} finally {
			MySqlConnectionUtil.closedbConnection(pstmt, conn);
		}
		return avg;
	}

	public float getDisengageAvg(String surveyName, String driverName, String Department, String Location, String Technology) {
		float avg = 0;
		Connection conn = null;
		ResultSet result = null;
		PreparedStatement pstmt = null;
		try {
			/*String sql = "SELECT survey_name, ROUND(((select Count(*) from survey_response_sum where survey_name='"+ surveyName +"')/(select sum(survey_response_sum) from survey_response_sum where survey_name='"+ surveyName +"')*100), 1) as avg  "
					+ " FROM survey_response_sum A JOIN survey_response B JOIN survey_questions C "
					+ " ON A.email_id = B.email_id AND  B.question_id = C.question_id"
					+ " Where  A.survey_name = '"+ surveyName +"' AND C.primary_engagement_driver='" + driverName + "'";*/
			
			StringBuilder sb = new StringBuilder(); 
			sb.append("SELECT survey_name, ROUND(((select Count(*) from survey_response_sum where survey_name='"+ surveyName +"')/(select sum(survey_response_sum) from survey_response_sum where survey_name='"+ surveyName +"')*100), 1) as avg   FROM survey_response_sum A JOIN survey_response B JOIN survey_questions C JOIN user_master_account D ON A.email_id = B.email_id AND  B.question_id = C.question_id  AND A.email_id = D.email_id Where  A.survey_name = '"+ surveyName +"' AND C.primary_engagement_driver='" + driverName + "'");
			if(Department != null && Department != "")
			{
				sb.append(" AND D.business_unit='"+ Department +"'");
			}	
			if(Location != null && Location != "")
			{
				sb.append(" AND D.location='"+ Location +"'");
			}
			if(Technology != null && Technology != "")
			{
				sb.append(" AND D.technology='"+ Technology +"'");
			}
			
			LOGGER.debug("[{}] Query for get average of  Disengage for unit pulse view of survey of chat bot application -> {}", sb.toString());
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sb.toString());
			if (conn != null) {
				result = pstmt.executeQuery();
				while (result.next()) {
					avg = result.getFloat("avg");
				}
			}
		} catch (SQLException exp) {
			LOGGER.error("[{}] Exception while  get the average of  Disengage for unit pulse view of survey of chat bot application : {} ", exp);
			exp.printStackTrace();
		} catch (Exception exp) {
			LOGGER.error("[{}] Exception while  get the average of  Disengage for unit pulse view of survey of chat bot application : {} ", exp);
			exp.printStackTrace();
		} finally {
			MySqlConnectionUtil.closedbConnection(pstmt, conn);
		}
		return avg;
	}

	public float somewhatDisengageAvg(String surveyName, String driverName, String Department, String Location, String Technology) {
		float avg = 0;
		Connection conn = null;
		ResultSet result = null;
		PreparedStatement pstmt = null;
		try {
			/*String sql = "SELECT survey_name, ROUND(((select Count(*) from survey_response_sum where survey_name='"+ surveyName +"')/(select sum(survey_response_sum) from survey_response_sum where survey_name='"+ surveyName +"')*100), 1) as avg  "
					+ " FROM survey_response_sum A JOIN survey_response B JOIN survey_questions C "
					+ " ON A.email_id = B.email_id AND  B.question_id = C.question_id"
					+ " Where  A.survey_name = '"+ surveyName +"' AND C.primary_engagement_driver='" + driverName + "'";*/
			
			StringBuilder sb = new StringBuilder(); 
			sb.append("SELECT survey_name, ROUND(((select Count(*) from survey_response_sum where survey_name='"+ surveyName +"')/(select sum(survey_response_sum) from survey_response_sum where survey_name='"+ surveyName +"')*100), 1) as avg   FROM survey_response_sum A JOIN survey_response B JOIN survey_questions C JOIN user_master_account D ON A.email_id = B.email_id AND  B.question_id = C.question_id  AND A.email_id = D.email_id Where  A.survey_name = '"+ surveyName +"' AND C.primary_engagement_driver='" + driverName + "'");
			if(Department != null && Department != "")
			{
				sb.append(" AND D.business_unit='"+ Department +"'");
			}	
			if(Location != null && Location != "")
			{
				sb.append(" AND D.location='"+ Location +"'");
			}
			if(Technology != null && Technology != "")
			{
				sb.append(" AND D.technology='"+ Technology +"'");
			}
			
			LOGGER.debug("[{}] Query for get average of  Somewhat disagree for unit pulse view of survey of chat bot application -> {}", sb.toString());
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sb.toString());
			if (conn != null) {
				result = pstmt.executeQuery();
				while (result.next()) {
					avg = result.getFloat("avg");
				}
			}
		} catch (SQLException exp) {
			LOGGER.error("[{}] Exception while  get the average of  Somewhat disagree for unit pulse view of survey of chat bot application : {} ", exp);
			exp.printStackTrace();
		} catch (Exception exp) {
			LOGGER.error("[{}] Exception while  get the average of  Somewhat disagree for unit pulse view of survey of chat bot application : {} ", exp);
			exp.printStackTrace();
		} finally {
			MySqlConnectionUtil.closedbConnection(pstmt, conn);
		}
		return avg;
	}

	public float somewhatEngageAvg(String surveyName, String driverName, String Department, String Location, String Technology) {
		float avg = 0;
		Connection conn = null;
		ResultSet result = null;
		PreparedStatement pstmt = null;
		try {
			/*String sql = "SELECT survey_name, ROUND(((select Count(*) from survey_response_sum where survey_name='"+ surveyName +"')/(select sum(survey_response_sum) from survey_response_sum where survey_name='"+ surveyName +"')*100), 1) as avg  "
					+ " FROM survey_response_sum A JOIN survey_response B JOIN survey_questions C "
					+ " ON A.email_id = B.email_id AND  B.question_id = C.question_id"
					+ " Where  A.survey_name = '"+ surveyName +"' AND C.primary_engagement_driver='" + driverName + "'";*/
			
			StringBuilder sb = new StringBuilder(); 
			sb.append("SELECT survey_name, ROUND(((select Count(*) from survey_response_sum where survey_name='"+ surveyName +"')/(select sum(survey_response_sum) from survey_response_sum where survey_name='"+ surveyName +"')*100), 1) as avg   FROM survey_response_sum A JOIN survey_response B JOIN survey_questions C JOIN user_master_account D ON A.email_id = B.email_id AND  B.question_id = C.question_id  AND A.email_id = D.email_id Where  A.survey_name = '"+ surveyName +"' AND C.primary_engagement_driver='" + driverName + "'");
			if(Department != null && Department != "")
			{
				sb.append(" AND D.business_unit='"+ Department +"'");
			}	
			if(Location != null && Location != "")
			{
				sb.append(" AND D.location='"+ Location +"'");
			}
			if(Technology != null && Technology != "")
			{
				sb.append(" AND D.technology='"+ Technology +"'");
			}
			
			LOGGER.debug("[{}] Query for get average of  Somewhat agree for unit pulse view of survey of chat bot application -> {}", sb.toString());
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sb.toString());
			if (conn != null) {
				result = pstmt.executeQuery();
				while (result.next()) {
					avg = result.getFloat("avg");
				}
			}
		} catch (SQLException exp) {
			LOGGER.error("[{}] Exception while  get the average of  Somewhat agree for unit pulse view of survey of chat bot application : {} ", exp);
			exp.printStackTrace();
		} catch (Exception exp) {
			LOGGER.error("[{}] Exception while  get the average of Somewhat agree for unit pulse view of survey of chat bot application : {} ", exp);
			exp.printStackTrace();
		} finally {
			MySqlConnectionUtil.closedbConnection(pstmt, conn);
		}
		return avg;
	}

	public float engageAvg(String surveyName, String driverName, String Department, String Location, String Technology) {
		float avg = 0;
		Connection conn = null;
		ResultSet result = null;
		PreparedStatement pstmt = null;
		try {
			/*String sql = "SELECT survey_name, ROUND(((select Count(*) from survey_response_sum where survey_name='"+ surveyName +"')/(select sum(survey_response_sum) from survey_response_sum where survey_name='"+ surveyName +"')*100), 1) as avg  "
					+ " FROM survey_response_sum A JOIN survey_response B JOIN survey_questions C "
					+ " ON A.email_id = B.email_id AND  B.question_id = C.question_id"
					+ " Where  A.survey_name = '"+ surveyName +"' AND C.primary_engagement_driver='" + driverName + "'";*/
			
			StringBuilder sb = new StringBuilder(); 
			sb.append("SELECT survey_name, ROUND(((select Count(*) from survey_response_sum where survey_name='"+ surveyName +"')/(select sum(survey_response_sum) from survey_response_sum where survey_name='"+ surveyName +"')*100), 1) as avg   FROM survey_response_sum A JOIN survey_response B JOIN survey_questions C JOIN user_master_account D ON A.email_id = B.email_id AND  B.question_id = C.question_id  AND A.email_id = D.email_id Where  A.survey_name = '"+ surveyName +"' AND C.primary_engagement_driver='" + driverName + "'");
			if(Department != null && Department != "")
			{
				sb.append(" AND D.business_unit='"+ Department +"'");
			}	
			if(Location != null && Location != "")
			{
				sb.append(" AND D.location='"+ Location +"'");
			}
			if(Technology != null && Technology != "")
			{
				sb.append(" AND D.technology='"+ Technology +"'");
			}
			
			LOGGER.debug("[{}] Query for get average of  Agree for unit pulse view of survey of chat bot application -> {}", sb.toString());
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sb.toString());
			if (conn != null) {
				result = pstmt.executeQuery();
				while (result.next()) {
					avg = result.getFloat("avg");
				}
			}
		} catch (SQLException exp) {
			LOGGER.error("[{}] Exception while  get the average of  Agree for unit pulse view of survey of chat bot application : {} ", exp);
			exp.printStackTrace();
		} catch (Exception exp) {
			LOGGER.error("[{}] Exception while  get the average of Agree for unit pulse view of survey of chat bot application : {} ", exp);
			exp.printStackTrace();
		} finally {
			MySqlConnectionUtil.closedbConnection(pstmt, conn);
		}
		return avg;
	}

	public float stronglyEngageAvg(String surveyName, String driverName, String Department, String Location, String Technology) {
		float avg = 0;
		Connection conn = null;
		ResultSet result = null;
		PreparedStatement pstmt = null;
		try {
			/*String sql = "SELECT survey_name, ROUND(((select Count(*) from survey_response_sum where survey_name='"+ surveyName +"')/(select sum(survey_response_sum) from survey_response_sum where survey_name='"+ surveyName +"')*100), 1) as avg  "
					+ " FROM survey_response_sum A JOIN survey_response B JOIN survey_questions C "
					+ " ON A.email_id = B.email_id AND  B.question_id = C.question_id"
					+ " Where  A.survey_name = '"+ surveyName +"' AND C.primary_engagement_driver='" + driverName + "'";*/
			
			StringBuilder sb = new StringBuilder(); 
			sb.append("SELECT survey_name, ROUND(((select Count(*) from survey_response_sum where survey_name='"+ surveyName +"')/(select sum(survey_response_sum) from survey_response_sum where survey_name='"+ surveyName +"')*100), 1) as avg   FROM survey_response_sum A JOIN survey_response B JOIN survey_questions C JOIN user_master_account D ON A.email_id = B.email_id AND  B.question_id = C.question_id  AND A.email_id = D.email_id Where  A.survey_name = '"+ surveyName +"' AND C.primary_engagement_driver='" + driverName + "'");
			if(Department != null && Department != "")
			{
				sb.append(" AND D.business_unit='"+ Department +"'");
			}	
			if(Location != null && Location != "")
			{
				sb.append(" AND D.location='"+ Location +"'");
			}
			if(Technology != null && Technology != "")
			{
				sb.append(" AND D.technology='"+ Technology +"'");
			}
			
			LOGGER.debug("[{}] Query for get average of  Strongly agree for unit pulse view of survey of chat bot application -> {}", sb.toString());
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sb.toString());
			if (conn != null) {
				result = pstmt.executeQuery();
				while (result.next()) {
					avg = result.getFloat("avg");
				}
			}
		} catch (SQLException exp) {
			LOGGER.error("[{}] Exception while  get the average of  Strongly agree for unit pulse view of survey of chat bot application : {} ", exp);
			exp.printStackTrace();
		} catch (Exception exp) {
			LOGGER.error("[{}] Exception while  get the average of Strongly agree for unit pulse view of survey of chat bot application : {} ", exp);
			exp.printStackTrace();
		} finally {
			MySqlConnectionUtil.closedbConnection(pstmt, conn);
		}
		return avg;
	}

	public int getTotalGenderCount(int i, String Department, String Location, String Technology) {
		int count = 0;
		Connection conn = null;
		ResultSet result = null;
		PreparedStatement pstmt = null;
		try {
			StringBuilder sb = new StringBuilder(); 
			sb.append("select Count(*) as count FROM user_master_account A JOIN chatbot.survey_response_sum B ON A.email_id = B.email_id where A.gender = "+ i +"");
			if(Department != null && Department != "")
			{
				sb.append(" AND A.business_unit='"+ Department +"'");
			}	
			if(Location != null && Location != "")
			{
				sb.append(" AND A.location='"+ Location +"'");
			}
			if(Technology != null && Technology != "")
			{
				sb.append(" AND A.technology='"+ Technology +"'");
			}
			
			LOGGER.debug("[{}] Query for get gender wise View  for dashbord of survey of chat bot application -> {}", sb.toString());
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sb.toString());
			if (conn != null) {
				result = pstmt.executeQuery();
				while (result.next()) {
					count = result.getInt("count");
				}
			}
		} catch (SQLException exp) {
			LOGGER.error("[{}] Exception while  get the gender wise View  for dashbord of survey of chat bot application : {} ", exp);
			exp.printStackTrace();
		} catch (Exception exp) {
			LOGGER.error("[{}] Exception while  get the gender wise View  for dashbord of survey of chat bot application : {} ", exp);
			exp.printStackTrace();
		} finally {
			MySqlConnectionUtil.closedbConnection(pstmt, conn);
		}
		return count;
	}

	public int getGenderWiseSurveySum(int i, String Department, String Location, String Technology) {
		int count = 0;
		Connection conn = null;
		ResultSet result = null;
		PreparedStatement pstmt = null;
		try {
			StringBuilder sb = new StringBuilder(); 
			sb.append("select sum(survey_response_sum) as count FROM user_master_account A JOIN chatbot.survey_response_sum B ON A.email_id = B.email_id where A.gender = "+ i +"");
			if(Department != null && Department != "")
			{
				sb.append(" AND A.business_unit='"+ Department +"'");
			}	
			if(Location != null && Location != "")
			{
				sb.append(" AND A.location='"+ Location +"'");
			}
			if(Technology != null && Technology != "")
			{
				sb.append(" AND A.technology='"+ Technology +"'");
			}
			
			LOGGER.debug("[{}] Query for get gender wise View  for dashbord of survey of chat bot application -> {}", sb.toString());
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sb.toString());
			if (conn != null) {
				result = pstmt.executeQuery();
				while (result.next()) {
					count = result.getInt("count");
				}
			}
		} catch (SQLException exp) {
			LOGGER.error("[{}] Exception while  get the gender wise View  for dashbord of survey of chat bot application : {} ", exp);
			exp.printStackTrace();
		} catch (Exception exp) {
			LOGGER.error("[{}] Exception while  get the gender wise View  for dashbord of survey of chat bot application : {} ", exp);
			exp.printStackTrace();
		} finally {
			MySqlConnectionUtil.closedbConnection(pstmt, conn);
		}
		return count;
	}

	public int getGenderCount(int i, String Department, String Location, String Technology) {
		int count = 0;
		Connection conn = null;
		ResultSet result = null;
		PreparedStatement pstmt = null;
		try {
			StringBuilder sb = new StringBuilder(); 
			sb.append("SELECT count(*) as count FROM user_master_account where gender = " + i + "");
			if(Department != null && Department != "")
			{
				sb.append(" AND business_unit='"+ Department +"'");
			}	
			if(Location != null && Location != "")
			{
				sb.append(" AND location='"+ Location +"'");
			}
			if(Technology != null && Technology != "")
			{
				sb.append(" AND technology='"+ Technology +"'");
			}
			
			LOGGER.debug("[{}] Query for get gender wise View  for dashbord of survey of chat bot application -> {}", sb.toString());
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sb.toString());
			if (conn != null) {
				result = pstmt.executeQuery();
				while (result.next()) {
					count = result.getInt("count");
				}
			}
		} catch (SQLException exp) {
			LOGGER.error("[{}] Exception while  get the gender wise View  for dashbord of survey of chat bot application : {} ", exp);
			exp.printStackTrace();
		} catch (Exception exp) {
			LOGGER.error("[{}] Exception while  get the gender wise View  for dashbord of survey of chat bot application : {} ", exp);
			exp.printStackTrace();
		} finally {
			MySqlConnectionUtil.closedbConnection(pstmt, conn);
		}
		return count;
	}

	public int getResponseGenderCount(int i, String Department, String Location, String Technology) {
		int count = 0;
		Connection conn = null;
		ResultSet result = null;
		PreparedStatement pstmt = null;
		try {
			StringBuilder sb = new StringBuilder(); 
			sb.append("select Count(A.email_id) as count FROM user_master_account A JOIN chatbot.survey_response_sum B ON A.email_id = B.email_id where A.gender = " + i + "");
			if(Department != null && Department != "")
			{
				sb.append(" AND A.business_unit='"+ Department +"'");
			}	
			if(Location != null && Location != "")
			{
				sb.append(" AND A.location='"+ Location +"'");
			}
			if(Technology != null && Technology != "")
			{
				sb.append(" AND A.technology='"+ Technology +"'");
			}
			
			LOGGER.debug("[{}] Query for get gender wise View  for dashbord of survey of chat bot application -> {}", sb.toString());
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sb.toString());
			if (conn != null) {
				result = pstmt.executeQuery();
				while (result.next()) {
					count = result.getInt("count");
				}
			}
		} catch (SQLException exp) {
			LOGGER.error("[{}] Exception while  get the gender wise View  for dashbord of survey of chat bot application : {} ", exp);
			exp.printStackTrace();
		} catch (Exception exp) {
			LOGGER.error("[{}] Exception while  get the gender wise View  for dashbord of survey of chat bot application : {} ", exp);
			exp.printStackTrace();
		} finally {
			MySqlConnectionUtil.closedbConnection(pstmt, conn);
		}
		return count;
	}

	public int getCriticalEmployeeCount(int i, String Department, String Location, String Technology) {
		int count = 0;
		Connection conn = null;
		ResultSet result = null;
		PreparedStatement pstmt = null;
		try {
			StringBuilder sb = new StringBuilder(); 
			sb.append("select Count(A.email_id) as count FROM user_master_account A JOIN chatbot.survey_response_sum B  ON A.email_id = B.email_id where A.is_critical='Yes' AND A.gender = " + i + "");
			if(Department != null && Department != "")
			{
				sb.append(" AND A.business_unit='"+ Department +"'");
			}	
			if(Location != null && Location != "")
			{
				sb.append(" AND A.location='"+ Location +"'");
			}
			if(Technology != null && Technology != "")
			{
				sb.append(" AND A.technology='"+ Technology +"'");
			}
			
			LOGGER.debug("[{}] Query for get gender wise View  for dashbord of survey of chat bot application -> {}", sb.toString());
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sb.toString());
			if (conn != null) {
				result = pstmt.executeQuery();
				while (result.next()) {
					count = result.getInt("count");
				}
			}
		} catch (SQLException exp) {
			LOGGER.error("[{}] Exception while  get the gender wise View  for dashbord of survey of chat bot application : {} ", exp);
			exp.printStackTrace();
		} catch (Exception exp) {
			LOGGER.error("[{}] Exception while  get the gender wise View  for dashbord of survey of chat bot application : {} ", exp);
			exp.printStackTrace();
		} finally {
			MySqlConnectionUtil.closedbConnection(pstmt, conn);
		}
		return count;
	}

	public int getTotalGradeCountOfHighRisk(String string) {
		int count = 0;
		Connection conn = null;
		ResultSet result = null;
		PreparedStatement pstmt = null;
		try {
			String sql = "select count(A.email_id) as count from user_master_account A JOIN survey_response_sum B ON A.email_id = B.email_id where A.band = '" + string + "' and B.survey_name in ('Strongly disagree','Disagree')";
			LOGGER.debug("[{}] Query for get the grade wise high flight risk  for dashbord of survey of chat bot application -> {}", sql);
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			if (conn != null) {
				result = pstmt.executeQuery();
				while (result.next()) {
					count = result.getInt("count");
				}
			}
		} catch (SQLException exp) {
			LOGGER.error("[{}] Exception while  get the grade wise high flight risk  for dashbord of survey of chat bot application : {} ", exp);
			exp.printStackTrace();
		} catch (Exception exp) {
			LOGGER.error("[{}] Exception while  get the grade wise high flight risk  for dashbord of survey of chat bot application : {} ", exp);
			exp.printStackTrace();
		} finally {
			MySqlConnectionUtil.closedbConnection(pstmt, conn);
		}
		return count;
	}

	public int TotalCountOfHighRisk() {
		int count = 0;
		Connection conn = null;
		ResultSet result = null;
		PreparedStatement pstmt = null;
		try {
			String sql = "SELECT count(A.email_id) as count FROM user_master_account A JOIN survey_response_sum B ON A.email_id = B.email_id where B.survey_name in ('Strongly disagree','Disagree')";
			LOGGER.debug("[{}] Query for get the grade wise high flight risk  for dashbord of survey of chat bot application -> {}", sql);
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			if (conn != null) {
				result = pstmt.executeQuery();
				while (result.next()) {
					count = result.getInt("count");
				}
			}
		} catch (SQLException exp) {
			LOGGER.error("[{}] Exception while  get the grade wise high flight risk  for dashbord of survey of chat bot application : {} ", exp);
			exp.printStackTrace();
		} catch (Exception exp) {
			LOGGER.error("[{}] Exception while  get the grade wise high flight risk  for dashbord of survey of chat bot application : {} ", exp);
			exp.printStackTrace();
		} finally {
			MySqlConnectionUtil.closedbConnection(pstmt, conn);
		}
		return count;
	}

	public int gettotalHighRiskBusinessUnit(int i) {
		int count = 0;
		Connection conn = null;
		ResultSet result = null;
		PreparedStatement pstmt = null;
		try {
			String sql = "select count(A.email_id) as count from user_master_account A JOIN survey_response_sum B ON A.email_id = B.email_id  where A.`function/bu` = " + i + " and B.survey_name in ('Strongly disagree','Disagree')";
			LOGGER.debug("[{}] Query for get the Business Unit Wise High Flight Risk  for dashbord of survey of chat bot application -> {}", sql);
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			if (conn != null) {
				result = pstmt.executeQuery();
				while (result.next()) {
					count = result.getInt("count");
				}
			}
		} catch (SQLException exp) {
			LOGGER.error("[{}] Exception while  get the Business Unit Wise High Flight Risk for dashbord of survey of chat bot application : {} ", exp);
			exp.printStackTrace();
		} catch (Exception exp) {
			LOGGER.error("[{}] Exception while  get the Business Unit Wise High Flight Risk  for dashbord of survey of chat bot application : {} ", exp);
			exp.printStackTrace();
		} finally {
			MySqlConnectionUtil.closedbConnection(pstmt, conn);
		}
		return count;
	}

	public int getTotalHighRiskAssociates() {
		int count = 0;
		Connection conn = null;
		ResultSet result = null;
		PreparedStatement pstmt = null;
		try {
			String sql = "SELECT count(A.email_id) as count FROM user_master_account A JOIN survey_response_sum B ON A.email_id = B.email_id where B.survey_name in ('Strongly disagree','Disagree')";
			LOGGER.debug("[{}] Query for get the Business Unit Wise High Flight Risk  for dashbord of survey of chat bot application -> {}", sql);
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			if (conn != null) {
				result = pstmt.executeQuery();
				while (result.next()) {
					count = result.getInt("count");
				}
			}
		} catch (SQLException exp) {
			LOGGER.error("[{}] Exception while  get the Business Unit Wise High Flight Risk for dashbord of survey of chat bot application : {} ", exp);
			exp.printStackTrace();
		} catch (Exception exp) {
			LOGGER.error("[{}] Exception while  get the Business Unit Wise High Flight Risk  for dashbord of survey of chat bot application : {} ", exp);
			exp.printStackTrace();
		} finally {
			MySqlConnectionUtil.closedbConnection(pstmt, conn);
		}
		return count;
	}

	public int getTotalHighRiskEmployee() {
		int count = 0;
		Connection conn = null;
		ResultSet result = null;
		PreparedStatement pstmt = null;
		try {
			String sql = "SELECT count(*) as count FROM survey_response_sum where survey_name in ('Strongly disagree','Disagree')";
			LOGGER.debug("[{}] Query for get the Flight High Risk employee total  for dashbord of survey of chat bot application -> {}", sql);
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			if (conn != null) {
				result = pstmt.executeQuery();
				while (result.next()) {
					count = result.getInt("count");
				}
			}
		} catch (SQLException exp) {
			LOGGER.error("[{}] Exception while  get the Flight High Risk employee total  for dashbord of survey of chat bot application : {} ", exp);
			exp.printStackTrace();
		} catch (Exception exp) {
			LOGGER.error("[{}] Exception while  get the Flight High Risk employee total  for dashbord of survey of chat bot application : {} ", exp);
			exp.printStackTrace();
		} finally {
			MySqlConnectionUtil.closedbConnection(pstmt, conn);
		}
		return count;
	}

	public int getTotalMediumRiskEmployee() {
		int count = 0;
		Connection conn = null;
		ResultSet result = null;
		PreparedStatement pstmt = null;
		try {
			String sql = "SELECT count(*) as count FROM survey_response_sum where survey_name in ('Somewhat disagree','Somewhat agree')";
			LOGGER.debug("[{}] Query for get the Flight Medium Risk employee total  for dashbord of survey of chat bot application -> {}", sql);
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			if (conn != null) {
				result = pstmt.executeQuery();
				while (result.next()) {
					count = result.getInt("count");
				}
			}
		} catch (SQLException exp) {
			LOGGER.error("[{}] Exception while  get the Flight Medium Risk employee total  for dashbord of survey of chat bot application : {} ", exp);
			exp.printStackTrace();
		} catch (Exception exp) {
			LOGGER.error("[{}] Exception while  get the Flight Medium Risk employee total  for dashbord of survey of chat bot application : {} ", exp);
			exp.printStackTrace();
		} finally {
			MySqlConnectionUtil.closedbConnection(pstmt, conn);
		}
		return count;
	}

	public int getTotalCriticalEmployee(int i) {
		int count = 0;
		Connection conn = null;
		ResultSet result = null;
		PreparedStatement pstmt = null;
		try {
			String sql = "select count(A.email_id) as count from user_master_account A JOIN survey_response_sum B ON A.email_id = B.email_id  where A.gender = " + i + " AND A.is_critical = 'Yes' AND B.survey_name in ('Strongly disagree','Disagree')";
			LOGGER.debug("[{}] Query for get the Critical Employee High Risk  for dashbord of survey of chat bot application -> {}", sql);
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			if (conn != null) {
				result = pstmt.executeQuery();
				while (result.next()) {
					count = result.getInt("count");
				}
			}
		} catch (SQLException exp) {
			LOGGER.error("[{}] Exception while  get the Critical Employee High Risk  for dashbord of survey of chat bot application : {} ", exp);
			exp.printStackTrace();
		} catch (Exception exp) {
			LOGGER.error("[{}] Exception while  get the Critical Employee High Risk  for dashbord of survey of chat bot application : {} ", exp);
			exp.printStackTrace();
		} finally {
			MySqlConnectionUtil.closedbConnection(pstmt, conn);
		}
		return count;
	}

	public List<Employee> getEmployeeList(String string) {
		List<Employee> HighRiskEmployeeList = new ArrayList<Employee>();
		Employee Employee = new Employee();
		Connection conn = null;
		ResultSet result = null;
		PreparedStatement pstmt = null;
		try {

			String sql = "SELECT A.id, A.first_name, A.email_id,A.mobile_no, A.band, A.is_critical, A.location, ROUND((B.survey_response_sum/6) , 1) as pulse  FROM user_master_account A JOIN survey_response_sum B ON A.email_id = B.email_id  where B.survey_name in ("+ string +")";
			LOGGER.debug("[{}] get the Risk Analysis Employee Covered for dashbord of survey of chat bot application Query -> {}", sql);
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			if (conn != null) {
				result = pstmt.executeQuery();
				if (conn != null) {
					while (result.next()) {
						Employee = new Employee();
						Employee.setId(result.getInt("id"));
						Employee.setName(result.getString("first_name"));
						Employee.setPulse(result.getFloat("pulse"));
						Employee.setCritical(result.getString("is_critical"));
						Employee.setBand(result.getString("band"));
						Employee.setLocation(result.getString("location"));
						
						HighRiskEmployeeList.add(Employee);
					}
					MySqlConnectionUtil.closedbConnection(pstmt, conn);
				}
			}
		} catch (SQLException exp) {
			LOGGER.error("[{}] Exception while get the Risk Analysis Employee Covered for dashbord of survey of chat bot application : {} ", exp);
			exp.printStackTrace();
		} catch (Exception exp) {
			LOGGER.error("[{}] Exception while get the Risk Analysis Employee Covered for dashbord of survey of chat bot application : {} ", exp);
			exp.printStackTrace();
		} finally {
			MySqlConnectionUtil.closedbConnection(pstmt, conn);
		}
		return HighRiskEmployeeList;
	}

	public int get30Above(String string) {
		int count = 0;
		Connection conn = null;
		ResultSet result = null;
		PreparedStatement pstmt = null;
		try {
			String sql = "SELECT Count(A.email_id) as count FROM user_master_account A JOIN survey_response_sum B  ON A.email_id = B.email_id where A.age > 30 AND B.survey_name in ( " + string + " )";
			LOGGER.debug("[{}] Query for get the Enterprise Employee filter  for dashbord of survey of chat bot application -> {}", sql);
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			if (conn != null) {
				result = pstmt.executeQuery();
				while (result.next()) {
					count = result.getInt("count");
				}
			}
		} catch (SQLException exp) {
			LOGGER.error("[{}] Exception while  get the Enterprise Employee filter  for dashbord of survey of chat bot application : {} ", exp);
			exp.printStackTrace();
		} catch (Exception exp) {
			LOGGER.error("[{}] Exception while  get the Enterprise Employee filter   for dashbord of survey of chat bot application : {} ", exp);
			exp.printStackTrace();
		} finally {
			MySqlConnectionUtil.closedbConnection(pstmt, conn);
		}
		return count;
	}

	public int get30Below(String string) {
		int count = 0;
		Connection conn = null;
		ResultSet result = null;
		PreparedStatement pstmt = null;
		try {
			String sql = "SELECT Count(A.email_id) as count FROM user_master_account A JOIN survey_response_sum B  ON A.email_id = B.email_id where A.age <= 30 AND B.survey_name in ( " + string + " )";
			LOGGER.debug("[{}] Query for get the Enterprise Employee filter   for dashbord of survey of chat bot application -> {}", sql);
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			if (conn != null) {
				result = pstmt.executeQuery();
				while (result.next()) {
					count = result.getInt("count");
				}
			}
		} catch (SQLException exp) {
			LOGGER.error("[{}] Exception while  get the Enterprise Employee filter  for dashbord of survey of chat bot application : {} ", exp);
			exp.printStackTrace();
		} catch (Exception exp) {
			LOGGER.error("[{}] Exception while  get the Enterprise Employee filter   for dashbord of survey of chat bot application : {} ", exp);
			exp.printStackTrace();
		} finally {
			MySqlConnectionUtil.closedbConnection(pstmt, conn);
		}
		return count;
	}

	public int get3RatingAbove(String string) {
		int count = 0;
		Connection conn = null;
		ResultSet result = null;
		PreparedStatement pstmt = null;
		try {
			String sql = "SELECT Count(A.email_id) as count FROM user_master_account A JOIN survey_response_sum B  ON A.email_id = B.email_id where A.perf_cat > 3 AND B.survey_name in ( " + string + " )";
			LOGGER.debug("[{}] Query for get the Enterprise Employee filter   for dashbord of survey of chat bot application -> {}", sql);
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			if (conn != null) {
				result = pstmt.executeQuery();
				while (result.next()) {
					count = result.getInt("count");
				}
			}
		} catch (SQLException exp) {
			LOGGER.error("[{}] Exception while  get the Enterprise Employee filter   for dashbord of survey of chat bot application : {} ", exp);
			exp.printStackTrace();
		} catch (Exception exp) {
			LOGGER.error("[{}] Exception while  get the Enterprise Employee filter   for dashbord of survey of chat bot application : {} ", exp);
			exp.printStackTrace();
		} finally {
			MySqlConnectionUtil.closedbConnection(pstmt, conn);
		}
		return count;
	}

	public int get3RatingBelow(String string) {
		int count = 0;
		Connection conn = null;
		ResultSet result = null;
		PreparedStatement pstmt = null;
		try {
			String sql = "SELECT Count(A.email_id) as count FROM user_master_account A JOIN survey_response_sum B  ON A.email_id = B.email_id where A.perf_cat <= 3 AND B.survey_name in ( " + string + " )";
			LOGGER.debug("[{}] Query for get the Enterprise Employee filter  for dashbord of survey of chat bot application -> {}", sql);
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			if (conn != null) {
				result = pstmt.executeQuery();
				while (result.next()) {
					count = result.getInt("count");
				}
			}
		} catch (SQLException exp) {
			LOGGER.error("[{}] Exception while  get the Enterprise Employee filter  for dashbord of survey of chat bot application : {} ", exp);
			exp.printStackTrace();
		} catch (Exception exp) {
			LOGGER.error("[{}] Exception while  get the Enterprise Employee filter   for dashbord of survey of chat bot application : {} ", exp);
			exp.printStackTrace();
		} finally {
			MySqlConnectionUtil.closedbConnection(pstmt, conn);
		}
		return count;
	}

	public int get22YearAbove(String string) {
		int count = 0;
		Connection conn = null;
		ResultSet result = null;
		PreparedStatement pstmt = null;
		try {
			String sql = "SELECT Count(A.email_id) as count FROM user_master_account A JOIN survey_response_sum B  ON A.email_id = B.email_id where A.qualifications > 22 AND B.survey_name in ( " + string + " )";
			LOGGER.debug("[{}] Query for get the Enterprise Employee filter  for dashbord of survey of chat bot application -> {}", sql);
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			if (conn != null) {
				result = pstmt.executeQuery();
				while (result.next()) {
					count = result.getInt("count");
				}
			}
		} catch (SQLException exp) {
			LOGGER.error("[{}] Exception while  get the Enterprise Employee filter  for dashbord of survey of chat bot application : {} ", exp);
			exp.printStackTrace();
		} catch (Exception exp) {
			LOGGER.error("[{}] Exception while  get the Enterprise Employee filter   for dashbord of survey of chat bot application : {} ", exp);
			exp.printStackTrace();
		} finally {
			MySqlConnectionUtil.closedbConnection(pstmt, conn);
		}
		return count;
	}

	public int get22YearBelow(String string) {
		int count = 0;
		Connection conn = null;
		ResultSet result = null;
		PreparedStatement pstmt = null;
		try {
			String sql = "SELECT Count(A.email_id) as count FROM user_master_account A JOIN survey_response_sum B  ON A.email_id = B.email_id where A.qualifications <= 22 AND B.survey_name in ( " + string + " )";
			LOGGER.debug("[{}] Query for get the Enterprise Employee filter  for dashbord of survey of chat bot application -> {}", sql);
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			if (conn != null) {
				result = pstmt.executeQuery();
				while (result.next()) {
					count = result.getInt("count");
				}
			}
		} catch (SQLException exp) {
			LOGGER.error("[{}] Exception while  get the Enterprise Employee filter  for dashbord of survey of chat bot application : {} ", exp);
			exp.printStackTrace();
		} catch (Exception exp) {
			LOGGER.error("[{}] Exception while  get the Enterprise Employee filter   for dashbord of survey of chat bot application : {} ", exp);
			exp.printStackTrace();
		} finally {
			MySqlConnectionUtil.closedbConnection(pstmt, conn);
		}
		return count;
	}

	public int get10YearAbove(String string) {
		int count = 0;
		Connection conn = null;
		ResultSet result = null;
		PreparedStatement pstmt = null;
		try {
			String sql = "SELECT Count(A.email_id) as count FROM user_master_account A JOIN survey_response_sum B  ON A.email_id = B.email_id where A.experience > 10 AND B.survey_name in ( " + string + " )";
			LOGGER.debug("[{}] Query for get the Enterprise Employee filter  for dashbord of survey of chat bot application -> {}", sql);
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			if (conn != null) {
				result = pstmt.executeQuery();
				while (result.next()) {
					count = result.getInt("count");
				}
			}
		} catch (SQLException exp) {
			LOGGER.error("[{}] Exception while  get the Enterprise Employee filter  for dashbord of survey of chat bot application : {} ", exp);
			exp.printStackTrace();
		} catch (Exception exp) {
			LOGGER.error("[{}] Exception while  get the Enterprise Employee filter   for dashbord of survey of chat bot application : {} ", exp);
			exp.printStackTrace();
		} finally {
			MySqlConnectionUtil.closedbConnection(pstmt, conn);
		}
		return count;
	}

	public int get10YearBelow(String string) {
		int count = 0;
		Connection conn = null;
		ResultSet result = null;
		PreparedStatement pstmt = null;
		try {
			String sql = "SELECT Count(A.email_id) as count FROM user_master_account A JOIN survey_response_sum B  ON A.email_id = B.email_id where A.experience <= 10 AND B.survey_name in ( " + string + " )";
			LOGGER.debug("[{}] Query for get the Enterprise Employee filter  for dashbord of survey of chat bot application -> {}", sql);
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			if (conn != null) {
				result = pstmt.executeQuery();
				while (result.next()) {
					count = result.getInt("count");
				}
			}
		} catch (SQLException exp) {
			LOGGER.error("[{}] Exception while  get the Enterprise Employee filter  for dashbord of survey of chat bot application : {} ", exp);
			exp.printStackTrace();
		} catch (Exception exp) {
			LOGGER.error("[{}] Exception while  get the Enterprise Employee filter   for dashbord of survey of chat bot application : {} ", exp);
			exp.printStackTrace();
		} finally {
			MySqlConnectionUtil.closedbConnection(pstmt, conn);
		}
		return count;
	}

	public int getMale(String string) {
		int count = 0;
		Connection conn = null;
		ResultSet result = null;
		PreparedStatement pstmt = null;
		try {
			String sql = "SELECT Count(A.email_id) as count FROM user_master_account A JOIN survey_response_sum B  ON A.email_id = B.email_id where A.gender = 1 AND B.survey_name in ( " + string + " )";
			LOGGER.debug("[{}] Query for get the Enterprise Employee filter  for dashbord of survey of chat bot application -> {}", sql);
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			if (conn != null) {
				result = pstmt.executeQuery();
				while (result.next()) {
					count = result.getInt("count");
				}
			}
		} catch (SQLException exp) {
			LOGGER.error("[{}] Exception while  get the Enterprise Employee filter  for dashbord of survey of chat bot application : {} ", exp);
			exp.printStackTrace();
		} catch (Exception exp) {
			LOGGER.error("[{}] Exception while  get the Enterprise Employee filter   for dashbord of survey of chat bot application : {} ", exp);
			exp.printStackTrace();
		} finally {
			MySqlConnectionUtil.closedbConnection(pstmt, conn);
		}
		return count;
	}

	public int getFemale(String string) {
		int count = 0;
		Connection conn = null;
		ResultSet result = null;
		PreparedStatement pstmt = null;
		try {
			String sql = "SELECT Count(A.email_id) as count FROM user_master_account A JOIN survey_response_sum B  ON A.email_id = B.email_id where A.gender = 2 AND B.survey_name in ( " + string + " )";
			LOGGER.debug("[{}] Query for get the Enterprise Employee filter  for dashbord of survey of chat bot application -> {}", sql);
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			if (conn != null) {
				result = pstmt.executeQuery();
				while (result.next()) {
					count = result.getInt("count");
				}
			}
		} catch (SQLException exp) {
			LOGGER.error("[{}] Exception while  get the Enterprise Employee filter  for dashbord of survey of chat bot application : {} ", exp);
			exp.printStackTrace();
		} catch (Exception exp) {
			LOGGER.error("[{}] Exception while  get the Enterprise Employee filter   for dashbord of survey of chat bot application : {} ", exp);
			exp.printStackTrace();
		} finally {
			MySqlConnectionUtil.closedbConnection(pstmt, conn);
		}
		return count;
	}

	public int getSumOfRatings(String Department, String Location, String Technology) {
		int sumOfSum = 0;
		Connection conn = null;
		ResultSet result = null;
		PreparedStatement pstmt = null;
		try {
			StringBuilder sb = new StringBuilder(); 
			sb.append("SELECT sum(B.survey_response_sum) as sum FROM user_master_account A JOIN survey_response_sum B ON A.email_id = B.email_id WHERE A.status=1");
			if(Department != null && Department != "")
			{
				sb.append(" AND A.business_unit='"+ Department +"'");
			}	
			if(Location != null && Location != "")
			{
				sb.append(" AND A.location='"+ Location +"'");
			}
			if(Technology != null && Technology != "")
			{
				sb.append(" AND A.technology='"+ Technology +"'");
			}
			LOGGER.debug("[{}] Query for get the sum of ratings associate response view for dashbord of survey of chat bot application -> {}", sb.toString());
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sb.toString());
			if (conn != null) {
				result = pstmt.executeQuery();
				while (result.next()) {
					sumOfSum = result.getInt("sum");
				}
			}
		} catch (SQLException exp) {
			LOGGER.error("[{}] Exception while  get the sum of ratings of associate response view for dashbord of survey of chat bot application : {} ", exp);
			exp.printStackTrace();
		} catch (Exception exp) {
			LOGGER.error("[{}] Exception while  get the sum of ratings associate response view for dashbord of survey of chat bot application : {} ", exp);
			exp.printStackTrace();
		} finally {
			MySqlConnectionUtil.closedbConnection(pstmt, conn);
		}
		return sumOfSum;
	}
	
	
	public int getHighRiskCount() {
		int count = 0;
		Connection conn = null;
		ResultSet result = null;
		PreparedStatement pstmt = null;
		try {
			String sql = "SELECT count(*) as count FROM survey_response_sum where survey_name in ('Strongly disagree','Disagree')";
			LOGGER.debug("[{}] Query for get High Risk count for dashbord of survey of chat bot application -> {}", sql);
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			if (conn != null) {
				result = pstmt.executeQuery();
				while (result.next()) {
					count = result.getInt("count");
				}
			}
		} catch (SQLException exp) {
			LOGGER.error("[{}] Exception while  get the High Risk count for dashbord of survey of chat bot application : {} ", exp);
			exp.printStackTrace();
		} catch (Exception exp) {
			LOGGER.error("[{}] Exception while  get the High Risk count for dashbord of survey of chat bot application : {} ", exp);
			exp.printStackTrace();
		} finally {
			MySqlConnectionUtil.closedbConnection(pstmt, conn);
		}
		return count;
	}

	public int getMediumRiskCount() {
		int count = 0;
		Connection conn = null;
		ResultSet result = null;
		PreparedStatement pstmt = null;
		try {
			String sql = "SELECT count(*) as count FROM survey_response_sum where survey_name in ('Somewhat disagree','Somewhat agree')";
			LOGGER.debug("[{}] Query for get Medium Risk count for dashbord of survey of chat bot application -> {}", sql);
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			if (conn != null) {
				result = pstmt.executeQuery();
				while (result.next()) {
					count = result.getInt("count");
				}
			}
		} catch (SQLException exp) {
			LOGGER.error("[{}] Exception while  get the Medium Risk count for dashbord of survey of chat bot application : {} ", exp);
			exp.printStackTrace();
		} catch (Exception exp) {
			LOGGER.error("[{}] Exception while  get the Medium Risk count for dashbord of survey of chat bot application : {} ", exp);
			exp.printStackTrace();
		} finally {
			MySqlConnectionUtil.closedbConnection(pstmt, conn);
		}
		return count;
	}

	public int getNoRiskCount() {
		int count = 0;
		Connection conn = null;
		ResultSet result = null;
		PreparedStatement pstmt = null;
		try {
			String sql = "SELECT count(*) as count FROM survey_response_sum where survey_name in ('Agree','Strongly agree')";
			LOGGER.debug("[{}] Query for get No Risk count for dashbord of survey of chat bot application -> {}", sql);
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			if (conn != null) {
				result = pstmt.executeQuery();
				while (result.next()) {
					count = result.getInt("count");
				}
			}
		} catch (SQLException exp) {
			LOGGER.error("[{}] Exception while  get the No Risk count for dashbord of survey of chat bot application : {} ", exp);
			exp.printStackTrace();
		} catch (Exception exp) {
			LOGGER.error("[{}] Exception while  get the No Risk count for dashbord of survey of chat bot application : {} ", exp);
			exp.printStackTrace();
		} finally {
			MySqlConnectionUtil.closedbConnection(pstmt, conn);
		}
		return count;
	}
	
	public int getTotalSurveyCount() {
		int count = 0;
		Connection conn = null;
		ResultSet result = null;
		PreparedStatement pstmt = null;
		try {
			String sql = "SELECT count(A.email_id) as count FROM user_master_account A JOIN survey_response_sum B ON A.email_id = B.email_id  where A.status=1";
			
			LOGGER.debug("[{}] Query for get Flight Risk Analysis total count for dashbord of survey of chat bot application -> {}", sql);
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			if (conn != null) {
				result = pstmt.executeQuery();
				while (result.next()) {
					count = result.getInt("count");
				}
			}
		} catch (SQLException exp) {
			LOGGER.error("[{}] Exception while  get the Flight Risk Analysis total count for dashbord of survey of chat bot application : {} ", exp);
			exp.printStackTrace();
		} catch (Exception exp) {
			LOGGER.error("[{}] Exception while  get the Flight Risk Analysis total count for dashbord of survey of chat bot application : {} ", exp);
			exp.printStackTrace();
		} finally {
			MySqlConnectionUtil.closedbConnection(pstmt, conn);
		}
		return count;
	}
	
	public int getTotalEmployeeFilterUnitWise(String Department, String Location, String Technology) {
		int totalEmployee = 0;
		Connection conn = null;
		ResultSet result = null;
		PreparedStatement pstmt = null;
		try {
			StringBuilder sb = new StringBuilder(); 
			sb.append("SELECT count(A.email_id) as total_employee FROM user_master_account A JOIN survey_response_sum B ON A.email_id = B.email_id WHERE A.status=1");
			/*if(Department != null && Department != "")
			{
				sb.append(" AND A.business_unit='"+ Department +"'");
			}*/	
			if(Location != null && Location != "")
			{
				sb.append(" AND A.location='"+ Location +"'");
			}
			if(Technology != null && Technology != "")
			{
				sb.append(" AND A.technology='"+ Technology +"'");
			}
			LOGGER.debug("[{}] Query for get the total employee associate response view for dashbord of survey of chat bot application -> {}", sb.toString());
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sb.toString());
			if (conn != null) {
				result = pstmt.executeQuery();
				while (result.next()) {
					totalEmployee = result.getInt("total_employee");
				}
			}
		} catch (SQLException exp) {
			LOGGER.error("[{}] Exception while  get the total employee of associate response view for dashbord of survey of chat bot application : {} ", exp);
			exp.printStackTrace();
		} catch (Exception exp) {
			LOGGER.error("[{}] Exception while  get the total employee associate response view for dashbord of survey of chat bot application : {} ", exp);
			exp.printStackTrace();
		} finally {
			MySqlConnectionUtil.closedbConnection(pstmt, conn);
		}
		
		return totalEmployee;
	}

	public int getEmployeeCount(String driverName, String Department, String Location, String Technology) {
		int count = 0;
		Connection conn = null;
		ResultSet result = null;
		PreparedStatement pstmt = null;
		try {
			StringBuilder sb = new StringBuilder(); 
			sb.append("SELECT count(A.email_id) as count FROM survey_response_sum A JOIN survey_response B JOIN survey_questions C JOIN user_master_account D ON A.email_id = B.email_id AND  B.question_id = C.question_id  AND A.email_id = D.email_id Where C.primary_engagement_driver='"+ driverName +"'");
			if(Department != null && Department != "")
			{
				sb.append(" AND D.business_unit='"+ Department +"'");
			}	
			if(Location != null && Location != "")
			{
				sb.append(" AND D.location='"+ Location +"'");
			}
			if(Technology != null && Technology != "")
			{
				sb.append(" AND D.technology='"+ Technology +"'");
			}
			LOGGER.debug("[{}] Query for get the sum of ratings associate response view for dashbord of survey of chat bot application -> {}", sb.toString());
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sb.toString());
			if (conn != null) {
				result = pstmt.executeQuery();
				while (result.next()) {
					count = result.getInt("count");
				}
			}
		} catch (SQLException exp) {
			LOGGER.error("[{}] Exception while  get the sum of ratings of associate response view for dashbord of survey of chat bot application : {} ", exp);
			exp.printStackTrace();
		} catch (Exception exp) {
			LOGGER.error("[{}] Exception while  get the sum of ratings associate response view for dashbord of survey of chat bot application : {} ", exp);
			exp.printStackTrace();
		} finally {
			MySqlConnectionUtil.closedbConnection(pstmt, conn);
		}
		return count;
	}

	public int getTotalEmp(String string, String driverName, String Department, String Location, String Technology) {
		int count = 0;
		Connection conn = null;
		ResultSet result = null;
		PreparedStatement pstmt = null;
		try {
			StringBuilder sb = new StringBuilder(); 
			sb.append("SELECT count(A.email_id) as count FROM survey_response_sum A JOIN survey_response B JOIN survey_questions C JOIN user_master_account D ON A.email_id = B.email_id AND  B.question_id = C.question_id  AND A.email_id = D.email_id Where A.survey_name = '"+ string +"' AND  C.primary_engagement_driver='" + driverName + "'");
			if(Department != null && Department != "")
			{
				sb.append(" AND D.business_unit='"+ Department +"'");
			}	
			if(Location != null && Location != "")
			{
				sb.append(" AND D.location='"+ Location +"'");
			}
			if(Technology != null && Technology != "")
			{
				sb.append(" AND D.technology='"+ Technology +"'");
			}
			LOGGER.debug("[{}] Query for get the sum of ratings associate response view for dashbord of survey of chat bot application -> {}", sb.toString());
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sb.toString());
			if (conn != null) {
				result = pstmt.executeQuery();
				while (result.next()) {
					count = result.getInt("count");
				}
			}
		} catch (SQLException exp) {
			LOGGER.error("[{}] Exception while  get the sum of ratings of associate response view for dashbord of survey of chat bot application : {} ", exp);
			exp.printStackTrace();
		} catch (Exception exp) {
			LOGGER.error("[{}] Exception while  get the sum of ratings associate response view for dashbord of survey of chat bot application : {} ", exp);
			exp.printStackTrace();
		} finally {
			MySqlConnectionUtil.closedbConnection(pstmt, conn);
		}
		return count;
	}
}
