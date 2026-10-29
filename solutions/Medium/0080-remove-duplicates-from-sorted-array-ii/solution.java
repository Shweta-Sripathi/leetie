// ──────────────────────────────────────────────────
// Problem  : 80. Remove Duplicates from Sorted Array II
// Difficulty: Medium
// Tags     : Array, Two Pointers
// Link     : https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/
// Runtime  : 0 ms (beats 100%)
// Memory   : 48308000 (beats 82%)
// Language : java
// Copyright: (c) 2026 Shweta-Sripathi. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length <= 2) {
            return nums.length;
        }

        int k = 2; // Start writing from index 2 since the first two elements are always valid

        for (int i = 2; i < nums.length; i++) {
            // If the current element is different from the element 2 positions back,
            // it means it hasn't appeared more than twice yet.
            if (nums[i] != nums[k - 2]) {
                nums[k] = nums[i];
                k++;
            }
        }

        return k;
    }
}