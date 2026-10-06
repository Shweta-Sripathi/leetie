// ──────────────────────────────────────────────────
// Problem  : 942. DI String Match
// Difficulty: Easy
// Tags     : Array, Two Pointers, String, Greedy
// Link     : https://leetcode.com/problems/di-string-match/
// Runtime  : 3 ms (beats 40%)
// Memory   : 47364000 (beats 25%)
// Language : java
// Copyright: (c) 2026 Shweta-Sripathi. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int[] diStringMatch(String s) {
        int n = s.length();
        int low = 0;
        int high = n;
        int[] perm = new int[n + 1];
        
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == 'I') {
                perm[i] = low++;
            } else {
                perm[i] = high--;
            }
        }
        
        // Place the last remaining number
        perm[n] = low; // low and high are equal at this point
        
        return perm;
    }
}