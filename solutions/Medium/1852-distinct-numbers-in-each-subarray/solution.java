// ──────────────────────────────────────────────────
// Problem  : 1852. Distinct Numbers in Each Subarray
// Difficulty: Medium
// Tags     : Array, Hash Table, Sliding Window
// Link     : https://leetcode.com/problems/distinct-numbers-in-each-subarray/
// Runtime  : 30 ms (beats 48%)
// Memory   : 51008000 (beats 27%)
// Language : java
// Copyright: (c) 2026 Shweta-Sripathi. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int longestBeautifulSubstring(String word) {
        int maxLen = 0;
        int currentLen = 1;
        int uniqueVowels = 1;

        for (int i = 1; i < word.length(); i++) {
            // Check if current character maintains alphabetical order
            if (word.charAt(i) >= word.charAt(i - 1)) {
                currentLen++;
                // Track distinct vowels encountered in current sequence
                if (word.charAt(i) > word.charAt(i - 1)) {
                    uniqueVowels++;
                }
            } else {
                // Alphabetical order broken, reset trackers
                currentLen = 1;
                uniqueVowels = 1;
            }

            // A substring is beautiful if all 5 vowels ('a', 'e', 'i', 'o', 'u') are present
            if (uniqueVowels == 5) {
                maxLen = Math.max(maxLen, currentLen);
            }
        }

        return maxLen;
    }
}