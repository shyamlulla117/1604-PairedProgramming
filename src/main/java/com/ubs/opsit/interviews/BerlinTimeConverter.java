package com.ubs.opsit.interviews;

public class BerlinTimeConverter {
	
	public static String toBerlinTime(int hours, int minutes, int seconds) {
		
		if(!(hours < 25 && hours > -1) || !(minutes < 60 && minutes > -1)  || !(seconds > -1 && seconds < 60) ) {
			throw new IllegalArgumentException();
		}
		
		StringBuffer berlinTimeString = new StringBuffer();
		
		if(seconds % 2 == 0) {
			berlinTimeString.append("Y");
		} else {
			berlinTimeString.append("O");
		}
		berlinTimeString.append(System.lineSeparator());
		
		int bigHourCounter = 0;
		while(bigHourCounter < hours/5) {
			berlinTimeString.append("R");
			bigHourCounter++;
			
		}
		while(bigHourCounter < 4) {
			berlinTimeString.append("O");
			bigHourCounter++;
		}
		berlinTimeString.append(System.lineSeparator());
		
		int smallHourCounter = 0;
		while(smallHourCounter < hours%5) {
			berlinTimeString.append("R");
			smallHourCounter++;
		}
		while(smallHourCounter < 4) {
			berlinTimeString.append("O");
			smallHourCounter++;
		}
		berlinTimeString.append(System.lineSeparator());
		
		int bigMinuteCounter = 0;
		while(bigMinuteCounter < minutes/5) {
			berlinTimeString.append((bigMinuteCounter % 3 != 2) ? "Y" : "R");
			bigMinuteCounter++;
			
		}
		while(bigMinuteCounter < 11) {
			berlinTimeString.append("O");
			bigMinuteCounter++;
		}
		berlinTimeString.append(System.lineSeparator());
		
		int smallMinuteCounter = 0;
		while(smallMinuteCounter < minutes%5) {
			berlinTimeString.append("Y");
			smallMinuteCounter++;
			
		}
		while(smallMinuteCounter < 4) {
			berlinTimeString.append("O");
			smallMinuteCounter++;
		}
		
		return berlinTimeString.toString();
	}
	
}
