// ──────────────────────────────────────────────────
// Problem  : 117. Populating Next Right Pointers in Each Node II
// Difficulty: Medium
// Tags     : Linked List, Tree, Depth-First Search, Breadth-First Search, Binary Tree
// Link     : https://leetcode.com/problems/populating-next-right-pointers-in-each-node-ii/
// Runtime  : 0 ms (beats 100%)
// Memory   : 45648000 (beats 94%)
// Language : java
// Copyright: (c) 2026 Shweta-Sripathi. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public Node connect(Node root) {
        Node dummyHead = new Node(0);
        Node prev = dummyHead;
        Node curr = root;

        while (curr != null) {
            while (curr != null) {
                if (curr.left != null) {
                    prev.next = curr.left;
                    prev = prev.next;
                }
                if (curr.right != null) {
                    prev.next = curr.right;
                    prev = prev.next;
                }
                curr = curr.next;
            }
            
            // Move to the next level
            curr = dummyHead.next;
            dummyHead.next = null;
            prev = dummyHead;
        }

        return root;
    }
}