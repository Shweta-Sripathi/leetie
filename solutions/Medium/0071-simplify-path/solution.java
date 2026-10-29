// ──────────────────────────────────────────────────
// Problem  : 71. Simplify Path
// Difficulty: Medium
// Tags     : String, Stack
// Link     : https://leetcode.com/problems/simplify-path/
// Runtime  : 5 ms (beats 55%)
// Memory   : 44012000 (beats 98%)
// Language : java
// Copyright: (c) 2026 Shweta-Sripathi. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

import java.util.Stack;

class Solution {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        String[] components = path.split("/");

        for (String component : components) {
            if (component.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else if (!component.equals(".") && !component.isEmpty()) {
                stack.push(component);
            }
        }

        StringBuilder result = new StringBuilder();
        for (String dir : stack) {
            result.append("/").append(dir);
        }

        return result.length() > 0 ? result.toString() : "/";
    }
}