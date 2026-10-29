// ──────────────────────────────────────────────────
// Problem  : 151. Reverse Words in a String
// Difficulty: Medium
// Tags     : Two Pointers, String
// Link     : https://leetcode.com/problems/reverse-words-in-a-string/
// Runtime  : 7 ms (beats 65%)
// Memory   : 43924000 (beats 85%)
// Language : java
// Copyright: (c) 2026 Shweta-Sripathi. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public String reverseWords(String s) {
        // Trim leading and trailing spaces, then split by one or more spaces
        String[] words = s.trim().split("\\s+");
        
        StringBuilder sb = new StringBuilder();
        
        // Iterate backwards through the words array and append them with a single space
        for (int i = words.length - 1; i >= 0; i--) {
            sb.append(words[i]);
            if (i > 0) {
                sb.append(" ");
            }
        }
        
        return sb.toString();
    }
}