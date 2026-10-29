// ──────────────────────────────────────────────────
// Problem  : 342. Power of Four
// Difficulty: Easy
// Tags     : Math, Bit Manipulation, Recursion
// Link     : https://leetcode.com/problems/power-of-four/
// Runtime  : 1 ms (beats 92%)
// Memory   : 42236000 (beats 81%)
// Language : java
// Copyright: (c) 2026 Shweta-Sripathi. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public boolean isPowerOfFour(int n) {
        return n > 0 && (n & (n - 1)) == 0 && (n & 0x55555555) != 0;
    }
}