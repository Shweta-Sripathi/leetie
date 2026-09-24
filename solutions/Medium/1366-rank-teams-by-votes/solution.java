// ──────────────────────────────────────────────────
// Problem  : 1366. Rank Teams by Votes
// Difficulty: Medium
// Tags     : Array, Hash Table, String, Sorting, Counting
// Link     : https://leetcode.com/problems/rank-teams-by-votes/
// Runtime  : 6 ms (beats 81%)
// Memory   : 45012000 (beats 93%)
// Language : java
// Copyright: (c) 2026 Shweta-Sripathi. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

import java.util.*;

class Solution {
    public String rankTeams(String[] votes) {
        int numTeams = votes[0].length();
        
        // count[i][j] stores how many votes team ('A' + i) received for position j
        int[][] count = new int[26][numTeams];
        
        // Count votes per team per position
        for (String vote : votes) {
            for (int j = 0; j < numTeams; j++) {
                count[vote.charAt(j) - 'A'][j]++;
            }
        }
        
        // Create a list of participating teams
        Character[] teams = new Character[numTeams];
        for (int i = 0; i < numTeams; i++) {
            teams[i] = votes[0].charAt(i);
        }
        
        // Sort teams based on vote counts per position, tie-breaking alphabetically
        Arrays.sort(teams, (a, b) -> {
            for (int j = 0; j < numTeams; j++) {
                if (count[a - 'A'][j] != count[b - 'A'][j]) {
                    return count[b - 'A'][j] - count[a - 'A'][j]; // Descending order of votes
                }
            }
            return a - b; // Ascending alphabetical order if completely tied
        });
        
        // Build the result string
        StringBuilder sb = new StringBuilder();
        for (char c : teams) {
            sb.append(c);
        }
        
        return sb.toString();
    }
}