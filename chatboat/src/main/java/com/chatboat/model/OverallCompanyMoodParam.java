package com.chatboat.model;

public class OverallCompanyMoodParam {
	
	private int overAllMood;
	private String ratingName;
	public int getOverAllMood() {
		return overAllMood;
	}
	public void setOverAllMood(int overAllMood) {
		this.overAllMood = overAllMood;
	}
	public String getRatingName() {
		return ratingName;
	}
	public void setRatingName(String ratingName) {
		this.ratingName = ratingName;
	}
	@Override
	public String toString() {
		return "OverallCompanyMoodParam [overAllMood=" + overAllMood + ", ratingName=" + ratingName + "]";
	}
}
