// ──────────────────────────────────────────────────
// Problem  : 2160. Minimum Sum of Four Digit Number After Splitting Digits
// Difficulty: Easy
// Tags     : Math, Greedy, Sorting
// Link     : https://leetcode.com/problems/minimum-sum-of-four-digit-number-after-splitting-digits/
// Runtime  : 1 ms (beats 87%)
// Memory   : 42180000 (beats 70%)
// Language : java
// Copyright: (c) 2026 Shweta-Sripathi. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

import java.util.Arrays;

class Solution {
    public int minimumSum(int num) {
        int[] digits = new int[4];
        
        // Extract digits
        for (int i = 0; i < 4; i++) {
            digits[i] = num % 10;
            num /= 10;
        }
        
        // Sort digits in ascending order
        Arrays.sort(digits);
        
        // Calculate min sum using smallest digits for the tens places
        return (digits[0] * 10 + digits[2]) + (digits[1] * 10 + digits[3]);
    }
}