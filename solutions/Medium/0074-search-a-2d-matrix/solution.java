// ──────────────────────────────────────────────────
// Problem  : 74. Search a 2D Matrix
// Difficulty: Medium
// Tags     : Array, Binary Search, Matrix
// Link     : https://leetcode.com/problems/search-a-2d-matrix/
// Runtime  : 0 ms (beats 100%)
// Memory   : 43304000 (beats 92%)
// Language : java
// Copyright: (c) 2026 Shweta-Sripathi. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        
        int m = matrix.length;
        int n = matrix[0].length;
        int left = 0;
        int right = m * n - 1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int midVal = matrix[mid / n][mid % n];
            
            if (midVal == target) {
                return true;
            } else if (midVal < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return false;
    }
}