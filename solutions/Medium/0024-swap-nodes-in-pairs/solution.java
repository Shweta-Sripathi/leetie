// ──────────────────────────────────────────────────
// Problem  : 24. Swap Nodes in Pairs
// Difficulty: Medium
// Tags     : Linked List, Recursion
// Link     : https://leetcode.com/problems/swap-nodes-in-pairs/
// Runtime  : 0 ms (beats 100%)
// Memory   : 42848000 (beats 83%)
// Language : java
// Copyright: (c) 2026 Shweta-Sripathi. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;

        while (prev.next != null && prev.next.next != null) {
            ListNode first = prev.next;
            ListNode second = prev.next.next;

            // Swapping pointers
            first.next = second.next;
            second.next = first;
            prev.next = second;

            // Move prev pointer forward for the next pair
            prev = first;
        }

        return dummy.next;
    }
}