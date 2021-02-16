package com.abichandani.string.calculator;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class StringCalculatorTest {
	
	@Test
	public void returnZeroforEmptyString() {
		assertEquals(0, StringCalculator.add(""));
	}
	
	@Test
	public void returnNumberForSingleNumber() {
		assertEquals(3, StringCalculator.add("3"));
	}
	
	@Test
	public void returnSumFor2Numbers() {
		assertEquals(3, StringCalculator.add("1,2"));
	}
	
	@Test
	public void returnSumForMultipleNumbers() {
		assertEquals(6, StringCalculator.add("1,2,3"));
	}
	
	@Test
	public void supportNewLineAsValidDelimiter() {
		assertEquals(6, StringCalculator.add("1\n2,3"));
		assertEquals(6, StringCalculator.add("1\n2\n3"));
	}

}
