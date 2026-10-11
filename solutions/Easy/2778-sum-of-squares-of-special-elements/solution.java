// ──────────────────────────────────────────────────
// Problem  : 2778. Sum of Squares of Special Elements 
// Difficulty: Easy
// Tags     : Array, Enumeration
// Link     : https://leetcode.com/problems/sum-of-squares-of-special-elements/
// Runtime  : 1 ms (beats 100%)
// Memory   : 46152000 (beats 86%)
// Language : java
// Copyright: (c) 2026 Shweta-Sripathi. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int sumOfSquares(int[] nums) {
        int n = nums.length;
        int sum = 0;
        
        // Iterate through 1-indexed positions
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                // In 0-indexed Java arrays, the 1-indexed element at position `i` corresponds to index `i - 1`
                sum += nums[i - 1] * nums[i - 1];
            }
        }
        
        return sum;
    }
}