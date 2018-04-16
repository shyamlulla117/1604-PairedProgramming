package com.ubs.opsit.interviews.unitTests;

import org.junit.Test;

import com.ubs.opsit.interviews.BerlinTimeConverter;

public class TestBerlinTimeConverter {
	
	@Test
	public void testBerlinTimeConverter() {
		BerlinTimeConverter.toBerlinTime(23, 59, 59);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testBerlinTimeConverterIllegalArgs() {
		BerlinTimeConverter.toBerlinTime(99, 100, -1);
	}
	
}
