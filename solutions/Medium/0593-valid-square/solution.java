// ──────────────────────────────────────────────────
// Problem  : 593. Valid Square
// Difficulty: Medium
// Tags     : Math, Geometry
// Link     : https://leetcode.com/problems/valid-square/
// Runtime  : 1 ms (beats 95%)
// Memory   : 43128000 (beats 90%)
// Language : java
// Copyright: (c) 2026 Shweta-Sripathi. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

import java.util.HashSet;
import java.util.Set;

class Solution {
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        Set<Integer> set = new HashSet<>();
        
        int[] dists = new int[] {
            distSq(p1, p2),
            distSq(p1, p3),
            distSq(p1, p4),
            distSq(p2, p3),
            distSq(p2, p4),
            distSq(p3, p4)
        };
        
        for (int d : dists) {
            if (d == 0) {
                return false; // Duplicate points found
            }
            set.add(d);
        }
        
        return set.size() == 2;
    }
    
    private int distSq(int[] p1, int[] p2) {
        return (p1[0] - p2[0]) * (p1[0] - p2[0]) + (p1[1] - p2[1]) * (p1[1] - p2[1]);
    }
}