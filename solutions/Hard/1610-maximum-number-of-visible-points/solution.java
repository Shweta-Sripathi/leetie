// ──────────────────────────────────────────────────
// Problem  : 1610. Maximum Number of Visible Points
// Difficulty: Hard
// Tags     : Array, Math, Geometry, Sliding Window, Sorting
// Link     : https://leetcode.com/problems/maximum-number-of-visible-points/
// Runtime  : 0 ms (beats 0%)
// Memory   : 42900000 (beats 0%)
// Language : java
// Copyright: (c) 2026 Shweta-Sripathi. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

import java.util.*;

class Solution {
    public int visiblePoints(List<List<Integer>> points, int angle, List<Integer> location) {
        int posX = location.get(0);
        int posY = location.get(1);

        int sameLocationCount = 0;
        List<Double> angles = new ArrayList<>();

        // Calculate relative polar angle for each point
        for (List<Integer> pt : points) {
            int x = pt.get(0);
            int y = pt.get(1);

            if (x == posX && y == posY) {
                sameLocationCount++;
            } else {
                double angleRad = Math.atan2(y - posY, x - posX);
                double angleDeg = Math.toDegrees(angleRad);
                angles.add(angleDeg);
            }
        }

        // Sort angles
        Collections.sort(angles);

        // Duplicate angles by adding 360 to handle wrap-around
        int size = angles.size();
        for (int i = 0; i < size; i++) {
            angles.add(angles.get(i) + 360.0);
        }

        // Sliding window to find max points within 'angle' degree window
        int maxVisible = 0;
        int left = 0;

        for (int right = 0; right < angles.size(); right++) {
            while (angles.get(right) - angles.get(left) > angle) {
                left++;
            }
            maxVisible = Math.max(maxVisible, right - left + 1);
        }

        return maxVisible + sameLocationCount;
    }
}