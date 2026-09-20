// ──────────────────────────────────────────────────
// Problem  : 1648. Sell Diminishing-Valued Colored Balls
// Difficulty: Medium
// Tags     : Array, Math, Binary Search, Greedy, Sorting, Heap (Priority Queue)
// Link     : https://leetcode.com/problems/sell-diminishing-valued-colored-balls/
// Runtime  : 1 ms (beats 0%)
// Memory   : 42692000 (beats 0%)
// Language : java
// Copyright: (c) 2026 Shweta-Sripathi. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

import java.util.Arrays;

class Solution {
    public int maxProfit(int[] inventory, int orders) {
        Arrays.sort(inventory);
        int n = inventory.length;

        // Reverse to process in descending order
        long[] inv = new long[n + 1];
        for (int i = 0; i < n; i++) {
            inv[i] = inventory[n - 1 - i];
        }
        inv[n] = 0; // Guard element

        long totalProfit = 0;
        long MOD = 1_000_000_007;

        for (int i = 0; i < n; i++) {
            long currentHeight = inv[i];
            long nextHeight = inv[i + 1];

            if (currentHeight == nextHeight) {
                continue;
            }

            long colors = i + 1; // Number of colors with height >= currentHeight
            long heightDiff = currentHeight - nextHeight;
            long totalBalls = colors * heightDiff;

            if (orders >= totalBalls) {
                // Sell all balls in this tier
                long sumOneColor = (currentHeight + nextHeight + 1) * heightDiff / 2;
                totalProfit = (totalProfit + sumOneColor % MOD * colors) % MOD;
                orders -= totalBalls;
            } else {
                // Sell partially
                long fullSteps = orders / colors;
                long remainder = orders % colors;

                long sumOneColor = (currentHeight + currentHeight - fullSteps + 1) * fullSteps / 2;
                totalProfit = (totalProfit + sumOneColor % MOD * colors) % MOD;

                totalProfit = (totalProfit + remainder * (currentHeight - fullSteps)) % MOD;
                orders = 0;
                break;
            }
        }

        return (int) totalProfit;
    }
}