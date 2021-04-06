package com.chatboat.model;

import java.math.BigDecimal;

public class Grade7 {
	
	private BigDecimal percente;
	private int totalHighRiskEmployee;
	public BigDecimal getPercente() {
		return percente;
	}
	public void setPercente(BigDecimal percente) {
		this.percente = percente;
	}
	public int getTotalHighRiskEmployee() {
		return totalHighRiskEmployee;
	}
	public void setTotalHighRiskEmployee(int totalHighRiskEmployee) {
		this.totalHighRiskEmployee = totalHighRiskEmployee;
	}
	@Override
	public String toString() {
		return "Grade7 [percente=" + percente + ", totalHighRiskEmployee=" + totalHighRiskEmployee + "]";
	}

}
