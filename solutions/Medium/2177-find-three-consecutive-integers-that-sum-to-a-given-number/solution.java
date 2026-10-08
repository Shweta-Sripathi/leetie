// ──────────────────────────────────────────────────
// Problem  : 2177. Find Three Consecutive Integers That Sum to a Given Number
// Difficulty: Medium
// Tags     : Math, Simulation
// Link     : https://leetcode.com/problems/find-three-consecutive-integers-that-sum-to-a-given-number/
// Runtime  : 0 ms (beats 100%)
// Memory   : 43076000 (beats 65%)
// Language : java
// Copyright: (c) 2026 Shweta-Sripathi. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public long[] sumOfThree(long num) {
        if (num % 3 != 0) {
            return new long[0];
        }
        
        long mid = num / 3;
        return new long[]{mid - 1, mid, mid + 1};
    }
}