package com.chatboat.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class HighRisk {

	private BigDecimal highRiskPercentage;
	List<Employee> employee = new ArrayList<Employee>();
	public BigDecimal getHighRiskPercentage() {
		return highRiskPercentage;
	}
	public void setHighRiskPercentage(BigDecimal highRiskPercentage) {
		this.highRiskPercentage = highRiskPercentage;
	}
	public List<Employee> getEmployee() {
		return employee;
	}
	public void setEmployee(List<Employee> employee) {
		this.employee = employee;
	}
	@Override
	public String toString() {
		return "HighRisk [highRiskPercentage=" + highRiskPercentage + ", employee=" + employee + "]";
	}
}
