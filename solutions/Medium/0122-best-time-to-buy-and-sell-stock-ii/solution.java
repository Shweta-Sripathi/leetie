// ──────────────────────────────────────────────────
// Problem  : 122. Best Time to Buy and Sell Stock II
// Difficulty: Medium
// Tags     : Array, Dynamic Programming, Greedy
// Link     : https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
// Runtime  : 1 ms (beats 21%)
// Memory   : 45892000 (beats 94%)
// Language : java
// Copyright: (c) 2026 Shweta-Sripathi. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        
        // Accumulate all positive differences between consecutive days
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                maxProfit += prices[i] - prices[i - 1];
            }
        }
        
        return maxProfit;
    }
}