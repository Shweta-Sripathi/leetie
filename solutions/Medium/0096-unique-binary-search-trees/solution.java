// ──────────────────────────────────────────────────
// Problem  : 96. Unique Binary Search Trees
// Difficulty: Medium
// Tags     : Math, Dynamic Programming, Tree, Binary Search Tree, Binary Tree
// Link     : https://leetcode.com/problems/unique-binary-search-trees/
// Runtime  : 0 ms (beats 100%)
// Memory   : 41792000 (beats 79%)
// Language : java
// Copyright: (c) 2026 Shweta-Sripathi. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i] += dp[j - 1] * dp[i - j];
            }
        }

        return dp[n];
    }
}