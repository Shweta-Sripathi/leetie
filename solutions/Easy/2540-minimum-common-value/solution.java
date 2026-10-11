// ──────────────────────────────────────────────────
// Problem  : 2540. Minimum Common Value
// Difficulty: Easy
// Tags     : Array, Hash Table, Two Pointers, Binary Search
// Link     : https://leetcode.com/problems/minimum-common-value/
// Runtime  : 2 ms (beats 93%)
// Memory   : 80372000 (beats 65%)
// Language : java
// Copyright: (c) 2026 Shweta-Sripathi. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int getCommon(int[] nums1, int[] nums2) {
        int i = 0, j = 0;
        
        // Use two pointers since both arrays are sorted in non-decreasing order
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] == nums2[j]) {
                return nums1[i]; // Found the minimum common value
            } else if (nums1[i] < nums2[j]) {
                i++;
            } else {
                j++;
            }
        }
        
        return -1; // Return -1 if no common integer exists
    }
}