// ──────────────────────────────────────────────────
// Problem  : 2180. Count Integers With Even Digit Sum
// Difficulty: Easy
// Tags     : Math, Simulation
// Link     : https://leetcode.com/problems/count-integers-with-even-digit-sum/
// Runtime  : 0 ms (beats 100%)
// Memory   : 42352000 (beats 7%)
// Language : java
// Copyright: (c) 2026 Shweta-Sripathi. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int countEven(int num) {
        int temp = num;
        int sum = 0;
        
        // Compute sum of digits of num
        while (temp > 0) {
            sum += temp % 10;
            temp /= 10;
        }
        
        // If digit sum is even: return num / 2
        // If digit sum is odd:  return (num - 1) / 2
        return (num - (sum % 2)) / 2;
    }
}