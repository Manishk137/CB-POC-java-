package com.chatboat.model;

import java.util.ArrayList;
import java.util.List;

public class SubmitSurveyModel {
	
	private String emailId;
	private long timestamp;
	private int survey_id;
	private String survey_name;
	List<SubmitSurveyParams>  serveyAnswerList = new ArrayList<SubmitSurveyParams>();
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public long getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}
	public int getSurvey_id() {
		return survey_id;
	}
	public void setSurvey_id(int survey_id) {
		this.survey_id = survey_id;
	}
	public String getSurvey_name() {
		return survey_name;
	}
	public void setSurvey_name(String survey_name) {
		this.survey_name = survey_name;
	}
	public List<SubmitSurveyParams> getServeyAnswerList() {
		return serveyAnswerList;
	}
	public void setServeyAnswerList(List<SubmitSurveyParams> serveyAnswerList) {
		this.serveyAnswerList = serveyAnswerList;
	}
	@Override
	public String toString() {
		return "SubmitSurveyModel [emailId=" + emailId + ", timestamp=" + timestamp + ", survey_id=" + survey_id
				+ ", survey_name=" + survey_name + ", serveyAnswerList=" + serveyAnswerList + "]";
	}
	
}
