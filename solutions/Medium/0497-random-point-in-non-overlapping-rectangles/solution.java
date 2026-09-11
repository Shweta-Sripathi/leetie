// ──────────────────────────────────────────────────
// Problem  : 497. Random Point in Non-overlapping Rectangles
// Difficulty: Medium
// Tags     : Array, Math, Binary Search, Reservoir Sampling, Prefix Sum, Ordered Set, Randomized
// Link     : https://leetcode.com/problems/random-point-in-non-overlapping-rectangles/
// Runtime  : 7 ms (beats 0%)
// Memory   : 42884000 (beats 0%)
// Language : java
// Copyright: (c) 2026 Shweta-Sripathi. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

import java.util.Random;
import java.util.TreeMap;

class Solution {
    private TreeMap<Integer, Integer> map;
    private int[][] rects;
    private int totalPoints;
    private Random random;

    public Solution(int[][] rects) {
        this.rects = rects;
        this.map = new TreeMap<>();
        this.random = new Random();
        this.totalPoints = 0;

        for (int i = 0; i < rects.length; i++) {
            int[] rect = rects[i];
            int points = (rect[2] - rect[0] + 1) * (rect[3] - rect[1] + 1);
            totalPoints += points;
            map.put(totalPoints, i);
        }
    }

    public int[] pick() {
        // Pick a random point number between 1 and totalPoints
        int target = random.nextInt(totalPoints) + 1;
        
        // Find the corresponding rectangle using binary search
        int rectIndex = map.ceilingEntry(target).getValue();
        int[] rect = rects[rectIndex];

        // Uniformly pick x and y coordinates inside the selected rectangle
        int x = rect[0] + random.nextInt(rect[2] - rect[0] + 1);
        int y = rect[1] + random.nextInt(rect[3] - rect[1] + 1);

        return new int[]{x, y};
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(rects);
 * int[] param_1 = obj.pick();
 */