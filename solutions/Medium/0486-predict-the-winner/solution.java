// ──────────────────────────────────────────────────
// Problem  : 486. Predict the Winner
// Difficulty: Medium
// Tags     : Array, Math, Dynamic Programming, Recursion, Minimax, Game Theory, Zero-Sum Game
// Link     : https://leetcode.com/problems/predict-the-winner/
// Runtime  : 0 ms (beats 100%)
// Memory   : 42556000 (beats 86%)
// Language : java
// Copyright: (c) 2026 Shweta-Sripathi. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public boolean predictTheWinner(int[] nums) {
        int n = nums.length;
        // dp[i] stores the max score difference Player 1 can secure over Player 2 for subarray nums[i..j]
        int[] dp = new int[n];

        // Base case: subarray of length 1, player gets the element value
        for (int i = 0; i < n; i++) {
            dp[i] = nums[i];
        }

        // Fill DP table for larger subarray lengths
        for (int len = 2; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
                int j = i + len - 1;
                dp[i] = Math.max(nums[i] - dp[i + 1], nums[j] - dp[i]);
            }
        }

        // Player 1 wins or ties if the max net score difference is >= 0
        return dp[0] >= 0;
    }
}