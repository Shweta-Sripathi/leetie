// ──────────────────────────────────────────────────
// Problem  : 703. Kth Largest Element in a Stream
// Difficulty: Easy
// Tags     : Tree, Design, Binary Search Tree, Heap (Priority Queue), Binary Tree, Data Stream
// Link     : https://leetcode.com/problems/kth-largest-element-in-a-stream/
// Runtime  : 21 ms (beats 94%)
// Memory   : 51748000 (beats 86%)
// Language : java
// Copyright: (c) 2026 Shweta-Sripathi. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

import java.util.PriorityQueue;

class KthLargest {
    private PriorityQueue<Integer> minHeap;
    private int k;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        this.minHeap = new PriorityQueue<>();
        for (int num : nums) {
            add(num);
        }
    }
    
    public int add(int val) {
        minHeap.offer(val);
        if (minHeap.size() > k) {
            minHeap.poll();
        }
        return minHeap.peek();
    }
}