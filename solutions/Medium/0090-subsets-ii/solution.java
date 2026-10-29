// ──────────────────────────────────────────────────
// Problem  : 90. Subsets II
// Difficulty: Medium
// Tags     : Array, Backtracking, Bit Manipulation
// Link     : https://leetcode.com/problems/subsets-ii/
// Runtime  : 3 ms (beats 58%)
// Memory   : 44648000 (beats 88%)
// Language : java
// Copyright: (c) 2026 Shweta-Sripathi. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums); // Sort to handle duplicates easily
        backtrack(result, new ArrayList<>(), nums, 0);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> tempList, int[] nums, int start) {
        result.add(new ArrayList<>(tempList));
        
        for (int i = start; i < nums.length; i++) {
            // Skip duplicates at the same level of recursion
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }
            
            tempList.add(nums[i]);
            backtrack(result, tempList, nums, i + 1);
            tempList.remove(tempList.size() - 1);
        }
    }
}