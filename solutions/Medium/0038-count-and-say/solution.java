// ──────────────────────────────────────────────────
// Problem  : 38. Count and Say
// Difficulty: Medium
// Tags     : String
// Link     : https://leetcode.com/problems/count-and-say/
// Runtime  : 9 ms (beats 35%)
// Memory   : 42948000 (beats 71%)
// Language : java
// Copyright: (c) 2026 Shweta-Sripathi. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public String countAndSay(int n) {
        String s = "1";
        
        for (int i = 1; i < n; i++) {
            StringBuilder next = new StringBuilder();
            int count = 1;
            
            for (int j = 0; j < s.length(); j++) {
                // If it's the last character or different from the next character
                if (j == s.length() - 1 || s.charAt(j) != s.charAt(j + 1)) {
                    next.append(count).append(s.charAt(j));
                    count = 1; // Reset count for the next sequence
                } else {
                    count++;
                }
            }
            s = next.toString();
        }
        
        return s;
    }
}