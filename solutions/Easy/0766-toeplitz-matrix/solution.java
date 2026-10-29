// ──────────────────────────────────────────────────
// Problem  : 766. Toeplitz Matrix
// Difficulty: Easy
// Tags     : Array, Matrix
// Link     : https://leetcode.com/problems/toeplitz-matrix/
// Runtime  : 1 ms (beats 29%)
// Memory   : 45744000 (beats 96%)
// Language : java
// Copyright: (c) 2026 Shweta-Sripathi. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public boolean isToeplitzMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length - 1; i++) {
            for (int j = 0; j < matrix[0].length - 1; j++) {
                if (matrix[i][j] != matrix[i + 1][j + 1]) {
                    return false;
                }
            }
        }
        return true;
    }
}