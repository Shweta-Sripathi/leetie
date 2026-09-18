// ──────────────────────────────────────────────────
// Problem  : 648. Replace Words
// Difficulty: Medium
// Tags     : Array, Hash Table, String, Trie
// Link     : https://leetcode.com/problems/replace-words/
// Runtime  : 12 ms (beats 67%)
// Memory   : 65684000 (beats 32%)
// Language : java
// Copyright: (c) 2026 Shweta-Sripathi. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

import java.util.List;

class Solution {
    static class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean isEnd = false;
    }

    public String replaceWords(List<String> dictionary, String sentence) {
        TrieNode root = new TrieNode();

        // 1. Build the Trie with all roots from the dictionary
        for (String word : dictionary) {
            TrieNode curr = root;
            for (char c : word.toCharArray()) {
                int index = c - 'a';
                if (curr.children[index] == null) {
                    curr.children[index] = new TrieNode();
                }
                curr = curr.children[index];
            }
            curr.isEnd = true;
        }

        // 2. Process each word in the sentence
        String[] words = sentence.split(" ");
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < words.length; i++) {
            if (i > 0) result.append(" ");
            result.append(findShortestRoot(root, words[i]));
        }

        return result.toString();
    }

    // Helper to find the shortest root matching the word prefix
    private String findShortestRoot(TrieNode root, String word) {
        TrieNode curr = root;
        StringBuilder prefix = new StringBuilder();

        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (curr.children[index] == null) {
                break;
            }
            prefix.append(c);
            curr = curr.children[index];
            if (curr.isEnd) {
                return prefix.toString(); // Found shortest root
            }
        }

        return word; // No root found, return original word
    }
}