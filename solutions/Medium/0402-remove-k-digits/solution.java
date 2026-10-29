// ──────────────────────────────────────────────────
// Problem  : 402. Remove K Digits
// Difficulty: Medium
// Tags     : String, Stack, Greedy, Monotonic Stack
// Link     : https://leetcode.com/problems/remove-k-digits/
// Runtime  : 20 ms (beats 56%)
// Memory   : 47540000 (beats 44%)
// Language : java
// Copyright: (c) 2026 Shweta-Sripathi. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

import java.util.Stack;

class Solution {
    public String removeKdigits(String num, int k) {
        int len = num.length();
        if (k == len) {
            return "0";
        }
        
        Stack<Character> stack = new Stack<>();
        
        for (int i = 0; i < len; i++) {
            char c = num.charAt(i);
            // Maintain a monotonic increasing stack: remove larger elements before smaller ones
            while (!stack.isEmpty() && k > 0 && stack.peek() > c) {
                stack.pop();
                k--;
            }
            stack.push(c);
        }
        
        // If we still need to remove digits, remove them from the end
        while (k > 0 && !stack.isEmpty()) {
            stack.pop();
            k--;
        }
        
        // Construct the number from the stack and remove leading zeros
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        sb.reverse();
        
        // Strip leading zeros
        while (sb.length() > 1 && sb.charAt(0) == '0') {
            sb.deleteCharAt(0);
        }
        
        return sb.length() == 0 ? "0" : sb.toString();
    }
}