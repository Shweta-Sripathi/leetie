// ──────────────────────────────────────────────────
// Problem  : 53. Maximum Subarray
// Difficulty: Medium
// Tags     : Array, Divide and Conquer, Dynamic Programming
// Link     : https://leetcode.com/problems/maximum-subarray/
// Runtime  : 0 ms (beats 0%)
// Memory   : 42168000 (beats 0%)
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