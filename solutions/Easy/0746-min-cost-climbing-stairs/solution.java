// ──────────────────────────────────────────────────
// Problem  : 746. Min Cost Climbing Stairs
// Difficulty: Easy
// Tags     : Array, Dynamic Programming
// Link     : https://leetcode.com/problems/min-cost-climbing-stairs/
// Runtime  : 1 ms (beats 50%)
// Memory   : 44204000 (beats 94%)
// Language : java
// Copyright: (c) 2026 Shweta-Sripathi. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int prev2 = cost[0];
        int prev1 = cost[1];
        
        for (int i = 2; i < n; i++) {
            int curr = cost[i] + Math.min(prev1, prev2);
            prev2 = prev1;
            prev1 = curr;
        }
        
        return Math.min(prev1, prev2);
    }
}