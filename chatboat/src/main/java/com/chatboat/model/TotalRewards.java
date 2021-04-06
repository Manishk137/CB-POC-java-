package com.chatboat.model;

public class TotalRewards {
	
	private float stronglyDisengage;
	private float disengage;
	private float somewhatDisengage;
	private float somewhatEngage;
	private float Engage;
	private float stronglyEngage;
	public float getStronglyDisengage() {
		return stronglyDisengage;
	}
	public void setStronglyDisengage(float stronglyDisengage) {
		this.stronglyDisengage = stronglyDisengage;
	}
	public float getDisengage() {
		return disengage;
	}
	public void setDisengage(float disengage) {
		this.disengage = disengage;
	}
	public float getSomewhatDisengage() {
		return somewhatDisengage;
	}
	public void setSomewhatDisengage(float somewhatDisengage) {
		this.somewhatDisengage = somewhatDisengage;
	}
	public float getSomewhatEngage() {
		return somewhatEngage;
	}
	public void setSomewhatEngage(float somewhatEngage) {
		this.somewhatEngage = somewhatEngage;
	}
	public float getEngage() {
		return Engage;
	}
	public void setEngage(float engage) {
		Engage = engage;
	}
	public float getStronglyEngage() {
		return stronglyEngage;
	}
	public void setStronglyEngage(float stronglyEngage) {
		this.stronglyEngage = stronglyEngage;
	}
	@Override
	public String toString() {
		return "TotalRewards [stronglyDisengage=" + stronglyDisengage + ", disengage=" + disengage
				+ ", somewhatDisengage=" + somewhatDisengage + ", somewhatEngage=" + somewhatEngage + ", Engage="
				+ Engage + ", stronglyEngage=" + stronglyEngage + "]";
	}

}
