// ──────────────────────────────────────────────────
// Problem  : 1608. Special Array With X Elements Greater Than or Equal X
// Difficulty: Easy
// Tags     : Array, Binary Search, Sorting
// Link     : https://leetcode.com/problems/special-array-with-x-elements-greater-than-or-equal-x/
// Runtime  : 1 ms (beats 0%)
// Memory   : 42532000 (beats 0%)
// Language : java
// Copyright: (c) 2026 Shweta-Sripathi. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

import java.util.Arrays;

class Solution {
    public int specialArray(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            int x = n - i; // Number of elements from index i to n - 1

            boolean validCurrent = nums[i] >= x;
            boolean validPrevious = (i == 0) || (nums[i - 1] < x);

            if (validCurrent && validPrevious) {
                return x;
            }
        }

        return -1;
    }
}