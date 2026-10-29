// ──────────────────────────────────────────────────
// Problem  : 148. Sort List
// Difficulty: Medium
// Tags     : Linked List, Two Pointers, Divide and Conquer, Sorting, Merge Sort
// Link     : https://leetcode.com/problems/sort-list/
// Runtime  : 9 ms (beats 95%)
// Memory   : 59132000 (beats 78%)
// Language : java
// Copyright: (c) 2026 Shweta-Sripathi. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        // Step 1. Cut the list in half using the slow and fast pointer approach
        ListNode prev = null;
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        prev.next = null; // Cut the first half from the second half

        // Step 2. Recursively sort both halves
        ListNode l1 = sortList(head);
        ListNode l2 = sortList(slow);

        // Step 3. Merge the sorted halves
        return merge(l1, l2);
    }

    private ListNode merge(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode curr = dummyHead;

        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                curr.next = l1;
                l1 = l1.next;
            } else {
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;
        }

        if (l1 != null) {
            curr.next = l1;
        }
        if (l2 != null) {
            curr.next = l2;
        }

        return dummyHead.next;
    }
}