// ──────────────────────────────────────────────────
// Problem  : 661. Image Smoother
// Difficulty: Easy
// Tags     : Array, Matrix
// Link     : https://leetcode.com/problems/image-smoother/
// Runtime  : 6 ms (beats 71%)
// Memory   : 47436000 (beats 81%)
// Language : java
// Copyright: (c) 2026 Shweta-Sripathi. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int[][] imageSmoother(int[][] img) {
        int m = img.length;
        int n = img[0].length;
        int[][] res = new int[m][n];

        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                int sum = 0;
                int count = 0;

                // Iterate through the 3x3 surrounding window
                for (int nr = r - 1; nr <= r + 1; nr++) {
                    for (int nc = c - 1; nc <= c + 1; nc++) {
                        // Check if neighbor cell is within bounds
                        if (nr >= 0 && nr < m && nc >= 0 && nc < n) {
                            sum += img[nr][nc];
                            count++;
                        }
                    }
                }

                res[r][c] = sum / count;
            }
        }

        return res;
    }
}