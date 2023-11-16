package com.java8.questions;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StringOperations {

	public static void main(String[] args) {
		String string = "abadasfwaefawe";

		//Frequency Of character
		Collector<Object, ?, Map<Object, Long>> groupingBy = Collectors.groupingBy(Function.identity(),
				Collectors.counting());

		IntStream intStream = string.chars();

		// <U> Stream<U> mapToObj(IntFunction<? extends U>
		// mapper);
		Map<Object, Long> collect = intStream.mapToObj(i -> (char) i)				
				.collect(groupingBy);

		collect.forEach((k, v) -> {
			System.out.println(k + "-" + v);
		});
		
	}
}
