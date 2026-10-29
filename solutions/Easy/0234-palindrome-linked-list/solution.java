// ──────────────────────────────────────────────────
// Problem  : 234. Palindrome Linked List
// Difficulty: Easy
// Tags     : Linked List, Two Pointers, Stack, Recursion
// Link     : https://leetcode.com/problems/palindrome-linked-list/
// Runtime  : 4 ms (beats 69%)
// Memory   : 96156000 (beats 32%)
// Language : java
// Copyright: (c) 2026 Shweta-Sripathi. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }

        // Find the middle of the linked list
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Reverse the second half
        ListNode secondHalfHead = reverseList(slow);
        ListNode firstHalfPtr = head;
        ListNode secondHalfPtr = secondHalfHead;
        
        boolean result = true;
        while (secondHalfPtr != null) {
            if (firstHalfPtr.val != secondHalfPtr.val) {
                result = false;
                break;
            }
            firstHalfPtr = firstHalfPtr.next;
            secondHalfPtr = secondHalfPtr.next;
        }

        // Optional: restore the list
        reverseList(secondHalfHead);

        return result;
    }

    private ListNode reverseList(ListNode head) {
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