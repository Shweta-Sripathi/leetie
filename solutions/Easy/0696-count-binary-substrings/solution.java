// ──────────────────────────────────────────────────
// Problem  : 696. Count Binary Substrings
// Difficulty: Easy
// Tags     : Two Pointers, String
// Link     : https://leetcode.com/problems/count-binary-substrings/
// Runtime  : 11 ms (beats 60%)
// Memory   : 46116000 (beats 72%)
// Language : java
// Copyright: (c) 2026 Shweta-Sripathi. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int countBinarySubstrings(String s) {
        int count = 0;
        int prevGroup = 0;
        int currGroup = 1;

        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                currGroup++;
            } else {
                count += Math.min(prevGroup, currGroup);
                prevGroup = currGroup;
                currGroup = 1;
            }
        }

        // Add valid substrings formed by the last two groups
        count += Math.min(prevGroup, currGroup);

        return count;
    }
}