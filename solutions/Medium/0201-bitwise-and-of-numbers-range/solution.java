// ──────────────────────────────────────────────────
// Problem  : 201. Bitwise AND of Numbers Range
// Difficulty: Medium
// Tags     : Bit Manipulation
// Link     : https://leetcode.com/problems/bitwise-and-of-numbers-range/
// Runtime  : 0 ms (beats 0%)
// Memory   : 41668000 (beats 0%)
// Language : java
// Copyright: (c) 2026 Shweta-Sripathi. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int rangeBitwiseAnd(int left, int right) {
        int shift = 0;

        // Shift both numbers right until they have a common prefix
        while (left < right) {
            left >>= 1;
            right >>= 1;
            shift++;
        }

        // Shift back to restore the common prefix with trailing zeros
        return left << shift;
    }
}