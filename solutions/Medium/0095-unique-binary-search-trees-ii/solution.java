// ──────────────────────────────────────────────────
// Problem  : 95. Unique Binary Search Trees II
// Difficulty: Medium
// Tags     : Dynamic Programming, Backtracking, Tree, Binary Search Tree, Binary Tree
// Link     : https://leetcode.com/problems/unique-binary-search-trees-ii/
// Runtime  : 2 ms (beats 27%)
// Memory   : 45620000 (beats 96%)
// Language : java
// Copyright: (c) 2026 Shweta-Sripathi. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<TreeNode> generateTrees(int n) {
        if (n == 0) {
            return new ArrayList<>();
        }
        return buildTrees(1, n);
    }

    private List<TreeNode> buildTrees(int start, int end) {
        List<TreeNode> allTrees = new ArrayList<>();
        if (start > end) {
            allTrees.add(null);
            return allTrees;
        }

        // Pick each node as a root
        for (int i = start; i <= end; i++) {
            // Generate all left subtrees with values less than i
            List<TreeNode> leftTrees = buildTrees(start, i - 1);
            
            // Generate all right subtrees with values greater than i
            List<TreeNode> rightTrees = buildTrees(i + 1, end);

            // Connect left and right subtrees to the root i
            for (TreeNode left : leftTrees) {
                for (TreeNode right : rightTrees) {
                    TreeNode currentRoot = new TreeNode(i);
                    currentRoot.left = left;
                    currentRoot.right = right;
                    allTrees.add(currentRoot);
                }
            }
        }
        return allTrees;
    }
}