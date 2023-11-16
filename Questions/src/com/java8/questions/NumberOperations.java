package com.java8.questions;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class NumberOperations {
	public static void main(String[] args) {
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
		
		//Reverse 
		numbers.stream().sorted(Comparator.reverseOrder()).forEach(System.out::print);
		
		System.out.println("=====");
		
		//Top 3 from sorted stream
		numbers.stream().sorted().limit(3).forEach(System.out::println);
		
		System.out.println("=====");
		//Last 3 from sorted stream
		numbers.stream().sorted(Comparator.reverseOrder()).limit(3).forEach(System.out::println);
	}
}
