// ──────────────────────────────────────────────────
// Problem  : 2543. Check if Point Is Reachable
// Difficulty: Hard
// Tags     : Math, Number Theory, Euclidean Algorithm, Greatest Common Divisor
// Link     : https://leetcode.com/problems/check-if-point-is-reachable/
// Runtime  : 0 ms (beats 100%)
// Memory   : 42324000 (beats 5%)
// Language : java
// Copyright: (c) 2026 Shweta-Sripathi. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public boolean isReachable(int targetX, int targetY) {
        int g = gcd(targetX, targetY);
        while (g % 2 == 0) {
            g /= 2;
        }
        return g == 1;
    }

    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}