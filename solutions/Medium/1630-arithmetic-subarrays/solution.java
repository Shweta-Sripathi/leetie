// ──────────────────────────────────────────────────
// Problem  : 1630. Arithmetic Subarrays
// Difficulty: Medium
// Tags     : Array, Hash Table, Sorting
// Link     : https://leetcode.com/problems/arithmetic-subarrays/
// Runtime  : 1 ms (beats 0%)
// Memory   : 43008000 (beats 0%)
// Language : java
// Copyright: (c) 2026 Shweta-Sripathi. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        List<Boolean> ans = new ArrayList<>();

        for (int i = 0; i < l.length; i++) {
            ans.add(isArithmetic(nums, l[i], r[i]));
        }

        return ans;
    }

    private boolean isArithmetic(int[] nums, int left, int right) {
        int len = right - left + 1;
        int[] sub = new int[len];
        
        // Copy subarray
        for (int i = 0; i < len; i++) {
            sub[i] = nums[left + i];
        }

        // Sort the subarray
        Arrays.sort(sub);

        int diff = sub[1] - sub[0];

        // Check arithmetic sequence condition
        for (int i = 2; i < len; i++) {
            if (sub[i] - sub[i - 1] != diff) {
                return false;
            }
        }

        return true;
    }
}