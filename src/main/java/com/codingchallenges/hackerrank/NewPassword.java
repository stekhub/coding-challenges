package com.codingchallenges.hackerrank;

public class NewPassword {

	public static void main(String[] args) {
		System.out.println(newPassword("hackerrank", "mountain"));

	}
	
	public static String newPassword(String a, String b) {
		StringBuilder result = new StringBuilder();
		
		for (int i = 0; a.length() + b.length() > i; i++) {
			if (a.length() > i) result.append(a.charAt(i));
			if (b.length() > i) result.append(b.charAt(i));
		}
		
		return result.toString();
	}	
}
