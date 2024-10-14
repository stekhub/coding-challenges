package com.codingchallenges.hackerrank;

public class EliminateSubstring {

	public static void main(String[] args) {
		System.out.println(eliminateSubstring("AWAWSSG"));
	}

	private static String eliminateSubstring(String s) {
		if (!s.contains("AWS")) return "-1";
		while (s.contains("AWS")) s = s.replace("AWS", "");
		return s;
	}
}
