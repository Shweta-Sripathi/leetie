// ──────────────────────────────────────────────────
// Problem  : 1345. Jump Game IV
// Difficulty: Hard
// Tags     : Array, Hash Table, Breadth-First Search
// Link     : https://leetcode.com/problems/jump-game-iv/
// Runtime  : 71 ms (beats 45%)
// Memory   : 86056000 (beats 82%)
// Language : java
// Copyright: (c) 2026 Shweta-Sripathi. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

import java.util.*;

class Solution {
    public int minJumps(int[] arr) {
        int n = arr.length;
        if (n <= 1) return 0;

        // Group all indices by their value
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < n; i++) {
            graph.computeIfAbsent(arr[i], k -> new ArrayList<>()).add(i);
        }

        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n];

        queue.offer(0);
        visited[0] = true;
        int steps = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int curr = queue.poll();

                // Reached the destination
                if (curr == n - 1) {
                    return steps;
                }

                List<Integer> nextIndices = graph.get(arr[curr]);

                // Option 1: Jump to same values
                if (nextIndices != null) {
                    for (int next : nextIndices) {
                        if (!visited[next]) {
                            visited[next] = true;
                            queue.offer(next);
                        }
                    }
                    // IMPORTANT: Clear the entry to avoid processing same-value jumps repeatedly (prevents TLE)
                    graph.remove(arr[curr]);
                }

                // Option 2: Jump right (i + 1)
                if (curr + 1 < n && !visited[curr + 1]) {
                    visited[curr + 1] = true;
                    queue.offer(curr + 1);
                }

                // Option 3: Jump left (i - 1)
                if (curr - 1 >= 0 && !visited[curr - 1]) {
                    visited[curr - 1] = true;
                    queue.offer(curr - 1);
                }
            }
            steps++;
        }

        return -1;
    }
}