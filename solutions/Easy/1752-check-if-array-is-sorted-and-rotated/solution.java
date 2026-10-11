// ──────────────────────────────────────────────────
// Problem  : 1752. Check if Array Is Sorted and Rotated
// Difficulty: Easy
// Tags     : Array
// Link     : https://leetcode.com/problems/check-if-array-is-sorted-and-rotated/
// Runtime  : 0 ms (beats 0%)
// Memory   : 42456000 (beats 0%)
// Language : java
// Copyright: (c) 2026 Shweta-Sripathi. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public boolean check(int[] nums) {
        int count = 0;
        int n = nums.length;
        
        // Count how many times the array decreases as we go from left to right
        for (int i = 0; i < n; i++) {
            if (nums[i] > nums[(i + 1) % n]) {
                count++;
            }
        }
        
        // A valid sorted and rotated array can have at most one drop/break point
        return count <= 1;
    }
}