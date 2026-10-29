// ──────────────────────────────────────────────────
// Problem  : 421. Maximum XOR of Two Numbers in an Array
// Difficulty: Medium
// Tags     : Array, Hash Table, Bit Manipulation, Trie
// Link     : https://leetcode.com/problems/maximum-xor-of-two-numbers-in-an-array/
// Runtime  : 661 ms (beats 61%)
// Memory   : 241616000 (beats 24%)
// Language : java
// Copyright: (c) 2026 Shweta-Sripathi. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

import java.util.HashSet;
import java.util.Set;

class Solution {
    public int findMaximumXOR(int[] nums) {
        int maxResult = 0;
        int mask = 0;
        
        // Iterate from the most significant bit (31st bit) down to 0
        for (int i = 31; i >= 0; i--) {
            mask |= (1 << i);
            
            Set<Integer> prefixes = new HashSet<>();
            for (int num : nums) {
                prefixes.add(num & mask);
            }
            
            // Candidate for the new maximum result if the i-th bit were set to 1
            int candidate = maxResult | (1 << i);
            
            // Check if there are two prefixes that XOR to the candidate:
            // a ^ b = candidate  =>  a ^ candidate = b
            for (int prefix : prefixes) {
                if (prefixes.contains(prefix ^ candidate)) {
                    maxResult = candidate;
                    break;
                }
            }
        }
        
        return maxResult;
    }
}