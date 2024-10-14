package com.codingchallenges.hackerrank;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class CountDuplicate {

	public static void main(String[] args) {
		Integer[] numbers = {1, 3, 1, 4, 5, 6, 3, 2, 2, 2, 2, 2};
		System.out.println(countDuplicate(Arrays.asList(numbers)));
	}
	
	public static int countDuplicate(List<Integer> numbers) {
		Set<Integer> setOfNumbers = new HashSet<>();
		return numbers.stream().map(i -> { if(!setOfNumbers.add(i)) return i; return null; }).filter(i -> i != null)
				.collect(Collectors.toSet()).size();
	}

}
