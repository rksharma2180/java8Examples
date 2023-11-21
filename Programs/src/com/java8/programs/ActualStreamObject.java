package com.java8.programs;

import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Stream;

public class ActualStreamObject {
	public static void main(String[] args) {

		System.out.println(Stream.of("Ravi", "Sharma"));// java.util.stream.ReferencePipeline$Head@123772c4

		System.out.println(Stream.of(1, 2, 3, 4));// java.util.stream.ReferencePipeline$Head@6f75e721

		System.out.println(Arrays.asList(1, 2, 3, 4, 5).stream());// java.util.stream.ReferencePipeline$Head@606d8acf

		System.out.println(Collections.singletonList(1).stream()); // java.util.stream.ReferencePipeline$Head@3fb4f649

		System.out.println(Stream.of("1", "1").mapToInt(Integer::parseInt));// java.util.stream.ReferencePipeline$4@12f40c25

		System.out.println(Arrays.stream(new int[] { 1, 2, 3, 4 }));// java.util.stream.IntPipeline$Head@3419866c

		System.out.println(Arrays.stream(new String[] { "", "", "" }));// java.util.stream.ReferencePipeline$Head@63e31ee

		System.out.println(Arrays.stream(new double[] { 1.0, 2.0, 3.0, 4.0 }));// java.util.stream.DoublePipeline$Head@6842775d

		System.out.println(Arrays.stream(new long[] { 1, 2, 3 }));// java.util.stream.LongPipeline$Head@5ecddf8f

		System.out.println(Arrays.stream(new Object[] { null, null, null }));// java.util.stream.ReferencePipeline$Head@3f102e87

		System.out.println(Stream.of("1", "1").mapToInt(Integer::parseInt).filter(i -> i == 1)); // java.util.stream.IntPipeline$10@2280cdac

	}
}
