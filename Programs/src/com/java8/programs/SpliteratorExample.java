package com.java8.programs;

import java.util.ArrayList;
import java.util.List;
import java.util.Spliterator;

public class SpliteratorExample {
	
	//Spliterator basically means "splittable Iterator".
	
	//Java Spliterator interface is an internal iterator that breaks the stream into the smaller parts. 
	//These smaller parts can be processed in parallel.
	
/*
 * 	Spliterator has been introduced in Java 8.
	It provides support for parallel processing of stream of elements for any collection.
	It provides tryAdvance() method to iterate elements individually in different threads. 
		It helps in parallel processing.
	To iterate elements sequentially in a single Thread, use forEachRemaining() method.
	The trySplit() method is used partition the spliterator, if it is possible.
	It helps in combining the hasNext() and next() operations into one method.
*/
	public static void main(String[] args) {
	
		List<String> list = new ArrayList<>();
		
		Spliterator<String> spliterator = list.spliterator();
		
		int expected = Spliterator.ORDERED | Spliterator.SIZED | Spliterator.SUBSIZED;
		
/* spliterator.characteristics()
 * Returns a set of characteristics of this Spliterator and itselements. The result is represented as 
 * ORed values from ORDERED, DISTINCT, SORTED, SIZED, NONNULL, IMMUTABLE, CONCURRENT, SUBSIZED. 
 * Repeated calls to characteristics() ona given spliterator, prior to or in-between calls to trySplit,should 
 * always return the same result. 
*/	
	System.out.println(spliterator.characteristics() == expected);  //true
	
	/*
	long estimateSize() : returns an estimate of the number of elements that would be encountered by a 
	forEachRemaining() traversal, or returns Long.MAX_VALUE if infinite, unknown, or too expensive to compute.
	*/
	
	//https://howtodoinjava.com/java/collections/java-spliterator/
	//https://www.baeldung.com/java-spliterator
	
	}
}
