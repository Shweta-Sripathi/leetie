// ──────────────────────────────────────────────────
// Problem  : 522. Longest Uncommon Subsequence II
// Difficulty: Medium
// Tags     : Array, Hash Table, Two Pointers, String, Sorting
// Link     : https://leetcode.com/problems/longest-uncommon-subsequence-ii/
// Runtime  : 1 ms (beats 100%)
// Memory   : 42996000 (beats 31%)
// Language : java
// Copyright: (c) 2026 Shweta-Sripathi. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int findLUSlength(String[] strs) {
        int maxLength = -1;
        
        for (int i = 0; i < strs.length; i++) {
            boolean isUncommon = true;
            
            // Check if strs[i] is a subsequence of any other string
            for (int j = 0; j < strs.length; j++) {
                if (i != j && isSubsequence(strs[i], strs[j])) {
                    isUncommon = false;
                    break;
                }
            }
            
            // If strs[i] is not a subsequence of any other string, update maxLength
            if (isUncommon) {
                maxLength = Math.max(maxLength, strs[i].length());
            }
        }
        
        return maxLength;
    }

    // Helper method to check if string 'a' is a subsequence of string 'b'
    private boolean isSubsequence(String a, String b) {
        int i = 0, j = 0;
        while (i < a.length() && j < b.length()) {
            if (a.charAt(i) == b.charAt(j)) {
                i++;
            }
            j++;
        }
        return i == a.length();
    }
}