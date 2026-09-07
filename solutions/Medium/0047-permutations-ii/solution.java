// ──────────────────────────────────────────────────
// Problem  : 47. Permutations II
// Difficulty: Medium
// Tags     : Array, Backtracking, Sorting
// Link     : https://leetcode.com/problems/permutations-ii/
// Runtime  : 1 ms (beats 0%)
// Memory   : 42988000 (beats 0%)
// Language : java
// Copyright: (c) 2026 Shweta-Sripathi. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums); // Sort to bring duplicate elements next to each other
        boolean[] used = new boolean[nums.length];
        backtrack(nums, used, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int[] nums, boolean[] used, List<Integer> current, List<List<Integer>> result) {
        if (current.size() == nums.length) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }

            // Skip duplicate elements: if nums[i] == nums[i - 1] and nums[i - 1] was not used in this path
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                continue;
            }

            used[i] = true;
            current.add(nums[i]);

            backtrack(nums, used, current, result);

            current.remove(current.size() - 1); // Backtrack
            used[i] = false;
        }
    }
}