// ──────────────────────────────────────────────────
// Problem  : 396. Rotate Function
// Difficulty: Medium
// Tags     : Array, Math, Dynamic Programming
// Link     : https://leetcode.com/problems/rotate-function/
// Runtime  : 4 ms (beats 98%)
// Memory   : 90892000 (beats 86%)
// Language : java
// Copyright: (c) 2026 Shweta-Sripathi. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int maxRotateFunction(int[] nums) {
        int n = nums.length;
        long allSum = 0;
        long F = 0;
        
        for (int i = 0; i < n; i++) {
            allSum += nums[i];
            F += (long) i * nums[i];
        }
        
        long max = F;
        for (int i = n - 1; i >= 1; i--) {
            F = F + allSum - (long) n * nums[i];
            max = Math.max(max, F);
        }
        
        return (int) max;
    }
}