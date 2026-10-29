// ──────────────────────────────────────────────────
// Problem  : 416. Partition Equal Subset Sum
// Difficulty: Medium
// Tags     : Array, Dynamic Programming, Knapsack Problem, 0-1 Knapsack
// Link     : https://leetcode.com/problems/partition-equal-subset-sum/
// Runtime  : 27 ms (beats 86%)
// Memory   : 43276000 (beats 97%)
// Language : java
// Copyright: (c) 2026 Shweta-Sripathi. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        
        // If the total sum is odd, it cannot be split into two equal integer subsets
        if (sum % 2 != 0) {
            return false;
        }
        
        int target = sum / 2;
        boolean[] dp = new boolean[target + 1];
        dp[0] = true; // Base case: sum 0 is always achievable
        
        for (int num : nums) {
            for (int j = target; j >= num; j--) {
                dp[j] = dp[j] || dp[j - num];
            }
        }
        
        return dp[target];
    }
}