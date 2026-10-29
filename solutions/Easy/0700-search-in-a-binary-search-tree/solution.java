// ──────────────────────────────────────────────────
// Problem  : 700. Search in a Binary Search Tree
// Difficulty: Easy
// Tags     : Tree, Binary Search Tree, Binary Tree
// Link     : https://leetcode.com/problems/search-in-a-binary-search-tree/
// Runtime  : 0 ms (beats 100%)
// Memory   : 46448000 (beats 90%)
// Language : java
// Copyright: (c) 2026 Shweta-Sripathi. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null || root.val == val) {
            return root;
        }
        return val < root.val ? searchBST(root.left, val) : searchBST(root.right, val);
    }
}