// ──────────────────────────────────────────────────
// Problem  : 417. Pacific Atlantic Water Flow
// Difficulty: Medium
// Tags     : Array, Depth-First Search, Breadth-First Search, Matrix
// Link     : https://leetcode.com/problems/pacific-atlantic-water-flow/
// Runtime  : 4 ms (beats 98%)
// Memory   : 46736000 (beats 96%)
// Language : java
// Copyright: (c) 2026 Shweta-Sripathi. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> result = new ArrayList<>();
        if (heights == null || heights.length == 0 || heights[0].length == 0) {
            return result;
        }
        
        int rows = heights.length;
        int cols = heights[0].length;
        
        boolean[][] pacific = new boolean[rows][cols];
        boolean[][] atlantic = new boolean[rows][cols];
        
        // Traverse from the ocean borders inward
        for (int i = 0; i < rows; i++) {
            dfs(heights, i, 0, pacific, Integer.MIN_VALUE);
            dfs(heights, i, cols - 1, atlantic, Integer.MIN_VALUE);
        }
        
        for (int j = 0; j < cols; j++) {
            dfs(heights, 0, j, pacific, Integer.MIN_VALUE);
            dfs(heights, rows - 1, j, atlantic, Integer.MIN_VALUE);
        }
        
        // Find cells that can reach both oceans
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    List<Integer> cell = new ArrayList<>();
                    cell.add(i);
                    cell.add(j);
                    result.add(cell);
                }
            }
        }
        
        return result;
    }
    
    private void dfs(int[][] heights, int r, int c, boolean[][] ocean, int prevHeight) {
        int rows = heights.length;
        int cols = heights[0].length;
        
        if (r < 0 || r >= rows || c < 0 || c >= cols || ocean[r][c] || heights[r][c] < prevHeight) {
            return;
        }
        
        ocean[r][c] = true;
        
        dfs(heights, r + 1, c, ocean, heights[r][c]);
        dfs(heights, r - 1, c, ocean, heights[r][c]);
        dfs(heights, r, c + 1, ocean, heights[r][c]);
        dfs(heights, r, c - 1, ocean, heights[r][c]);
    }
}