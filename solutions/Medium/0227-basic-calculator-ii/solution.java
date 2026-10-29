// ──────────────────────────────────────────────────
// Problem  : 227. Basic Calculator II
// Difficulty: Medium
// Tags     : Math, String, Stack
// Link     : https://leetcode.com/problems/basic-calculator-ii/
// Runtime  : 29 ms (beats 11%)
// Memory   : 47400000 (beats 76%)
// Language : java
// Copyright: (c) 2026 Shweta-Sripathi. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

import java.util.Stack;

class Solution {
    public int calculate(String s) {
        if (s == null || s.isEmpty()) return 0;
        
        Stack<Integer> stack = new Stack<>();
        int currentNumber = 0;
        char operation = '+';
        int len = s.length();
        
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            
            if (Character.isDigit(c)) {
                currentNumber = (currentNumber * 10) + (c - '0');
            }
            
            // If current char is an operator, or we reached the end of the string
            if ((!Character.isDigit(c) && !Character.isWhitespace(c)) || i == len - 1) {
                if (operation == '+') {
                    stack.push(currentNumber);
                } else if (operation == '-') {
                    stack.push(-currentNumber);
                } else if (operation == '*') {
                    stack.push(stack.pop() * currentNumber);
                } else if (operation == '/') {
                    stack.push(stack.pop() / currentNumber);
                }
                operation = c;
                currentNumber = 0;
            }
        }
        
        int result = 0;
        while (!stack.isEmpty()) {
            result += stack.pop();
        }
        
        return result;
    }
}