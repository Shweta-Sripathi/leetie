// ──────────────────────────────────────────────────
// Problem  : 386. Lexicographical Numbers
// Difficulty: Medium
// Tags     : Depth-First Search, Trie
// Link     : https://leetcode.com/problems/lexicographical-numbers/
// Runtime  : 5 ms (beats 62%)
// Memory   : 49512000 (beats 86%)
// Language : java
// Copyright: (c) 2026 Shweta-Sripathi. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> result = new ArrayList<>();
        int curr = 1;
        
        for (int i = 0; i < n; i++) {
            result.add(curr);
            
            if (curr * 10 <= n) {
                curr *= 10;
            } else {
                while (curr % 10 == 9 || curr >= n) {
                    curr /= 10;
                }
                curr += 1;
            }
        }
        
        return result;
    }
}