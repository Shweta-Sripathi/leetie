// ──────────────────────────────────────────────────
// Problem  : 401. Binary Watch
// Difficulty: Easy
// Tags     : Backtracking, Bit Manipulation
// Link     : https://leetcode.com/problems/binary-watch/
// Runtime  : 4 ms (beats 97%)
// Memory   : 48744000 (beats 57%)
// Language : java
// Copyright: (c) 2026 Shweta-Sripathi. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> readBinaryWatch(int turnedOn) {
        List<String> result = new ArrayList<>();
        
        for (int h = 0; h < 12; h++) {
            for (int m = 0; m < 60; m++) {
                if (Integer.bitCount(h) + Integer.bitCount(m) == turnedOn) {
                    if (m < 10) {
                        result.add(h + ":0" + m);
                    } else {
                        result.add(h + ":" + m);
                    }
                }
            }
        }
        
        return result;
    }
}