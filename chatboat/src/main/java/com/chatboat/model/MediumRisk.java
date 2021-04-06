package com.chatboat.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class MediumRisk {
	
	private BigDecimal mediumRiskPercentage;
	List<Employee> employee = new ArrayList<Employee>();
	public BigDecimal getMediumRiskPercentage() {
		return mediumRiskPercentage;
	}
	public void setMediumRiskPercentage(BigDecimal mediumRiskPercentage) {
		this.mediumRiskPercentage = mediumRiskPercentage;
	}
	public List<Employee> getEmployee() {
		return employee;
	}
	public void setEmployee(List<Employee> employee) {
		this.employee = employee;
	}
	@Override
	public String toString() {
		return "MediumRisk [mediumRiskPercentage=" + mediumRiskPercentage + ", employee=" + employee + "]";
	}
}
