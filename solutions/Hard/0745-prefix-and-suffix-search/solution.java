// ──────────────────────────────────────────────────
// Problem  : 745. Prefix and Suffix Search
// Difficulty: Hard
// Tags     : Array, Hash Table, String, Design, Trie
// Link     : https://leetcode.com/problems/prefix-and-suffix-search/
// Runtime  : 4 ms (beats 0%)
// Memory   : 42860000 (beats 0%)
// Language : java
// Copyright: (c) 2026 Shweta-Sripathi. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class WordFilter {

    class TrieNode {
        TrieNode[] children = new TrieNode[27]; // 26 lowercase letters + '{'
        int weight = -1;
    }

    private TrieNode root;

    public WordFilter(String[] words) {
        root = new TrieNode();

        for (int weight = 0; weight < words.length; weight++) {
            String word = words[weight];
            int len = word.length();

            // Insert combinations: suffix + '{' + word into the Trie
            for (int i = 0; i <= len; i++) {
                String key = word.substring(i) + "{" + word;
                insert(key, weight);
            }
        }
    }

    private void insert(String key, int weight) {
        TrieNode curr = root;
        for (char c : key.toCharArray()) {
            int idx = c - 'a'; // '{' - 'a' evaluates to index 26
            if (curr.children[idx] == null) {
                curr.children[idx] = new TrieNode();
            }
            curr = curr.children[idx];
            curr.weight = weight; // Overwrite with the latest/largest index
        }
    }

    public int f(String pref, String suff) {
        TrieNode curr = root;
        String query = suff + "{" + pref;

        for (char c : query.toCharArray()) {
            int idx = c - 'a';
            if (curr.children[idx] == null) {
                return -1;
            }
            curr = curr.children[idx];
        }

        return curr.weight;
    }
}

/**
 * Your WordFilter object will be instantiated and called as such:
 * WordFilter obj = new WordFilter(words);
 * int param_1 = obj.f(pref,suff);
 */