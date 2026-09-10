// ──────────────────────────────────────────────────
// Problem  : 833. Find And Replace in String
// Difficulty: Medium
// Tags     : Array, Hash Table, String, Sorting
// Link     : https://leetcode.com/problems/find-and-replace-in-string/
// Runtime  : 0 ms (beats 0%)
// Memory   : 42836000 (beats 0%)
// Language : java
// Copyright: (c) 2026 Shweta-Sripathi. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

import java.util.Arrays;

class Solution {
    public String findReplaceString(String s, int[] indices, String[] sources, String[] targets) {
        int n = s.length();
        int[] match = new int[n];
        Arrays.fill(match, -1);

        for (int i = 0; i < indices.length; i++) {
            int idx = indices[i];
            if (s.startsWith(sources[i], idx)) {
                match[idx] = i;
            }
        }

        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i < n) {
            if (match[i] != -1) {
                int opIdx = match[i];
                sb.append(targets[opIdx]);
                i += sources[opIdx].length();
            } else {
                sb.append(s.charAt(i));
                i++;
            }
        }

        return sb.toString();
    }
}