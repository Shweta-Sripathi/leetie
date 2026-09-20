// ──────────────────────────────────────────────────
// Problem  : 1727. Largest Submatrix With Rearrangements
// Difficulty: Medium
// Tags     : Array, Greedy, Sorting, Matrix
// Link     : https://leetcode.com/problems/largest-submatrix-with-rearrangements/
// Runtime  : 13 ms (beats 76%)
// Memory   : 114704000 (beats 20%)
// Language : java
// Copyright: (c) 2026 Shweta-Sripathi. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

import java.util.Arrays;

class Solution {
    public int largestSubmatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        // Step 1: Compute consecutive ones height for each column
        for (int r = 1; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (matrix[r][c] == 1) {
                    matrix[r][c] += matrix[r - 1][c];
                }
            }
        }

        int maxArea = 0;

        // Step 2: For each row, sort heights and find max submatrix area
        for (int r = 0; r < m; r++) {
            int[] row = matrix[r].clone();
            Arrays.sort(row);

            // Iterate in descending order of heights
            for (int k = 0; k < n; k++) {
                int height = row[n - 1 - k];
                int width = k + 1;
                maxArea = Math.max(maxArea, height * width);
            }
        }

        return maxArea;
    }
}