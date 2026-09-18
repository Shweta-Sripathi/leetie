// ──────────────────────────────────────────────────
// Problem  : 657. Robot Return to Origin
// Difficulty: Easy
// Tags     : String, Simulation
// Link     : https://leetcode.com/problems/robot-return-to-origin/
// Runtime  : 0 ms (beats 0%)
// Memory   : 42520000 (beats 0%)
// Language : java
// Copyright: (c) 2026 Shweta-Sripathi. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public boolean judgeCircle(String moves) {
        int x = 0;
        int y = 0;

        for (char move : moves.toCharArray()) {
            if (move == 'U') {
                y++;
            } else if (move == 'D') {
                y--;
            } else if (move == 'R') {
                x++;
            } else if (move == 'L') {
                x--;
            }
        }

        // Return true if the robot ends up back at (0, 0)
        return x == 0 && y == 0;
    }
}