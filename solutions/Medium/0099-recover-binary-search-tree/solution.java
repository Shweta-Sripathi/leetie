// ──────────────────────────────────────────────────
// Problem  : 99. Recover Binary Search Tree
// Difficulty: Medium
// Tags     : Tree, Depth-First Search, Binary Search Tree, Binary Tree
// Link     : https://leetcode.com/problems/recover-binary-search-tree/
// Runtime  : 3 ms (beats 24%)
// Memory   : 45976000 (beats 93%)
// Language : java
// Copyright: (c) 2026 Shweta-Sripathi. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    private TreeNode first = null;
    private TreeNode second = null;
    private TreeNode prev = null;

    public void recoverTree(TreeNode root) {
        traverse(root);
        
        // Swap the values of the two nodes to recover the BST
        if (first != null && second != null) {
            int temp = first.val;
            first.val = second.val;
            second.val = temp;
        }
    }

    private void traverse(TreeNode node) {
        if (node == null) {
            return;
        }

        // In-order traversal (Left, Root, Right)
        traverse(node.left);

        // If prev node value is greater than current node value, we found a violation
        if (prev != null && prev.val > node.val) {
            if (first == null) {
                first = prev;       // First violation: prev is the incorrect larger node
            }
            second = node;          // Second violation (or update for adjacent swap): node is the incorrect smaller node
        }

        prev = node;

        traverse(node.right);
    }
}