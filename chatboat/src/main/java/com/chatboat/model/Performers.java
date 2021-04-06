package com.chatboat.model;

public class Performers {
	
	private int highRisk3RatingAbove;
	private int highRisk3RatingBelow;
	
	private int mediumRisk3RatingAbove;
	private int mediumRisk3RatingBelow;
	public int getHighRisk3RatingAbove() {
		return highRisk3RatingAbove;
	}
	public void setHighRisk3RatingAbove(int highRisk3RatingAbove) {
		this.highRisk3RatingAbove = highRisk3RatingAbove;
	}
	public int getHighRisk3RatingBelow() {
		return highRisk3RatingBelow;
	}
	public void setHighRisk3RatingBelow(int highRisk3RatingBelow) {
		this.highRisk3RatingBelow = highRisk3RatingBelow;
	}
	public int getMediumRisk3RatingAbove() {
		return mediumRisk3RatingAbove;
	}
	public void setMediumRisk3RatingAbove(int mediumRisk3RatingAbove) {
		this.mediumRisk3RatingAbove = mediumRisk3RatingAbove;
	}
	public int getMediumRisk3RatingBelow() {
		return mediumRisk3RatingBelow;
	}
	public void setMediumRisk3RatingBelow(int mediumRisk3RatingBelow) {
		this.mediumRisk3RatingBelow = mediumRisk3RatingBelow;
	}
	@Override
	public String toString() {
		return "Performers [highRisk3RatingAbove=" + highRisk3RatingAbove + ", highRisk3RatingBelow="
				+ highRisk3RatingBelow + ", mediumRisk3RatingAbove=" + mediumRisk3RatingAbove
				+ ", mediumRisk3RatingBelow=" + mediumRisk3RatingBelow + "]";
	}
}
