// ──────────────────────────────────────────────────
// Problem  : 650. 2 Keys Keyboard
// Difficulty: Medium
// Tags     : Math, Dynamic Programming
// Link     : https://leetcode.com/problems/2-keys-keyboard/
// Runtime  : 0 ms (beats 100%)
// Memory   : 42332000 (beats 37%)
// Language : java
// Copyright: (c) 2026 Shweta-Sripathi. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int minSteps(int n) {
        int steps = 0;
        int d = 2;

        while (n > 1) {
            while (n % d == 0) {
                steps += d;
                n /= d;
            }
            d++;
        }

        return steps;
    }
}