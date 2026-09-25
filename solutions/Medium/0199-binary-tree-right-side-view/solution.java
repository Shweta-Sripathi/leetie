// ──────────────────────────────────────────────────
// Problem  : 199. Binary Tree Right Side View
// Difficulty: Medium
// Tags     : Tree, Depth-First Search, Breadth-First Search, Binary Tree
// Link     : https://leetcode.com/problems/binary-tree-right-side-view/
// Runtime  : 0 ms (beats 0%)
// Memory   : 42772000 (beats 0%)
// Language : java
// Copyright: (c) 2026 Shweta-Sripathi. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

import java.util.ArrayList;
import java.util.List;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        dfs(root, 0, result);
        return result;
    }

    private void dfs(TreeNode node, int depth, List<Integer> result) {
        if (node == null) {
            return;
        }

        // The first node visited at a given depth is the rightmost node
        if (depth == result.size()) {
            result.add(node.val);
        }

        // Traverse right subtree first so rightmost nodes are processed first
        dfs(node.right, depth + 1, result);
        dfs(node.left, depth + 1, result);
    }
}