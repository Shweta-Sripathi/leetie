// ──────────────────────────────────────────────────
// Problem  : 539. Minimum Time Difference
// Difficulty: Medium
// Tags     : Array, Math, String, Sorting
// Link     : https://leetcode.com/problems/minimum-time-difference/
// Runtime  : 2 ms (beats 99%)
// Memory   : 46124000 (beats 98%)
// Language : java
// Copyright: (c) 2026 Shweta-Sripathi. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

import java.util.List;

class Solution {
    public int findMinDifference(List<String> timePoints) {
        // More time points than minutes in a day implies duplicates exist
        if (timePoints.size() > 1440) {
            return 0;
        }

        boolean[] minutes = new boolean[1440];

        for (String time : timePoints) {
            int h = (time.charAt(0) - '0') * 10 + (time.charAt(1) - '0');
            int m = (time.charAt(3) - '0') * 10 + (time.charAt(4) - '0');
            int totalMinutes = h * 60 + m;

            if (minutes[totalMinutes]) {
                return 0; // Duplicate time point found
            }
            minutes[totalMinutes] = true;
        }

        int minDiff = Integer.MAX_VALUE;
        int first = -1;
        int prev = -1;

        for (int i = 0; i < 1440; i++) {
            if (minutes[i]) {
                if (first == -1) {
                    first = i;
                } else {
                    minDiff = Math.min(minDiff, i - prev);
                }
                prev = i;
            }
        }

        // Circular difference between last and first time point
        minDiff = Math.min(minDiff, 1440 + first - prev);

        return minDiff;
    }
}