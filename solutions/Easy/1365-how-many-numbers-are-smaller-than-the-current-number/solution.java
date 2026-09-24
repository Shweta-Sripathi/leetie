// ──────────────────────────────────────────────────
// Problem  : 1365. How Many Numbers Are Smaller Than the Current Number
// Difficulty: Easy
// Tags     : Array, Hash Table, Sorting, Counting Sort
// Link     : https://leetcode.com/problems/how-many-numbers-are-smaller-than-the-current-number/
// Runtime  : 0 ms (beats 0%)
// Memory   : 42764000 (beats 0%)
// Language : java
// Copyright: (c) 2026 Shweta-Sripathi. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] count = new int[102];
        
        // Count frequency of each number
        for (int num : nums) {
            count[num + 1]++;
        }
        
        // Compute prefix sums (running total of elements smaller than i)
        for (int i = 1; i < count.length; i++) {
            count[i] += count[i - 1];
        }
        
        // Build the result array using the prefix counts
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            result[i] = count[nums[i]];
        }
        
        return result;
    }
}