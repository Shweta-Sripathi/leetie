// ──────────────────────────────────────────────────
// Problem  : 649. Dota2 Senate
// Difficulty: Medium
// Tags     : String, Greedy, Queue
// Link     : https://leetcode.com/problems/dota2-senate/
// Runtime  : 11 ms (beats 80%)
// Memory   : 47068000 (beats 56%)
// Language : java
// Copyright: (c) 2026 Shweta-Sripathi. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public String predictPartyVictory(String senate) {
        Queue<Integer> radiant = new LinkedList<>();
        Queue<Integer> dire = new LinkedList<>();
        int n = senate.length();

        // Populate queues with indices of respective senators
        for (int i = 0; i < n; i++) {
            if (senate.charAt(i) == 'R') {
                radiant.offer(i);
            } else {
                dire.offer(i);
            }
        }

        // Process rounds until one party has no senators left
        while (!radiant.isEmpty() && !dire.isEmpty()) {
            int rIndex = radiant.poll();
            int dIndex = dire.poll();

            // The senator with the smaller index acts first and bans the other
            if (rIndex < dIndex) {
                radiant.offer(rIndex + n); // Move to the next round
            } else {
                dire.offer(dIndex + n);    // Move to the next round
            }
        }

        return radiant.isEmpty() ? "Dire" : "Radiant";
    }
}