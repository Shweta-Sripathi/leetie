// ──────────────────────────────────────────────────
// Problem  : 523. Continuous Subarray Sum
// Difficulty: Medium
// Tags     : Array, Hash Table, Math, Prefix Sum, Pigeonhole Principle
// Link     : https://leetcode.com/problems/continuous-subarray-sum/
// Runtime  : 22 ms (beats 97%)
// Memory   : 139592000 (beats 77%)
// Language : java
// Copyright: (c) 2026 Shweta-Sripathi. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

import java.util.HashMap;
import java.util.Map;

class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        // Map stores remainder -> first occurrence index
        Map<Integer, Integer> remainderMap = new HashMap<>();
        remainderMap.put(0, -1);
        
        int runningSum = 0;
        
        for (int i = 0; i < nums.length; i++) {
            runningSum += nums[i];
            int remainder = runningSum % k;
            
            if (remainderMap.containsKey(remainder)) {
                if (i - remainderMap.get(remainder) >= 2) {
                    return true;
                }
            } else {
                remainderMap.put(remainder, i);
            }
        }
        
        return false;
    }
}