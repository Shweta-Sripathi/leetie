// ──────────────────────────────────────────────────
// Problem  : 828. Count Unique Characters of All Substrings of a Given String
// Difficulty: Hard
// Tags     : Hash Table, String, Dynamic Programming
// Link     : https://leetcode.com/problems/count-unique-characters-of-all-substrings-of-a-given-string/
// Runtime  : 9 ms (beats 71%)
// Memory   : 47108000 (beats 52%)
// Language : java
// Copyright: (c) 2026 Shweta-Sripathi. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public int uniqueLetterString(String s) {
        int n = s.length();
        int[] prev = new int[26];
        int[] curr = new int[26];
        
        Arrays.fill(prev, -1);
        Arrays.fill(curr, -1);
        
        long totalUniqueCount = 0;
        
        for (int i = 0; i < n; i++) {
            int c = s.charAt(i) - 'A';
            if (curr[c] != -1) {
                totalUniqueCount += (long) (curr[c] - prev[c]) * (i - curr[c]);
            }
            prev[c] = curr[c];
            curr[c] = i;
        }
        
        for (int c = 0; c < 26; c++) {
            if (curr[c] != -1) {
                totalUniqueCount += (long) (curr[c] - prev[c]) * (n - curr[c]);
            }
        }
        
        return (int) totalUniqueCount;
    }
}