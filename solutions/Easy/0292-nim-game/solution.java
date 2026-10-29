// ──────────────────────────────────────────────────
// Problem  : 292. Nim Game
// Difficulty: Easy
// Tags     : Math, Brainteaser, Minimax, Game Theory, Nim Game, Impartial Game
// Link     : https://leetcode.com/problems/nim-game/
// Runtime  : 0 ms (beats 100%)
// Memory   : 41580000 (beats 92%)
// Language : java
// Copyright: (c) 2026 Shweta-Sripathi. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public boolean canWinNim(int n) {
        return n % 4 != 0;
    }
}