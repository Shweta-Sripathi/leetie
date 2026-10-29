// ──────────────────────────────────────────────────
// Problem  : 109. Convert Sorted List to Binary Search Tree
// Difficulty: Medium
// Tags     : Linked List, Divide and Conquer, Tree, Binary Search Tree, Binary Tree
// Link     : https://leetcode.com/problems/convert-sorted-list-to-binary-search-tree/
// Runtime  : 0 ms (beats 100%)
// Memory   : 46588000 (beats 83%)
// Language : java
// Copyright: (c) 2026 Shweta-Sripathi. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    private ListNode headNode;

    public TreeNode sortedListToBST(ListNode head) {
        int size = 0;
        ListNode curr = head;
        while (curr != null) {
            size++;
            curr = curr.next;
        }

        headNode = head;
        return convert(0, size - 1);
    }

    private TreeNode convert(int left, int right) {
        if (left > right) {
            return null;
        }

        int mid = left + (right - left) / 2;

        // Recursively build the left subtree
        TreeNode leftChild = convert(left, mid - 1);

        // The current node in the linked list becomes the root
        TreeNode root = new TreeNode(headNode.val);
        root.left = leftChild;

        // Move the linked list pointer forward
        headNode = headNode.next;

        // Recursively build the right subtree
        root.right = convert(mid + 1, right);

        return root;
    }
}