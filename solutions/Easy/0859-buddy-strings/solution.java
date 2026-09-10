// ──────────────────────────────────────────────────
// Problem  : 859. Buddy Strings
// Difficulty: Easy
// Tags     : Hash Table, String
// Link     : https://leetcode.com/problems/buddy-strings/
// Runtime  : 3 ms (beats 45%)
// Memory   : 43944000 (beats 29%)
// Language : java
// Copyright: (c) 2026 Shweta-Sripathi. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    public boolean buddyStrings(String s, String goal) {
        if (s.length() != goal.length()) {
            return false;
        }

        // Case 1: Strings are equal, check if any character appears at least twice
        if (s.equals(goal)) {
            Set<Character> set = new HashSet<>();
            for (char c : s.toCharArray()) {
                if (set.contains(c)) {
                    return true;
                }
                set.add(c);
            }
            return false;
        }

        // Case 2: Strings are different, find indices where characters differ
        List<Integer> diffIndices = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != goal.charAt(i)) {
                diffIndices.add(i);
            }
        }

        // Must have exactly two mismatches that swap to equal each other
        if (diffIndices.size() != 2) {
            return false;
        }

        int i = diffIndices.get(0);
        int j = diffIndices.get(1);

        return s.charAt(i) == goal.charAt(j) && s.charAt(j) == goal.charAt(i);
    }
}