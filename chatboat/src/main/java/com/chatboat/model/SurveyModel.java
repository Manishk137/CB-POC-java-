package com.chatboat.model;

import java.util.ArrayList;
import java.util.List;

public class SurveyModel {
	
	private int survey_id;
	private String survey_name;
	List<ServeyQuestions> serveyQuestionList = new ArrayList<ServeyQuestions>();
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
	public List<ServeyQuestions> getServeyQuestionList() {
		return serveyQuestionList;
	}
	public void setServeyQuestionList(List<ServeyQuestions> serveyQuestionList) {
		this.serveyQuestionList = serveyQuestionList;
	}
	@Override
	public String toString() {
		return "SurveyModel [survey_id=" + survey_id + ", survey_name=" + survey_name + ", serveyQuestionList="
				+ serveyQuestionList + "]";
	}
}
