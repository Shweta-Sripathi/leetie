// ──────────────────────────────────────────────────
// Problem  : 37. Sudoku Solver
// Difficulty: Hard
// Tags     : Array, Hash Table, Backtracking, Matrix, Algorithm X, Dancing Links
// Link     : https://leetcode.com/problems/sudoku-solver/
// Runtime  : 391 ms (beats 27%)
// Memory   : 42224000 (beats 95%)
// Language : java
// Copyright: (c) 2026 Shweta-Sripathi. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public void solveSudoku(char[][] board) {
        solve(board);
    }
    
    private boolean solve(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    for (char c = '1'; c <= '9'; c++) {
                        if (isValid(board, i, j, c)) {
                            board[i][j] = c;
                            
                            if (solve(board)) {
                                return true;
                            }
                            
                            board[i][j] = '.'; // Backtrack
                        }
                    }
                    return false; // Trigger backtracking if no valid number works
                }
            }
        }
        return true; // Board is fully solved
    }
    
    private boolean isValid(char[][] board, int row, int col, char c) {
        for (int i = 0; i < 9; i++) {
            // Check row
            if (board[row][i] == c) return false;
            // Check column
            if (board[i][col] == c) return false;
            // Check 3x3 sub-box
            if (board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] == c) return false;
        }
        return true;
    }
}