// ──────────────────────────────────────────────────
// Problem  : 106. Construct Binary Tree from Inorder and Postorder Traversal
// Difficulty: Medium
// Tags     : Array, Hash Table, Divide and Conquer, Tree, Binary Tree
// Link     : https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
// Runtime  : 2 ms (beats 70%)
// Memory   : 46044000 (beats 68%)
// Language : java
// Copyright: (c) 2026 Shweta-Sripathi. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

import java.util.HashMap;
import java.util.Map;

class Solution {
    private Map<Integer, Integer> inorderMap;
    private int postorderIndex;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        postorderIndex = postorder.length - 1;
        inorderMap = new HashMap<>();

        // Store the indices of each element in the inorder array for O(1) lookups
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }

        return helper(postorder, 0, inorder.length - 1);
    }

    private TreeNode helper(int[] postorder, int left, int right) {
        // If there are no elements to construct the subtree, return null
        if (left > right) {
            return null;
        }

        // The current root value is the last element in the current postorder segment
        int rootVal = postorder[postorderIndex--];
        TreeNode root = new TreeNode(rootVal);

        // Find the index of this root in the inorder array
        int inorderIndex = inorderMap.get(rootVal);

        // Recursively build the right subtree first (since we traverse postorder backwards),
        // then build the left subtree.
        root.right = helper(postorder, inorderIndex + 1, right);
        root.left = helper(postorder, left, inorderIndex - 1);

        return root;
    }
}