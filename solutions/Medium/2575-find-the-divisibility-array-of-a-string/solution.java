// ──────────────────────────────────────────────────
// Problem  : 2575. Find the Divisibility Array of a String
// Difficulty: Medium
// Tags     : Array, Math, String
// Link     : https://leetcode.com/problems/find-the-divisibility-array-of-a-string/
// Runtime  : 6 ms (beats 100%)
// Memory   : 81384000 (beats 69%)
// Language : java
// Copyright: (c) 2026 Shweta-Sripathi. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int[] divisibilityArray(String word, int m) {
        int n = word.length();
        int[] div = new int[n];
        long remainder = 0;

        for (int i = 0; i < n; i++) {
            // Append current digit and take modulo m to prevent overflow
            remainder = (remainder * 10 + (word.charAt(i) - '0')) % m;
            
            if (remainder == 0) {
                div[i] = 1;
            }
        }

        return div;
    }
}