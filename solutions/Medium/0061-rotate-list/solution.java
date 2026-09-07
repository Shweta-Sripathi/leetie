// ──────────────────────────────────────────────────
// Problem  : 61. Rotate List
// Difficulty: Medium
// Tags     : Linked List, Two Pointers
// Link     : https://leetcode.com/problems/rotate-list/
// Runtime  : 0 ms (beats 100%)
// Memory   : 44300000 (beats 63%)
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
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) {
            return head;
        }

        // 1. Find the length of the linked list and locate the tail node
        int length = 1;
        ListNode tail = head;
        while (tail.next != null) {
            tail = tail.next;
            length++;
        }

        // 2. Connect the tail to the head to make it a circular list
        tail.next = head;

        // 3. Find the effective number of rotations
        k = k % length;
        int stepsToNewTail = length - k;

        // 4. Find the new tail (stepsToNewTail - 1 nodes from current position)
        ListNode newTail = tail;
        while (stepsToNewTail > 0) {
            newTail = newTail.next;
            stepsToNewTail--;
        }

        // 5. The node after the new tail becomes the new head, then break the loop
        ListNode newHead = newTail.next;
        newTail.next = null;

        return newHead;
    }
}