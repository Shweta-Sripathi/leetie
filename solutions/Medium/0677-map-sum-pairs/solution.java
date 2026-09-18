// ──────────────────────────────────────────────────
// Problem  : 677. Map Sum Pairs
// Difficulty: Medium
// Tags     : Hash Table, String, Design, Trie
// Link     : https://leetcode.com/problems/map-sum-pairs/
// Runtime  : 3 ms (beats 0%)
// Memory   : 42936000 (beats 0%)
// Language : java
// Copyright: (c) 2026 Shweta-Sripathi. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

import java.util.HashMap;

class MapSum {

    private class TrieNode {
        TrieNode[] children = new TrieNode[26];
        int score = 0;
    }

    private TrieNode root;
    private HashMap<String, Integer> map;

    public MapSum() {
        root = new TrieNode();
        map = new HashMap<>();
    }
    
    public void insert(String key, int val) {
        // Calculate the difference if the key already exists
        int delta = val - map.getOrDefault(key, 0);
        map.put(key, val);

        // Update prefix sums along the path in the Trie
        TrieNode curr = root;
        for (char c : key.toCharArray()) {
            int idx = c - 'a';
            if (curr.children[idx] == null) {
                curr.children[idx] = new TrieNode();
            }
            curr = curr.children[idx];
            curr.score += delta;
        }
    }
    
    public int sum(String prefix) {
        TrieNode curr = root;
        for (char c : prefix.toCharArray()) {
            int idx = c - 'a';
            if (curr.children[idx] == null) {
                return 0; // Prefix does not exist
            }
            curr = curr.children[idx];
        }
        return curr.score;
    }
}

/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */