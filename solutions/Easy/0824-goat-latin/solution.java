// ──────────────────────────────────────────────────
// Problem  : 824. Goat Latin
// Difficulty: Easy
// Tags     : String
// Link     : https://leetcode.com/problems/goat-latin/
// Runtime  : 2 ms (beats 85%)
// Memory   : 42956000 (beats 93%)
// Language : java
// Copyright: (c) 2026 Shweta-Sripathi. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

import java.util.Set;

class Solution {
    public String toGoatLatin(String sentence) {
        Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U');
        String[] words = sentence.split(" ");
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            char firstChar = word.charAt(0);

            if (vowels.contains(firstChar)) {
                result.append(word);
            } else {
                result.append(word.substring(1)).append(firstChar);
            }

            result.append("ma");
            result.append("a".repeat(i + 1));

            if (i < words.length - 1) {
                result.append(" ");
            }
        }

        return result.toString();
    }
}