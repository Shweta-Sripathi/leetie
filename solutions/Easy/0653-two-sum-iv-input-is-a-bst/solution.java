// ──────────────────────────────────────────────────
// Problem  : 653. Two Sum IV - Input is a BST
// Difficulty: Easy
// Tags     : Hash Table, Two Pointers, Tree, Depth-First Search, Breadth-First Search, Binary Search Tree, Binary Tree
// Link     : https://leetcode.com/problems/two-sum-iv-input-is-a-bst/
// Runtime  : 4 ms (beats 23%)
// Memory   : 46976000 (beats 86%)
// Language : java
// Copyright: (c) 2026 Shweta-Sripathi. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

import java.util.HashSet;
import java.util.Set;

class Solution {
    public boolean findTarget(TreeNode root, int k) {
        Set<Integer> set = new HashSet<>();
        return dfs(root, k, set);
    }
    
    private boolean dfs(TreeNode root, int k, Set<Integer> set) {
        if (root == null) {
            return false;
        }
        
        if (set.contains(k - root.val)) {
            return true;
        }
        
        set.add(root.val);
        
        return dfs(root.left, k, set) || dfs(root.right, k, set);
    }
}