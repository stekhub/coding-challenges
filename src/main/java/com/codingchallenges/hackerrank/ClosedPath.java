package com.codingchallenges.hackerrank;

public class ClosedPath {

	public static void main(String[] args) {
		System.out.println(closedPath(6380));
	}

	public static int closedPath(int number) {
		int result = 0;

		for (Character c : Integer.toString(number).toCharArray()) {
			if (c.equals('0') || c.equals('4') || c.equals('6') || c.equals('9'))
				result++;
			if (c.equals('8'))
				result += 2;
		}

		return result;
	}
}
