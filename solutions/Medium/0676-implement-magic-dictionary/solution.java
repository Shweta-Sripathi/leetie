// ──────────────────────────────────────────────────
// Problem  : 676. Implement Magic Dictionary
// Difficulty: Medium
// Tags     : Hash Table, String, Depth-First Search, Design, Trie
// Link     : https://leetcode.com/problems/implement-magic-dictionary/
// Runtime  : 33 ms (beats 44%)
// Memory   : 47848000 (beats 47%)
// Language : java
// Copyright: (c) 2026 Shweta-Sripathi. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class MagicDictionary {

    private class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean isEnd = false;
    }

    private TrieNode root;

    public MagicDictionary() {
        root = new TrieNode();
    }

    public void buildDict(String[] dictionary) {
        for (String word : dictionary) {
            TrieNode curr = root;
            for (char c : word.toCharArray()) {
                int idx = c - 'a';
                if (curr.children[idx] == null) {
                    curr.children[idx] = new TrieNode();
                }
                curr = curr.children[idx];
            }
            curr.isEnd = true;
        }
    }

    public boolean search(String searchWord) {
        return dfs(root, searchWord, 0, 0);
    }

    private boolean dfs(TrieNode node, String word, int index, int count) {
        if (count > 1) return false;

        if (index == word.length()) {
            return count == 1 && node.isEnd;
        }

        int charIdx = word.charAt(index) - 'a';

        for (int i = 0; i < 26; i++) {
            if (node.children[i] == null) continue;

            int newCount = count + (i == charIdx ? 0 : 1);
            if (dfs(node.children[i], word, index + 1, newCount)) {
                return true;
            }
        }

        return false;
    }
}