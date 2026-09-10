// ──────────────────────────────────────────────────
// Problem  : 838. Push Dominoes
// Difficulty: Medium
// Tags     : Two Pointers, String, Dynamic Programming
// Link     : https://leetcode.com/problems/push-dominoes/
// Runtime  : 28 ms (beats 26%)
// Memory   : 48216000 (beats 16%)
// Language : java
// Copyright: (c) 2026 Shweta-Sripathi. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public String pushDominoes(String dominoes) {
        int n = dominoes.length();
        int[] forces = new int[n];

        // Left to Right: calculate forces pushing right
        int force = 0;
        for (int i = 0; i < n; i++) {
            if (dominoes.charAt(i) == 'R') {
                force = n;
            } else if (dominoes.charAt(i) == 'L') {
                force = 0;
            } else {
                force = Math.max(force - 1, 0);
            }
            forces[i] += force;
        }

        // Right to Left: calculate forces pushing left
        force = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (dominoes.charAt(i) == 'L') {
                force = n;
            } else if (dominoes.charAt(i) == 'R') {
                force = 0;
            } else {
                force = Math.max(force - 1, 0);
            }
            forces[i] -= force;
        }

        // Build result based on net forces
        StringBuilder result = new StringBuilder();
        for (int f : forces) {
            if (f > 0) {
                result.append('R');
            } else if (f < 0) {
                result.append('L');
            } else {
                result.append('.');
            }
        }

        return result.toString();
    }
}