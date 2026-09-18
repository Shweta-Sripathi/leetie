// ──────────────────────────────────────────────────
// Problem  : 736. Parse Lisp Expression
// Difficulty: Hard
// Tags     : Hash Table, String, Stack, Recursion
// Link     : https://leetcode.com/problems/parse-lisp-expression/
// Runtime  : 5 ms (beats 56%)
// Memory   : 44976000 (beats 30%)
// Language : java
// Copyright: (c) 2026 Shweta-Sripathi. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

import java.util.*;

class Solution {
    public int evaluate(String expression) {
        return evaluate(expression, new HashMap<>());
    }

    private int evaluate(String expr, Map<String, Integer> parentScope) {
        // Case 1: Integers (positive or negative)
        if (expr.charAt(0) != '(') {
            if (Character.isDigit(expr.charAt(0)) || expr.charAt(0) == '-') {
                return Integer.parseInt(expr);
            }
            // Variable lookup from the current scope
            return parentScope.get(expr);
        }

        // Create a local scope copying all parent bindings
        Map<String, Integer> localScope = new HashMap<>(parentScope);

        // Remove outer parentheses: "(let ...)" -> "let ..."
        String inner = expr.substring(1, expr.length() - 1);
        List<String> tokens = parseTokens(inner);

        String op = tokens.get(0);

        if (op.equals("add")) {
            return evaluate(tokens.get(1), localScope) + evaluate(tokens.get(2), localScope);
        } else if (op.equals("mult")) {
            return evaluate(tokens.get(1), localScope) * evaluate(tokens.get(2), localScope);
        } else { // "let"
            for (int i = 1; i < tokens.size() - 1; i += 2) {
                String var = tokens.get(i);
                int val = evaluate(tokens.get(i + 1), localScope);
                localScope.put(var, val);
            }
            // Evaluate the final return expression in the let block
            return evaluate(tokens.get(tokens.size() - 1), localScope);
        }
    }

    // Parses a Lisp statement into top-level tokens while respecting sub-expression parentheses
    private List<String> parseTokens(String expr) {
        List<String> tokens = new ArrayList<>();
        int n = expr.length();
        int i = 0;

        while (i < n) {
            if (expr.charAt(i) == ' ') {
                i++;
                continue;
            }

            int start = i;
            if (expr.charAt(i) == '(') {
                int bal = 0;
                while (i < n) {
                    if (expr.charAt(i) == '(') bal++;
                    else if (expr.charAt(i) == ')') bal--;
                    i++;
                    if (bal == 0) break;
                }
            } else {
                while (i < n && expr.charAt(i) != ' ') {
                    i++;
                }
            }
            tokens.add(expr.substring(start, i));
        }

        return tokens;
    }
}
