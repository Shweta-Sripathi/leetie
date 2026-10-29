// ──────────────────────────────────────────────────
// Problem  : 762. Prime Number of Set Bits in Binary Representation
// Difficulty: Easy
// Tags     : Math, Bit Manipulation, Primality Test
// Link     : https://leetcode.com/problems/prime-number-of-set-bits-in-binary-representation/
// Runtime  : 4 ms (beats 87%)
// Memory   : 41352000 (beats 100%)
// Language : java
// Copyright: (c) 2026 Shweta-Sripathi. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int countPrimeSetBits(int left, int right) {
        int count = 0;
        // Since right <= 10^6, the maximum number of set bits is 20 (as 2^20 > 10^6).
        // Prime numbers up to 20 are: 2, 3, 5, 7, 11, 13, 17, 19.
        // We can use a bitmask where the i-th bit is set if i is prime:
        // (1 << 2) | (1 << 3) | (1 << 5) | (1 << 7) | (1 << 11) | (1 << 13) | (1 << 17) | (1 << 19) = 665772.
        int primeMask = 665772;

        for (int i = left; i <= right; i++) {
            int setBits = Integer.bitCount(i);
            if ((primeMask & (1 << setBits)) != 0) {
                count++;
            }
        }

        return count;
    }
}