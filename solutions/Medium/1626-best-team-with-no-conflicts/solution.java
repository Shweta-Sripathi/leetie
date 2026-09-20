// ──────────────────────────────────────────────────
// Problem  : 1626. Best Team With No Conflicts
// Difficulty: Medium
// Tags     : Array, Dynamic Programming, Sorting, Longest Increasing Subsequence
// Link     : https://leetcode.com/problems/best-team-with-no-conflicts/
// Runtime  : 32 ms (beats 86%)
// Memory   : 46912000 (beats 70%)
// Language : java
// Copyright: (c) 2026 Shweta-Sripathi. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

import java.util.Arrays;

class Solution {
    public int bestTeamScore(int[] scores, int[] ages) {
        int n = scores.length;
        int[][] players = new int[n][2];

        for (int i = 0; i < n; i++) {
            players[i][0] = ages[i];
            players[i][1] = scores[i];
        }

        // Sort primarily by age, secondarily by score
        Arrays.sort(players, (a, b) -> a[0] != b[0] ? Integer.compare(a[0], b[0]) : Integer.compare(a[1], b[1]));

        int[] dp = new int[n];
        int maxScore = 0;

        for (int i = 0; i < n; i++) {
            dp[i] = players[i][1]; // Base case: team consisting only of player i

            for (int j = 0; j < i; j++) {
                if (players[j][1] <= players[i][1]) {
                    dp[i] = Math.max(dp[i], dp[j] + players[i][1]);
                }
            }

            maxScore = Math.max(maxScore, dp[i]);
        }

        return maxScore;
    }
}