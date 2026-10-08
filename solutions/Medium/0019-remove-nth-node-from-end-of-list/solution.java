// ──────────────────────────────────────────────────
// Problem  : 19. Remove Nth Node From End of List
// Difficulty: Medium
// Tags     : Linked List, Two Pointers
// Link     : https://leetcode.com/problems/remove-nth-node-from-end-of-list/
// Runtime  : 0 ms (beats 100%)
// Memory   : 43672000 (beats 21%)
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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        ListNode fast = dummy;
        ListNode slow = dummy;
        
        // Move fast pointer ahead by n + 1 steps
        for (int i = 0; i <= n; i++) {
            fast = fast.next;
        }
        
        // Move fast to the end, maintaining the (n + 1) gap
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        
        // Skip the nth node from the end
        slow.next = slow.next.next;
        
        return dummy.next;
    }
}