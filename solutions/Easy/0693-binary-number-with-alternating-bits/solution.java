// ──────────────────────────────────────────────────
// Problem  : 693. Binary Number with Alternating Bits
// Difficulty: Easy
// Tags     : Bit Manipulation
// Link     : https://leetcode.com/problems/binary-number-with-alternating-bits/
// Runtime  : 0 ms (beats 100%)
// Memory   : 41672000 (beats 91%)
// Language : java
// Copyright: (c) 2026 Shweta-Sripathi. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public boolean hasAlternatingBits(int n) {
        int x = n ^ (n >> 1);
        return (x & (x + 1)) == 0;
    }
}