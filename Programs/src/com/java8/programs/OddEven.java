package com.java8.programs;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class OddEven {
	public static void main(String[] args) {
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);

		
		/*Collectors.partitioningBy(Predicate<? super Integer>)Returns a Collector which partitions the input elements accordingto a Predicate, 
		 * and organizes them into a Map<Boolean, List<T>>.The returned Map always contains mappings 
		 * for both false and true keys.There are no guarantees on the type, mutability, serializability, 
		 * or thread-safety of the Map or List returned.
		 */
		Collector<Integer, ?, Map<Boolean, List<Integer>>> collect = Collectors.partitioningBy(i -> i % 2 == 0);

		Map<Boolean, List<Integer>> collect2 = numbers.stream().collect(collect);

		collect2.forEach((k, v) -> {
			System.out.println(k);
			System.out.println(v);
		});
		
		//GroupingBy Accept Function partitioningBy Accept Predicate
		
	}
}
