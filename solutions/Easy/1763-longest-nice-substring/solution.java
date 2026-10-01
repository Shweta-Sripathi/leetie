// ──────────────────────────────────────────────────
// Problem  : 1763. Longest Nice Substring
// Difficulty: Easy
// Tags     : Hash Table, String, Divide and Conquer, Bit Manipulation, Sliding Window
// Link     : https://leetcode.com/problems/longest-nice-substring/
// Runtime  : 0 ms (beats 0%)
// Memory   : 42744000 (beats 0%)
// Language : java
// Copyright: (c) 2026 Shweta-Sripathi. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

import java.util.HashSet;
import java.util.Set;

class Solution {
    public String longestNiceSubstring(String s) {
        if (s.length() < 2) {
            return "";
        }

        // Store all characters present in the current string
        Set<Character> set = new HashSet<>();
        for (char c : s.toCharArray()) {
            set.add(c);
        }

        // Find the first character that doesn't have both uppercase and lowercase counterparts
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            
            // If the character's counterpart is missing, it CANNOT be part of any nice substring
            if (set.contains(Character.toLowerCase(c)) && set.contains(Character.toUpperCase(c))) {
                continue;
            }

            // Split the string into two halves around the invalid character
            String sub1 = longestNiceSubstring(s.substring(0, i));
            String sub2 = longestNiceSubstring(s.substring(i + 1));

            // Return the longer nice substring (or the earlier one in case of a tie)
            return sub1.length() >= sub2.length() ? sub1 : sub2;
        }

        // If all characters have matching lower/upper pairs, the whole string is nice
        return s;
    }
}