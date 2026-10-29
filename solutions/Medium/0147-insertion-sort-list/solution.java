// ──────────────────────────────────────────────────
// Problem  : 147. Insertion Sort List
// Difficulty: Medium
// Tags     : Linked List, Sorting
// Link     : https://leetcode.com/problems/insertion-sort-list/
// Runtime  : 3 ms (beats 95%)
// Memory   : 45832000 (beats 90%)
// Language : java
// Copyright: (c) 2026 Shweta-Sripathi. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode curr = head; // The last sorted node
        ListNode prev = null; // Used for scanning from the start

        while (curr != null && curr.next != null) {
            if (curr.next.val >= curr.val) {
                curr = curr.next;
            } else {
                ListNode temp = curr.next;
                curr.next = temp.next;
                
                // Find the right place to insert temp
                prev = dummy;
                while (prev.next.val < temp.val) {
                    prev = prev.next;
                }
                
                // Insert temp between prev and prev.next
                temp.next = prev.next;
                prev.next = temp;
            }
        }

        return dummy.next;
    }
}