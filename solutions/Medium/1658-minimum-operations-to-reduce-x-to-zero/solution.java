// ──────────────────────────────────────────────────
// Problem  : 1658. Minimum Operations to Reduce X to Zero
// Difficulty: Medium
// Tags     : Array, Hash Table, Binary Search, Sliding Window, Prefix Sum
// Link     : https://leetcode.com/problems/minimum-operations-to-reduce-x-to-zero/
// Runtime  : 0 ms (beats 0%)
// Memory   : 42328000 (beats 0%)
// Language : java
// Copyright: (c) 2026 Shweta-Sripathi. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int minOperations(int[] nums, int x) {
        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }

        // Target sum for the remaining subarray in the middle
        int target = totalSum - x;

        // If target < 0, it's impossible because all elements are positive
        if (target < 0) {
            return -1;
        }

        // If target == 0, we must remove all elements
        if (target == 0) {
            return nums.length;
        }

        int maxLen = -1;
        int currentSum = 0;
        int left = 0;

        // Sliding window to find the longest subarray with sum equal to target
        for (int right = 0; right < nums.length; right++) {
            currentSum += nums[right];

            // Shrink window if current sum exceeds target
            while (currentSum > target && left <= right) {
                currentSum -= nums[left];
                left++;
            }

            // Check if we found a subarray with sum equal to target
            if (currentSum == target) {
                maxLen = Math.max(maxLen, right - left + 1);
            }
        }

        // Return total size minus max subarray length, or -1 if no valid subarray was found
        return maxLen == -1 ? -1 : nums.length - maxLen;
    }
}