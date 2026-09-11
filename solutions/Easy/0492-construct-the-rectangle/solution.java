// ──────────────────────────────────────────────────
// Problem  : 492. Construct the Rectangle
// Difficulty: Easy
// Tags     : Math
// Link     : https://leetcode.com/problems/construct-the-rectangle/
// Runtime  : 0 ms (beats 100%)
// Memory   : 42416000 (beats 48%)
// Language : java
// Copyright: (c) 2026 Shweta-Sripathi. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int[] constructRectangle(int area) {
        int w = (int) Math.sqrt(area);
        while (area % w != 0) {
            w--;
        }
        return new int[]{area / w, w};
    }
}