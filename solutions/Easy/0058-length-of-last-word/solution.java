// ──────────────────────────────────────────────────
// Problem  : 58. Length of Last Word
// Difficulty: Easy
// Tags     : String
// Link     : https://leetcode.com/problems/length-of-last-word/
// Runtime  : 0 ms (beats 100%)
// Memory   : 42908000 (beats 69%)
// Language : java
// Copyright: (c) 2026 Shweta-Sripathi. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int lengthOfLastWord(String s) {
        int length = 0;
        int i = s.length() - 1;

        // Skip trailing spaces
        while (i >= 0 && s.charAt(i) == ' ') {
            i--;
        }

        // Count characters of the last word
        while (i >= 0 && s.charAt(i) != ' ') {
            length++;
            i--;
        }

        return length;
    }
}