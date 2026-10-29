// ──────────────────────────────────────────────────
// Problem  : 107. Binary Tree Level Order Traversal II
// Difficulty: Medium
// Tags     : Tree, Breadth-First Search, Binary Tree
// Link     : https://leetcode.com/problems/binary-tree-level-order-traversal-ii/
// Runtime  : 1 ms (beats 98%)
// Memory   : 43908000 (beats 90%)
// Language : java
// Copyright: (c) 2026 Shweta-Sripathi. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> currentLevel = new ArrayList<>();

            for (int i = 0; i < levelSize; i++) {
                TreeNode currentNode = queue.poll();
                currentLevel.add(currentNode.val);

                if (currentNode.left != null) {
                    queue.offer(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.offer(currentNode.right);
                }
            }

            result.add(currentLevel);
        }

        // Reverse the level order list to get bottom-up traversal
        Collections.reverse(result);
        return result;
    }
}