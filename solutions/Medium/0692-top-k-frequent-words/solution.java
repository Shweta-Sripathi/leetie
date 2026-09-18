// ──────────────────────────────────────────────────
// Problem  : 692. Top K Frequent Words
// Difficulty: Medium
// Tags     : Array, Hash Table, String, Trie, Sorting, Heap (Priority Queue), Bucket Sort, Counting
// Link     : https://leetcode.com/problems/top-k-frequent-words/
// Runtime  : 2 ms (beats 0%)
// Memory   : 43000000 (beats 0%)
// Language : java
// Copyright: (c) 2026 Shweta-Sripathi. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

import java.util.*;

class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        // 1. Count word frequencies
        Map<String, Integer> countMap = new HashMap<>();
        for (String word : words) {
            countMap.put(word, countMap.getOrDefault(word, 0) + 1);
        }

        // 2. Define Min-Heap:
        // - Lower frequency gets higher priority (evicted first)
        // - Higher alphabetical order gets higher priority if frequencies are equal
        PriorityQueue<String> minHeap = new PriorityQueue<>((a, b) -> {
            int freqA = countMap.get(a);
            int freqB = countMap.get(b);
            if (freqA != freqB) {
                return Integer.compare(freqA, freqB);
            }
            return b.compareTo(a);
        });

        // 3. Maintain top K elements in minHeap
        for (String word : countMap.keySet()) {
            minHeap.offer(word);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        // 4. Extract elements and reverse to get highest frequency / lower lexicographical first
        List<String> result = new ArrayList<>();
        while (!minHeap.isEmpty()) {
            result.add(minHeap.poll());
        }
        Collections.reverse(result);

        return result;
    }
}
