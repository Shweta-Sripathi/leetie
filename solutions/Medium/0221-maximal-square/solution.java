// ──────────────────────────────────────────────────
// Problem  : 221. Maximal Square
// Difficulty: Medium
// Tags     : Array, Dynamic Programming, Matrix
// Link     : https://leetcode.com/problems/maximal-square/
// Runtime  : 7 ms (beats 95%)
// Memory   : 78600000 (beats 13%)
// Language : java
// Copyright: (c) 2026 Shweta-Sripathi. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        
        int rows = matrix.length;
        int cols = matrix[0].length;
        int maxSide = 0;
        
        // dp[j] will represent the side length of the maximal square '1'-submatrix whose bottom-right corner is at current cell (i, j)
        int[] dp = new int[cols + 1];
        int prev = 0; // stores dp[i-1][j-1]
        
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= cols; j++) {
                int temp = dp[j];
                if (matrix[i - 1][j - 1] == '1') {
                    dp[j] = Math.min(Math.min(dp[j], dp[j - 1]), prev) + 1;
                    maxSide = Math.max(maxSide, dp[j]);
                } else {
                    dp[j] = 0;
                }
                prev = temp;
            }
        }
        
        return maxSide * maxSide;
    }
}