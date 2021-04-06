package com.chatboat.model;

public class Educations {
	
	private int highRisk22YearAbove;
	private int highRisk22YearBelow;
	
	private int mediumRisk22YearAbove;
	private int mediumRisk22YearBelow;
	public int getHighRisk22YearAbove() {
		return highRisk22YearAbove;
	}
	public void setHighRisk22YearAbove(int highRisk22YearAbove) {
		this.highRisk22YearAbove = highRisk22YearAbove;
	}
	public int getHighRisk22YearBelow() {
		return highRisk22YearBelow;
	}
	public void setHighRisk22YearBelow(int highRisk22YearBelow) {
		this.highRisk22YearBelow = highRisk22YearBelow;
	}
	public int getMediumRisk22YearAbove() {
		return mediumRisk22YearAbove;
	}
	public void setMediumRisk22YearAbove(int mediumRisk22YearAbove) {
		this.mediumRisk22YearAbove = mediumRisk22YearAbove;
	}
	public int getMediumRisk22YearBelow() {
		return mediumRisk22YearBelow;
	}
	public void setMediumRisk22YearBelow(int mediumRisk22YearBelow) {
		this.mediumRisk22YearBelow = mediumRisk22YearBelow;
	}
	@Override
	public String toString() {
		return "Educations [highRisk22YearAbove=" + highRisk22YearAbove + ", highRisk22YearBelow=" + highRisk22YearBelow
				+ ", mediumRisk22YearAbove=" + mediumRisk22YearAbove + ", mediumRisk22YearBelow="
				+ mediumRisk22YearBelow + "]";
	}
}
