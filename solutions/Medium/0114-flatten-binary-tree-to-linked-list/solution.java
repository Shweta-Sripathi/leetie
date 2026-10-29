// ──────────────────────────────────────────────────
// Problem  : 114. Flatten Binary Tree to Linked List
// Difficulty: Medium
// Tags     : Linked List, Stack, Tree, Depth-First Search, Binary Tree
// Link     : https://leetcode.com/problems/flatten-binary-tree-to-linked-list/
// Runtime  : 1 ms (beats 20%)
// Memory   : 43464000 (beats 90%)
// Language : java
// Copyright: (c) 2026 Shweta-Sripathi. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }

        TreeNode curr = root;
        while (curr != null) {
            // If there is a left child, find the rightmost node of the left subtree
            if (curr.left != null) {
                TreeNode prev = curr.left;
                while (prev.right != null) {
                    prev = prev.right;
                }

                // Connect the right subtree of the current node to the rightmost node of the left subtree
                prev.right = curr.right;

                // Move the left subtree to the right child and set the left child to null
                curr.right = curr.left;
                curr.left = null;
            }
            // Move on to the next node on the right
            curr = curr.right;
        }
    }
}