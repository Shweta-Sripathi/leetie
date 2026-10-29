// ──────────────────────────────────────────────────
// Problem  : 30. Substring with Concatenation of All Words
// Difficulty: Hard
// Tags     : Hash Table, String, Sliding Window
// Link     : https://leetcode.com/problems/substring-with-concatenation-of-all-words/
// Runtime  : 12 ms (beats 53%)
// Memory   : 46680000 (beats 95%)
// Language : java
// Copyright: (c) 2026 Shweta-Sripathi. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        if (s == null || words == null || words.length == 0 || s.length() == 0) {
            return result;
        }

        int wordLen = words[0].length();
        int numWords = words.length;
        int totalLen = wordLen * numWords;

        if (s.length() < totalLen) {
            return result;
        }

        Map<String, Integer> wordCount = new HashMap<>();
        for (String word : words) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }

        // Iterate over each possible offset to handle all alignments
        for (int i = 0; i < wordLen; i++) {
            int left = i, right = i;
            Map<String, Integer> seenWords = new HashMap<>();
            int count = 0;

            while (right + wordLen <= s.length()) {
                String sub = s.substring(right, right + wordLen);
                right += wordLen;

                if (wordCount.containsKey(sub)) {
                    seenWords.put(sub, seenWords.getOrDefault(sub, 0) + 1);
                    count++;

                    // If the frequency exceeds the required count, shrink from the left
                    while (seenWords.get(sub) > wordCount.get(sub)) {
                        String leftSub = s.substring(left, left + wordLen);
                        seenWords.put(leftSub, seenWords.get(leftSub) - 1);
                        left += wordLen;
                        count--;
                    }

                    // If all words match, record the starting index
                    if (count == numWords) {
                        result.add(left);
                        // Shift left by one word to look for subsequent valid windows
                        String leftSub = s.substring(left, left + wordLen);
                        seenWords.put(leftSub, seenWords.get(leftSub) - 1);
                        left += wordLen;
                        count--;
                    }
                } else {
                    // Reset if the word is not in the dictionary
                    seenWords.clear();
                    count = 0;
                    left = right;
                }
            }
        }

        return result;
    }
}