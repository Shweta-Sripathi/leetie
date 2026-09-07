// ──────────────────────────────────────────────────
// Problem  : 62. Unique Paths
// Difficulty: Medium
// Tags     : Math, Dynamic Programming, Combinatorics
// Link     : https://leetcode.com/problems/unique-paths/
// Runtime  : 0 ms (beats 100%)
// Memory   : 42220000 (beats 29%)
// Language : java
// Copyright: (c) 2026 Shweta-Sripathi. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

import java.util.Arrays;

class Solution {
    public int uniquePaths(int m, int n) {
        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[j] += dp[j - 1];
            }
        }

        return dp[n - 1];
    }
}