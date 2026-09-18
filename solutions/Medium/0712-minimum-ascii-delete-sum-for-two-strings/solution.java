// ──────────────────────────────────────────────────
// Problem  : 712. Minimum ASCII Delete Sum for Two Strings
// Difficulty: Medium
// Tags     : String, Dynamic Programming, Longest Common Subsequence
// Link     : https://leetcode.com/problems/minimum-ascii-delete-sum-for-two-strings/
// Runtime  : 0 ms (beats 0%)
// Memory   : 42360000 (beats 0%)
// Language : java
// Copyright: (c) 2026 Shweta-Sripathi. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int minimumDeleteSum(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        int[][] dp = new int[m + 1][n + 1];

        // Base cases: deleting all remaining characters of s1
        for (int i = 1; i <= m; i++) {
            dp[i][0] = dp[i - 1][0] + s1.charAt(i - 1);
        }

        // Base cases: deleting all remaining characters of s2
        for (int j = 1; j <= n; j++) {
            dp[0][j] = dp[0][j - 1] + s2.charAt(j - 1);
        }

        // Fill DP table
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1]; // No characters deleted
                } else {
                    dp[i][j] = Math.min(
                        dp[i - 1][j] + s1.charAt(i - 1), // Delete s1[i-1]
                        dp[i][j - 1] + s2.charAt(j - 1)  // Delete s2[j-1]
                    );
                }
            }
        }

        return dp[m][n];
    }
}