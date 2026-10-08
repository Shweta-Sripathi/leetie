// ──────────────────────────────────────────────────
// Problem  : 2178. Maximum Split of Positive Even Integers
// Difficulty: Medium
// Tags     : Math, Backtracking, Greedy
// Link     : https://leetcode.com/problems/maximum-split-of-positive-even-integers/
// Runtime  : 12 ms (beats 31%)
// Memory   : 111644000 (beats 73%)
// Language : java
// Copyright: (c) 2026 Shweta-Sripathi. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Long> maximumEvenSplit(long finalSum) {
        List<Long> result = new ArrayList<>();
        
        // Odd numbers cannot be split into even integers
        if (finalSum % 2 != 0) {
            return result;
        }
        
        long curr = 2;
        while (curr <= finalSum) {
            result.add(curr);
            finalSum -= curr;
            curr += 2;
        }
        
        // Add the remaining sum to the last element to keep all elements unique
        if (finalSum > 0) {
            long lastIndex = result.size() - 1;
            result.set((int) lastIndex, result.get((int) lastIndex) + finalSum);
        }
        
        return result;
    }
}