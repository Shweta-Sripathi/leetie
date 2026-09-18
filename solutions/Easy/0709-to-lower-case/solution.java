// ──────────────────────────────────────────────────
// Problem  : 709. To Lower Case
// Difficulty: Easy
// Tags     : String
// Link     : https://leetcode.com/problems/to-lower-case/
// Runtime  : 0 ms (beats 100%)
// Memory   : 42864000 (beats 68%)
// Language : java
// Copyright: (c) 2026 Shweta-Sripathi. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public String toLowerCase(String s) {
        char[] chars = s.toCharArray();
        
        for (int i = 0; i < chars.length; i++) {
            // Check if character is an uppercase letter ('A' to 'Z')
            if (chars[i] >= 'A' && chars[i] <= 'Z') {
                // Convert to lowercase by adding the offset ('a' - 'A' = 32)
                chars[i] = (char) (chars[i] + 32);
            }
        }
        
        return new String(chars);
    }
}