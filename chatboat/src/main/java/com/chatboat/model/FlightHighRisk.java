package com.chatboat.model;

import java.math.BigDecimal;

public class FlightHighRisk {
	
	private BigDecimal  highRiskPercentage;
	private int totalHighRiskEmployee;
	public BigDecimal getHighRiskPercentage() {
		return highRiskPercentage;
	}
	public void setHighRiskPercentage(BigDecimal highRiskPercentage) {
		this.highRiskPercentage = highRiskPercentage;
	}
	public int getTotalHighRiskEmployee() {
		return totalHighRiskEmployee;
	}
	public void setTotalHighRiskEmployee(int totalHighRiskEmployee) {
		this.totalHighRiskEmployee = totalHighRiskEmployee;
	}
	@Override
	public String toString() {
		return "FlightHighRisk [highRiskPercentage=" + highRiskPercentage + ", totalHighRiskEmployee="
				+ totalHighRiskEmployee + "]";
	}
}
