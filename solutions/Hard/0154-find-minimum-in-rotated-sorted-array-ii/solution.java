// ──────────────────────────────────────────────────
// Problem  : 154. Find Minimum in Rotated Sorted Array II
// Difficulty: Hard
// Tags     : Array, Binary Search
// Link     : https://leetcode.com/problems/find-minimum-in-rotated-sorted-array-ii/
// Runtime  : 0 ms (beats 100%)
// Memory   : 44576000 (beats 93%)
// Language : java
// Copyright: (c) 2026 Shweta-Sripathi. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        
        while (left < right) {
            int mid = left + (right - left) / 2;
            
            if (nums[mid] > nums[right]) {
                // Minimum must be in the right half
                left = mid + 1;
            } else if (nums[mid] < nums[right]) {
                // Minimum is at mid or in the left half
                right = mid;
            } else {
                // When nums[mid] == nums[right], we can't be sure which side has the min,
                // but we can safely decrement `right` to handle the duplicate.
                right--;
            }
        }
        
        return nums[left];
    }
}