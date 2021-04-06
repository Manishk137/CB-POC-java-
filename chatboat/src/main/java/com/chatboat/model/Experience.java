package com.chatboat.model;

public class Experience {

	private int highRisk10YearAbove;
	private int highRisk10YearBelow;
	
	private int mediumRisk10YearAbove;
	private int mediumRisk10YearBelow;
	public int getHighRisk10YearAbove() {
		return highRisk10YearAbove;
	}
	public void setHighRisk10YearAbove(int highRisk10YearAbove) {
		this.highRisk10YearAbove = highRisk10YearAbove;
	}
	public int getHighRisk10YearBelow() {
		return highRisk10YearBelow;
	}
	public void setHighRisk10YearBelow(int highRisk10YearBelow) {
		this.highRisk10YearBelow = highRisk10YearBelow;
	}
	public int getMediumRisk10YearAbove() {
		return mediumRisk10YearAbove;
	}
	public void setMediumRisk10YearAbove(int mediumRisk10YearAbove) {
		this.mediumRisk10YearAbove = mediumRisk10YearAbove;
	}
	public int getMediumRisk10YearBelow() {
		return mediumRisk10YearBelow;
	}
	public void setMediumRisk10YearBelow(int mediumRisk10YearBelow) {
		this.mediumRisk10YearBelow = mediumRisk10YearBelow;
	}
	@Override
	public String toString() {
		return "Experience [highRisk10YearAbove=" + highRisk10YearAbove + ", highRisk10YearBelow=" + highRisk10YearBelow
				+ ", mediumRisk10YearAbove=" + mediumRisk10YearAbove + ", mediumRisk10YearBelow="
				+ mediumRisk10YearBelow + "]";
	}
}
