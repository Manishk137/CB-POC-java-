package com.chatboat.model;

import java.util.ArrayList;
import java.util.List;

public class EngagementModel {
	
	List<EngagementServeyModel> engagementQuestionList = new ArrayList<EngagementServeyModel>();

	public List<EngagementServeyModel> getEngagementQuestionList() {
		return engagementQuestionList;
	}

	public void setEngagementQuestionList(List<EngagementServeyModel> engagementQuestionList) {
		this.engagementQuestionList = engagementQuestionList;
	}

	@Override
	public String toString() {
		return "EngagementModel [engagementQuestionList=" + engagementQuestionList + "]";
	} 
}
