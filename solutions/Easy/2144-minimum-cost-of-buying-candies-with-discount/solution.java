// ──────────────────────────────────────────────────
// Problem  : 2144. Minimum Cost of Buying Candies With Discount
// Difficulty: Easy
// Tags     : Array, Greedy, Sorting
// Link     : https://leetcode.com/problems/minimum-cost-of-buying-candies-with-discount/
// Runtime  : 6 ms (beats 40%)
// Memory   : 44236000 (beats 90%)
// Language : java
// Copyright: (c) 2026 Shweta-Sripathi. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

import java.util.Arrays;

class Solution {
    public int minimumCost(int[] cost) {
        // Sort the array in ascending order
        Arrays.sort(cost);
        
        int totalCost = 0;
        int n = cost.length;
        
        // Iterate backwards from the most expensive candy to the cheapest
        for (int i = n - 1; i >= 0; i--) {
            // Every 3rd candy (when counting backwards from the end, starting at index 0, 1, free) 
            // is skipped because we get it for free.
            // Specifically, skip when (n - 1 - i) % 3 == 2
            if ((n - 1 - i) % 3 == 2) {
                continue;
            }
            totalCost += cost[i];
        }
        
        return totalCost;
    }
}