package com.java8.programs;

import java.util.Arrays;
import java.util.OptionalInt;
import java.util.Set;
import java.util.function.IntBinaryOperator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ArrayOperations {

	public static void main(String[] args) {

		int[] numbers = new int[] { 2, 3, 4 };
		/**
		 * Calculates the greatest common denominator (gcd) of an array of numbers
		 */
		System.out.println("==== Calculate greatest common denominator GCD");
		OptionalInt reduce = Arrays.stream(numbers).reduce((a, b) -> gcd(a, b));
		System.out.println(reduce.getAsInt());

		/**
		 * Calculates the lowest common multiple (lcm) of an array of numbers.
		 */
		System.out.println("==== Calculate lowest common multiple LCM");
		IntBinaryOperator lcm = (x, y) -> (x * y) / gcd(x, y);
		OptionalInt reduce2 = Arrays.stream(numbers).reduce((a, b) -> lcm.applyAsInt(a, b));
		System.out.println(reduce2.getAsInt());

		/**
		 * Returns the minimum value in an array.
		 */
		System.out.println("==== Minimum value in an array");
		System.out.println(Arrays.stream(numbers).min().getAsInt());

		/**
		 * Returns the maximum value in an array.
		 */
		System.out.println("==== Maximum value in an array");
		System.out.println(Arrays.stream(numbers).max().getAsInt());

		/**
		 * Chunks an array into smaller arrays of a specified size.
		 */
		System.out.println("==== Dividing a larger array to smaller chunks of size 2");
		int size = 2;
		int[] numbers2 = new int[] { 2, 3, 4, 7, 8, 9, 0, 2, 21, 2, 3, 4, 5, 6, 76, 7, 2, 3, 78, 90, 65 };
		System.out.println("Length of new Array: " + numbers2.length);
		Stream<int[]> mapToObj = IntStream.iterate(0, i -> i + size)
				.limit((long) Math.ceil((double) numbers2.length / size)).mapToObj(cur -> Arrays.copyOfRange(numbers2,
						cur, cur + size > numbers2.length ? numbers2.length : cur + size));
		mapToObj.forEach(arr -> {
			System.out.print("Array: [ ");
			for (int num : arr) {
				System.out.print(num + " ");
			}
			System.out.println("]");
		});

		/**
		 * Counts the occurrences of a value in an array.
		 */
		System.out.println("==== Count the occurrance of a value in Array");
		System.out.println(Arrays.stream(numbers2).filter(n -> n == 2).count());

		/**
		 * Returns the difference between two arrays.
		 */
		System.out.println("==== Difference between two arrays");
		Set<Integer> set = Arrays.stream(numbers).boxed().collect(Collectors.toSet());
		int[] array = Arrays.stream(numbers2).filter(n -> !set.contains(n)).toArray();
		for (int num : array) {
			System.out.println(num);
		}

		/**
		 * Distinct values of an array
		 */
		System.out.println("==== Distinct Values of an array");
		int[] array2 = Arrays.stream(numbers2).distinct().toArray();
		for (int num : array2) {
			System.out.println(num);
		}
		;

		System.out.println("==== Returning a new array dropping 2 elements from right");
		System.out.println("length of Existing array: " + numbers2.length);
		int[] copyOfRange = Arrays.copyOfRange(numbers2, 0, numbers2.length - 2);
		System.out.println("length of New array: " + copyOfRange.length);
		for (int num : copyOfRange) {
			System.out.println(num);
		}

		/**
		 * Returning filtered array
		 */
		System.out.println("==== Printing filtered values from an array");
		int[] array3 = Arrays.stream(numbers2).filter(n -> n % 2 == 0).toArray();
		for(int num: array3) {
			System.out.println(num);
		}
		
		/**
		 * Returning filtered array
		 */
		System.out.println("==== Returning Unique values from Array");
		int[] array4 = Arrays.stream(numbers2).filter(el-> indexOf(numbers2, el) == lastIndexOf(numbers2, el)).toArray();
		for(int num: array4) {
			System.out.println(num);
		}
		
		System.out.println("==== Transforming Object Array to Int Array");
		int[] array5 = Arrays.stream(new Object[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 0 })
				.flatMapToInt(el -> el instanceof int[] ? Arrays.stream((int[]) el) : IntStream.of((int) el)).toArray();
		for(int num: array5) {
			System.out.println(num);
		}
	}

	private static int indexOf(int[] numbers, int element) {
		return IntStream.range(0, numbers.length).filter(idx -> numbers[idx] == element).findFirst().orElse(-1);
	}

	private static int lastIndexOf(int[] numbers, int element) {
		return IntStream.iterate(numbers.length - 1, i -> i - 1).limit(numbers.length - 1)
				.filter(idx -> numbers[idx] == element).findFirst().orElse(-1);
	}

	private static int gcd(int a, int b) {
		if (b == 0) {
			return a;
		}
		return gcd(b, a % b);
	}
}
