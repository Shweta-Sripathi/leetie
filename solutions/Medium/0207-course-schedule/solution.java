// ──────────────────────────────────────────────────
// Problem  : 207. Course Schedule
// Difficulty: Medium
// Tags     : Depth-First Search, Breadth-First Search, Graph Theory, Topological Sort, Directed Acyclic Graph
// Link     : https://leetcode.com/problems/course-schedule/
// Runtime  : 4 ms (beats 93%)
// Memory   : 46672000 (beats 87%)
// Language : java
// Copyright: (c) 2026 Shweta-Sripathi. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

import java.util.ArrayList;
import java.util.List;

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // Build the adjacency list
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] pre : prerequisites) {
            adj.get(pre[1]).add(pre[0]);
        }
        
        // State array: 0 = unvisited, 1 = visiting (currently in recursion stack), 2 = visited
        int[] visit = new int[numCourses];
        
        for (int i = 0; i < numCourses; i++) {
            if (visit[i] == 0) {
                if (hasCycle(i, adj, visit)) {
                    return false; // Cycle detected, cannot finish all courses
                }
            }
        }
        
        return true;
    }
    
    private boolean hasCycle(int node, List<List<Integer>> adj, int[] visit) {
        if (visit[node] == 1) return true; // Cycle found
        if (visit[node] == 2) return false; // Already checked and safe
        
        visit[node] = 1; // Mark as currently visiting
        
        for (int neighbor : adj.get(node)) {
            if (hasCycle(neighbor, adj, visit)) {
                return true;
            }
        }
        
        visit[node] = 2; // Mark as fully visited/safe
        return false;
    }
}