// ──────────────────────────────────────────────────
// Problem  : 507. Perfect Number
// Difficulty: Easy
// Tags     : Math
// Link     : https://leetcode.com/problems/perfect-number/
// Runtime  : 1 ms (beats 96%)
// Memory   : 42048000 (beats 62%)
// Language : java
// Copyright: (c) 2026 Shweta-Sripathi. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public boolean checkPerfectNumber(int num) {
        if (num <= 1) {
            return false;
        }

        int sum = 1;
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                sum += i;
                if (i * i != num) {
                    sum += num / i;
                }
            }
        }

        return sum == num;
    }
}