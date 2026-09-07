// ──────────────────────────────────────────────────
// Problem  : 45. Jump Game II
// Difficulty: Medium
// Tags     : Array, Dynamic Programming, Greedy
// Link     : https://leetcode.com/problems/jump-game-ii/
// Runtime  : 0 ms (beats 0%)
// Memory   : 42524000 (beats 0%)
// Language : java
// Copyright: (c) 2026 Shweta-Sripathi. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int jump(int[] nums) {
        int jumps = 0;
        int currentEnd = 0;
        int farthest = 0;

        // Loop until nums.length - 1 because we don't need to jump from the last element
        for (int i = 0; i < nums.length - 1; i++) {
            // Update the furthest index reachable
            farthest = Math.max(farthest, i + nums[i]);

            // If reached the end of the current jump boundary
            if (i == currentEnd) {
                jumps++;
                currentEnd = farthest;
                
                // Early stop if we can already reach or pass the last index
                if (currentEnd >= nums.length - 1) {
                    break;
                }
            }
        }

        return jumps;
    }
}