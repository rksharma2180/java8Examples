	package com.java8.programs;

import java.util.stream.Stream;

public class Fibonacci {
    public final int previous;
    public final int value;
    private static final int MAX_NUMS = 10;

    // Seed for stream.iterate()
    public static final Fibonacci SEED =
            new Fibonacci(1, 1);

    public Fibonacci(int previous, int value) {
        this.previous = previous;
        this.value = value;
    }

    public Fibonacci next() {
        return new Fibonacci(value, value + previous);
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }

    public static void main(String[] args) {
        System.out.print(Fibonacci.SEED + ", "); // Print 1st

        Stream.iterate(Fibonacci.SEED, Fibonacci::next)
                .limit(MAX_NUMS)
                .forEach(x -> System.out.print(x + ", "));

        System.out.println("..."); // Print nice
    }
}