// ──────────────────────────────────────────────────
// Problem  : 3300. Minimum Element After Replacement With Digit Sum
// Difficulty: Easy
// Tags     : Array, Math
// Link     : https://leetcode.com/problems/minimum-element-after-replacement-with-digit-sum/
// Runtime  : 0 ms (beats 0%)
// Memory   : 42408000 (beats 0%)
// Language : java
// Copyright: (c) 2026 Shweta-Sripathi. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int minElement(int[] nums) {
        int min = Integer.MAX_VALUE;
        
        for (int num : nums) {
            int digitSum = getDigitSum(num);
            min = Math.min(min, digitSum);
        }
        
        return min;
    }
    
    private int getDigitSum(int n) {
        int sum = 0;
        while (n > 0) {
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }
}