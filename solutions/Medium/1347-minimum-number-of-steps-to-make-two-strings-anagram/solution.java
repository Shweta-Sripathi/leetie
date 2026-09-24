// ──────────────────────────────────────────────────
// Problem  : 1347. Minimum Number of Steps to Make Two Strings Anagram
// Difficulty: Medium
// Tags     : Hash Table, String, Counting
// Link     : https://leetcode.com/problems/minimum-number-of-steps-to-make-two-strings-anagram/
// Runtime  : 9 ms (beats 47%)
// Memory   : 47652000 (beats 46%)
// Language : java
// Copyright: (c) 2026 Shweta-Sripathi. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int minSteps(String s, String t) {
        int[] count = new int[26];

        // Count frequency of characters in s and subtract frequency of characters in t
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
            count[t.charAt(i) - 'a']--;
        }

        int steps = 0;
        // Sum all the positive differences (missing characters in t)
        for (int c : count) {
            if (c > 0) {
                steps += c;
            }
        }

        return steps;
    }
}