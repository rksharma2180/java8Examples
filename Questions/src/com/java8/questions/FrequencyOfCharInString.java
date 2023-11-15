package com.java8.questions;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FrequencyOfCharInString {

	public static void main(String[] args) {
		String string = "abadasfwaefawe";

		Collector<Object, ?, Map<Object, Long>> groupingBy = Collectors.groupingBy(Function.identity(),
				Collectors.counting());

		IntStream intStream = string.chars();

		Map<Object, Long> collect = intStream.mapToObj(i -> (char) i)// <U> Stream<U> mapToObj(IntFunction<? extends U>
																		// mapper);
				.collect(groupingBy);

		collect.forEach((k, v) -> {
			System.out.println(k + "-" + v);
		});
	}
}
