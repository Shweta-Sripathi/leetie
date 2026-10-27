// ──────────────────────────────────────────────────
// Problem  : 3011. Find if Array Can Be Sorted
// Difficulty: Medium
// Tags     : Array, Bit Manipulation, Sorting
// Link     : https://leetcode.com/problems/find-if-array-can-be-sorted/
// Runtime  : 0 ms (beats 0%)
// Memory   : 41888000 (beats 0%)
// Language : java
// Copyright: (c) 2026 Shweta-Sripathi. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public boolean canSortArray(int[] nums) {
        int prevMax = 0;
        int currMin = nums[0];
        int currMax = nums[0];
        int currBitSet = Integer.bitCount(nums[0]);

        for (int i = 1; i < nums.length; i++) {
            int bitSet = Integer.bitCount(nums[i]);

            if (bitSet == currBitSet) {
                // Same segment: update min and max of current segment
                currMin = Math.min(currMin, nums[i]);
                currMax = Math.max(currMax, nums[i]);
            } else {
                // New segment: check if previous segment's max exceeds current segment's min
                if (prevMax > currMin) {
                    return false;
                }
                // Transition to new segment
                prevMax = currMax;
                currMin = nums[i];
                currMax = nums[i];
                currBitSet = bitSet;
            }
        }

        // Check boundary condition for the last segment
        return prevMax <= currMin;
    }
}