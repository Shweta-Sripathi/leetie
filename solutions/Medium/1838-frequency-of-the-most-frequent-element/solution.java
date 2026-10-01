// ──────────────────────────────────────────────────
// Problem  : 1838. Frequency of the Most Frequent Element
// Difficulty: Medium
// Tags     : Array, Binary Search, Greedy, Sliding Window, Sorting, Prefix Sum
// Link     : https://leetcode.com/problems/frequency-of-the-most-frequent-element/
// Runtime  : 33 ms (beats 91%)
// Memory   : 94748000 (beats 64%)
// Language : java
// Copyright: (c) 2026 Shweta-Sripathi. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

import java.util.Arrays;

class Solution {
    public int maxFrequency(int[] nums, int k) {
        // Step 1: Sort the array so that we can greedily make smaller numbers equal to larger ones
        Arrays.sort(nums);

        int left = 0;
        int maxFreq = 0;
        long totalSum = 0; // Use long to prevent integer overflow

        // Step 2: Expand the right side of the sliding window
        for (int right = 0; right < nums.length; right++) {
            totalSum += nums[right];

            // Condition check:
            // Target sum to make all elements in current window equal to nums[right] is:
            // (nums[right] * windowSize)
            // Operations required = (nums[right] * windowSize) - totalSum
            // If operations required exceed k, shrink the window from the left
            while ((long) nums[right] * (right - left + 1) - totalSum > k) {
                totalSum -= nums[left];
                left++;
            }

            // Update maximum valid frequency (window length)
            maxFreq = Math.max(maxFreq, right - left + 1);
        }

        return maxFreq;
    }
}