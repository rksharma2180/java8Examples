package com.java8.programs;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;
import java.util.function.Function;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class NumberOperations {
	public static void main(String[] args) {
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);

		// Reverse
		numbers.stream().sorted(Comparator.reverseOrder()).forEach(System.out::print);
		System.out.println("=====");

		// Top 3 from sorted stream
		numbers.stream().sorted().limit(3).forEach(System.out::println);
		System.out.println("=====");

		// Last 3 from sorted stream
		numbers.stream().sorted(Comparator.reverseOrder()).limit(3).forEach(System.out::println);
		System.out.println("=====");

		// Sum of Integers
		System.out.println(numbers.stream().mapToInt(i -> i).sum());
		System.out.println("=====");

		// Average
		System.out.println(numbers.stream().mapToInt(i -> i).average().getAsDouble());
		System.out.println("=====");

		// Reverse An Integer Array
		int[] arr = new int[] { 5, 6, 7, 8, 7, 4, 3, 9, 5, 3 };
		int[] array = IntStream.rangeClosed(1, arr.length)// Returns a sequential ordered IntStream from
															// startInclusive(inclusive) to endInclusive (inclusive) by
															// an incremental step of 1.
				.map(i -> {
					// System.out.println(i); //Index
					return arr[arr.length - i];

				}).toArray();
		System.out.println("=====");
		for (int num : array) {
			System.out.println(num);
		}
		System.out.println("=====");
		/*
		 * //Not working as this map method returns element int[] array2 =
		 * Arrays.stream(arr).sorted().map(i -> { //System.out.println(i);//Element
		 * return arr[arr.length - 1 - i]; }).toArray();
		 * 
		 * for (int num : array2) { System.out.println(num); }
		 */

		System.out.println("=====");
		// Frequency of Each element in Array
		// GroupingBy Accept Function partitioningBy Accept Predicate
		Map<Integer, Long> collect = Arrays.asList(5, 6, 7, 8, 7, 4, 3, 9, 5, 3).stream()
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

		for (Entry<Integer, Long> entry : collect.entrySet()) {
			System.out.println(entry.getKey() + "-" + entry.getValue());
		}
		System.out.println("=====");
		// Maximum in a List
		System.out.println(numbers.stream().max(Comparator.naturalOrder()).get());
		System.out.println("=====");
		// Minimum in a List
		System.out.println(numbers.stream().min(Comparator.naturalOrder()).get());

		System.out.println("=====");
		// Sum of all digit of a number
		int number = 1234555;
		Integer collect2 = Stream.of(String.valueOf(number).split(""))
				.collect(Collectors.summingInt(Integer::parseInt));
		System.out.println(collect2);

		System.out.println("=====");
		// Try another way
		// boxed() Returns a Stream consisting of the elements of this stream,each boxed
		// to an Integer.
		System.out.println(Integer.toString(number).chars().boxed()
				.collect(Collectors.summarizingInt(Character::getNumericValue)).getSum());
		System.out.println("=====");
		// Another way
		System.out.println(String.valueOf(number).chars().map(Character::getNumericValue).sum());
		System.out.println("=====");
		// Another way
		System.out.println(Pattern.compile("").splitAsStream(String.valueOf(number)).mapToInt(Integer::valueOf).sum());

		System.out.println("=====Incorrect");
		System.out.println((numbers + "").chars().map(digit -> digit % 48).sum());

		System.out.println("=====");
		// 2nd Largest number in An Integer List
		System.out.println(numbers.stream().sorted(Comparator.reverseOrder()).skip(1).findFirst().get());
		
		System.out.println("=====");
		// Sum of n numbers
		System.out.println(IntStream.range(1,11).sum());
		
		System.out.println("=====");
		final Set<Integer> set = new HashSet<>();
		Arrays.asList(6, 4, 32, 21, 45, 6, 5, 76, 7, 8, 8, 9, 5, 23, 4, 3).stream().filter(i -> !set.add(i))
				.collect(Collectors.toSet()).forEach(System.out::println);
		
		System.out.println("=====");
		List<int[]> asList = Arrays.asList(arr);
		int[] is = asList.stream().skip(2).findFirst().get();
		for (int num : is) {
			System.out.println(num);
		}
	}
}
