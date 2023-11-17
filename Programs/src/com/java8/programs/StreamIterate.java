package com.java8.programs;

import java.util.stream.Stream;

public class StreamIterate {

	public static void main(String[] args) {
		//
		//Stream.iterate(T Seed, UniaryOperator<T>)
		Stream.iterate(2, i-> i + 2).limit(10).forEach(System.out::println);
	}
}
