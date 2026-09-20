// ──────────────────────────────────────────────────
// Problem  : 1710. Maximum Units on a Truck
// Difficulty: Easy
// Tags     : Array, Greedy, Sorting
// Link     : https://leetcode.com/problems/maximum-units-on-a-truck/
// Runtime  : 0 ms (beats 0%)
// Memory   : 42764000 (beats 0%)
// Language : java
// Copyright: (c) 2026 Shweta-Sripathi. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

import java.util.Arrays;

class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        // Sort boxTypes descending by the number of units per box
        Arrays.sort(boxTypes, (a, b) -> Integer.compare(b[1], a[1]));

        int totalUnits = 0;

        for (int[] box : boxTypes) {
            int numBoxes = box[0];
            int unitsPerBox = box[1];

            // Take as many boxes of this type as possible
            int count = Math.min(truckSize, numBoxes);
            totalUnits += count * unitsPerBox;
            truckSize -= count;

            // Stop if the truck is completely full
            if (truckSize == 0) {
                break;
            }
        }

        return totalUnits;
    }
}