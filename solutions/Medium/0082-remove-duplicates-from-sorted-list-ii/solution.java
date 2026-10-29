// ──────────────────────────────────────────────────
// Problem  : 82. Remove Duplicates from Sorted List II
// Difficulty: Medium
// Tags     : Linked List, Two Pointers
// Link     : https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/
// Runtime  : 1 ms (beats 23%)
// Memory   : 44700000 (beats 80%)
// Language : java
// Copyright: (c) 2026 Shweta-Sripathi. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        ListNode current = head;

        while (current != null) {
            boolean hasDuplicate = false;
            
            // Check if the current node has duplicates ahead
            while (current.next != null && current.val == current.next.val) {
                hasDuplicate = true;
                current = current.next;
            }

            if (hasDuplicate) {
                // Skip all duplicates
                prev.next = current.next;
            } else {
                // No duplicate, move prev pointer forward
                prev = prev.next;
            }

            current = current.next;
        }

        return dummy.next;
    }
}