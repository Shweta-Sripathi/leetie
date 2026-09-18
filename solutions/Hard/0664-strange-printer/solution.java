// ──────────────────────────────────────────────────
// Problem  : 664. Strange Printer
// Difficulty: Hard
// Tags     : String, Dynamic Programming
// Link     : https://leetcode.com/problems/strange-printer/
// Runtime  : 27 ms (beats 33%)
// Memory   : 44984000 (beats 29%)
// Language : java
// Copyright: (c) 2026 Shweta-Sripathi. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int strangePrinter(String s) {
        if (s == null || s.length() == 0) return 0;
        
        int n = s.length();
        int[][] dp = new int[n][n];

        // Base cases: single characters take 1 turn
        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
        }

        // Build DP table for substrings of length 2 to n
        for (int len = 2; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
                int j = i + len - 1;
                
                // Worst case: print s[j] separately
                dp[i][j] = dp[i][j - 1] + 1;

                // Try splitting at every point k where s[k] == s[j]
                for (int k = i; k < j; k++) {
                    if (s.charAt(k) == s.charAt(j)) {
                        int turns = dp[i][k] + (k + 1 <= j - 1 ? dp[k + 1][j - 1] : 0);
                        dp[i][j] = Math.min(dp[i][j], turns);
                    }
                }
            }
        }

        return dp[0][n - 1];
    }
}