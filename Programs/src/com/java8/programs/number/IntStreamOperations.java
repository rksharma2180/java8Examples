package com.java8.programs.number;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class IntStreamOperations {
	
	 /* IntStream
	  * A sequence of primitive int-valued elements supporting sequential and parallel aggregate operations.
	 */
	
	public static void main(String[] args) {
		System.out.println("=====> Printing Numbers from 1 to 10 where end in exclusive");
		IntStream.range(1, 10).forEach(System.out::println);
		
		System.out.println("=====> Printing Numbers from 1 to 10 where end in Inclusive");
		IntStream.rangeClosed(1, 10).forEach(System.out::println);
		
		System.out.println("=====> Printing Numbers starting from 1 and multiplying to 1");
		IntStream.iterate(1, i-> i * 1).limit(10).forEach(System.out::println);
		
		System.out.println("=====> Printing 2 digit Randome Numbers ");
		//IntStream.generate(IntSupplier s)
		IntStream.generate(() -> Double.valueOf(Math.random() * 100).intValue()).limit(10)
				.forEach(System.out::println);
		
		System.out.println("=====> To Understand Math.Random");
		System.out.println(Math.random());//example 0.6152908966994997
		
		IntStream empty = IntStream.empty();
		empty.forEach(System.out::println);
		
		List<Integer> numbers = Arrays.asList(25, 20, 18, 78, 23, 67, 90, 12, 9,2);
		List<Integer> numbers2 = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);

		//Merging 2 Lists
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
