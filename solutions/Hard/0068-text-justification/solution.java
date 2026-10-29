// ──────────────────────────────────────────────────
// Problem  : 68. Text Justification
// Difficulty: Hard
// Tags     : Array, String, Simulation
// Link     : https://leetcode.com/problems/text-justification/
// Runtime  : 0 ms (beats 100%)
// Memory   : 43064000 (beats 69%)
// Language : java
// Copyright: (c) 2026 Shweta-Sripathi. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        int n = words.length;
        int i = 0;

        while (i < n) {
            int j = i;
            int lineLen = 0;

            // Find how many words can fit in the current line
            while (j < n && lineLen + words[j].length() + (j - i) <= maxWidth) {
                lineLen += words[j].length();
                j++;
            }

            StringBuilder sb = new StringBuilder();
            int numberOfWords = j - i;
            int totalSpaces = maxWidth - lineLen;

            // If it's the last line or the line has only one word, left-justify it
            if (j == n || numberOfWords == 1) {
                for (int k = i; k < j; k++) {
                    sb.append(words[k]);
                    if (k < j - 1) {
                        sb.append(" ");
                    }
                }
                // Pad remaining spaces at the end
                while (sb.length() < maxWidth) {
                    sb.append(" ");
                }
            } else {
                // Fully justify the line
                int spacesBetweenWords = totalSpaces / (numberOfWords - 1);
                int extraSpaces = totalSpaces % (numberOfWords - 1);

                for (int k = i; k < j; k++) {
                    sb.append(words[k]);
                    if (k < j - 1) {
                        int spacesToApply = spacesBetweenWords + (k - i < extraSpaces ? 1 : 0);
                        for (int s = 0; s < spacesToApply; s++) {
                            sb.append(" ");
                        }
                    }
                }
            }

            result.add(sb.toString());
            i = j; // Move to the next line's starting word
        }

        return result;
    }
}