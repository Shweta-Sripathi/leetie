// ──────────────────────────────────────────────────
// Problem  : 236. Lowest Common Ancestor of a Binary Tree
// Difficulty: Medium
// Tags     : Tree, Depth-First Search, Binary Tree, Binary Lifting, Lowest Common Ancestor
// Link     : https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/
// Runtime  : 19 ms (beats 22%)
// Memory   : 70000000 (beats 42%)
// Language : java
// Copyright: (c) 2026 Shweta-Sripathi. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // Base case: if root is null or matches either p or q
        if (root == null || root == p || root == q) {
            return root;
        }
        
        // Recurse left and right subtrees
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        
        // If both left and right return non-null, it means p and q are found in separate subtrees;
        // therefore, the current root is their lowest common ancestor.
        if (left != null && right != null) {
            return root;
        }
        
        // Otherwise, return whichever non-null result we found (or null if neither was found)
        return left != null ? left : right;
    }
}