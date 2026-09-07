// ──────────────────────────────────────────────────
// Problem  : 39. Combination Sum
// Difficulty: Medium
// Tags     : Array, Backtracking
// Link     : https://leetcode.com/problems/combination-sum/
// Runtime  : 2 ms (beats 95%)
// Memory   : 45692000 (beats 68%)
// Language : java
// Copyright: (c) 2026 Shweta-Sripathi. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(candidates, target, 0, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int[] candidates, int remaining, int start, List<Integer> current, List<List<Integer>> result) {
        if (remaining == 0) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            if (candidates[i] <= remaining) {
                current.add(candidates[i]);
                // Pass `i` (not `i + 1`) to allow reusing the same element
                backtrack(candidates, remaining - candidates[i], i, current, result);
                current.remove(current.size() - 1); // Backtrack
            }
        }
    }
}