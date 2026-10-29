// ──────────────────────────────────────────────────
// Problem  : 93. Restore IP Addresses
// Difficulty: Medium
// Tags     : String, Backtracking
// Link     : https://leetcode.com/problems/restore-ip-addresses/
// Runtime  : 1 ms (beats 100%)
// Memory   : 43212000 (beats 94%)
// Language : java
// Copyright: (c) 2026 Shweta-Sripathi. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        backtrack(s, 0, 0, new StringBuilder(), result);
        return result;
    }

    private void backtrack(String s, int startIndex, int dotCount, StringBuilder current, List<String> result) {
        // If we have placed 3 dots, check the remaining segment
        if (dotCount == 3) {
            if (isValid(s, startIndex, s.length() - 1)) {
                result.add(current.toString() + s.substring(startIndex));
            }
            return;
        }

        // Try placing a dot after 1, 2, or 3 digits
        for (int i = startIndex; i < Math.min(startIndex + 3, s.length()); i++) {
            if (isValid(s, startIndex, i)) {
                int len = current.length();
                current.append(s, startIndex, i + 1).append('.');
                backtrack(s, i + 1, dotCount + 1, current, result);
                current.setLength(len); // backtrack
            }
        }
    }

    private boolean isValid(String s, int start, int end) {
        if (start > end) {
            return false;
        }
        // Leading zero check
        if (s.charAt(start) == '0' && start != end) {
            return false;
        }
        int num = 0;
        for (int i = start; i <= end; i++) {
            num = num * 10 + (s.charAt(i) - '0');
        }
        return num >= 0 && num <= 255;
    }
}