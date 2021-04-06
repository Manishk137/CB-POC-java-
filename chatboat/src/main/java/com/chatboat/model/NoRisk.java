package com.chatboat.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class NoRisk {
	
	private BigDecimal noRiskPercentage;
	List<Employee> employee = new ArrayList<Employee>();
	public BigDecimal getNoRiskPercentage() {
		return noRiskPercentage;
	}
	public void setNoRiskPercentage(BigDecimal noRiskPercentage) {
		this.noRiskPercentage = noRiskPercentage;
	}
	public List<Employee> getEmployee() {
		return employee;
	}
	public void setEmployee(List<Employee> employee) {
		this.employee = employee;
	}
	@Override
	public String toString() {
		return "NoRisk [noRiskPercentage=" + noRiskPercentage + ", employee=" + employee + "]";
	}
}
