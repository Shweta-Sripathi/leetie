// ──────────────────────────────────────────────────
// Problem  : 399. Evaluate Division
// Difficulty: Medium
// Tags     : Array, String, Depth-First Search, Breadth-First Search, Union-Find, Graph Theory, Shortest Path, Bellman–Ford Algorithm, Floyd–Warshall Algorithm
// Link     : https://leetcode.com/problems/evaluate-division/
// Runtime  : 1 ms (beats 98%)
// Memory   : 46152000 (beats 95%)
// Language : java
// Copyright: (c) 2026 Shweta-Sripathi. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

import java.util.*;

class Solution {
    class Node {
        String key;
        double val;
        Node(String key, double val) {
            this.key = key;
            this.val = val;
        }
    }

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, List<Node>> graph = new HashMap<>();
        
        // Build the graph
        for (int i = 0; i < equations.size(); i++) {
            String u = equations.get(i).get(0);
            String v = equations.get(i).get(1);
            double val = values[i];
            
            graph.putIfAbsent(u, new ArrayList<>());
            graph.get(u).add(new Node(v, val));
            
            graph.putIfAbsent(v, new ArrayList<>());
            graph.get(v).add(new Node(u, 1.0 / val));
        }
        
        double[] result = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            String start = queries.get(i).get(0);
            String end = queries.get(i).get(1);
            
            if (!graph.containsKey(start) || !graph.containsKey(end)) {
                result[i] = -1.0;
            } else if (start.equals(end)) {
                result[i] = 1.0;
            } else {
                Set<String> visited = new HashSet<>();
                result[i] = dfs(start, end, 1.0, graph, visited);
            }
        }
        
        return result;
    }
    
    private double dfs(String curr, String target, double accVal, Map<String, List<Node>> graph, Set<String> visited) {
        if (curr.equals(target)) {
            return accVal;
        }
        
        visited.add(curr);
        for (Node neighbor : graph.get(curr)) {
            if (!visited.contains(neighbor.key)) {
                double ans = dfs(neighbor.key, target, accVal * neighbor.val, graph, visited);
                if (ans != -1.0) {
                    return ans;
                }
            }
        }
        
        return -1.0;
    }
}