// ──────────────────────────────────────────────────
// Problem  : 1585. Check If String Is Transformable With Substring Sort Operations
// Difficulty: Hard
// Tags     : String, Greedy, Sorting
// Link     : https://leetcode.com/problems/check-if-string-is-transformable-with-substring-sort-operations/
// Runtime  : 25 ms (beats 54%)
// Memory   : 48980000 (beats 74%)
// Language : java
// Copyright: (c) 2026 Shweta-Sripathi. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

import java.util.ArrayDeque;
import java.util.Queue;

class Solution {
    public boolean isTransformable(String s, String t) {
        // Store indices of each digit 0-9 in s
        Queue<Integer>[] pos = new Queue[10];
        for (int i = 0; i < 10; i++) {
            pos[i] = new ArrayDeque<>();
        }
        
        for (int i = 0; i < s.length(); i++) {
            pos[s.charAt(i) - '0'].add(i);
        }
        
        // Try to match each character in t
        for (int i = 0; i < t.length(); i++) {
            int digit = t.charAt(i) - '0';
            
            // If the digit is not available in s, cannot transform
            if (pos[digit].isEmpty()) {
                return false;
            }
            
            int idx = pos[digit].peek();
            
            // Check if any smaller digit appears before 'digit' in s
            for (int k = 0; k < digit; k++) {
                if (!pos[k].isEmpty() && pos[k].peek() < idx) {
                    return false;
                }
            }
            
            // Consume the matched digit
            pos[digit].poll();
        }
        
        return true;
    }
}