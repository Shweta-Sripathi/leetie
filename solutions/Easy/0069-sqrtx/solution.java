// ──────────────────────────────────────────────────
// Problem  : 69. Sqrt(x)
// Difficulty: Easy
// Tags     : Math, Binary Search, Newton's Method
// Link     : https://leetcode.com/problems/sqrtx/
// Runtime  : 1 ms (beats 99%)
// Memory   : 42328000 (beats 90%)
// Language : java
// Copyright: (c) 2026 Shweta-Sripathi. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int mySqrt(int x) {
        if (x < 2) {
            return x;
        }

        int left = 1, right = x / 2;
        int ans = 0;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            // Use long to prevent integer overflow during mid * mid
            if ((long) mid * mid <= x) {
                ans = mid; // Store the potential answer
                left = mid + 1; // Try to find a larger value
            } else {
                right = mid - 1;
            }
        }

        return ans;
    }
}