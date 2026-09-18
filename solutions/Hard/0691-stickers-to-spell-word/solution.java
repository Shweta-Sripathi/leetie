// ──────────────────────────────────────────────────
// Problem  : 691. Stickers to Spell Word
// Difficulty: Hard
// Tags     : Array, Hash Table, String, Dynamic Programming, Backtracking, Bit Manipulation, Memoization, Bitmask
// Link     : https://leetcode.com/problems/stickers-to-spell-word/
// Runtime  : 0 ms (beats 0%)
// Memory   : 42516000 (beats 0%)
// Language : java
// Copyright: (c) 2026 Shweta-Sripathi. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public int minStickers(String[] stickers, String target) {
        int n = target.length();
        int maxState = 1 << n;
        
        // Count character frequencies for each sticker
        int[][] stickerCounts = new int[stickers.length][26];
        for (int i = 0; i < stickers.length; i++) {
            for (char c : stickers[i].toCharArray()) {
                stickerCounts[i][c - 'a']++;
            }
        }

        Map<Integer, Integer> memo = new HashMap<>();
        memo.put(0, 0); // 0 stickers needed when target is fully formed (state 0)

        int result = dfs(target, stickerCounts, maxState - 1, memo);
        return result == Integer.MAX_VALUE ? -1 : result;
    }

    private int dfs(String target, int[][] stickers, int state, Map<Integer, Integer> memo) {
        if (memo.containsKey(state)) {
            return memo.get(state);
        }

        int n = target.length();
        int ans = Integer.MAX_VALUE;

        // Find the first uncovered character index in the target
        int firstCharIdx = -1;
        for (int i = 0; i < n; i++) {
            if (((state >> i) & 1) == 1) {
                firstCharIdx = i;
                break;
            }
        }

        char targetChar = target.charAt(firstCharIdx);

        // Try applying each sticker that contains targetChar
        for (int[] sticker : stickers) {
            if (sticker[targetChar - 'a'] == 0) continue; // Optimization: skip stickers without the target character

            int nextState = state;
            int[] available = sticker.clone();

            // Cover as many characters in the target as possible with this sticker
            for (int i = 0; i < n; i++) {
                if (((nextState >> i) & 1) == 1) {
                    char c = target.charAt(i);
                    if (available[c - 'a'] > 0) {
                        available[c - 'a']--;
                        nextState &= ~(1 << i); // Clear bit i
                    }
                }
            }

            int res = dfs(target, stickers, nextState, memo);
            if (res != Integer.MAX_VALUE) {
                ans = Math.min(ans, 1 + res);
            }
        }

        memo.put(state, ans);
        return ans;
    }
}