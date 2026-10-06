// ──────────────────────────────────────────────────
// Problem  : 922. Sort Array By Parity II
// Difficulty: Easy
// Tags     : Array, Two Pointers, Sorting
// Link     : https://leetcode.com/problems/sort-array-by-parity-ii/
// Runtime  : 0 ms (beats 0%)
// Memory   : 42756000 (beats 0%)
// Language : java
// Copyright: (c) 2026 Shweta-Sripathi. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int[] sortArrayByParityII(int[] nums) {
        int i = 0; // Pointer for even indices (0, 2, 4, ...)
        int j = 1; // Pointer for odd indices (1, 3, 5, ...)
        int n = nums.length;
        
        while (i < n && j < n) {
            // Find the first even index containing an odd number
            while (i < n && nums[i] % 2 == 0) {
                i += 2;
            }
            // Find the first odd index containing an even number
            while (j < n && nums[j] % 2 != 0) {
                j += 2;
            }
            
            // Swap the misplaced elements
            if (i < n && j < n) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
        }
        
        return nums;
    }
}