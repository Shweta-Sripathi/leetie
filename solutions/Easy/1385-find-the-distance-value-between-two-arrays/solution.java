// ──────────────────────────────────────────────────
// Problem  : 1385. Find the Distance Value Between Two Arrays
// Difficulty: Easy
// Tags     : Array, Two Pointers, Binary Search, Sorting
// Link     : https://leetcode.com/problems/find-the-distance-value-between-two-arrays/
// Runtime  : 3 ms (beats 99%)
// Memory   : 46408000 (beats 34%)
// Language : java
// Copyright: (c) 2026 Shweta-Sripathi. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        int distanceValue = 0;

        for (int x : arr1) {
            boolean isValid = true;
            for (int y : arr2) {
                if (Math.abs(x - y) <= d) {
                    isValid = false;
                    break;
                }
            }
            if (isValid) {
                distanceValue++;
            }
        }

        return distanceValue;
    }
}