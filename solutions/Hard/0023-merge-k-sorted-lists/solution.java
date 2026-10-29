// ──────────────────────────────────────────────────
// Problem  : 23. Merge k Sorted Lists
// Difficulty: Hard
// Tags     : Linked List, Divide and Conquer, Heap (Priority Queue), Merge Sort, Tournament Sort
// Link     : https://leetcode.com/problems/merge-k-sorted-lists/
// Runtime  : 5 ms (beats 46%)
// Memory   : 46052000 (beats 97%)
// Language : java
// Copyright: (c) 2026 Shweta-Sripathi. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

import java.util.PriorityQueue;

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }

        // Min-heap to keep track of the smallest node among the heads of all lists
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a.val, b.val));

        // Add the head of each non-null list to the min-heap
        for (ListNode list : lists) {
            if (list != null) {
                minHeap.offer(list);
            }
        }

        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        // Extract the smallest node and add its next node to the heap
        while (!minHeap.isEmpty()) {
            ListNode smallest = minHeap.poll();
            current.next = smallest;
            current = current.next;

            if (smallest.next != null) {
                minHeap.offer(smallest.next);
            }
        }

        return dummy.next;
    }
}