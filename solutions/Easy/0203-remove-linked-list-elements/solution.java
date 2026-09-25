// ──────────────────────────────────────────────────
// Problem  : 203. Remove Linked List Elements
// Difficulty: Easy
// Tags     : Linked List, Recursion
// Link     : https://leetcode.com/problems/remove-linked-list-elements/
// Runtime  : 1 ms (beats 96%)
// Memory   : 47172000 (beats 79%)
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
    public ListNode removeElements(ListNode head, int val) {
        // Dummy node to handle edge cases where the head itself needs to be removed
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        ListNode curr = dummy;
        
        while (curr.next != null) {
            if (curr.next.val == val) {
                // Skip the node with matching value
                curr.next = curr.next.next;
            } else {
                // Advance pointer only when no node was removed
                curr = curr.next;
            }
        }
        
        return dummy.next;
    }
}