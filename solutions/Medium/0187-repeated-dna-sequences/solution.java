// ──────────────────────────────────────────────────
// Problem  : 187. Repeated DNA Sequences
// Difficulty: Medium
// Tags     : Hash Table, String, Bit Manipulation, Sliding Window, Rolling Hash, Hash Function, Z Algorithm, Boyer–Moore String-Search Algorithm
// Link     : https://leetcode.com/problems/repeated-dna-sequences/
// Runtime  : 483 ms (beats 44%)
// Memory   : 272816000 (beats 64%)
// Language : java
// Copyright: (c) 2026 Shweta-Sripathi. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        Set<String> seen = new HashSet<>();
        Set<String> repeated = new HashSet<>();
        
        // If string length is less than 10, no 10-letter sequence can exist
        if (s == null || s.length() < 10) {
            return new ArrayList<>();
        }
        
        for (int i = 0; i <= s.length() - 10; i++) {
            String sub = s.substring(i, i + 10);
            
            if (seen.contains(sub)) {
                repeated.add(sub);
            } else {
                seen.add(sub);
            }
        }
        
        return new ArrayList<>(repeated);
    }
}