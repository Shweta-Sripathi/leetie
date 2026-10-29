// ──────────────────────────────────────────────────
// Problem  : 92. Reverse Linked List II
// Difficulty: Medium
// Tags     : Linked List
// Link     : https://leetcode.com/problems/reverse-linked-list-ii/
// Runtime  : 0 ms (beats 100%)
// Memory   : 42376000 (beats 96%)
// Language : java
// Copyright: (c) 2026 Shweta-Sripathi. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || left == right) {
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;

        // 1. Move prev to the node just before the 'left' position
        for (int i = 0; i < left - 1; i++) {
            prev = prev.next;
        }

        // 2. Reverse the sublist from left to right
        ListNode curr = prev.next;
        ListNode nextNode = null;
        ListNode tail = curr;

        for (int i = 0; i <= right - left; i++) {
            ListNode temp = curr.next;
            curr.next = nextNode;
            nextNode = curr;
            curr = temp;
        }

        // 3. Connect the reversed portion back to the original list
        prev.next = nextNode;
        tail.next = curr;

        return dummy.next;
    }
}