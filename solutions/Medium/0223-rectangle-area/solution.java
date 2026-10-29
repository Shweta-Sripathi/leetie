// ──────────────────────────────────────────────────
// Problem  : 223. Rectangle Area
// Difficulty: Medium
// Tags     : Math, Geometry
// Link     : https://leetcode.com/problems/rectangle-area/
// Runtime  : 4 ms (beats 17%)
// Memory   : 43552000 (beats 98%)
// Language : java
// Copyright: (c) 2026 Shweta-Sripathi. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        int area1 = (ax2 - ax1) * (ay2 - ay1);
        int area2 = (bx2 - bx1) * (by2 - by1);
        
        // Calculate overlap width and height
        int overlapWidth = Math.min(ax2, bx2) - Math.max(ax1, bx1);
        int overlapHeight = Math.min(ay2, by2) - Math.max(ay1, by1);
        
        int overlapArea = 0;
        if (overlapWidth > 0 && overlapHeight > 0) {
            overlapArea = overlapWidth * overlapHeight;
        }
        
        // Total area is sum of both minus the overlapping area
        return area1 + area2 - overlapArea;
    }
}