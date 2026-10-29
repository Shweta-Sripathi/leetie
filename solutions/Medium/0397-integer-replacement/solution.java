// ──────────────────────────────────────────────────
// Problem  : 397. Integer Replacement
// Difficulty: Medium
// Tags     : Dynamic Programming, Greedy, Bit Manipulation, Memoization
// Link     : https://leetcode.com/problems/integer-replacement/
// Runtime  : 0 ms (beats 100%)
// Memory   : 41660000 (beats 86%)
// Language : java
// Copyright: (c) 2026 Shweta-Sripathi. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int integerReplacement(int n) {
        // Use long to prevent integer overflow when n = Integer.MAX_VALUE (2^31 - 1)
        // because n + 1 would overflow a standard 32-bit signed int.
        long num = n;
        int count = 0;
        
        while (num > 1) {
            if (num % 2 == 0) {
                num /= 2;
            } else {
                // Special case for n = 3: 3 -> 2 -> 1 takes 2 steps, whereas 3 -> 4 -> 2 -> 1 takes 3 steps.
                // Also, if (num & 2) == 0 (meaning binary ends in 01 like ..., 01), subtracting 1 makes it ..., 00 (divisible by 4 in next steps).
                // Exception: if num == 3, we prefer 3 - 1 = 2.
                if (num == 3 || (num & 2) == 0) {
                    num -= 1;
                } else {
                    num += 1;
                }
            }
            count++;
        }
        
        return count;
    }
}