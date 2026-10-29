// ──────────────────────────────────────────────────
// Problem  : 98. Validate Binary Search Tree
// Difficulty: Medium
// Tags     : Tree, Depth-First Search, Binary Search Tree, Binary Tree
// Link     : https://leetcode.com/problems/validate-binary-search-tree/
// Runtime  : 0 ms (beats 100%)
// Memory   : 45140000 (beats 42%)
// Language : java
// Copyright: (c) 2026 Shweta-Sripathi. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public boolean isValidBST(TreeNode root) {
        return validate(root, null, null);
    }

    private boolean validate(TreeNode node, Integer low, Integer high) {
        // An empty tree is a valid BST
        if (node == null) {
            return true;
        }

        // The current node's value must be between low and high
        if ((low != null && node.val <= low) || (high != null && node.val >= high)) {
            return false;
        }

        // Validate the left subtree (values must be less than node.val)
        // and the right subtree (values must be greater than node.val)
        return validate(node.left, low, node.val) && validate(node.right, node.val, high);
    }
}