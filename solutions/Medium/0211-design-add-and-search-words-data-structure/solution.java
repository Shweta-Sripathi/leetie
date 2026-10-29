// ──────────────────────────────────────────────────
// Problem  : 211. Design Add and Search Words Data Structure
// Difficulty: Medium
// Tags     : String, Depth-First Search, Design, Trie
// Link     : https://leetcode.com/problems/design-add-and-search-words-data-structure/
// Runtime  : 225 ms (beats 36%)
// Memory   : 273080000 (beats 98%)
// Language : java
// Copyright: (c) 2026 Shweta-Sripathi. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class WordDictionary {
    
    private static class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean isEnd = false;
    }
    
    private final TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }
    
    public void addWord(String word) {
        TrieNode current = root;
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (current.children[index] == null) {
                current.children[index] = new TrieNode();
            }
            current = current.children[index];
        }
        current.isEnd = true;
    }
    
    public boolean search(String word) {
        return searchInNode(word, 0, root);
    }
    
    private boolean searchInNode(String word, int index, TrieNode node) {
        if (node == null) {
            return false;
        }
        
        if (index == word.length()) {
            return node.isEnd;
        }
        
        char c = word.charAt(index);
        
        if (c == '.') {
            // If the character is '.', try all possible non-null children
            for (int i = 0; i < 26; i++) {
                if (node.children[i] != null) {
                    if (searchInNode(word, index + 1, node.children[i])) {
                        return true;
                    }
                }
            }
            return false;
        } else {
            // Normal character matching
            int childIndex = c - 'a';
            return searchInNode(word, index + 1, node.children[childIndex]);
        }
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */