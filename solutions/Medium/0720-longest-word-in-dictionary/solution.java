// ──────────────────────────────────────────────────
// Problem  : 720. Longest Word in Dictionary
// Difficulty: Medium
// Tags     : Array, Hash Table, String, Trie, Sorting
// Link     : https://leetcode.com/problems/longest-word-in-dictionary/
// Runtime  : 0 ms (beats 0%)
// Memory   : 42716000 (beats 0%)
// Language : java
// Copyright: (c) 2026 Shweta-Sripathi. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class Solution {
    public String longestWord(String[] words) {
        // Sort words lexicographically
        Arrays.sort(words);

        Set<String> builtWords = new HashSet<>();
        String result = "";

        for (String word : words) {
            // A word can be built if it's 1 character long, or if its prefix exists in the set
            if (word.length() == 1 || builtWords.contains(word.substring(0, word.length() - 1))) {
                builtWords.add(word);
                // Keep the longest word (lexicographical tie breaks automatically due to initial sort)
                if (word.length() > result.length()) {
                    result = word;
                }
            }
        }

        return result;
    }
}