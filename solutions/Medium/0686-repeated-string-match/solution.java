// ──────────────────────────────────────────────────
// Problem  : 686. Repeated String Match
// Difficulty: Medium
// Tags     : String, String Matching, Z Algorithm, Knuth–Morris–Pratt Algorithm, Boyer–Moore String-Search Algorithm
// Link     : https://leetcode.com/problems/repeated-string-match/
// Runtime  : 266 ms (beats 34%)
// Memory   : 43384000 (beats 93%)
// Language : java
// Copyright: (c) 2026 Shweta-Sripathi. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int repeatedStringMatch(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int count = 0;

        // Repeat string 'a' until its length is at least the length of 'b'
        while (sb.length() < b.length()) {
            sb.append(a);
            count++;
        }

        // Check if 'b' is a substring
        if (sb.toString().contains(b)) {
            return count;
        }

        // Add one more repetition of 'a' to cover boundary wrap-around cases
        sb.append(a);
        count++;

        if (sb.toString().contains(b)) {
            return count;
        }

        return -1;
    }
}