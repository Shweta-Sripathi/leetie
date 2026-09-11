// ──────────────────────────────────────────────────
// Problem  : 519. Random Flip Matrix
// Difficulty: Medium
// Tags     : Hash Table, Math, Reservoir Sampling, Randomized
// Link     : https://leetcode.com/problems/random-flip-matrix/
// Runtime  : 25 ms (beats 50%)
// Memory   : 47404000 (beats 34%)
// Language : java
// Copyright: (c) 2026 Shweta-Sripathi. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

class Solution {
    private int rows;
    private int cols;
    private int total;
    private Map<Integer, Integer> map;
    private Random random;

    public Solution(int m, int n) {
        this.rows = m;
        this.cols = n;
        this.total = m * n;
        this.map = new HashMap<>();
        this.random = new Random();
    }
    
    public int[] flip() {
        int r = random.nextInt(total);
        total--;

        // Get the mapped value for r if it exists, otherwise r itself
        int actualIndex = map.getOrDefault(r, r);

        // Get the mapped value for the last element (total) if it exists, otherwise total itself
        int lastValue = map.getOrDefault(total, total);

        // Swap: assign the last available element's actual value to key r
        map.put(r, lastValue);

        return new int[]{actualIndex / cols, actualIndex % cols};
    }
    
    public void reset() {
        map.clear();
        total = rows * cols;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(m, n);
 * int[] param_1 = obj.flip();
 * obj.reset();
 */