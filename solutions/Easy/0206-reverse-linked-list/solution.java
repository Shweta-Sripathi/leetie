// ──────────────────────────────────────────────────
// Problem  : 206. Reverse Linked List
// Difficulty: Easy
// Tags     : Linked List, Recursion
// Link     : https://leetcode.com/problems/reverse-linked-list/
// Runtime  : 0 ms (beats 100%)
// Memory   : 43860000 (beats 85%)
// Language : java
// Copyright: (c) 2026 Shweta-Sripathi. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }
}