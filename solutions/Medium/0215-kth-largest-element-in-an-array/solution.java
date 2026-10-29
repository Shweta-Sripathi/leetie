// ──────────────────────────────────────────────────
// Problem  : 215. Kth Largest Element in an Array
// Difficulty: Medium
// Tags     : Array, Divide and Conquer, Sorting, Heap (Priority Queue), Quickselect
// Link     : https://leetcode.com/problems/kth-largest-element-in-an-array/
// Runtime  : 71 ms (beats 36%)
// Memory   : 73752000 (beats 83%)
// Language : java
// Copyright: (c) 2026 Shweta-Sripathi. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

import java.util.PriorityQueue;

class Solution {
    public int findKthLargest(int[] nums, int k) {
        // Min-heap to store the k largest elements
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        
        for (int num : nums) {
            minHeap.offer(num);
            if (minHeap.size() > k) {
                minHeap.poll(); // Remove the smallest element to maintain size k
            }
        }
        
        // The root of the min-heap is the kth largest element
        return minHeap.peek();
    }
}