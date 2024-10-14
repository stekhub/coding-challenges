package com.codingchallenges.leetcode;

// https://leetcode.com/problems/trapping-rain-water/
public class TrappingRainWater {
    public int trap(int[] height) {
        int result = 0;
        int heightOfLeftWall = height[0];

        // The first and last column can never hold any water
        for (int i = 1; i < height.length - 1; i++) {
            // Find highest wall to the right
            int heightOfRightWall = height[i + 1];
            for (int j = i + 1; j < height.length; j++) {
                if (heightOfRightWall < height[j]) heightOfRightWall = height[j];
            }

            // If current column is below a wall, add trapped water amount
            if (!(height[i] >= heightOfLeftWall || height[i] >= heightOfRightWall)) {
                result += heightOfLeftWall < heightOfRightWall ? heightOfLeftWall - height[i]
                        : heightOfRightWall - height[i];
            }

            // Check if current column becomes the highest wall for the next iteration
            if (heightOfLeftWall < height[i]) heightOfLeftWall = height[i];
        }

        return result;
    }

}
