// ──────────────────────────────────────────────────
// Problem  : 2572. Count the Number of Square-Free Subsets
// Difficulty: Medium
// Tags     : Array, Math, Dynamic Programming, Bit Manipulation, Number Theory, Bitmask
// Link     : https://leetcode.com/problems/count-the-number-of-square-free-subsets/
// Runtime  : 3 ms (beats 87%)
// Memory   : 43740000 (beats 100%)
// Language : java
// Copyright: (c) 2026 Shweta-Sripathi. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    private static final int MOD = 1_000_000_007;
    private static final int[] PRIMES = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29};

    public int squareFreeSubsets(int[] nums) {
        // Count frequencies of numbers from 1 to 30
        int[] count = new int[31];
        for (int num : nums) {
            count[num]++;
        }

        // dp[mask] = number of valid subsets using a prime mask
        long[] dp = new long[1 << 10];
        dp[0] = 1;

        for (int i = 2; i <= 30; i++) {
            if (count[i] == 0) continue;

            int mask = getPrimeMask(i);
            if (mask == -1) continue; // Skip numbers that are not square-free (e.g., 4, 8, 9, 12, etc.)

            // Traverse backwards to avoid using the same element multiple times
            for (int currentMask = (1 << 10) - 1; currentMask >= 0; currentMask--) {
                if ((currentMask & mask) == 0) {
                    dp[currentMask | mask] = (dp[currentMask | mask] + dp[currentMask] * count[i]) % MOD;
                }
            }
        }

        // Calculate sum over all masks
        long totalSubsets = 0;
        for (long val : dp) {
            totalSubsets = (totalSubsets + val) % MOD;
        }

        // Handle number 1 separately (2^count[1] choices)
        long pow2 = 1;
        for (int i = 0; i < count[1]; i++) {
            pow2 = (pow2 * 2) % MOD;
        }

        totalSubsets = (totalSubsets * pow2) % MOD;

        // Subtract 1 to exclude the empty subset
        return (int) ((totalSubsets - 1 + MOD) % MOD);
    }

    private int getPrimeMask(int num) {
        int mask = 0;
        for (int i = 0; i < PRIMES.length; i++) {
            int p = PRIMES[i];
            if (num % (p * p) == 0) return -1; // Divisible by square of a prime
            if (num % p == 0) {
                mask |= (1 << i);
            }
        }
        return mask;
    }
}