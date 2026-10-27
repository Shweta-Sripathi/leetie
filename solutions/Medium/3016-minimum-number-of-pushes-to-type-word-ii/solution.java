// ──────────────────────────────────────────────────
// Problem  : 3016. Minimum Number of Pushes to Type Word II
// Difficulty: Medium
// Tags     : Hash Table, String, Greedy, Sorting, Counting
// Link     : https://leetcode.com/problems/minimum-number-of-pushes-to-type-word-ii/
// Runtime  : 1 ms (beats 0%)
// Memory   : 41988000 (beats 0%)
// Language : java
// Copyright: (c) 2026 Shweta-Sripathi. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

import java.util.Arrays;

class Solution {
    public int minimumPushes(String word) {
        // Count the frequency of each letter
        int[] freq = new int[26];
        for (char c : word.toCharArray()) {
            freq[c - 'a']++;
        }
        
        // Sort frequencies in ascending order
        Arrays.sort(freq);
        
        int totalPushes = 0;
        int count = 0;
        
        // Iterate from the highest frequency to lowest
        for (int i = 25; i >= 0; i--) {
            if (freq[i] == 0) {
                break;
            }
            // Every 8 characters, the cost per character increases by 1 push
            int multiplier = (count / 8) + 1;
            totalPushes += freq[i] * multiplier;
            count++;
        }
        
        return totalPushes;
    }
}