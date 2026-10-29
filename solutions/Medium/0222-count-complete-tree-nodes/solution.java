// ──────────────────────────────────────────────────
// Problem  : 222. Count Complete Tree Nodes
// Difficulty: Medium
// Tags     : Binary Search, Bit Manipulation, Tree, Binary Tree
// Link     : https://leetcode.com/problems/count-complete-tree-nodes/
// Runtime  : 0 ms (beats 100%)
// Memory   : 48784000 (beats 95%)
// Language : java
// Copyright: (c) 2026 Shweta-Sripathi. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        int leftHeight = getLeftHeight(root);
        int rightHeight = getRightHeight(root);
        
        // If left and right subtree heights are equal, the left subtree is a full binary tree
        if (leftHeight == rightHeight) {
            return (1 << leftHeight) - 1; // 2^leftHeight - 1 + 1 (for root)
        } else {
            // Otherwise, the right subtree is a full binary tree of height rightHeight
            return 1 + countNodes(root.left) + countNodes(root.right);
        }
    }
    
    private int getLeftHeight(TreeNode node) {
        int height = 0;
        while (node != null) {
            height++;
            node = node.left;
        }
        return height;
    }
    
    private int getRightHeight(TreeNode node) {
        int height = 0;
        while (node != null) {
            height++;
            node = node.right;
        }
        return height;
    }
}