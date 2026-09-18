// ──────────────────────────────────────────────────
// Problem  : 761. Special Binary String
// Difficulty: Hard
// Tags     : String, Divide and Conquer, Sorting
// Link     : https://leetcode.com/problems/special-binary-string/
// Runtime  : 0 ms (beats 0%)
// Memory   : 42484000 (beats 0%)
// Language : java
// Copyright: (c) 2026 Shweta-Sripathi. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    public String makeLargestSpecial(String s) {
        List<String> specialSubstrings = new ArrayList<>();
        int count = 0;
        int start = 0;

        // Decompose into top-level special binary substrings
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                count++;
            } else {
                count--;
            }

            // A balanced special binary substring is completed
            if (count == 0) {
                // Recursively optimize the inner substring, wrapped between starting '1' and ending '0'
                String inner = s.substring(start + 1, i);
                specialSubstrings.add("1" + makeLargestSpecial(inner) + "0");
                start = i + 1;
            }
        }

        // Sort all top-level special substrings in descending order to maximize lexicographical value
        Collections.sort(specialSubstrings, Collections.reverseOrder());

        // Join all sorted special substrings
        StringBuilder sb = new StringBuilder();
        for (String str : specialSubstrings) {
            sb.append(str);
        }

        return sb.toString();
    }
}