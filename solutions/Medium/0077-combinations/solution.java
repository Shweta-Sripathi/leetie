// ──────────────────────────────────────────────────
// Problem  : 77. Combinations
// Difficulty: Medium
// Tags     : Backtracking
// Link     : https://leetcode.com/problems/combinations/
// Runtime  : 18 ms (beats 73%)
// Memory   : 97536000 (beats 86%)
// Language : java
// Copyright: (c) 2026 Shweta-Sripathi. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), n, k, 1);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> tempList, int n, int k, int start) {
        if (tempList.size() == k) {
            result.add(new ArrayList<>(tempList));
            return;
        }

        for (int i = start; i <= n; i++) {
            tempList.add(i);
            backtrack(result, tempList, n, k, i + 1);
            tempList.remove(tempList.size() - 1);
        }
    }
}