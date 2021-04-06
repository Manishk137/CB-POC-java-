package com.chatboat.utils;

public enum Week{
	SUNDAY(1),MONDAY(2),TUESDAY(3),WEDNESDAY(4),THURSDAY(5),FRIDAY(6),SATURDAY(7);
	
	private final int dayAsInt;
	
	private Week(int day){
		this.dayAsInt = day;
	}
	
	public int getDayAsInt(){
		return this.dayAsInt;
	}
	
}