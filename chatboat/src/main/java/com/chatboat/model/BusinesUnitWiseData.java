package com.chatboat.model;

public class BusinesUnitWiseData {

	private int businessType;
	private String surveyName;
	private String userCount;
	public int getBusinessType() {
		return businessType;
	}
	public void setBusinessType(int businessType) {
		this.businessType = businessType;
	}
	public String getSurveyName() {
		return surveyName;
	}
	public void setSurveyName(String surveyName) {
		this.surveyName = surveyName;
	}
	public String getUserCount() {
		return userCount;
	}
	public void setUserCount(String userCount) {
		this.userCount = userCount;
	}
	@Override
	public String toString() {
		return "BusinesUnitWiseData [businessType=" + businessType + ", surveyName=" + surveyName + ", userCount="
				+ userCount + "]";
	}
}
