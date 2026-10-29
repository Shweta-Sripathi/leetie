// ──────────────────────────────────────────────────
// Problem  : 60. Permutation Sequence
// Difficulty: Hard
// Tags     : Math, Recursion
// Link     : https://leetcode.com/problems/permutation-sequence/
// Runtime  : 2 ms (beats 42%)
// Memory   : 42316000 (beats 91%)
// Language : java
// Copyright: (c) 2026 Shweta-Sripathi. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

import java.util.ArrayList;
import java.util.List;

class Solution {
    public String getPermutation(int n, int k) {
        int fact = 1;
        List<Integer> numbers = new ArrayList<>();
        
        // Calculate (n-1)! and populate the list of numbers [1, 2, ..., n]
        for (int i = 1; i < n; i++) {
            fact *= i;
            numbers.add(i);
        }
        numbers.add(n);
        
        // Convert k to 0-indexed
        k--;
        
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < n; i++) {
            int index = k / fact;
            sb.append(numbers.get(index));
            numbers.remove(index);
            
            if (i == n - 1) {
                break;
            }
            
            k %= fact;
            fact /= (n - 1 - i);
        }
        
        return sb.toString();
    }
}