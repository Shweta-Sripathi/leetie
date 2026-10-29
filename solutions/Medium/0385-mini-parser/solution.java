// ──────────────────────────────────────────────────
// Problem  : 385. Mini Parser
// Difficulty: Medium
// Tags     : String, Stack, Depth-First Search
// Link     : https://leetcode.com/problems/mini-parser/
// Runtime  : 8 ms (beats 41%)
// Memory   : 47352000 (beats 79%)
// Language : java
// Copyright: (c) 2026 Shweta-Sripathi. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

import java.util.Stack;

class Solution {
    public NestedInteger deserialize(String s) {
        if (s == null || s.isEmpty()) {
            return null;
        }
        
        // If it's just a single integer without brackets
        if (s.charAt(0) != '[') {
            return new NestedInteger(Integer.parseInt(s));
        }
        
        Stack<NestedInteger> stack = new Stack<>();
        NestedInteger curr = null;
        int l = 0;
        
        for (int r = 0; r < s.length(); r++) {
            char c = s.charAt(r);
            
            if (c == '[') {
                if (curr != null) {
                    stack.push(curr);
                }
                curr = new NestedInteger();
                l = r + 1;
            } else if (c == ',' || c == ']') {
                if (r > l) {
                    int val = Integer.parseInt(s.substring(l, r));
                    curr.add(new NestedInteger(val));
                }
                l = r + 1;
                
                if (c == ']' && !stack.isEmpty()) {
                    NestedInteger parent = stack.pop();
                    parent.add(curr);
                    curr = parent;
                }
            }
        }
        
        return curr;
    }
}