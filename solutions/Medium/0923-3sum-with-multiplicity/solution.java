// ──────────────────────────────────────────────────
// Problem  : 923. 3Sum With Multiplicity
// Difficulty: Medium
// Tags     : Array, Hash Table, Two Pointers, Sorting, Counting
// Link     : https://leetcode.com/problems/3sum-with-multiplicity/
// Runtime  : 4 ms (beats 59%)
// Memory   : 45452000 (beats 69%)
// Language : java
// Copyright: (c) 2026 Shweta-Sripathi. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int threeSumMulti(int[] arr, int target) {
        long MOD = 1_000_000_007;
        long[] count = new long[101];
        
        // Count frequencies of each number (since 0 <= arr[i] <= 100)
        for (int num : arr) {
            count[num]++;
        }
        
        long ans = 0;
        
        // Iterate through all unique combinations of numbers (i, j, k)
        for (int i = 0; i <= 100; i++) {
            if (count[i] == 0) continue;
            
            for (int j = i; j <= 100; j++) {
                if (count[j] == 0) continue;
                
                int k = target - i - j;
                if (k < j || k > 100 || count[k] == 0) continue;
                
                // Case 1: All three numbers are distinct (i < j < k)
                if (i < j && j < k) {
                    ans += count[i] * count[j] * count[k];
                } 
                // Case 2: Two numbers are equal (i == j < k)
                else if (i == j && j < k) {
                    ans += (count[i] * (count[i] - 1) / 2) * count[k];
                } 
                // Case 3: Two numbers are equal (i < j == k)
                else if (i < j && j == k) {
                    ans += count[i] * (count[j] * (count[j] - 1) / 2);
                } 
                // Case 4: All three numbers are equal (i == j == k)
                else if (i == j && j == k) {
                    ans += count[i] * (count[i] - 1) * (count[i] - 2) / 6;
                }
                
                ans %= MOD;
            }
        }
        
        return (int) ans;
    }
}