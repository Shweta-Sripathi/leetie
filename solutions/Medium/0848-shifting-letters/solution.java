// ──────────────────────────────────────────────────
// Problem  : 848. Shifting Letters
// Difficulty: Medium
// Tags     : Array, String, Prefix Sum
// Link     : https://leetcode.com/problems/shifting-letters/
// Runtime  : 0 ms (beats 0%)
// Memory   : 42768000 (beats 0%)
// Language : java
// Copyright: (c) 2026 Shweta-Sripathi. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public String shiftingLetters(String s, int[] shifts) {
        char[] chars = s.toCharArray();
        long totalShift = 0;

        for (int i = shifts.length - 1; i >= 0; i--) {
            totalShift = (totalShift + shifts[i]) % 26;
            chars[i] = (char) ((chars[i] - 'a' + totalShift) % 26 + 'a');
        }

        return new String(chars);
    }
}