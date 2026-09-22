// ──────────────────────────────────────────────────
// Problem  : 2579. Count Total Number of Colored Cells
// Difficulty: Medium
// Tags     : Math
// Link     : https://leetcode.com/problems/count-total-number-of-colored-cells/
// Runtime  : 0 ms (beats 100%)
// Memory   : 42200000 (beats 44%)
// Language : java
// Copyright: (c) 2026 Shweta-Sripathi. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public long coloredCells(int n) {
        // Formula: 1 + 2 * n * (n - 1)
        // Using long to prevent integer overflow for n up to 10^5
        long N = n;
        return 1 + 2 * N * (N - 1);
    }
}