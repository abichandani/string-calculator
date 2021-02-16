package com.abichandani.string.calculator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringCalculator {
	
	public static int add(String text) {
		if(text.isEmpty())
			return 0;
		else if(text.contains(",")) {
			List<Integer> numbers = toIntList(text.split(","));
			return sumIntList(numbers); 
		}
		else {
			return Integer.valueOf(text);
		}
	}

	private static List<Integer> toIntList(String[] array) {
		return Arrays.stream(array)
				.map(x -> Integer.valueOf(x))
				.collect(Collectors.toList());
	}

	private static Integer sumIntList(List<Integer> numbers) {
		return numbers.stream().reduce(0, (x,y) -> x+y);
	}

}
