// ──────────────────────────────────────────────────
// Problem  : 240. Search a 2D Matrix II
// Difficulty: Medium
// Tags     : Array, Binary Search, Divide and Conquer, Matrix
// Link     : https://leetcode.com/problems/search-a-2d-matrix-ii/
// Runtime  : 3 ms (beats 87%)
// Memory   : 47772000 (beats 90%)
// Language : java
// Copyright: (c) 2026 Shweta-Sripathi. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        
        int rows = matrix.length;
        int cols = matrix[0].length;
        
        // Start from the top-right corner
        int row = 0;
        int col = cols - 1;
        
        while (row < rows && col >= 0) {
            int current = matrix[row][col];
            
            if (current == target) {
                return true;
            } else if (current > target) {
                col--; // Move left
            } else {
                row++; // Move down
            }
        }
        
        return false;
    }
}