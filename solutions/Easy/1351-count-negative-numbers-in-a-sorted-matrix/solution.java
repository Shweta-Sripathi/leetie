// ──────────────────────────────────────────────────
// Problem  : 1351. Count Negative Numbers in a Sorted Matrix
// Difficulty: Easy
// Tags     : Array, Binary Search, Matrix
// Link     : https://leetcode.com/problems/count-negative-numbers-in-a-sorted-matrix/
// Runtime  : 0 ms (beats 100%)
// Memory   : 46776000 (beats 82%)
// Language : java
// Copyright: (c) 2026 Shweta-Sripathi. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int countNegatives(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        
        int row = m - 1;
        int col = 0;
        int count = 0;

        while (row >= 0 && col < n) {
            if (grid[row][col] < 0) {
                // All elements from col to n - 1 in this row are negative
                count += (n - col);
                row--; // Move up to check the previous row
            } else {
                col++; // Move right to find a negative number
            }
        }

        return count;
    }
}