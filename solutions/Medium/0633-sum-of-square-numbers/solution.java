// ──────────────────────────────────────────────────
// Problem  : 633. Sum of Square Numbers
// Difficulty: Medium
// Tags     : Math, Two Pointers, Binary Search
// Link     : https://leetcode.com/problems/sum-of-square-numbers/
// Runtime  : 4 ms (beats 82%)
// Memory   : 42176000 (beats 50%)
// Language : java
// Copyright: (c) 2026 Shweta-Sripathi. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public boolean judgeSquareSum(int c) {
        long a = 0;
        long b = (long) Math.sqrt(c);

        while (a <= b) {
            long sum = a * a + b * b;
            if (sum == c) {
                return true;
            } else if (sum < c) {
                a++;
            } else {
                b--;
            }
        }

        return false;
    }
}