package com.codingchallenges.hackerrank;

import java.util.Arrays;
import java.util.List;

public class LowestStartingStair {

	public static void main(String[] args) {
		Integer[] jumps = {-5, 4, -2, 3, 1, -1, -6, -1, 0, -5};
		
		System.out.println(findLowestStartingStair(Arrays.asList(jumps)));
	}

	private static int findLowestStartingStair(List<Integer> jumps) {
		Integer lowestPosition = 0;
		Integer currentPosition = 0;
		for (Integer jump : jumps) {
			currentPosition += jump;
			if (currentPosition < lowestPosition) lowestPosition = currentPosition;
		}
		
		return lowestPosition < 0 ? lowestPosition * -1 + 1 : 1;
	}
}
