package com.codingchallenges.leetcode;

// https://leetcode.com/problems/jump-game-ii/
public class JumpGameII {
    public int jump(int[] nums) {
        if (nums.length <= 1) return 0;
        if (nums[0] >= nums.length - 1) return 1;

        int currentPosition = 0;
        int jumpsMade = 0;

        while (currentPosition < nums.length - 1) {
            if (currentPosition + nums[currentPosition] >= nums.length - 1) {
                jumpsMade++;
                break;
            }

            int maximumReachableIndexWithNextMove = 0;
            int nextIndex = 0;

            for (int i = 1; i <= nums[currentPosition]; i++) {
                if (currentPosition + i < nums.length && nums[currentPosition + i] + i > maximumReachableIndexWithNextMove) {
                    nextIndex = currentPosition + i;
                    maximumReachableIndexWithNextMove = nums[currentPosition + i] + i;
                }
            }

            System.out.println(nextIndex);
            currentPosition = nextIndex;
            jumpsMade++;
        }

        return jumpsMade;

    }
}
