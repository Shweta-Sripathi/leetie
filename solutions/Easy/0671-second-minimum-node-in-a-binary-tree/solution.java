// ──────────────────────────────────────────────────
// Problem  : 671. Second Minimum Node In a Binary Tree
// Difficulty: Easy
// Tags     : Tree, Depth-First Search, Binary Tree
// Link     : https://leetcode.com/problems/second-minimum-node-in-a-binary-tree/
// Runtime  : 0 ms (beats 100%)
// Memory   : 42468000 (beats 75%)
// Language : java
// Copyright: (c) 2026 Shweta-Sripathi. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int findSecondMinimumValue(TreeNode root) {
        if (root == null) {
            return -1;
        }
        return (int) dfs(root, root.val);
    }
    
    private long dfs(TreeNode node, int minVal) {
        if (node == null) {
            return -1;
        }
        
        // Find the first value strictly greater than minVal
        if (node.val > minVal) {
            return node.val;
        }
        
        long leftMin = dfs(node.left, minVal);
        long rightMin = dfs(node.right, minVal);
        
        // If both subtrees return valid greater values, pick the minimum of the two
        if (leftMin != -1 && rightMin != -1) {
            return Math.min(leftMin, rightMin);
        }
        
        // Otherwise, return whichever side found a valid value (or -1 if neither did)
        return leftMin != -1 ? leftMin : rightMin;
    }
}