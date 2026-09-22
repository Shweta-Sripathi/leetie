// ──────────────────────────────────────────────────
// Problem  : 2549. Count Distinct Numbers on Board
// Difficulty: Easy
// Tags     : Array, Hash Table, Math, Simulation
// Link     : https://leetcode.com/problems/count-distinct-numbers-on-board/
// Runtime  : 0 ms (beats 0%)
// Memory   : 42244000 (beats 0%)
// Language : java
// Copyright: (c) 2026 Shweta-Sripathi. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int distinctIntegers(int n) {
        return n == 1 ? 1 : n - 1;
    }
}