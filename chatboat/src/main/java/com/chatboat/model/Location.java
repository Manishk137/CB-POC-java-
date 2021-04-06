package com.chatboat.model;

public class Location {
	
	PositiveNegative Noida ;
	PositiveNegative Mumbai;
	PositiveNegative Chennai;
	PositiveNegative Kolkatta ;
	PositiveNegative Pune;
	PositiveNegative Bengaluru;
	PositiveNegative Hydrabad;
	public PositiveNegative getNoida() {
		return Noida;
	}
	public void setNoida(PositiveNegative noida) {
		Noida = noida;
	}
	public PositiveNegative getMumbai() {
		return Mumbai;
	}
	public void setMumbai(PositiveNegative mumbai) {
		Mumbai = mumbai;
	}
	public PositiveNegative getChennai() {
		return Chennai;
	}
	public void setChennai(PositiveNegative chennai) {
		Chennai = chennai;
	}
	public PositiveNegative getKolkatta() {
		return Kolkatta;
	}
	public void setKolkatta(PositiveNegative kolkatta) {
		Kolkatta = kolkatta;
	}
	public PositiveNegative getPune() {
		return Pune;
	}
	public void setPune(PositiveNegative pune) {
		Pune = pune;
	}
	public PositiveNegative getBengaluru() {
		return Bengaluru;
	}
	public void setBengaluru(PositiveNegative bengaluru) {
		Bengaluru = bengaluru;
	}
	public PositiveNegative getHydrabad() {
		return Hydrabad;
	}
	public void setHydrabad(PositiveNegative hydrabad) {
		Hydrabad = hydrabad;
	}
	@Override
	public String toString() {
		return "Location [Noida=" + Noida + ", Mumbai=" + Mumbai + ", Chennai=" + Chennai + ", Kolkatta=" + Kolkatta
				+ ", Pune=" + Pune + ", Bengaluru=" + Bengaluru + ", Hydrabad=" + Hydrabad + "]";
	}
}
