// ──────────────────────────────────────────────────
// Problem  : 2550. Count Collisions of Monkeys on a Polygon
// Difficulty: Medium
// Tags     : Math, Recursion
// Link     : https://leetcode.com/problems/count-collisions-of-monkeys-on-a-polygon/
// Runtime  : 0 ms (beats 0%)
// Memory   : 42232000 (beats 0%)
// Language : java
// Copyright: (c) 2026 Shweta-Sripathi. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int monkeyMove(int n) {
        long mod = 1_000_000_007;
        
        // Total ways monkeys can move = 2^n
        long totalWays = power(2, n, mod);
        
        // Number of ways WITH collision = Total ways - No-collision ways
        // There are only 2 non-colliding configurations (all clockwise or all counter-clockwise)
        long ans = (totalWays - 2 + mod) % mod;
        
        return (int) ans;
    }

    // Binary Exponentiation to compute (base^exp) % mod
    private long power(long base, long exp, long mod) {
        long res = 1;
        base %= mod;
        
        while (exp > 0) {
            if ((exp & 1) == 1) {
                res = (res * base) % mod;
            }
            base = (base * base) % mod;
            exp >>= 1;
        }
        
        return res;
    }
}