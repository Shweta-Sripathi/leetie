// ──────────────────────────────────────────────────
// Problem  : 2507. Smallest Value After Replacing With Sum of Prime Factors
// Difficulty: Medium
// Tags     : Math, Simulation, Number Theory, Prime Factorization, Primality Test, Sieve Theory, Prime Number Sieve
// Link     : https://leetcode.com/problems/smallest-value-after-replacing-with-sum-of-prime-factors/
// Runtime  : 0 ms (beats 100%)
// Memory   : 42200000 (beats 67%)
// Language : java
// Copyright: (c) 2026 Shweta-Sripathi. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int smallestValue(int n) {
        while (true) {
            int sum = 0;
            int temp = n;
            
            // Find prime factors of temp
            for (int i = 2; i * i <= temp; i++) {
                while (temp % i == 0) {
                    sum += i;
                    temp /= i;
                }
            }
            if (temp > 1) {
                sum += temp;
            }
            
            // If the sum of prime factors is equal to n, we reached the smallest value
            if (sum == n) {
                return n;
            }
            
            n = sum;
        }
    }
}