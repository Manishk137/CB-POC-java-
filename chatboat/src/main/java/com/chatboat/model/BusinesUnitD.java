package com.chatboat.model;

public class BusinesUnitD {
	
	private int stronglyDisengage;
	private int disengage;
	private int somewhatDisengage;
	private int somewhatEngage;
	private int Engage;
	private int stronglyEngage;
	public int getStronglyDisengage() {
		return stronglyDisengage;
	}
	public void setStronglyDisengage(int stronglyDisengage) {
		this.stronglyDisengage = stronglyDisengage;
	}
	public int getDisengage() {
		return disengage;
	}
	public void setDisengage(int disengage) {
		this.disengage = disengage;
	}
	public int getSomewhatDisengage() {
		return somewhatDisengage;
	}
	public void setSomewhatDisengage(int somewhatDisengage) {
		this.somewhatDisengage = somewhatDisengage;
	}
	public int getSomewhatEngage() {
		return somewhatEngage;
	}
	public void setSomewhatEngage(int somewhatEngage) {
		this.somewhatEngage = somewhatEngage;
	}
	public int getEngage() {
		return Engage;
	}
	public void setEngage(int engage) {
		Engage = engage;
	}
	public int getStronglyEngage() {
		return stronglyEngage;
	}
	public void setStronglyEngage(int stronglyEngage) {
		this.stronglyEngage = stronglyEngage;
	}
	@Override
	public String toString() {
		return "BusinesUnitD [stronglyDisengage=" + stronglyDisengage + ", disengage=" + disengage
				+ ", somewhatDisengage=" + somewhatDisengage + ", somewhatEngage=" + somewhatEngage + ", Engage="
				+ Engage + ", stronglyEngage=" + stronglyEngage + "]";
	}
}
