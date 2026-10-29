// ──────────────────────────────────────────────────
// Problem  : 216. Combination Sum III
// Difficulty: Medium
// Tags     : Array, Backtracking
// Link     : https://leetcode.com/problems/combination-sum-iii/
// Runtime  : 1 ms (beats 24%)
// Memory   : 41820000 (beats 94%)
// Language : java
// Copyright: (c) 2026 Shweta-Sripathi. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), k, n, 1);
        return result;
    }
    
    private void backtrack(List<List<Integer>> result, List<Integer> tempList, int k, int remain, int start) {
        // If the combination is valid (size k and sum equals 0)
        if (tempList.size() == k && remain == 0) {
            result.add(new ArrayList<>(tempList));
            return;
        }
        
        // Pruning: if size exceeds k or remaining sum is less than 0, stop searching
        if (tempList.size() > k || remain < 0) {
            return;
        }
        
        // Iterate through numbers 1 to 9
        for (int i = start; i <= 9; i++) {
            tempList.add(i);
            backtrack(result, tempList, k, remain - i, i + 1);
            tempList.remove(tempList.size() - 1);
        }
    }
}