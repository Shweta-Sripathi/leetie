// ──────────────────────────────────────────────────
// Problem  : 804. Unique Morse Code Words
// Difficulty: Easy
// Tags     : Array, Hash Table, String
// Link     : https://leetcode.com/problems/unique-morse-code-words/
// Runtime  : 2 ms (beats 99%)
// Memory   : 42684000 (beats 96%)
// Language : java
// Copyright: (c) 2026 Shweta-Sripathi. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

import java.util.HashSet;
import java.util.Set;

class Solution {
    public int uniqueMorseRepresentations(String[] words) {
        String[] morse = {".-","-...","-.-.-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        // Correct Morse code array for 26 letters:
        String[] codes = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        
        Set<String> transformations = new HashSet<>();
        
        for (String word : words) {
            StringBuilder sb = new StringBuilder();
            for (char c : word.toCharArray()) {
                sb.append(codes[c - 'a']);
            }
            transformations.add(sb.toString());
        }
        
        return transformations.size();
    }
}