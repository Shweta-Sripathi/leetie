// ──────────────────────────────────────────────────
// Problem  : 881. Boats to Save People
// Difficulty: Medium
// Tags     : Array, Two Pointers, Greedy, Sorting, Timsort
// Link     : https://leetcode.com/problems/boats-to-save-people/
// Runtime  : 20 ms (beats 81%)
// Memory   : 56736000 (beats 10%)
// Language : java
// Copyright: (c) 2026 Shweta-Sripathi. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

import java.util.Arrays;

class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        
        int left = 0;                  // Lightest person pointer
        int right = people.length - 1; // Heaviest person pointer
        int boats = 0;
        
        while (left <= right) {
            // If the lightest and heaviest person can fit together
            if (people[left] + people[right] <= limit) {
                left++;
            }
            // Heaviest person always takes a boat
            right--;
            boats++;
        }
        
        return boats;
    }
}