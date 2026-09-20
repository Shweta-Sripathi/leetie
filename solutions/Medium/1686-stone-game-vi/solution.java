// ──────────────────────────────────────────────────
// Problem  : 1686. Stone Game VI
// Difficulty: Medium
// Tags     : Array, Math, Greedy, Minimax, Sorting, Heap (Priority Queue), Game Theory, Zero-Sum Game
// Link     : https://leetcode.com/problems/stone-game-vi/
// Runtime  : 82 ms (beats 50%)
// Memory   : 102656000 (beats 15%)
// Language : java
// Copyright: (c) 2026 Shweta-Sripathi. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

import java.util.Arrays;

class Solution {
    public int stoneGameVI(int[] aliceValues, int[] bobValues) {
        int n = aliceValues.length;
        int[][] stones = new int[n][3];

        for (int i = 0; i < n; i++) {
            stones[i][0] = aliceValues[i] + bobValues[i]; // Combined value
            stones[i][1] = aliceValues[i];               // Alice's value
            stones[i][2] = bobValues[i];               // Bob's value
        }

        // Sort by combined value in descending order
        Arrays.sort(stones, (a, b) -> Integer.compare(b[0], a[0]));

        int aliceScore = 0;
        int bobScore = 0;

        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                aliceScore += stones[i][1]; // Alice's turn
            } else {
                bobScore += stones[i][2];   // Bob's turn
            }
        }

        return Integer.compare(aliceScore, bobScore);
    }
}