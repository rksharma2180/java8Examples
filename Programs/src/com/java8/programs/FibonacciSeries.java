package com.java8.programs;

import java.util.stream.Stream;

public class FibonacciSeries {
	static int limit = 10;
	
	public static void main(String[] args) {
	
		/*
		 * Returns an infinite sequential ordered Stream produced by iterative application of a function f to 
		 * an initial element seed, producing a Stream consisting of seed, f(seed), f(f(seed)), etc. 
		   The first element (position 0) in the Stream will be the provided seed. For n > 0, the element at 
		   position n, will be the result of applying the function f to the element at position n - 1. 
		*/
		
		Stream.iterate(new int[] { 0, 1 }, f -> {
			//for (int num : f)
				//System.out.println(num);
			return new int[] { f[1], f[0] + f[1] };
		}).limit(10).map(f -> f[0]).forEach(i -> System.out.println("Element "+i + " "));
		
		System.out.print(0+","+1);
		printFibonacci(0, 1);
	}
	
	public static void printFibonacci(int first, int second) {
		int temp = first + second;
		System.out.print(","+temp);
		first = second;
		second = temp;
		if(limit-- > 0)
			printFibonacci(first, second);
	}	
}
