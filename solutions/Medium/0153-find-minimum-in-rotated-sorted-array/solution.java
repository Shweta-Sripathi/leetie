// ──────────────────────────────────────────────────
// Problem  : 153. Find Minimum in Rotated Sorted Array
// Difficulty: Medium
// Tags     : Array, Binary Search
// Link     : https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
// Runtime  : 0 ms (beats 100%)
// Memory   : 43672000 (beats 73%)
// Language : java
// Copyright: (c) 2026 Shweta-Sripathi. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        
        // If the array is already sorted (not rotated or rotated n times)
        if (nums[left] <= nums[right]) {
            return nums[left];
        }
        
        while (left < right) {
            int mid = left + (right - left) / 2;
            
            // If the mid element is greater than the rightmost element, 
            // the minimum element must be in the right half.
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                // Otherwise, the minimum element is at mid or in the left half.
                right = mid;
            }
        }
        
        return nums[left];
    }
}