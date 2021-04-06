package com.chatboat.model;

import java.math.BigDecimal;

public class FemaleGenderCritical {
	private BigDecimal  femaleCriticalHighRiskPercentage;
	private int totalFemaleCriticalHighRiskEmp;
	public BigDecimal getFemaleCriticalHighRiskPercentage() {
		return femaleCriticalHighRiskPercentage;
	}
	public void setFemaleCriticalHighRiskPercentage(BigDecimal femaleCriticalHighRiskPercentage) {
		this.femaleCriticalHighRiskPercentage = femaleCriticalHighRiskPercentage;
	}
	public int getTotalFemaleCriticalHighRiskEmp() {
		return totalFemaleCriticalHighRiskEmp;
	}
	public void setTotalFemaleCriticalHighRiskEmp(int totalFemaleCriticalHighRiskEmp) {
		this.totalFemaleCriticalHighRiskEmp = totalFemaleCriticalHighRiskEmp;
	}
	@Override
	public String toString() {
		return "FemaleGenderCritical [femaleCriticalHighRiskPercentage=" + femaleCriticalHighRiskPercentage
				+ ", totalFemaleCriticalHighRiskEmp=" + totalFemaleCriticalHighRiskEmp + "]";
	}
}
