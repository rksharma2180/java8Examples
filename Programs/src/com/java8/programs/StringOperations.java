package com.java8.programs;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StringOperations {

	public static void main(String[] args) {
		String string = "abadasfwaefawe";

		// Frequency Of character
		// GroupingBy Accept Function partitioningBy Accept Predicate
		Collector<Object, ?, Map<Object, Long>> groupingBy = Collectors.groupingBy(Function.identity(),
				Collectors.counting());

		IntStream intStream = string.chars();

		// <U> Stream<U> mapToObj(IntFunction<? extends U>
		// mapper);
		Map<Object, Long> collect = intStream.mapToObj(i -> (char) i).collect(groupingBy);

		collect.forEach((k, v) -> {
			System.out.println(k + "-" + v);
		});

		System.out.println("=====");
		// Join List of String with Prefix, suffix and Delimiter
		String collect2 = Arrays.asList("Ravi", "Kumar", "Sharma").stream()
				.collect(Collectors.joining(" ", "MR. ", " The Great"));
		System.out.println(collect2);

		System.out.println("=====");
		// Reverse Each word of a String
		String s1 = "Reverse Each Word of a String 8Test";
		System.out.println(Arrays.stream(s1.split(" ")).map(word -> new StringBuffer(word).reverse())
				.collect(Collectors.joining(" ")));

		System.out.println("=====");
		// Find Strings which start with Number
		Arrays.asList(s1.split(" ")).stream().filter(str -> Character.isDigit(str.charAt(0)))
				.forEach(System.out::println);
	}
}
