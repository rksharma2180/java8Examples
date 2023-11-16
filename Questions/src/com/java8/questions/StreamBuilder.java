package com.java8.questions;

import java.util.Arrays;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.util.stream.Stream.Builder;

/*
 * Stream.Builder<T> 
 * A mutable builder for a Stream. This allows the creation of a Stream by generating elements individually 
 * and adding them to the Builder (without the copying overhead that comes from using an ArrayList as a 
 * temporary buffer.)
 * A stream builder has a lifecycle, which starts in a building phase, during which elements can be added, 
 * and then transitions to a built phase, after which elements may not be added. The built phase begins when 
 * the build() method is called, which creates an ordered Stream whose elements are the elements that were 
 * added to the stream builder, in the order they were added.
*/

public class StreamBuilder {
	public static void main(String[] args) {
		Builder<String> builder = Stream.builder();
		builder.add("Test");
		builder.add("Abc");
		builder.add("Def");
		Consumer<String> andThen = builder.andThen(e->e.toUpperCase());
		builder.add("mno");
		Stream<String> build = builder.build();
		build.forEach(System.out::println);
		
		Stream<Character> charStream = Stream.of('a','c','e', 'z', 'i');
		
		IntStream intStream = Arrays.stream(new int []{1,1,2,3,3,43});
		
		Supplier<Double> supplier =  () -> Math.random();
		
		Stream<Double> doubleStream = Stream.generate(supplier).limit(5000);
		
		System.out.println(doubleStream.count());
		
	}
}
