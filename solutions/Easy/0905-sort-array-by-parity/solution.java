// ──────────────────────────────────────────────────
// Problem  : 905. Sort Array By Parity
// Difficulty: Easy
// Tags     : Array, Two Pointers, Sorting
// Link     : https://leetcode.com/problems/sort-array-by-parity/
// Runtime  : 1 ms (beats 42%)
// Memory   : 46832000 (beats 49%)
// Language : java
// Copyright: (c) 2026 Shweta-Sripathi. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int[] sortArrayByParity(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        
        while (left < right) {
            // If left is odd and right is even, swap them
            if (nums[left] % 2 > nums[right] % 2) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
            }
            
            // Advance left pointer if it already points to an even number
            if (nums[left] % 2 == 0) {
                left++;
            }
            // Decrement right pointer if it already points to an odd number
            if (nums[right] % 2 != 0) {
                right--;
            }
        }
        
        return nums;
    }
}