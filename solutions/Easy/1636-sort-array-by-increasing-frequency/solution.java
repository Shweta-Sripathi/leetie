// ──────────────────────────────────────────────────
// Problem  : 1636. Sort Array by Increasing Frequency
// Difficulty: Easy
// Tags     : Array, Hash Table, Sorting
// Link     : https://leetcode.com/problems/sort-array-by-increasing-frequency/
// Runtime  : 9 ms (beats 40%)
// Memory   : 45924000 (beats 12%)
// Language : java
// Copyright: (c) 2026 Shweta-Sripathi. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

import java.util.*;

class Solution {
    public int[] frequencySort(int[] nums) {
        // Step 1: Count frequencies of each number
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        // Step 2: Convert int[] to Integer[] to allow custom sorting
        Integer[] numsBoxed = new Integer[nums.length];
        for (int i = 0; i < nums.length; i++) {
            numsBoxed[i] = nums[i];
        }

        // Step 3: Sort using custom comparator
        Arrays.sort(numsBoxed, (a, b) -> {
            int freqA = freqMap.get(a);
            int freqB = freqMap.get(b);
            
            if (freqA != freqB) {
                return Integer.compare(freqA, freqB); // Increasing frequency
            } else {
                return Integer.compare(b, a);         // Decreasing value
            }
        });

        // Step 4: Convert back to primitive int[]
        for (int i = 0; i < nums.length; i++) {
            nums[i] = numsBoxed[i];
        }

        return nums;
    }
}