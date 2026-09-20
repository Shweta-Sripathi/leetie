// ──────────────────────────────────────────────────
// Problem  : 1782. Count Pairs Of Nodes
// Difficulty: Hard
// Tags     : Array, Hash Table, Two Pointers, Binary Search, Graph Theory, Sorting, Counting
// Link     : https://leetcode.com/problems/count-pairs-of-nodes/
// Runtime  : 222 ms (beats 26%)
// Memory   : 188656000 (beats 40%)
// Language : java
// Copyright: (c) 2026 Shweta-Sripathi. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

import java.util.*;

class Solution {
    public int[] countPairs(int n, int[][] edges, int[] queries) {
        int[] deg = new int[n + 1];
        Map<Long, Integer> edgeMap = new HashMap<>();

        // Step 1: Compute node degrees and count unique edge occurrences
        for (int[] edge : edges) {
            int u = Math.min(edge[0], edge[1]);
            int v = Math.max(edge[0], edge[1]);

            deg[u]++;
            deg[v]++;

            // Encode pair (u, v) into a unique long key
            long key = ((long) u << 32) | v;
            edgeMap.put(key, edgeMap.getOrDefault(key, 0) + 1);
        }

        // Step 2: Sort a copy of the degree array (1-indexed to 0-indexed)
        int[] sortedDeg = new int[n];
        for (int i = 1; i <= n; i++) {
            sortedDeg[i - 1] = deg[i];
        }
        Arrays.sort(sortedDeg);

        int[] result = new int[queries.length];

        // Step 3: Process each query
        for (int k = 0; k < queries.length; k++) {
            int q = queries[k];
            int count = 0;

            // Two-pointer count ignoring shared edges
            int left = 0;
            int right = n - 1;
            while (left < right) {
                if (sortedDeg[left] + sortedDeg[right] > q) {
                    count += (right - left);
                    right--;
                } else {
                    left++;
                }
            }

            // Step 4: Correct for pairs connected by shared edges
            for (Map.Entry<Long, Integer> entry : edgeMap.entrySet()) {
                long key = entry.getKey();
                int shared = entry.getValue();

                int u = (int) (key >> 32);
                int v = (int) (key & 0xFFFFFFFFL);

                int totalDeg = deg[u] + deg[v];
                if (totalDeg > q && totalDeg - shared <= q) {
                    count--;
                }
            }

            result[k] = count;
        }

        return result;
    }
}