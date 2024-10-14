package com.codingchallenges.leetcode;

import java.util.*;

// https://leetcode.com/problems/spiral-matrix/
public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int amountOfNUmbersToPrint = m * n;
        int numbersPrinted = 1;

        List<Integer> result = new ArrayList<>();

        for (int layer = 0; layer < m; layer++) {

            // print upper row
            for (int i = layer, j = layer; j < m - layer && numbersPrinted <= amountOfNUmbersToPrint; j++) {
                result.add(matrix[i][j]);
                numbersPrinted++;
            }

            // print right side
            for (int i = layer + 1, j = m - layer - 1; i < n - layer && numbersPrinted <= amountOfNUmbersToPrint; i++) {
                result.add(matrix[i][j]);
                numbersPrinted++;
            }

            // print lower row
            for (int i = n - layer - 1, j = m - layer - 2; j >= layer && numbersPrinted <= amountOfNUmbersToPrint; j--) {
                result.add(matrix[i][j]);
                numbersPrinted++;
            }

            // print left side
            for (int i = n - layer - 2, j = layer; i > layer && numbersPrinted <= amountOfNUmbersToPrint; i--) {
                result.add(matrix[i][j]);
                numbersPrinted++;
            }
        }

        return result;
    }
}
