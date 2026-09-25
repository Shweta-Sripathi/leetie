// ──────────────────────────────────────────────────
// Problem  : 190. Reverse Bits
// Difficulty: Easy
// Tags     : Divide and Conquer, Bit Manipulation
// Link     : https://leetcode.com/problems/reverse-bits/
// Runtime  : 0 ms (beats 100%)
// Memory   : 42764000 (beats 9%)
// Language : java
// Copyright: (c) 2026 Shweta-Sripathi. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

public class Solution {
    // Treat 'n' as an unsigned 32-bit value
    public int reverseBits(int n) {
        int result = 0;
        
        for (int i = 0; i < 32; i++) {
            // Shift result left to make space for the next bit
            result <<= 1;
            
            // Extract the least significant bit of n and add it to result
            result |= (n & 1);
            
            // Unsigned right shift n by 1 bit
            n >>>= 1;
        }
        
        return result;
    }
}