package com.ubs.opsit.interviews.unitTests;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import com.ubs.opsit.interviews.TimeConverter;
import com.ubs.opsit.interviews.TimeConverterImpl;

public class TestTimeConverterImpl {
	static TimeConverter converter;
	
	@BeforeClass
	public static void initTimeConverter() {
		converter = new TimeConverterImpl();
	}
	
	@Test
	public void checkRandomDayTime() {
		String result = converter.convertTime("15:24:55");
		Assert.assertThat("Seconds field is incorrect", result, CoreMatchers.startsWith("O" + System.lineSeparator()));
		Assert.assertThat("Major Hours field is incorrect", result, CoreMatchers.containsString("RRRO" + System.lineSeparator()));
		Assert.assertThat("Minor Hours field is incorrect", result, CoreMatchers.containsString("OOOO" + System.lineSeparator()));
		Assert.assertThat("Major Minutes field is incorrect", result, CoreMatchers.containsString("YYRYOOOOOOO" + System.lineSeparator()));
		Assert.assertThat("Minor Minutes field is incorrect", result, CoreMatchers.endsWith("YYYY"));
	}
	
	@Test
	public void checkMidDayTime() {
		String result = converter.convertTime("12:00:00");
		Assert.assertThat("Seconds field is incorrect", result, CoreMatchers.startsWith("Y" + System.lineSeparator()));
		Assert.assertThat("Major Hours field is incorrect", result, CoreMatchers.containsString("RROO" + System.lineSeparator()));
		Assert.assertThat("Minor Hours field is incorrect", result, CoreMatchers.containsString("OOOO" + System.lineSeparator()));
		Assert.assertThat("Major Minutes field is incorrect", result, CoreMatchers.containsString("OOOOOOOOOOO" + System.lineSeparator()));
		Assert.assertThat("Minor Minutes field is incorrect", result, CoreMatchers.endsWith("OOOO"));
	}
	
	@Test
	public void checkMidNightTime0000() {
		String result = converter.convertTime("00:00:00");
		Assert.assertThat("Seconds field is incorrect", result, CoreMatchers.startsWith("Y" + System.lineSeparator()));
		Assert.assertThat("Major Hours field is incorrect", result, CoreMatchers.containsString("OOOO" + System.lineSeparator()));
		Assert.assertThat("Minor Hours field is incorrect", result, CoreMatchers.containsString("OOOO" + System.lineSeparator()));
		Assert.assertThat("Major Minutes field is incorrect", result, CoreMatchers.containsString("OOOOOOOOOOO" + System.lineSeparator()));
		Assert.assertThat("Minor Minutes field is incorrect", result, CoreMatchers.endsWith("OOOO"));
	}
	
	@Test
	public void checkMidNightTime2400() {
		String result = converter.convertTime("24:00:00");
		Assert.assertThat("Seconds field is incorrect", result, CoreMatchers.startsWith("Y" + System.lineSeparator()));
		Assert.assertThat("Major Hours field is incorrect", result, CoreMatchers.containsString("RRRR" + System.lineSeparator()));
		Assert.assertThat("Minor Hours field is incorrect", result, CoreMatchers.containsString("RRRR" + System.lineSeparator()));
		Assert.assertThat("Major Minutes field is incorrect", result, CoreMatchers.containsString("OOOOOOOOOOO" + System.lineSeparator()));
		Assert.assertThat("Minor Minutes field is incorrect", result, CoreMatchers.endsWith("OOOO"));
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void checkInvalidTime() {
		converter.convertTime("25:61:-22");
	}
	
	@Test (expected = NumberFormatException.class)
	public void checkInvalidString() {
		converter.convertTime("Test:Shyam:String");
	}
}
