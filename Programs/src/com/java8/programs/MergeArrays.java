package com.java8.programs;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class MergeArrays {
	public static void main(String[] args) {
		List<Integer> numbers = Arrays.asList(25, 20, 18, 78, 23, 67, 90, 12, 9,2);
		List<Integer> numbers2 = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);

		IntStream result = IntStream.concat(numbers.stream().mapToInt(e -> e), numbers2.stream().mapToInt(i -> i));
		result.forEach(System.out::print);

		int[] array = IntStream.concat(numbers.stream().mapToInt(e -> e), numbers2.stream().mapToInt(i -> i)).sorted()
				.toArray();
		System.out.println("\n=================================== Sorted");
		for(int num: array) {
			System.out.println(num);
		}
		System.out.println("\n=================================== Distinct");
		int[] array2 = IntStream.concat(numbers.stream().mapToInt(e -> e), numbers2.stream().mapToInt(i -> i)).sorted().distinct()
				.toArray();
		for(int num: array2) {
			System.out.println(num);
		}		
	}
}
