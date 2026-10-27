// ──────────────────────────────────────────────────
// Problem  : 3025. Find the Number of Ways to Place People I
// Difficulty: Medium
// Tags     : Array, Math, Geometry, Sorting, Enumeration
// Link     : https://leetcode.com/problems/find-the-number-of-ways-to-place-people-i/
// Runtime  : 0 ms (beats 0%)
// Memory   : 42152000 (beats 0%)
// Language : java
// Copyright: (c) 2026 Shweta-Sripathi. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

import java.util.Arrays;

class Solution {
    public int numberOfPairs(int[][] points) {
        int n = points.length;
        
        // Sort points: ascending by x, and descending by y if x is the same
        Arrays.sort(points, (a, b) -> {
            if (a[0] != b[0]) {
                return Integer.compare(a[0], b[0]);
            }
            return Integer.compare(b[1], a[1]);
        });
        
        int count = 0;
        
        // Check all pairs (i, j) where point i is the upper-left candidate
        for (int i = 0; i < n; i++) {
            int x1 = points[i][0];
            int y1 = points[i][1];
            
            for (int j = i + 1; j < n; j++) {
                int x2 = points[j][0];
                int y2 = points[j][1];
                
                // Point i must be above or at the same level as point j (y1 >= y2)
                if (y1 >= y2) {
                    boolean isValid = true;
                    
                    // Check if any other point k lies inside the bounding box
                    for (int k = 0; k < n; k++) {
                        if (k == i || k == j) continue;
                        int x = points[k][0];
                        int y = points[k][1];
                        
                        if (x >= x1 && x <= x2 && y >= y2 && y <= y1) {
                            isValid = false;
                            break;
                        }
                    }
                    
                    if (isValid) {
                        count++;
                    }
                }
            }
        }
        
        return count;
    }
}