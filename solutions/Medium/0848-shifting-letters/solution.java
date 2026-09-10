// ──────────────────────────────────────────────────
// Problem  : 848. Shifting Letters
// Difficulty: Medium
// Tags     : Array, String, Prefix Sum
// Link     : https://leetcode.com/problems/shifting-letters/
// Runtime  : 7 ms (beats 60%)
// Memory   : 71828000 (beats 55%)
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