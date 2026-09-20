// ──────────────────────────────────────────────────
// Problem  : 1637. Widest Vertical Area Between Two Points Containing No Points
// Difficulty: Easy
// Tags     : Array, Sorting
// Link     : https://leetcode.com/problems/widest-vertical-area-between-two-points-containing-no-points/
// Runtime  : 1 ms (beats 0%)
// Memory   : 42628000 (beats 0%)
// Language : java
// Copyright: (c) 2026 Shweta-Sripathi. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

import java.util.Arrays;

class Solution {
    public int maxWidthOfVerticalArea(int[][] points) {
        // Sort points primarily by their x-coordinate
        Arrays.sort(points, (a, b) -> Integer.compare(a[0], b[0]));

        int maxWidth = 0;

        // Find the maximum gap between adjacent x-coordinates
        for (int i = 1; i < points.length; i++) {
            int width = points[i][0] - points[i - 1][0];
            maxWidth = Math.max(maxWidth, width);
        }

        return maxWidth;
    }
}