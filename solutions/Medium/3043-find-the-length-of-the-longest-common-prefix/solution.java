// ──────────────────────────────────────────────────
// Problem  : 3043. Find the Length of the Longest Common Prefix
// Difficulty: Medium
// Tags     : Array, Hash Table, String, Trie
// Link     : https://leetcode.com/problems/find-the-length-of-the-longest-common-prefix/
// Runtime  : 93 ms (beats 28%)
// Memory   : 90512000 (beats 38%)
// Language : java
// Copyright: (c) 2026 Shweta-Sripathi. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

import java.util.HashSet;

class Solution {
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        HashSet<Integer> prefixSet = new HashSet<>();
        
        // Store all possible prefixes of numbers in arr1
        for (int num : arr1) {
            while (num > 0) {
                prefixSet.add(num);
                num /= 10;
            }
        }
        
        int maxLength = 0;
        
        // Check all possible prefixes of numbers in arr2 against the set
        for (int num : arr2) {
            while (num > 0) {
                if (prefixSet.contains(num)) {
                    maxLength = Math.max(maxLength, stringLength(num));
                    break; // Since we check from longest to shortest prefix for each number, we can break early
                }
                num /= 10;
            }
        }
        
        return maxLength;
    }
    
    // Helper method to get the length of an integer
    private int stringLength(int num) {
        return String.valueOf(num).length();
    }
}