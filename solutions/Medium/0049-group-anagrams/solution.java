// ──────────────────────────────────────────────────
// Problem  : 49. Group Anagrams
// Difficulty: Medium
// Tags     : Array, Hash Table, String, Sorting
// Link     : https://leetcode.com/problems/group-anagrams/
// Runtime  : 0 ms (beats 0%)
// Memory   : 42604000 (beats 0%)
// Language : java
// Copyright: (c) 2026 Shweta-Sripathi. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) {
            return new ArrayList<>();
        }

        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            // Sort characters to create a canonical key for all anagrams
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String key = String.valueOf(charArray);

            // Add the original string to the corresponding key's group
            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(str);
        }

        return new ArrayList<>(map.values());
    }
}