// ──────────────────────────────────────────────────
// Problem  : 1589. Maximum Sum Obtained of Any Permutation
// Difficulty: Medium
// Tags     : Array, Greedy, Sorting, Prefix Sum
// Link     : https://leetcode.com/problems/maximum-sum-obtained-of-any-permutation/
// Runtime  : 36 ms (beats 16%)
// Memory   : 113288000 (beats 20%)
// Language : java
// Copyright: (c) 2026 Shweta-Sripathi. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

import java.util.Arrays;

class Solution {
    public int maxSumRangeQuery(int[] nums, int[][] requests) {
        int n = nums.length;
        long[] freq = new long[n + 1];

        // Mark range increments using a difference array
        for (int[] req : requests) {
            freq[req[0]]++;
            freq[req[1] + 1]--;
        }

        // Compute prefix sums to get actual request frequencies
        for (int i = 1; i < n; i++) {
            freq[i] += freq[i - 1];
        }

        // Take only the valid n frequency elements and sort
        long[] counts = Arrays.copyOf(freq, n);
        Arrays.sort(counts);
        Arrays.sort(nums);

        long totalSum = 0;
        long mod = 1_000_000_007;

        // Pair the largest numbers with the highest frequency indices
        for (int i = 0; i < n; i++) {
            totalSum = (totalSum + counts[i] * nums[i]) % mod;
        }

        return (int) totalSum;
    }
}