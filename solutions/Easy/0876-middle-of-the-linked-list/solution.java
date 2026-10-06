// ──────────────────────────────────────────────────
// Problem  : 876. Middle of the Linked List
// Difficulty: Easy
// Tags     : Linked List, Two Pointers
// Link     : https://leetcode.com/problems/middle-of-the-linked-list/
// Runtime  : 0 ms (beats 100%)
// Memory   : 42988000 (beats 35%)
// Language : java
// Copyright: (c) 2026 Shweta-Sripathi. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        
        while (fast != null && fast.next != null) {
            slow = slow.next;        // moves 1 step
            fast = fast.next.next;   // moves 2 steps
        }
        
        return slow;
    }
}