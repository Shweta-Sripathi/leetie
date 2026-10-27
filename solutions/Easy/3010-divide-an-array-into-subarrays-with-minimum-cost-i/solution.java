// ──────────────────────────────────────────────────
// Problem  : 3010. Divide an Array Into Subarrays With Minimum Cost I
// Difficulty: Easy
// Tags     : Array, Sorting, Enumeration
// Link     : https://leetcode.com/problems/divide-an-array-into-subarrays-with-minimum-cost-i/
// Runtime  : 1 ms (beats 98%)
// Memory   : 44800000 (beats 94%)
// Language : java
// Copyright: (c) 2026 Shweta-Sripathi. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

import java.util.Arrays;

class Solution {
    public int minimumCost(int[] nums) {
        // The first element is always the cost of the first subarray
        int ans = nums[0];
        
        // Find the two smallest elements in the remaining part of the array
        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;
        
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < min1) {
                min2 = min1;
                min1 = nums[i];
            } else if (nums[i] < min2) {
                min2 = nums[i];
            }
        }
        
        return ans + min1 + min2;
    }
}