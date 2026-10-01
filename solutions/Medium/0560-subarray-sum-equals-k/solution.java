// ──────────────────────────────────────────────────
// Problem  : 560. Subarray Sum Equals K
// Difficulty: Medium
// Tags     : Array, Hash Table, Prefix Sum
// Link     : https://leetcode.com/problems/subarray-sum-equals-k/
// Runtime  : 27 ms (beats 29%)
// Memory   : 48928000 (beats 34%)
// Language : java
// Copyright: (c) 2026 Shweta-Sripathi. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int subarraySum(int[] nums, int k) {
        int count = 0;
        int currentPrefixSum = 0;
        
        // Map stores (prefixSum -> frequency)
        Map<Integer, Integer> prefixSumMap = new HashMap<>();
        
        // Base case: prefix sum of 0 occurs once (for subarrays starting at index 0)
        prefixSumMap.put(0, 1);
        
        for (int num : nums) {
            currentPrefixSum += num;
            
            // If (currentPrefixSum - k) exists, it means we found a subarray sum equal to k
            if (prefixSumMap.containsKey(currentPrefixSum - k)) {
                count += prefixSumMap.get(currentPrefixSum - k);
            }
            
            // Record the current prefix sum in the hash map
            prefixSumMap.put(currentPrefixSum, prefixSumMap.getOrDefault(currentPrefixSum, 0) + 1);
        }
        
        return count;
    }
}