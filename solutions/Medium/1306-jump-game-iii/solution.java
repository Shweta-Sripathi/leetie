// ──────────────────────────────────────────────────
// Problem  : 1306. Jump Game III
// Difficulty: Medium
// Tags     : Array, Depth-First Search, Breadth-First Search
// Link     : https://leetcode.com/problems/jump-game-iii/
// Runtime  : 0 ms (beats 0%)
// Memory   : 42492000 (beats 0%)
// Language : java
// Copyright: (c) 2026 Shweta-Sripathi. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public boolean canReach(int[] arr, int start) {
        // Base case: check bounds and if the current index is already visited (we can mark visited by making it negative)
        if (start < 0 || start >= arr.length || arr[start] < 0) {
            return false;
        }
        
        // If we reach an index with value 0, return true
        if (arr[start] == 0) {
            return true;
        }
        
        // Mark the current index as visited by negating its value
        arr[start] = -arr[start];
        
        // Recursively check both possible jump directions: i + arr[i] and i - arr[i]
        return canReach(arr, start + arr[start]) || canReach(arr, start - arr[start]);
    }
}