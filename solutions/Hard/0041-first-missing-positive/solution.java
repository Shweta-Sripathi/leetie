// ──────────────────────────────────────────────────
// Problem  : 41. First Missing Positive
// Difficulty: Hard
// Tags     : Array, Hash Table
// Link     : https://leetcode.com/problems/first-missing-positive/
// Runtime  : 1 ms (beats 100%)
// Memory   : 70892000 (beats 96%)
// Language : java
// Copyright: (c) 2026 Shweta-Sripathi. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            // Place nums[i] at index nums[i] - 1 if it is in range [1, n]
            // and not already at the correct position.
            while (nums[i] > 0 && nums[i] <= n && nums[nums[i] - 1] != nums[i]) {
                int temp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = temp;
            }
        }

        // Find the first index where the number does not match index + 1
        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }

        return n + 1;
    }
}