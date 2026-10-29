// ──────────────────────────────────────────────────
// Problem  : 390. Elimination Game
// Difficulty: Medium
// Tags     : Math, Recursion
// Link     : https://leetcode.com/problems/elimination-game/
// Runtime  : 5 ms (beats 7%)
// Memory   : 42496000 (beats 99%)
// Language : java
// Copyright: (c) 2026 Shweta-Sripathi. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int lastRemaining(int n) {
        int head = 1;
        int step = 1;
        boolean leftToRight = true;
        int remaining = n;
        
        while (remaining > 1) {
            // We eliminate from left to right, OR
            // we eliminate from right to left with an odd number of remaining elements
            if (leftToRight || remaining % 2 == 1) {
                head += step;
            }
            
            step *= 2;
            remaining /= 2;
            leftToRight = !leftToRight;
        }
        
        return head;
    }
}