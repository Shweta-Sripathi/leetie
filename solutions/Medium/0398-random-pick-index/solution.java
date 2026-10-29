// ──────────────────────────────────────────────────
// Problem  : 398. Random Pick Index
// Difficulty: Medium
// Tags     : Hash Table, Math, Reservoir Sampling, Randomized
// Link     : https://leetcode.com/problems/random-pick-index/
// Runtime  : 1523 ms (beats 17%)
// Memory   : 60076000 (beats 98%)
// Language : java
// Copyright: (c) 2026 Shweta-Sripathi. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

import java.util.Random;

class Solution {
    private int[] nums;
    private Random rand;

    public Solution(int[] nums) {
        this.nums = nums;
        this.rand = new Random();
    }
    
    public int pick(int target) {
        int count = 0;
        int result = -1;
        
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                count++;
                // Reservoir sampling: select the current index with probability 1/count
                if (rand.nextInt(count) == 0) {
                    result = i;
                }
            }
        }
        
        return result;
    }
}