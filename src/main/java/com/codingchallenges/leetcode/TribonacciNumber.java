package com.codingchallenges.leetcode;

// https://leetcode.com/problems/n-th-tribonacci-number/
public class TribonacciNumber {
    public static Integer[] memory;

    public int tribonacci(int n) {
        memory = new Integer[n + 1];

        return calculateTribonacci(n);
    }

    public int calculateTribonacci(int n) {
        if (memory[n] != null) return memory[n];
        if (n == 0) return 0;
        if (n == 1 || n == 2) return 1;

        return memory[n] = calculateTribonacci(n - 1) + calculateTribonacci(n - 2)
                + calculateTribonacci(n - 3);
    }
}
