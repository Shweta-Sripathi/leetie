// ──────────────────────────────────────────────────
// Problem  : 598. Range Addition II
// Difficulty: Easy
// Tags     : Array, Math
// Link     : https://leetcode.com/problems/range-addition-ii/
// Runtime  : 1 ms (beats 31%)
// Memory   : 48452000 (beats 78%)
// Language : java
// Copyright: (c) 2026 Shweta-Sripathi. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int maxCount(int m, int n, int[][] ops) {
        int minRow = m;
        int minCol = n;

        for (int[] op : ops) {
            minRow = Math.min(minRow, op[0]);
            minCol = Math.min(minCol, op[1]);
        }

        return minRow * minCol;
    }
}