// ──────────────────────────────────────────────────
// Problem  : 210. Course Schedule II
// Difficulty: Medium
// Tags     : Depth-First Search, Breadth-First Search, Graph Theory, Topological Sort
// Link     : https://leetcode.com/problems/course-schedule-ii/
// Runtime  : 4 ms (beats 94%)
// Memory   : 46444000 (beats 86%)
// Language : java
// Copyright: (c) 2026 Shweta-Sripathi. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // Build the adjacency list
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] pre : prerequisites) {
            adj.get(pre[1]).add(pre[0]);
        }
        
        // State array: 0 = unvisited, 1 = visiting, 2 = visited
        int[] visit = new int[numCourses];
        List<Integer> orderList = new ArrayList<>();
        
        for (int i = 0; i < numCourses; i++) {
            if (visit[i] == 0) {
                if (hasCycleAndOrder(i, adj, visit, orderList)) {
                    return new int[0]; // Cycle detected, impossible to finish courses
                }
            }
        }
        
        // Convert reverse post-order list to array
        int[] result = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            result[i] = orderList.get(numCourses - 1 - i);
        }
        
        return result;
    }
    
    private boolean hasCycleAndOrder(int node, List<List<Integer>> adj, int[] visit, List<Integer> orderList) {
        if (visit[node] == 1) return true; // Cycle found
        if (visit[node] == 2) return false; // Already visited
        
        visit[node] = 1; // Mark as visiting
        
        for (int neighbor : adj.get(node)) {
            if (hasCycleAndOrder(neighbor, adj, visit, orderList)) {
                return true;
            }
        }
        
        visit[node] = 2; // Mark as fully visited
        orderList.add(node);
        return false;
    }
}