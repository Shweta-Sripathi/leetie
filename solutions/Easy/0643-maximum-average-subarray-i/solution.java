// ──────────────────────────────────────────────────
// Problem  : 643. Maximum Average Subarray I
// Difficulty: Easy
// Tags     : Array, Sliding Window
// Link     : https://leetcode.com/problems/maximum-average-subarray-i/
// Runtime  : 5 ms (beats 34%)
// Memory   : 69212000 (beats 82%)
// Language : java
// Copyright: (c) 2026 Shweta-Sripathi. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double currentSum = 0;
        
        // 1. Calculate sum of the first window of size k
        for (int i = 0; i < k; i++) {
            currentSum += nums[i];
        }
        
        double maxSum = currentSum;
        
        // 2. Slide the window across the rest of the array
        for (int i = k; i < nums.length; i++) {
            currentSum = currentSum + nums[i] - nums[i - k];
            maxSum = Math.max(maxSum, currentSum);
        }
        
        // 3. Return the maximum average
        return maxSum / k;
    }
}