// ──────────────────────────────────────────────────
// Problem  : 678. Valid Parenthesis String
// Difficulty: Medium
// Tags     : String, Dynamic Programming, Stack, Greedy, Bracket Sequences
// Link     : https://leetcode.com/problems/valid-parenthesis-string/
// Runtime  : 0 ms (beats 0%)
// Memory   : 42628000 (beats 0%)
// Language : java
// Copyright: (c) 2026 Shweta-Sripathi. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public boolean checkValidString(String s) {
        int minOpen = 0; // Minimum possible open parentheses count
        int maxOpen = 0; // Maximum possible open parentheses count

        for (char c : s.toCharArray()) {
            if (c == '(') {
                minOpen++;
                maxOpen++;
            } else if (c == ')') {
                minOpen--;
                maxOpen--;
            } else { // c == '*'
                minOpen--; // Treat '*' as ')'
                maxOpen++; // Treat '*' as '('
            }

            // If maxOpen is negative, we have more ')' than can ever be matched
            if (maxOpen < 0) return false;

            // minOpen cannot be negative (we can't have negative open parentheses)
            minOpen = Math.max(minOpen, 0);
        }

        // Valid if minOpen can reach 0 at the end
        return minOpen == 0;
    }
}