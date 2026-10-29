// ──────────────────────────────────────────────────
// Problem  : 25. Reverse Nodes in k-Group
// Difficulty: Hard
// Tags     : Linked List, Recursion
// Link     : https://leetcode.com/problems/reverse-nodes-in-k-group/
// Runtime  : 0 ms (beats 100%)
// Memory   : 45876000 (beats 91%)
// Language : java
// Copyright: (c) 2026 Shweta-Sripathi. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 1) {
            return head;
        }

        // Check if there are at least k nodes remaining
        ListNode curr = head;
        int count = 0;
        while (curr != null && count < k) {
            curr = curr.next;
            count++;
        }

        // If we have at least k nodes, reverse them
        if (count == k) {
            ListNode prev = null;
            ListNode next = null;
            curr = head;

            // Reverse k nodes
            for (int i = 0; i < k; i++) {
                next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }

            // Recurse for the remaining list and connect
            if (next != null) {
                head.next = reverseKGroup(next, k);
            }

            // prev is the new head of the reversed group
            return prev;
        }

        // If fewer than k nodes remain, leave them as is
        return head;
    }
}