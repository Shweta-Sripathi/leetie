// ──────────────────────────────────────────────────
// Problem  : 2544. Alternating Digit Sum
// Difficulty: Easy
// Tags     : Math
// Link     : https://leetcode.com/problems/alternating-digit-sum/
// Runtime  : 0 ms (beats 0%)
// Memory   : 42028000 (beats 0%)
// Language : java
// Copyright: (c) 2026 Shweta-Sripathi. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int alternateDigitSum(int n) {
        String s = Integer.toString(n);
        int sum = 0;
        int sign = 1;

        for (int i = 0; i < s.length(); i++) {
            int digit = s.charAt(i) - '0';
            sum += digit * sign;
            sign *= -1; // Alternate the sign for the next digit
        }

        return sum;
    }
}