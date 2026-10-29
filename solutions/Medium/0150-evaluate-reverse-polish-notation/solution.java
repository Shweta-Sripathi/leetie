// ──────────────────────────────────────────────────
// Problem  : 150. Evaluate Reverse Polish Notation
// Difficulty: Medium
// Tags     : Array, Math, Stack
// Link     : https://leetcode.com/problems/evaluate-reverse-polish-notation/
// Runtime  : 7 ms (beats 44%)
// Memory   : 44604000 (beats 96%)
// Language : java
// Copyright: (c) 2026 Shweta-Sripathi. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

import java.util.Stack;

class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for (String token : tokens) {
            if (token.equals("+")) {
                int b = stack.pop();
                int a = stack.pop();
                stack.push(a + b);
            } else if (token.equals("-")) {
                int b = stack.pop();
                int a = stack.pop();
                stack.push(a - b);
            } else if (token.equals("*")) {
                int b = stack.pop();
                int a = stack.pop();
                stack.push(a * b);
            } else if (token.equals("/")) {
                int b = stack.pop();
                int a = stack.pop();
                stack.push(a / b);
            } else {
                stack.push(Integer.parseInt(token));
            }
        }

        return stack.pop();
    }
}