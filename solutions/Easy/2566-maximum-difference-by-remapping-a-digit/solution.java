// ──────────────────────────────────────────────────
// Problem  : 2566. Maximum Difference by Remapping a Digit
// Difficulty: Easy
// Tags     : Math, Greedy
// Link     : https://leetcode.com/problems/maximum-difference-by-remapping-a-digit/
// Runtime  : 1 ms (beats 94%)
// Memory   : 42272000 (beats 66%)
// Language : java
// Copyright: (c) 2026 Shweta-Sripathi. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int minMaxDifference(int num) {
        String s = Integer.toString(num);
        
        // 1. To get the maximum value:
        // Replace the first digit that is NOT '9' with '9'.
        String maxStr = s;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != '9') {
                maxStr = s.replace(s.charAt(i), '9');
                break;
            }
        }
        
        // 2. To get the minimum value:
        // Replace the first digit (s.charAt(0)) with '0'.
        String minStr = s.replace(s.charAt(0), '0');
        
        // Calculate and return the difference
        return Integer.parseInt(maxStr) - Integer.parseInt(minStr);
    }
}