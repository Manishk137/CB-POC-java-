package com.chatboat.model;

public class OverallCompanyMood {
	
	OverallCompanyMoodParam overallCompanyMood;

	public OverallCompanyMoodParam getOverallCompanyMood() {
		return overallCompanyMood;
	}

	public void setOverallCompanyMood(OverallCompanyMoodParam overallCompanyMood) {
		this.overallCompanyMood = overallCompanyMood;
	}

	@Override
	public String toString() {
		return "OverallCompanyMood [overallCompanyMood=" + overallCompanyMood + "]";
	}
}
