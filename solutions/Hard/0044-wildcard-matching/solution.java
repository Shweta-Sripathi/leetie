// ──────────────────────────────────────────────────
// Problem  : 44. Wildcard Matching
// Difficulty: Hard
// Tags     : String, Dynamic Programming, Greedy, Recursion
// Link     : https://leetcode.com/problems/wildcard-matching/
// Runtime  : 0 ms (beats 0%)
// Memory   : 42560000 (beats 0%)
// Language : java
// Copyright: (c) 2026 Shweta-Sripathi. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public boolean isMatch(String s, String p) {
        int sIndex = 0, pIndex = 0;
        int starIndex = -1, sMatch = 0;

        while (sIndex < s.length()) {
            // Case 1: Exact match or '?' wild card
            if (pIndex < p.length() && (p.charAt(pIndex) == '?' || s.charAt(sIndex) == p.charAt(pIndex))) {
                sIndex++;
                pIndex++;
            }
            // Case 2: '*' found, record position and try matching 0 characters first
            else if (pIndex < p.length() && p.charAt(pIndex) == '*') {
                starIndex = pIndex;
                sMatch = sIndex;
                pIndex++;
            }
            // Case 3: Last character didn't match, backtrack to the last '*'
            else if (starIndex != -1) {
                pIndex = starIndex + 1;
                sMatch++;
                sIndex = sMatch;
            }
            // Case 4: Mismatch with no previous '*'
            else {
                return false;
            }
        }

        // Check if remaining pattern characters are all '*'
        while (pIndex < p.length() && p.charAt(pIndex) == '*') {
            pIndex++;
        }

        return pIndex == p.length();
    }
}