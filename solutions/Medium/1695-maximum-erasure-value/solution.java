// ──────────────────────────────────────────────────
// Problem  : 1695. Maximum Erasure Value
// Difficulty: Medium
// Tags     : Array, Hash Table, Sliding Window
// Link     : https://leetcode.com/problems/maximum-erasure-value/
// Runtime  : 0 ms (beats 0%)
// Memory   : 41872000 (beats 0%)
// Language : java
// Copyright: (c) 2026 Shweta-Sripathi. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

import java.util.HashSet;
import java.util.Set;

class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        Set<Integer> seen = new HashSet<>();
        int maxScore = 0;
        int currentSum = 0;
        int left = 0;

        for (int right = 0; right < nums.length; right++) {
            // Shrink window from the left until the duplicate element is removed
            while (seen.contains(nums[right])) {
                seen.remove(nums[left]);
                currentSum -= nums[left];
                left++;
            }

            // Expand window to the right
            seen.add(nums[right]);
            currentSum += nums[right];

            // Update maximum sum found so far
            maxScore = Math.max(maxScore, currentSum);
        }

        return maxScore;
    }
}