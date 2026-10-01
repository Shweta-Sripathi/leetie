// ──────────────────────────────────────────────────
// Problem  : 1652. Defuse the Bomb
// Difficulty: Easy
// Tags     : Array, Sliding Window
// Link     : https://leetcode.com/problems/defuse-the-bomb/
// Runtime  : 0 ms (beats 100%)
// Memory   : 43744000 (beats 67%)
// Language : java
// Copyright: (c) 2026 Shweta-Sripathi. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int[] decrypt(int[] code, int k) {
        int n = code.length;
        int[] result = new int[n];
        
        if (k == 0) {
            return result; // Default values are all 0
        }
        
        // Define the initial window bounds based on k
        int left = 1;
        int right = k;
        
        if (k < 0) {
            left = n + k;
            right = n - 1;
        }
        
        // Compute sum of the first window
        int windowSum = 0;
        for (int i = left; i <= right; i++) {
            windowSum += code[i % n];
        }
        
        // Slide the window across all elements
        for (int i = 0; i < n; i++) {
            result[i] = windowSum;
            // Slide window right: subtract element leaving left, add element entering right
            windowSum -= code[left % n];
            left++;
            right++;
            windowSum += code[right % n];
        }
        
        return result;
    }
}