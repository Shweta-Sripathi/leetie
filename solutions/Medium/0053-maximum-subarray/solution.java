// ──────────────────────────────────────────────────
// Problem  : 53. Maximum Subarray
// Difficulty: Medium
// Tags     : Array, Divide and Conquer, Dynamic Programming
// Link     : https://leetcode.com/problems/maximum-subarray/
// Runtime  : 1 ms (beats 100%)
// Memory   : 77136000 (beats 66%)
// Language : java
// Copyright: (c) 2026 Shweta-Sripathi. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int maxSubArray(int[] nums) {
        int maxSum = nums[0];
        int currentSum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            currentSum = Math.max(nums[i], currentSum + nums[i]);
            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum;
    }
}