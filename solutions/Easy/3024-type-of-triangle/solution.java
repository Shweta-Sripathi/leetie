// ──────────────────────────────────────────────────
// Problem  : 3024. Type of Triangle
// Difficulty: Easy
// Tags     : Array, Math, Sorting, Polygons
// Link     : https://leetcode.com/problems/type-of-triangle/
// Runtime  : 0 ms (beats 0%)
// Memory   : 41872000 (beats 0%)
// Language : java
// Copyright: (c) 2026 Shweta-Sripathi. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public String triangleType(int[] nums) {
        int a = nums[0];
        int b = nums[1];
        int c = nums[2];

        // Step 1: Check triangle inequality rule
        if (a + b <= c || a + c <= b || b + c <= a) {
            return "none";
        }

        // Step 2: Determine the type of triangle
        if (a == b && b == c) {
            return "equilateral";
        } else if (a == b || b == c || a == c) {
            return "isosceles";
        } else {
            return "scalene";
        }
    }
}