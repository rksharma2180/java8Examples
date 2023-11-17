package com.java8.programs;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
 * Two strings are said to be anagrams if they make a meaningful word by rearranging or shuffling the 
 * letters of the string. In other words, we can say that two strings are anagrams if they contain the same 
 * characters but in a different order. Note that a letter has to be used only once.
 * Examples: Listen -> Silent, Heart -> Earth, Lived-> Elvis, Keep -> Peek, Table -> Bleat
*/

public class Anagram {
	public static void main(String[] args) {
		System.out.println(isAnagram("Heart", "earth"));
		System.out.println(isAnagramUsingJava8("Silent", "Listen"));
	}

	private static boolean isAnagramUsingJava8(String s1, String s2) {
		s1 = Stream.of(s1.split("")).map(String::toUpperCase).sorted().collect(Collectors.joining());
		s2 = Stream.of(s2.split("")).map(String::toUpperCase).sorted().collect(Collectors.joining());
		return s1.equals(s2);
	}

	private static boolean isAnagram(String s1, String s2) {
		//Remove white spaces
		s1 = s1.replaceAll("\\s", "");
		s2 = s2.replaceAll("\\s", "");
		
		if(s1.length() != s2.length())
			return false;
		
		char[] charArray = s1.toLowerCase().toCharArray();
		char[] charArray2 = s2.toLowerCase().toCharArray();
		
		Arrays.sort(charArray);
		Arrays.sort(charArray2);
		
		return Arrays.equals(charArray, charArray2);
	}
}
