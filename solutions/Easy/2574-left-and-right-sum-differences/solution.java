// ──────────────────────────────────────────────────
// Problem  : 2574. Left and Right Sum Differences
// Difficulty: Easy
// Tags     : Array, Prefix Sum
// Link     : https://leetcode.com/problems/left-and-right-sum-differences/
// Runtime  : 2 ms (beats 99%)
// Memory   : 46500000 (beats 72%)
// Language : java
// Copyright: (c) 2026 Shweta-Sripathi. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int[] leftRightDifference(int[] nums) {
        int n = nums.length;
        int totalSum = 0;
        
        for (int num : nums) {
            totalSum += num;
        }
        
        int[] answer = new int[n];
        int leftSum = 0;
        
        for (int i = 0; i < n; i++) {
            // rightSum is totalSum minus leftSum minus the current element
            int rightSum = totalSum - leftSum - nums[i];
            
            answer[i] = Math.abs(leftSum - rightSum);
            
            // Update leftSum for the next index
            leftSum += nums[i];
        }
        
        return answer;
    }
}