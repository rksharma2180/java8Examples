package com.java8.programs;

import java.util.Comparator;
import java.util.function.Function;
import java.util.function.ToIntFunction;
import java.util.stream.Stream;

public class ComparatorExample {

	public static void main(String[] args) {
		System.out.println("=====");
		Stream<String> stringStream = Stream.of("of", "ravi", "farji", "maxwel", "a", "test");
		
		Function<String, Integer> function = (s) -> s.length();
		
		//stringStream.sorted(Comparator.comparing(String::length)).forEach(System.out::println);
		
		//OR
		stringStream.sorted(Comparator.comparing(function)).forEach(System.out::println);
		
		System.out.println("=====");
		//Natural Order
		Stream<String> newStream = Stream.of("z", "m", "k", "o", "a", "t");
		newStream.sorted(Comparator.naturalOrder()).forEach(System.out::println);
		
		System.out.println("=====");
		
		Stream<String> stream = Stream.of("of", "ravi", null, "farji", "maxwel", "a", "test");
		stream.sorted(Comparator.nullsFirst(Comparator.naturalOrder())).forEach(System.out::println);
		
		System.out.println("=====");
		Stream<String> stream2 = Stream.of("of", "ravi", null, "farji", "maxwel", "a", "test");
		stream2.sorted(Comparator.nullsLast(Comparator.naturalOrder())).forEach(System.out::println);
		
		
		Stream<String> intStream = Stream.of("4","5","7","8","9","1","0");
		ToIntFunction<String> toIntFunction =  (i) -> Integer.parseInt(i);
		intStream.sorted(Comparator.comparingInt(toIntFunction)).forEach(System.out::println);
	}
}
