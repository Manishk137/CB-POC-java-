package com.chatboat.model;

import java.util.ArrayList;
import java.util.List;

public class SearchFeedsResponse {
	
	List<Questions> questions = new ArrayList<Questions>();

	public List<Questions> getQuestions() {
		return questions;
	}

	public void setQuestions(List<Questions> questions) {
		this.questions = questions;
	}

	@Override
	public String toString() {
		return "SearchFeedsResponse [questions=" + questions + "]";
	}
}
