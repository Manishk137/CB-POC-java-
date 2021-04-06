package com.chatboat.model;

public class PositiveNegative {
	
	private int positive;
	private int negative;
	public int getPositive() {
		return positive;
	}
	public void setPositive(int positive) {
		this.positive = positive;
	}
	public int getNegative() {
		return negative;
	}
	public void setNegative(int negative) {
		this.negative = negative;
	}
	@Override
	public String toString() {
		return "Location [positive=" + positive + ", negative=" + negative + "]";
	}

}
