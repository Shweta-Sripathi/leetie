// ──────────────────────────────────────────────────
// Problem  : 237. Delete Node in a Linked List
// Difficulty: Medium
// Tags     : Linked List
// Link     : https://leetcode.com/problems/delete-node-in-a-linked-list/
// Runtime  : 0 ms (beats 100%)
// Memory   : 44588000 (beats 96%)
// Language : java
// Copyright: (c) 2026 Shweta-Sripathi. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}