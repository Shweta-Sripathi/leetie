// ──────────────────────────────────────────────────
// Problem  : 367. Valid Perfect Square
// Difficulty: Easy
// Tags     : Math, Binary Search
// Link     : https://leetcode.com/problems/valid-perfect-square/
// Runtime  : 0 ms (beats 100%)
// Memory   : 41720000 (beats 83%)
// Language : java
// Copyright: (c) 2026 Shweta-Sripathi. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public boolean isPerfectSquare(int num) {
        if (num < 1) {
            return false;
        }
        long left = 1;
        long right = num;
        while (left <= right) {
            long mid = left + (right - left) / 2;
            long square = mid * mid;
            if (square == num) {
                return true;
            } else if (square < num) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }
}