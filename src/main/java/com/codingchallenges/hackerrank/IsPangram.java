package com.codingchallenges.hackerrank;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class IsPangram {

	public static void main(String[] args) {
		String[] input = { "the quick brown fox jumps over the lazy dog", "not a pangram", "hahahaha",
				"the quick brown dog jumps over the lazy fox" };
		System.out.println(isPangram(Arrays.asList(input)));
	}

	public static String isPangram(List<String> pangram) {
		return pangram.stream().map(line -> {
			return (line.replace(" ", "").chars().distinct().count() >= 26) ? "1" : "0";
		}).collect(Collectors.joining());
	}
}
