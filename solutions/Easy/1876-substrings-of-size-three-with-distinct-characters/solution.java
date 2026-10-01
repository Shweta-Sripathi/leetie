// ──────────────────────────────────────────────────
// Problem  : 1876. Substrings of Size Three with Distinct Characters
// Difficulty: Easy
// Tags     : Hash Table, String, Sliding Window, Counting
// Link     : https://leetcode.com/problems/substrings-of-size-three-with-distinct-characters/
// Runtime  : 1 ms (beats 96%)
// Memory   : 42904000 (beats 50%)
// Language : java
// Copyright: (c) 2026 Shweta-Sripathi. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int countGoodSubstrings(String s) {
        int count = 0;
        
        // Loop through all possible starting indices for a substring of length 3
        for (int i = 0; i <= s.length() - 3; i++) {
            char a = s.charAt(i);
            char b = s.charAt(i + 1);
            char c = s.charAt(i + 2);
            
            // Check if all three characters are distinct
            if (a != b && b != c && a != c) {
                count++;
            }
        }
        
        return count;
    }
}