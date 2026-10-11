// ──────────────────────────────────────────────────
// Problem  : 3120. Count the Number of Special Characters I
// Difficulty: Easy
// Tags     : Hash Table, String
// Link     : https://leetcode.com/problems/count-the-number-of-special-characters-i/
// Runtime  : 0 ms (beats 0%)
// Memory   : 42800000 (beats 0%)
// Language : java
// Copyright: (c) 2026 Shweta-Sripathi. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int numberOfSpecialChars(String word) {
        boolean[] lower = new boolean[26];
        boolean[] upper = new boolean[26];
        
        // Mark presence of lowercase and uppercase letters
        for (char c : word.toCharArray()) {
            if (c >= 'a' && c <= 'z') {
                lower[c - 'a'] = true;
            } else if (c >= 'A' && c <= 'Z') {
                upper[c - 'A'] = true;
            }
        }
        
        int specialCount = 0;
        
        // Count characters that appear in both forms
        for (int i = 0; i < 26; i++) {
            if (lower[i] && upper[i]) {
                specialCount++;
            }
        }
        
        return specialCount;
    }
}