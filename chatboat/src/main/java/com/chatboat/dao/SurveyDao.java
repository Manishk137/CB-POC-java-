package com.chatboat.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.chatboat.database.MySqlConnectionUtil;
import com.chatboat.model.ServeyQuestions;
import com.chatboat.model.SubmitSurveyModel;
import com.chatboat.model.SubmitSurveyParams;
import com.chatboat.model.SurveyModel;

@Repository
public class SurveyDao {
	
private static final Logger LOGGER = LoggerFactory.getLogger(SurveyDao.class);
	
	@Autowired
	private DataSource dataSource;

	public SurveyModel getEngamentServeyQuestionsList() {
		List<ServeyQuestions> serveyQuestionList = new ArrayList<ServeyQuestions>();
		SurveyModel surveyModel = new SurveyModel();
		Connection conn = null;
		ResultSet result = null;
		PreparedStatement pstmt = null;
		try {

			/*String sql ="SELECT A.survey_id, A.survey_type,A.survey_frequency, B.question_id, B.question, B.type "
					+ " FROM survey_master A JOIN survey_questions B ON A.survey_id = B.survey_id "
					+ " WHERE B.survey_id = 1 ORDER BY RAND() LIMIT 5";*/
			
			String sql ="SELECT A.survey_id, A.survey_type,A.survey_frequency, B.question_id, B.question, B.type "
					+ " FROM survey_master A JOIN survey_questions B ON A.survey_id = B.survey_id "
					+ " WHERE B.survey_id = 1";
			
			LOGGER.debug("[{}] get engagment question list for survey of chat bot application Query -> {}", sql);
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			if (conn != null) {
				result = pstmt.executeQuery();
				if (conn != null) {
					while (result.next()) {
						ServeyQuestions serveyQuestions= new ServeyQuestions();
						surveyModel.setSurvey_id(result.getInt("survey_id"));
						surveyModel.setSurvey_name(result.getString("survey_type"));
						serveyQuestions.setQuestionId(result.getInt("question_id"));
						serveyQuestions.setQuestion(result.getString("question"));
						serveyQuestions.setType(result.getString("type"));
						serveyQuestionList.add(serveyQuestions);
					}
					surveyModel.setServeyQuestionList(serveyQuestionList);
				}
			}
		} catch (SQLException exp) {
			LOGGER.error("[{}] Exception while get engagment question list for survey of chat bot application : {} ", exp);
			exp.printStackTrace();
		} catch (Exception exp) {
			LOGGER.error("[{}] Exception while get engagment question list for survey of chat bot application : {} ", exp);
			exp.printStackTrace();
		} finally {
			MySqlConnectionUtil.closedbConnection(pstmt, conn);
		}
		return surveyModel;
	}
	
	public SurveyModel getPersonalityServeyQuestionsList() {
		List<ServeyQuestions> serveyQuestionList = new ArrayList<ServeyQuestions>();
		SurveyModel surveyModel = new SurveyModel();
		Connection conn = null;
		ResultSet result = null;
		PreparedStatement pstmt = null;
		try {

			String sql ="SELECT A.survey_id, A.survey_type,A.survey_frequency, B.question_id, B.question, B.type "
					+ " FROM survey_master A JOIN survey_questions B ON A.survey_id = B.survey_id "
					+ " WHERE B.survey_id = 2 ORDER BY RAND() LIMIT 5";
			LOGGER.debug("[{}] get personality question list for survey of chat bot application Query -> {}", sql);
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			if (conn != null) {
				result = pstmt.executeQuery();
				if (conn != null) {
					while (result.next()) {
						ServeyQuestions serveyQuestions= new ServeyQuestions();
						surveyModel.setSurvey_id(result.getInt("survey_id"));
						surveyModel.setSurvey_name(result.getString("survey_type"));
						serveyQuestions.setQuestionId(result.getInt("question_id"));
						serveyQuestions.setQuestion(result.getString("question"));
						serveyQuestions.setType(result.getString("type"));
						serveyQuestionList.add(serveyQuestions);
					}
					surveyModel.setServeyQuestionList(serveyQuestionList);
				}
			}
		} catch (SQLException exp) {
			LOGGER.error("[{}] Exception while get personality question list for survey of chat bot application : {} ", exp);
			exp.printStackTrace();
		} catch (Exception exp) {
			LOGGER.error("[{}] Exception while get personality question list for survey of chat bot application : {} ", exp);
			exp.printStackTrace();
		} finally {
			MySqlConnectionUtil.closedbConnection(pstmt, conn);
		}
		return surveyModel;
	}

	public String submitSurvey(SubmitSurveyModel submitSurveyModel, SubmitSurveyParams submitSurveyParams) {
		String status = null;
		PreparedStatement pstmt = null;
		Connection conn = null;
		try {
			String sql = "INSERT INTO  survey_response (email_id, question_id, rating, comment, survey_date, survey_datetime, sync_date, sync_datetime)"
						+ " values (?,?,?,?,?,?,?,?)";
			conn = dataSource.getConnection();
			LOGGER.debug("[{}] sql query for submit survey of chat bot application : {}", sql);
			if (conn != null) {
				Date date = new Date();
				pstmt = conn.prepareStatement(sql);

				
				
				pstmt.setString(1, submitSurveyModel.getEmailId());
				pstmt.setInt(2, submitSurveyParams.getQuestionId());
				pstmt.setInt(3, submitSurveyParams.getRating());
				pstmt.setString(4, submitSurveyParams.getComment());
				pstmt.setDate(5, new java.sql.Date(submitSurveyModel.getTimestamp()));
				pstmt.setTimestamp(6, new java.sql.Timestamp(submitSurveyModel.getTimestamp()));
				pstmt.setDate(7, new java.sql.Date(date.getTime()));
				pstmt.setTimestamp(8, new java.sql.Timestamp(date.getTime()));
				
				pstmt.executeUpdate();
				status = "200";
			}
		} catch (SQLException exp) {
			LOGGER.error("[{}] Exception while submit survey for chat bot application : {} ", exp);
			exp.printStackTrace();
			status = "101";
		} catch (Exception exp) {
			LOGGER.error("[{}] Exception while submit survey chat bot application : {} ", exp);
			exp.printStackTrace();
			status = "101";
		} finally {

			MySqlConnectionUtil.closedbConnection(pstmt, conn);
		}
		return status;
	}

	public void submitSurvey(SubmitSurveyModel submitSurveyModel, int ratingCount, String surveyName) {
		PreparedStatement pstmt = null;
		Connection conn = null;
		try {
			String sql = "INSERT INTO  survey_response_sum (survey_id, email_id, survey_name, survey_response_sum, survey_date, survey_datetime, sync_date, sync_datetime)"
						+ " values (?,?,?,?,?,?,?,?)";
			conn = dataSource.getConnection();
			LOGGER.debug("[{}] sql query for submit survey sum of chat bot application : {}", sql);
			if (conn != null) {
				Date date = new Date();
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, submitSurveyModel.getSurvey_id());
				pstmt.setString(2, submitSurveyModel.getEmailId());
				pstmt.setString(3, surveyName);
				pstmt.setInt(4, ratingCount);
				pstmt.setDate(5, new java.sql.Date(submitSurveyModel.getTimestamp()));
				pstmt.setTimestamp(6, new java.sql.Timestamp(submitSurveyModel.getTimestamp()));
				pstmt.setDate(7, new java.sql.Date(date.getTime()));
				pstmt.setTimestamp(8, new java.sql.Timestamp(date.getTime()));
				
				pstmt.executeUpdate();
			}
		} catch (SQLException exp) {
			LOGGER.error("[{}] Exception while submit survey sum for chat boat application : {} ", exp);
			exp.printStackTrace();
		} catch (Exception exp) {
			LOGGER.error("[{}] Exception while submit survey sum chat boat application : {} ", exp);
			exp.printStackTrace();
		} finally {
			MySqlConnectionUtil.closedbConnection(pstmt, conn);
		}
	}

	public void saveRatingAverage(SubmitSurveyModel submitSurveyModel, float avgOfSum, String ratingName) {
		PreparedStatement pstmt = null;
		Connection conn = null;
		try {
			String sql = "INSERT INTO  overall_company_mood (survey_id, email_id, survey_name, survey_average, survey_date, survey_datetime, sync_date, sync_datetime)"
						+ " values (?,?,?,?,?,?,?,?)";
			conn = dataSource.getConnection();
			LOGGER.debug("[{}] sql query for submit survey average of chat bot application : {}", sql);
			if (conn != null) {
				Date date = new Date();
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, submitSurveyModel.getSurvey_id());
				pstmt.setString(2, submitSurveyModel.getEmailId());
				pstmt.setString(3, ratingName);
				pstmt.setFloat(4, avgOfSum);
				pstmt.setDate(5, new java.sql.Date(submitSurveyModel.getTimestamp()));
				pstmt.setTimestamp(6, new java.sql.Timestamp(submitSurveyModel.getTimestamp()));
				pstmt.setDate(7, new java.sql.Date(date.getTime()));
				pstmt.setTimestamp(8, new java.sql.Timestamp(date.getTime()));
				
				pstmt.executeUpdate();
			}
		} catch (SQLException exp) {
			LOGGER.error("[{}] Exception while submit survey average for chat boat application : {} ", exp);
			exp.printStackTrace();
		} catch (Exception exp) {
			LOGGER.error("[{}] Exception while submit survey average chat boat application : {} ", exp);
			exp.printStackTrace();
		} finally {
			MySqlConnectionUtil.closedbConnection(pstmt, conn);
		}
	}
}
