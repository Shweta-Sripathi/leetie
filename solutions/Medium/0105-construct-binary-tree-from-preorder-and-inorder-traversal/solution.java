// ──────────────────────────────────────────────────
// Problem  : 105. Construct Binary Tree from Preorder and Inorder Traversal
// Difficulty: Medium
// Tags     : Array, Hash Table, Divide and Conquer, Tree, Binary Tree
// Link     : https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
// Runtime  : 2 ms (beats 69%)
// Memory   : 46144000 (beats 65%)
// Language : java
// Copyright: (c) 2026 Shweta-Sripathi. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

import java.util.HashMap;
import java.util.Map;

class Solution {
    private Map<Integer, Integer> inorderMap;
    private int preorderIndex;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        preorderIndex = 0;
        inorderMap = new HashMap<>();
        
        // Store the indices of each element in the inorder array for O(1) lookups
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }

        return helper(preorder, 0, inorder.length - 1);
    }

    private TreeNode helper(int[] preorder, int left, int right) {
        // If there are no elements to construct the subtree, return null
        if (left > right) {
            return null;
        }

        // The current root value is at the current preorderIndex
        int rootVal = preorder[preorderIndex++];
        TreeNode root = new TreeNode(rootVal);

        // Find the index of this root in the inorder array
        int inorderIndex = inorderMap.get(rootVal);

        // Recursively build the left and right subtrees
        root.left = helper(preorder, left, inorderIndex - 1);
        root.right = helper(preorder, inorderIndex + 1, right);

        return root;
    }
}