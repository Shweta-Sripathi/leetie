// ──────────────────────────────────────────────────
// Problem  : 388. Longest Absolute File Path
// Difficulty: Medium
// Tags     : String, Stack, Depth-First Search
// Link     : https://leetcode.com/problems/longest-absolute-file-path/
// Runtime  : 1 ms (beats 58%)
// Memory   : 42484000 (beats 79%)
// Language : java
// Copyright: (c) 2026 Shweta-Sripathi. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int lengthLongestPath(String input) {
        String[] lines = input.split("\n");
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 0);
        int maxLength = 0;
        
        for (String line : lines) {
            int level = line.lastIndexOf('\t') + 1;
            String name = line.substring(level);
            
            if (name.contains(".")) {
                maxLength = Math.max(maxLength, map.get(level) + name.length());
            } else {
                map.put(level + 1, map.get(level) + name.length() + 1);
            }
        }
        
        return maxLength;
    }
}