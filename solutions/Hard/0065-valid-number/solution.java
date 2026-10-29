// ──────────────────────────────────────────────────
// Problem  : 65. Valid Number
// Difficulty: Hard
// Tags     : String
// Link     : https://leetcode.com/problems/valid-number/
// Runtime  : 2 ms (beats 26%)
// Memory   : 43356000 (beats 95%)
// Language : java
// Copyright: (c) 2026 Shweta-Sripathi. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public boolean isNumber(String s) {
        boolean seenDigit = false;
        boolean seenExponent = false;
        boolean seenDot = false;
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            
            if (Character.isDigit(c)) {
                seenDigit = true;
            } else if (c == '+' || c == '-') {
                // Sign can only appear at the beginning or right after an exponent ('e' or 'E')
                if (i > 0 && s.charAt(i - 1) != 'e' && s.charAt(i - 1) != 'E') {
                    return false;
                }
            } else if (c == '.') {
                // A dot is invalid if we have already seen an exponent or another dot
                if (seenExponent || seenDot) {
                    return false;
                }
                seenDot = true;
            } else if (c == 'e' || c == 'E') {
                // An exponent is invalid if we already saw one, or if we haven't seen any digit yet
                if (seenExponent || !seenDigit) {
                    return false;
                }
                seenExponent = true;
                seenDigit = false; // Reset seenDigit to ensure there is at least one digit after 'e'/'E'
            } else {
                // Any other character makes it invalid
                return false;
            }
        }
        
        return seenDigit;
    }
}