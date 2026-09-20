// ──────────────────────────────────────────────────
// Problem  : 1657. Determine if Two Strings Are Close
// Difficulty: Medium
// Tags     : Hash Table, String, Sorting, Counting
// Link     : https://leetcode.com/problems/determine-if-two-strings-are-close/
// Runtime  : 1 ms (beats 0%)
// Memory   : 42176000 (beats 0%)
// Language : java
// Copyright: (c) 2026 Shweta-Sripathi. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

import java.util.Arrays;

class Solution {
    public boolean closeStrings(String word1, String word2) {
        if (word1.length() != word2.length()) {
            return false;
        }

        int[] freq1 = new int[26];
        int[] freq2 = new int[26];

        for (int i = 0; i < word1.length(); i++) {
            freq1[word1.charAt(i) - 'a']++;
            freq2[word2.charAt(i) - 'a']++;
        }

        // Condition 1: Both strings must contain the exact same set of unique characters
        for (int i = 0; i < 26; i++) {
            if ((freq1[i] == 0 && freq2[i] > 0) || (freq1[i] > 0 && freq2[i] == 0)) {
                return false;
            }
        }

        // Condition 2: Both strings must have the exact same character frequency counts
        Arrays.sort(freq1);
        Arrays.sort(freq2);

        return Arrays.equals(freq1, freq2);
    }
}