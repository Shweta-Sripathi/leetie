// ──────────────────────────────────────────────────
// Problem  : 395. Longest Substring with At Least K Repeating Characters
// Difficulty: Medium
// Tags     : Hash Table, String, Divide and Conquer, Sliding Window
// Link     : https://leetcode.com/problems/longest-substring-with-at-least-k-repeating-characters/
// Runtime  : 72 ms (beats 14%)
// Memory   : 47508000 (beats 8%)
// Language : java
// Copyright: (c) 2026 Shweta-Sripathi. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int longestSubstring(String s, int k) {
        int n = s.length();
        if (n == 0 || n < k) {
            return 0;
        }
        if (k <= 1) {
            return n;
        }
        
        // Count frequencies of each character
        int[] count = new int[26];
        char[] chars = s.toCharArray();
        for (char c : chars) {
            count[c - 'a']++;
        }
        
        // Find the first character that appears fewer than k times
        for (int i = 0; i < n; i++) {
            char c = chars[i];
            if (count[c - 'a'] < k) {
                // Split the string at this character and recurse on both parts
                int left = longestSubstring(s.substring(0, i), k);
                int right = longestSubstring(s.substring(i + 1), k);
                return Math.max(left, right);
            }
        }
        
        // If all characters meet or exceed frequency k, the whole string is valid
        return n;
    }
}