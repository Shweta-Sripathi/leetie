// ──────────────────────────────────────────────────
// Problem  : 32. Longest Valid Parentheses
// Difficulty: Hard
// Tags     : String, Dynamic Programming, Stack, Bracket Sequences
// Link     : https://leetcode.com/problems/longest-valid-parentheses/
// Runtime  : 7 ms (beats 6%)
// Memory   : 46780000 (beats 12%)
// Language : java
// Copyright: (c) 2026 Shweta-Sripathi. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

import java.util.Stack;

class Solution {
    public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        // Push -1 onto the stack as a base index for calculating valid substring lengths
        stack.push(-1);
        int maxLen = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.isEmpty()) {
                    // Current ')' becomes the new base index for valid substrings
                    stack.push(i);
                } else {
                    // Length of the valid substring ending at the current index
                    maxLen = Math.max(maxLen, i - stack.peek());
                }
            }
        }

        return maxLen;
    }
}