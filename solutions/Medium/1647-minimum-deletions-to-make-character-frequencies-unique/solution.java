// ──────────────────────────────────────────────────
// Problem  : 1647. Minimum Deletions to Make Character Frequencies Unique
// Difficulty: Medium
// Tags     : Hash Table, String, Greedy, Sorting
// Link     : https://leetcode.com/problems/minimum-deletions-to-make-character-frequencies-unique/
// Runtime  : 0 ms (beats 0%)
// Memory   : 42348000 (beats 0%)
// Language : java
// Copyright: (c) 2026 Shweta-Sripathi. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

import java.util.HashSet;
import java.util.Set;

class Solution {
    public int minDeletions(String s) {
        // Step 1: Count frequency of each character
        int[] freq = new int[26];
        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 'a']++;
        }

        Set<Integer> seenFrequencies = new HashSet<>();
        int deletions = 0;

        // Step 2: Ensure all non-zero frequencies are unique
        for (int count : freq) {
            while (count > 0 && seenFrequencies.contains(count)) {
                count--;
                deletions++;
            }
            if (count > 0) {
                seenFrequencies.add(count);
            }
        }

        return deletions;
    }
}