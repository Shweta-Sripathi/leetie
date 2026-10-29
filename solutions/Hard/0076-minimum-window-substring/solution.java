// ──────────────────────────────────────────────────
// Problem  : 76. Minimum Window Substring
// Difficulty: Hard
// Tags     : Hash Table, String, Sliding Window
// Link     : https://leetcode.com/problems/minimum-window-substring/
// Runtime  : 3 ms (beats 70%)
// Memory   : 44924000 (beats 95%)
// Language : java
// Copyright: (c) 2026 Shweta-Sripathi. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public String minWindow(String s, String t) {
        if (s == null || t == null || s.length() == 0 || t.length() == 0 || s.length() < t.length()) {
            return "";
        }

        int[] targetFreq = new int[128];
        for (int i = 0; i < t.length(); i++) {
            targetFreq[t.charAt(i)]++;
        }

        int required = 0;
        for (int i = 0; i < 128; i++) {
            if (targetFreq[i] > 0) {
                required++;
            }
        }

        int left = 0, right = 0;
        int formed = 0;
        int[] windowFreq = new int[128];

        // Store length of window, left, right
        int[] ans = {-1, 0, 0}; // {length, left, right}

        while (right < s.length()) {
            char c = s.charAt(right);
            windowFreq[c]++;

            if (targetFreq[c] > 0 && windowFreq[c] == targetFreq[c]) {
                formed++;
            }

            // Try and contract the window until it ceases to be 'desirable'
            while (left <= right && formed == required) {
                c = s.charAt(left);

                // Save the smallest window
                if (ans[0] == -1 || right - left + 1 < ans[0]) {
                    ans[0] = right - left + 1;
                    ans[1] = left;
                    ans[2] = right;
                }

                windowFreq[c]--;
                if (targetFreq[c] > 0 && windowFreq[c] < targetFreq[c]) {
                    formed--;
                }

                left++;
            }

            right++;
        }

        return ans[0] == -1 ? "" : s.substring(ans[1], ans[2] + 1);
    }
}