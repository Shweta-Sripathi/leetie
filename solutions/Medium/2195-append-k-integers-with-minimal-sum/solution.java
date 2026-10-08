// ──────────────────────────────────────────────────
// Problem  : 2195. Append K Integers With Minimal Sum
// Difficulty: Medium
// Tags     : Array, Math, Greedy, Sorting
// Link     : https://leetcode.com/problems/append-k-integers-with-minimal-sum/
// Runtime  : 23 ms (beats 96%)
// Memory   : 73196000 (beats 60%)
// Language : java
// Copyright: (c) 2026 Shweta-Sripathi. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

import java.util.Arrays;

class Solution {
    public long minimalKSum(int[] nums, int k) {
        Arrays.sort(nums);
        
        long sum = (long) k * (k + 1) / 2;
        int prev = -1;
        
        for (int num : nums) {
            // Skip duplicates
            if (num == prev) {
                continue;
            }
            prev = num;
            
            // If num was included in the initial range [1, k], replace it with (k + 1)
            if (num <= k) {
                sum -= num;
                sum += (k + 1);
                k++;
            } else {
                // Since nums is sorted, no subsequent elements will be <= k
                break;
            }
        }
        
        return sum;
    }
}