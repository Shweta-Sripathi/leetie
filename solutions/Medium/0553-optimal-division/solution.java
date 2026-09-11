// ──────────────────────────────────────────────────
// Problem  : 553. Optimal Division
// Difficulty: Medium
// Tags     : Array, Math, Dynamic Programming
// Link     : https://leetcode.com/problems/optimal-division/
// Runtime  : 3 ms (beats 89%)
// Memory   : 43196000 (beats 43%)
// Language : java
// Copyright: (c) 2026 Shweta-Sripathi. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public String optimalDivision(int[] nums) {
        int n = nums.length;
        
        if (n == 1) {
            return String.valueOf(nums[0]);
        }
        if (n == 2) {
            return nums[0] + "/" + nums[1];
        }
        
        StringBuilder sb = new StringBuilder();
        sb.append(nums[0]).append("/(").append(nums[1]);
        
        for (int i = 2; i < n; i++) {
            sb.append("/").append(nums[i]);
        }
        
        sb.append(")");
        return sb.toString();
    }
}