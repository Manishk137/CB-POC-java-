package com.chatboat.model;

public class GenderWiseViewParam {
	
	MaleGender MaleGender;
	FemaleGender FemaleGender;
	public MaleGender getMaleGender() {
		return MaleGender;
	}
	public void setMaleGender(MaleGender maleGender) {
		MaleGender = maleGender;
	}
	public FemaleGender getFemaleGender() {
		return FemaleGender;
	}
	public void setFemaleGender(FemaleGender femaleGender) {
		FemaleGender = femaleGender;
	}
	@Override
	public String toString() {
		return "GenderWiseViewParam []";
	}

}
