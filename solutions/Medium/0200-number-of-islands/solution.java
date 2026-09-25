// ──────────────────────────────────────────────────
// Problem  : 200. Number of Islands
// Difficulty: Medium
// Tags     : Array, Depth-First Search, Breadth-First Search, Union-Find, Matrix
// Link     : https://leetcode.com/problems/number-of-islands/
// Runtime  : 0 ms (beats 0%)
// Memory   : 42820000 (beats 0%)
// Language : java
// Copyright: (c) 2026 Shweta-Sripathi. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int m = grid.length;
        int n = grid[0].length;
        int numIslands = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // When land ('1') is encountered, it indicates a new island
                if (grid[i][j] == '1') {
                    numIslands++;
                    // Sink the entire island using DFS
                    dfs(grid, i, j, m, n);
                }
            }
        }

        return numIslands;
    }

    private void dfs(char[][] grid, int r, int c, int m, int n) {
        // Boundary checks and water check
        if (r < 0 || c < 0 || r >= m || c >= n || grid[r][c] == '0') {
            return;
        }

        // Mark the current land cell as visited by turning it into '0'
        grid[r][c] = '0';

        // Traverse all 4 adjacent directions (up, down, left, right)
        dfs(grid, r - 1, c, m, n);
        dfs(grid, r + 1, c, m, n);
        dfs(grid, r, c - 1, m, n);
        dfs(grid, r, c + 1, m, n);
    }
}