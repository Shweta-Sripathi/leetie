// ──────────────────────────────────────────────────
// Problem  : 2165. Smallest Value of the Rearranged Number
// Difficulty: Medium
// Tags     : Math, Sorting
// Link     : https://leetcode.com/problems/smallest-value-of-the-rearranged-number/
// Runtime  : 4 ms (beats 20%)
// Memory   : 42208000 (beats 89%)
// Language : java
// Copyright: (c) 2026 Shweta-Sripathi. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

import java.util.Arrays;

class Solution {
    public long smallestNumber(long num) {
        if (num == 0) return 0;

        boolean isNegative = num < 0;
        char[] digits = String.valueOf(Math.abs(num)).toCharArray();
        
        Arrays.sort(digits);

        if (!isNegative) {
            // For positive numbers: find the first non-zero digit and place it at index 0
            if (digits[0] == '0') {
                int i = 0;
                while (i < digits.length && digits[i] == '0') {
                    i++;
                }
                // Swap the first non-zero digit to the front
                digits[0] = digits[i];
                digits[i] = '0';
            }
            return Long.parseLong(new String(digits));
        } else {
            // For negative numbers: reverse the sorted array (descending order)
            StringBuilder sb = new StringBuilder(new String(digits));
            sb.reverse();
            return -Long.parseLong(sb.toString());
        }
    }
}