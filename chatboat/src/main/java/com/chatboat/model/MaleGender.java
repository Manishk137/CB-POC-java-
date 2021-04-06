package com.chatboat.model;

import java.math.BigDecimal;

public class MaleGender {
	
	private BigDecimal mood;
	private BigDecimal progress;
	private int criticalEmployee;
	public BigDecimal getMood() {
		return mood;
	}
	public void setMood(BigDecimal mood) {
		this.mood = mood;
	}
	public BigDecimal getProgress() {
		return progress;
	}
	public void setProgress(BigDecimal progress) {
		this.progress = progress;
	}
	public int getCriticalEmployee() {
		return criticalEmployee;
	}
	public void setCriticalEmployee(int criticalEmployee) {
		this.criticalEmployee = criticalEmployee;
	}
	@Override
	public String toString() {
		return "MaleGender [criticalEmployee=" + criticalEmployee + "]";
	}
}
