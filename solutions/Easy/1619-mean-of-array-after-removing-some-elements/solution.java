// ──────────────────────────────────────────────────
// Problem  : 1619. Mean of Array After Removing Some Elements
// Difficulty: Easy
// Tags     : Array, Sorting
// Link     : https://leetcode.com/problems/mean-of-array-after-removing-some-elements/
// Runtime  : 5 ms (beats 100%)
// Memory   : 47180000 (beats 74%)
// Language : java
// Copyright: (c) 2026 Shweta-Sripathi. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

import java.util.Arrays;

class Solution {
    public double trimMean(int[] arr) {
        Arrays.sort(arr);
        int n = arr.length;
        int k = n / 20; // 5% of elements

        double sum = 0;
        for (int i = k; i < n - k; i++) {
            sum += arr[i];
        }

        return sum / (n - 2 * k);
    }
}