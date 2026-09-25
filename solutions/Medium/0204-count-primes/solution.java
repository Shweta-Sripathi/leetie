// ──────────────────────────────────────────────────
// Problem  : 204. Count Primes
// Difficulty: Medium
// Tags     : Array, Math, Enumeration, Number Theory, Primality Test, Sieve Theory, Prime Number Sieve
// Link     : https://leetcode.com/problems/count-primes/
// Runtime  : 618 ms (beats 58%)
// Memory   : 79280000 (beats 61%)
// Language : java
// Copyright: (c) 2026 Shweta-Sripathi. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int countPrimes(int n) {
        if (n <= 2) {
            return 0;
        }

        // isComposite[i] will be true if i is composite (not prime)
        boolean[] isComposite = new boolean[n];
        int count = 0;

        for (int i = 2; i * i < n; i++) {
            if (!isComposite[i]) {
                // Mark multiples of i starting from i * i as composite
                for (int j = i * i; j < n; j += i) {
                    isComposite[j] = true;
                }
            }
        }

        // Count prime numbers strictly less than n
        for (int i = 2; i < n; i++) {
            if (!isComposite[i]) {
                count++;
            }
        }

        return count;
    }
}