// ──────────────────────────────────────────────────
// Problem  : 830. Positions of Large Groups
// Difficulty: Easy
// Tags     : String
// Link     : https://leetcode.com/problems/positions-of-large-groups/
// Runtime  : 0 ms (beats 0%)
// Memory   : 43000000 (beats 0%)
// Language : java
// Copyright: (c) 2026 Shweta-Sripathi. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> largeGroupPositions(String s) {
        List<List<Integer>> result = new ArrayList<>();
        int i = 0, n = s.length();

        for (int j = 0; j < n; j++) {
            if (j == n - 1 || s.charAt(j) != s.charAt(j + 1)) {
                if (j - i + 1 >= 3) {
                    result.add(Arrays.asList(i, j));
                }
                i = j + 1;
            }
        }

        return result;
    }
}