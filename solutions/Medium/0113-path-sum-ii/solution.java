// ──────────────────────────────────────────────────
// Problem  : 113. Path Sum II
// Difficulty: Medium
// Tags     : Backtracking, Tree, Depth-First Search, Binary Tree
// Link     : https://leetcode.com/problems/path-sum-ii/
// Runtime  : 1 ms (beats 100%)
// Memory   : 44964000 (beats 91%)
// Language : java
// Copyright: (c) 2026 Shweta-Sripathi. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        findPaths(root, targetSum, new ArrayList<>(), result);
        return result;
    }

    private void findPaths(TreeNode node, int targetSum, List<Integer> currentPath, List<List<Integer>> result) {
        if (node == null) {
            return;
        }

        // Add current node to the path
        currentPath.add(node.val);

        // Check if it's a leaf node and the remaining sum equals the node value
        if (node.left == null && node.right == null && targetSum == node.val) {
            result.add(new ArrayList<>(currentPath));
        } else {
            // Recursively traverse left and right subtrees
            findPaths(node.left, targetSum - node.val, currentPath, result);
            findPaths(node.right, targetSum - node.val, currentPath, result);
        }

        // Backtrack by removing the current node before returning to the parent
        currentPath.remove(currentPath.size() - 1);
    }
}