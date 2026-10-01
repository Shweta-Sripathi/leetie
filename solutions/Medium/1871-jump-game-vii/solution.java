// ──────────────────────────────────────────────────
// Problem  : 1871. Jump Game VII
// Difficulty: Medium
// Tags     : String, Dynamic Programming, Sliding Window, Prefix Sum
// Link     : https://leetcode.com/problems/jump-game-vii/
// Runtime  : 8 ms (beats 92%)
// Memory   : 47524000 (beats 83%)
// Language : java
// Copyright: (c) 2026 Shweta-Sripathi. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public boolean canReach(String s, int minJump, int maxJump) {
        int n = s.length();
        
        // If the last character is '1', we can never reach it
        if (s.charAt(n - 1) == '1') {
            return false;
        }

        boolean[] dp = new boolean[n];
        dp[0] = true; // Start position

        int reachableCount = 0;

        for (int i = 1; i < n; i++) {
            // Expand the sliding window on the right (add valid reachable index)
            if (i >= minJump && dp[i - minJump]) {
                reachableCount++;
            }

            // Shrink the sliding window on the left (remove index beyond maxJump)
            if (i > maxJump && dp[i - maxJump - 1]) {
                reachableCount--;
            }

            // Index i is reachable if it's '0' and at least one index in [i - maxJump, i - minJump] is reachable
            if (s.charAt(i) == '0' && reachableCount > 0) {
                dp[i] = true;
            }
        }

        return dp[n - 1];
    }
}