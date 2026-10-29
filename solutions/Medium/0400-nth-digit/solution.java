// ──────────────────────────────────────────────────
// Problem  : 400. Nth Digit
// Difficulty: Medium
// Tags     : Math, Binary Search
// Link     : https://leetcode.com/problems/nth-digit/
// Runtime  : 0 ms (beats 100%)
// Memory   : 41848000 (beats 73%)
// Language : java
// Copyright: (c) 2026 Shweta-Sripathi. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int findNthDigit(int n) {
        int len = 1;
        long count = 9;
        long start = 1;
        
        // 1. Find the length of the number where the nth digit is
        while (n > len * count) {
            n -= len * count;
            len++;
            count *= 10;
            start *= 10;
        }
        
        // 2. Find the actual number containing the nth digit
        start += (n - 1) / len;
        
        // 3. Find the specific digit within the number
        String s = Long.toString(start);
        return s.charAt((n - 1) % len) - '0';
    }
}