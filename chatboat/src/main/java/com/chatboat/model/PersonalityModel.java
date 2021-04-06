package com.chatboat.model;

import java.util.ArrayList;
import java.util.List;

public class PersonalityModel {
	
	List<PersonalityServeyModel> personalityQuestionList = new ArrayList<PersonalityServeyModel>();

	public List<PersonalityServeyModel> getPersonalityQuestionList() {
		return personalityQuestionList;
	}

	public void setPersonalityQuestionList(List<PersonalityServeyModel> personalityQuestionList) {
		this.personalityQuestionList = personalityQuestionList;
	}

	@Override
	public String toString() {
		return "PersonalityModel [personalityQuestionList=" + personalityQuestionList + "]";
	}
}
