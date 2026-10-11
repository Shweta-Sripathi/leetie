// ──────────────────────────────────────────────────
// Problem  : 3838. Weighted Word Mapping
// Difficulty: Easy
// Tags     : Array, String, Simulation
// Link     : https://leetcode.com/problems/weighted-word-mapping/
// Runtime  : 2 ms (beats 94%)
// Memory   : 46444000 (beats 69%)
// Language : java
// Copyright: (c) 2026 Shweta-Sripathi. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public String mapWordWeights(String[] words, int[] weights) {
        StringBuilder result = new StringBuilder();
        
        for (String word : words) {
            int wordWeight = 0;
            
            // Calculate the total weight of the word
            for (char c : word.toCharArray()) {
                wordWeight += weights[c - 'a'];
            }
            
            // Take modulo 26
            int remainder = wordWeight % 26;
            
            // Map using reverse alphabetical order: 0 -> 'z', 1 -> 'y', ..., 25 -> 'a'
            char mappedChar = (char) ('z' - remainder);
            result.append(mappedChar);
        }
        
        return result.toString();
    }
}