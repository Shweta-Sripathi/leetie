// ──────────────────────────────────────────────────
// Problem  : 198. House Robber
// Difficulty: Medium
// Tags     : Array, Dynamic Programming
// Link     : https://leetcode.com/problems/house-robber/
// Runtime  : 0 ms (beats 100%)
// Memory   : 42912000 (beats 20%)
// Language : java
// Copyright: (c) 2026 Shweta-Sripathi. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        
        int prev2 = 0; // Maximum money robbed up to 2 houses back
        int prev1 = 0; // Maximum money robbed up to 1 house back

        for (int num : nums) {
            // At the current house, choose the maximum of:
            // 1. Robbing current house + max money from 2 houses back (prev2)
            // 2. Skipping current house and keeping max money from 1 house back (prev1)
            int temp = Math.max(prev1, prev2 + num);
            prev2 = prev1;
            prev1 = temp;
        }

        return prev1;
    }
}