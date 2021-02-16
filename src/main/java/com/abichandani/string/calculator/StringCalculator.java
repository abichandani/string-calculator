package com.abichandani.string.calculator;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class StringCalculator {
	
	public static int add(String text) {
		if(text.isEmpty())
			return 0;
		else {
			String[] numbersStringArray = splitByDelimiter(text);
			List<Integer> numbers = toIntList(numbersStringArray);
			return sumIntList(numbers);
		}
	}
	
	private static String[] splitByDelimiter(String text) {
		String delimiter;
		if(hasCustomDelimiter(text)) {
			Matcher matcher = Pattern.compile("//(.)\n(.*)").matcher(text);
			matcher.matches();
			delimiter = Pattern.quote(matcher.group(1));
			text = matcher.group(2);
		} else {
			delimiter = ",|\n";
		}
		return text.split(delimiter);
	}

	private static boolean hasCustomDelimiter(String text) {
		return text.startsWith("//");
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
