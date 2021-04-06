package com.chatboat.model;

public class CriticalEmployeeHighRiskParam {
	
	MaleGenderCritical MaleGenderCritical;
	FemaleGenderCritical femaleGenderCritical;
	public MaleGenderCritical getMaleGenderCritical() {
		return MaleGenderCritical;
	}
	public void setMaleGenderCritical(MaleGenderCritical maleGenderCritical) {
		MaleGenderCritical = maleGenderCritical;
	}
	public FemaleGenderCritical getFemaleGenderCritical() {
		return femaleGenderCritical;
	}
	public void setFemaleGenderCritical(FemaleGenderCritical femaleGenderCritical) {
		this.femaleGenderCritical = femaleGenderCritical;
	}
	@Override
	public String toString() {
		return "CriticalEmployeeHighRiskParam [MaleGenderCritical=" + MaleGenderCritical + ", femaleGenderCritical="
				+ femaleGenderCritical + "]";
	}
}
