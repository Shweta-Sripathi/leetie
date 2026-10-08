// ──────────────────────────────────────────────────
// Problem  : 2169. Count Operations to Obtain Zero
// Difficulty: Easy
// Tags     : Math, Simulation
// Link     : https://leetcode.com/problems/count-operations-to-obtain-zero/
// Runtime  : 0 ms (beats 100%)
// Memory   : 42012000 (beats 82%)
// Language : java
// Copyright: (c) 2026 Shweta-Sripathi. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int countOperations(int num1, int num2) {
        int count = 0;
        
        while (num1 > 0 && num2 > 0) {
            if (num1 >= num2) {
                count += num1 / num2;
                num1 %= num2;
            } else {
                count += num2 / num1;
                num2 %= num1;
            }
        }
        
        return count;
    }
}