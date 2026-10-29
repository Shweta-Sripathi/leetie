// ──────────────────────────────────────────────────
// Problem  : 393. UTF-8 Validation
// Difficulty: Medium
// Tags     : Array, Bit Manipulation
// Link     : https://leetcode.com/problems/utf-8-validation/
// Runtime  : 2 ms (beats 38%)
// Memory   : 46044000 (beats 86%)
// Language : java
// Copyright: (c) 2026 Shweta-Sripathi. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public boolean validUtf8(int[] data) {
        int remainingBytes = 0;
        
        for (int num : data) {
            // Get only the least significant 8 bits
            int byteVal = num & 0xFF;
            
            if (remainingBytes == 0) {
                // Determine the number of bytes in the UTF-8 character
                if ((byteVal >> 7) == 0) {
                    // 1-byte character: 0xxxxxxx
                    remainingBytes = 0;
                } else if ((byteVal >> 5) == 0x6) { // 110x xxxx -> shifted right by 5 is 0x6
                    // 2-bytes character: 110xxxxx
                    remainingBytes = 1;
                } else if ((byteVal >> 4) == 0xE) { // 1110 xxxx -> shifted right by 4 is 0xE
                    // 3-bytes character: 1110xxxx
                    remainingBytes = 2;
                } else if ((byteVal >> 3) == 0x1E) { // 1111 0xxx -> shifted right by 3 is 0x1E
                    // 4-bytes character: 11110xxx
                    remainingBytes = 3;
                } else {
                    return false;
                }
            } else {
                // For continuation bytes, the most significant 2 bits must be '10'
                if ((byteVal >> 6) != 2) {
                    return false;
                }
                remainingBytes--;
            }
        }
        
        return remainingBytes == 0;
    }
}