// ──────────────────────────────────────────────────
// Problem  : 1679. Max Number of K-Sum Pairs
// Difficulty: Medium
// Tags     : Array, Hash Table, Two Pointers, Sorting
// Link     : https://leetcode.com/problems/max-number-of-k-sum-pairs/
// Runtime  : 1 ms (beats 0%)
// Memory   : 42628000 (beats 0%)
// Language : java
// Copyright: (c) 2026 Shweta-Sripathi. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

import java.util.Arrays;

class Solution {
    public int maxOperations(int[] nums, int k) {
        Arrays.sort(nums);
        
        int left = 0;
        int right = nums.length - 1;
        int count = 0;
        
        while (left < right) {
            int sum = nums[left] + nums[right];
            
            if (sum == k) {
                count++;
                left++;
                right--;
            } else if (sum < k) {
                left++;
            } else {
                right--;
            }
        }
        
        return count;
    }
}