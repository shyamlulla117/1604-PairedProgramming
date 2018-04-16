package com.ubs.opsit.interviews;

import java.util.StringTokenizer;

public class TimeConverterImpl implements TimeConverter {

	@Override
	public String convertTime(String aTime) {
		
		StringTokenizer tokenizer = new StringTokenizer(aTime, ":");
		if(tokenizer.countTokens() != 3) {
			throw new IllegalArgumentException("Please provide a valid time. Valid time format is HH:mm:ss format");
		}
		
		int hours = -1;
		int minutes = -1;
		int seconds = -1;

		try {
			hours = Integer.parseInt((String) tokenizer.nextElement());
			minutes = Integer.parseInt((String) tokenizer.nextElement());
			seconds = Integer.parseInt((String) tokenizer.nextElement());
		} catch(NumberFormatException n) {
			throw new NumberFormatException("Please provide valid non negative integers in hour(s), minute(s) and second(s) fields");
		}
		
		if(hours < 0 || minutes < 0 || seconds < 0) {
			throw new IllegalArgumentException("Please provide valid non-negative integers in hour(s), minute(s) and second(s) fields");
		}
		
		String timeStr = BerlinTimeConverter.toBerlinTime(hours, minutes, seconds);
		
		
		return timeStr;
	}
}
