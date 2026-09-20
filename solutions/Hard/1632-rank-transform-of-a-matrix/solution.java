// ──────────────────────────────────────────────────
// Problem  : 1632. Rank Transform of a Matrix
// Difficulty: Hard
// Tags     : Array, Union-Find, Graph Theory, Topological Sort, Sorting, Matrix
// Link     : https://leetcode.com/problems/rank-transform-of-a-matrix/
// Runtime  : 87 ms (beats 86%)
// Memory   : 130024000 (beats 9%)
// Language : java
// Copyright: (c) 2026 Shweta-Sripathi. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

import java.util.*;

class Solution {
    public int[][] matrixRankTransform(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        // Step 1: Group coordinates by their values in sorted order
        TreeMap<Integer, List<int[]>> valueMap = new TreeMap<>();
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                valueMap.computeIfAbsent(matrix[r][c], k -> new ArrayList<>()).add(new int[]{r, c});
            }
        }

        int[] maxRankRow = new int[m];
        int[] maxRankCol = new int[n];
        int[][] answer = new int[m][n];

        // Step 2: Process values in ascending order
        for (int val : valueMap.keySet()) {
            List<int[]> cells = valueMap.get(val);
            DSU dsu = new DSU(m + n);

            // Connect row r and column c + m for all cells with this value
            for (int[] cell : cells) {
                dsu.union(cell[0], cell[1] + m);
            }

            // Group cells by their connected component root
            Map<Integer, List<int[]>> components = new HashMap<>();
            for (int[] cell : cells) {
                int root = dsu.find(cell[0]);
                components.computeIfAbsent(root, k -> new ArrayList<>()).add(cell);
            }

            // Calculate the max rank for each component and update matrix
            for (List<int[]> group : components.values()) {
                int maxRank = 0;

                // Find max rank among all rows and columns in the component
                for (int[] cell : group) {
                    int r = cell[0];
                    int c = cell[1];
                    maxRank = Math.max(maxRank, Math.max(maxRankRow[r], maxRankCol[c]));
                }

                int rank = maxRank + 1;

                // Assign rank and update row/col maximums
                for (int[] cell : group) {
                    int r = cell[0];
                    int c = cell[1];
                    answer[r][c] = rank;
                    maxRankRow[r] = rank;
                    maxRankCol[c] = rank;
                }
            }
        }

        return answer;
    }

    // Disjoint Set Union (DSU) implementation
    private static class DSU {
        private final int[] parent;

        public DSU(int size) {
            parent = new int[size];
            for (int i = 0; i < size; i++) {
                parent[i] = i;
            }
        }

        public int find(int i) {
            if (parent[i] == i) {
                return i;
            }
            return parent[i] = find(parent[i]);
        }

        public void union(int i, int j) {
            int rootI = find(i);
            int rootJ = find(j);
            if (rootI != rootJ) {
                parent[rootI] = rootJ;
            }
        }
    }
}