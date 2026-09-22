// ──────────────────────────────────────────────────
// Problem  : 2578. Split With Minimum Sum
// Difficulty: Easy
// Tags     : Math, Greedy, Sorting
// Link     : https://leetcode.com/problems/split-with-minimum-sum/
// Runtime  : 1 ms (beats 94%)
// Memory   : 42296000 (beats 56%)
// Language : java
// Copyright: (c) 2026 Shweta-Sripathi. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

import java.util.Arrays;

class Solution {
    public int splitNum(int num) {
        char[] digits = String.valueOf(num).toCharArray();
        Arrays.sort(digits);
        
        int num1 = 0;
        int num2 = 0;
        
        for (int i = 0; i < digits.length; i++) {
            if (i % 2 == 0) {
                num1 = num1 * 10 + (digits[i] - '0');
            } else {
                num2 = num2 * 10 + (digits[i] - '0');
            }
        }
        
        return num1 + num2;
    }
}