// ──────────────────────────────────────────────────
// Problem  : 756. Pyramid Transition Matrix
// Difficulty: Medium
// Tags     : Hash Table, String, Backtracking, Bit Manipulation
// Link     : https://leetcode.com/problems/pyramid-transition-matrix/
// Runtime  : 103 ms (beats 69%)
// Memory   : 49304000 (beats 32%)
// Language : java
// Copyright: (c) 2026 Shweta-Sripathi. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

import java.util.*;

class Solution {
    public boolean pyramidTransition(String bottom, List<String> allowed) {
        // Map pairs of characters (e.g. "AB") to possible top characters (e.g. "C", "D")
        Map<String, List<Character>> transitions = new HashMap<>();
        for (String pattern : allowed) {
            String base = pattern.substring(0, 2);
            char top = pattern.charAt(2);
            transitions.computeIfAbsent(base, k -> new ArrayList<>()).add(top);
        }

        // Memoization set to store failed rows/states to avoid redundant computation
        Set<String> memo = new HashSet<>();
        return canBuild(bottom, "", transitions, memo);
    }

    private boolean canBuild(String currRow, String nextRow, Map<String, List<Character>> transitions, Set<String> memo) {
        // Base case: successfully built the pyramid to the top block
        if (currRow.length() == 1) {
            return true;
        }

        // When the current row is completely processed, move up to the next row
        if (nextRow.length() == currRow.length() - 1) {
            if (memo.contains(nextRow)) {
                return false;
            }
            boolean possible = canBuild(nextRow, "", transitions, memo);
            if (!possible) {
                memo.add(nextRow);
            }
            return possible;
        }

        // Find possible top blocks for the adjacent pair in the current row
        int idx = nextRow.length();
        String pair = currRow.substring(idx, idx + 2);

        if (!transitions.containsKey(pair)) {
            return false;
        }

        // Try every possible character for the top position
        for (char top : transitions.get(pair)) {
            if (canBuild(currRow, nextRow + top, transitions, memo)) {
                return true;
            }
        }

        return false;
    }
}