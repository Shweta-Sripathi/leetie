// ──────────────────────────────────────────────────
// Problem  : 116. Populating Next Right Pointers in Each Node
// Difficulty: Medium
// Tags     : Linked List, Tree, Depth-First Search, Breadth-First Search, Binary Tree
// Link     : https://leetcode.com/problems/populating-next-right-pointers-in-each-node/
// Runtime  : 0 ms (beats 100%)
// Memory   : 45892000 (beats 94%)
// Language : java
// Copyright: (c) 2026 Shweta-Sripathi. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public Node connect(Node root) {
        if (root == null) {
            return null;
        }

        // Start with the root node of the current level
        Node leftmost = root;

        while (leftmost.left != null) {
            Node head = leftmost;
            
            while (head != null) {
                // 1. Connect the left child to the right child of the same parent
                head.left.next = head.right;

                // 2. Connect the right child to the left child of the next node in the same level
                if (head.next != null) {
                    head.right.next = head.next.left;
                }

                // Move to the next node on the same level
                head = head.next;
            }

            // Move down to the next level
            leftmost = leftmost.left;
        }

        return root;
    }
}