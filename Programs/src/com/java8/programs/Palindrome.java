package com.java8.programs;

import java.util.stream.IntStream;

public class Palindrome {
	public static void main(String[] args) {
		String s = "MOM";
		System.out.println(isPalindrome(s));
		System.out.println(IntStream.range(0, s.length() / 2).noneMatch(i -> {
			System.out.println(i);//Index
			return s.toLowerCase().charAt(i) != s.toLowerCase().charAt(s.length() - i - 1);
		}));
		System.out.println(isPalnindrom(s));
	}
	
	//Library Usage
	public static boolean isPalindrome(String s) {
		return s.equalsIgnoreCase(new StringBuilder(s).reverse().toString());
	}
	
	//Traditional way n/2
	public static boolean isPalnindrom(String s) {
		boolean isPalindrome = false;
		for(int i = 0; i<= s.length()/2; i++) {
			if(s.toLowerCase().charAt(i) == s.toLowerCase().charAt(s.length() -i -1)) {
				isPalindrome = true;
			}else {
				isPalindrome = false;
			}
		}
		return isPalindrome;
	}
}