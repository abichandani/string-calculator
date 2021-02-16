package com.abichandani.string.calculator;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class StringCalculatorTest {
	
	@Test
	public void returnZeroforEmptyString() {
		assertEquals(0, StringCalculator.add(""));
	}

}
