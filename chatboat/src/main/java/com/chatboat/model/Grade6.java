package com.chatboat.model;

import java.math.BigDecimal;

public class Grade6 {
	
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
		return "Grade6 [percente=" + percente + ", totalHighRiskEmployee=" + totalHighRiskEmployee + "]";
	}

}
