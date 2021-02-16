package com.abichandani.string.calculator;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class StringCalculator {
	
	public static int add(String text) throws RuntimeException{
		if(text.isEmpty())
			return 0;
		else {
			String[] numbersStringArray = splitByDelimiter(text);
			List<Integer> numbers = toIntList(numbersStringArray);

			// Negatives not allowed.
			List<Integer> negatives = filterNegativeNumbersFromList(numbers);
			
			if(negatives.size() > 0) {
				throw new RuntimeException("Negatives not allowed : "+negatives.toString());
			}
			
			// Ignore numbers greater than 1000
			List<Integer> filteredNumbers = filterNumbersLessThanOrEqualTo1000(numbers);
			
			return sumIntList(filteredNumbers);
		}
	}

	private static List<Integer> filterNumbersLessThanOrEqualTo1000(List<Integer> numbers) {
		return numbers.stream()
						.filter(x -> x<1000)
						.collect(Collectors.toList());
	}

	private static List<Integer> filterNegativeNumbersFromList(List<Integer> numbers) {
		return numbers.stream()
					.filter(x -> isNegative(x))
					.collect(Collectors.toList());
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
	
	private static boolean isNegative(Integer i) throws RuntimeException{
		if(i<0)
			return true;
		else
			return false;
	}

}
