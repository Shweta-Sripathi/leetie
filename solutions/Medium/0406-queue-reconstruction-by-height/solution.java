// ──────────────────────────────────────────────────
// Problem  : 406. Queue Reconstruction by Height
// Difficulty: Medium
// Tags     : Array, Binary Indexed Tree, Segment Tree, Sorting
// Link     : https://leetcode.com/problems/queue-reconstruction-by-height/
// Runtime  : 7 ms (beats 92%)
// Memory   : 46428000 (beats 99%)
// Language : java
// Copyright: (c) 2026 Shweta-Sripathi. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[][] reconstructQueue(int[][] people) {
        // Sort people:
        // 1. Descending by height (h)
        // 2. Ascending by k-value if heights are equal
        Arrays.sort(people, (a, b) -> {
            if (a[0] != b[0]) {
                return Integer.compare(b[0], a[0]); // Descending height
            } else {
                return Integer.compare(a[1], b[1]); // Ascending k-value
            }
        });

        List<int[]> result = new ArrayList<>();
        
        // Insert each person into the list at index equal to their k-value
        for (int[] person : people) {
            result.add(person[1], person);
        }

        return result.toArray(new int[people.length][]);
    }
}