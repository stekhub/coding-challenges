package com.codingchallenges.leetcode;

// https://leetcode.com/problems/container-with-most-water/
public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int pointerLeft = 0;
        int pointerRight = height.length - 1;
        int maxVolume = 0;

        while (pointerLeft < pointerRight) {
            int volume = Math.min(height[pointerLeft], height[pointerRight]) * (pointerRight - pointerLeft);

            if (volume > maxVolume) maxVolume = volume;

            if (height[pointerLeft] < height[pointerRight]) pointerLeft++;
            else pointerRight--;
        }

        return maxVolume;
    }
}
