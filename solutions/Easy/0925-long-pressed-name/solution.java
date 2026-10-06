// ──────────────────────────────────────────────────
// Problem  : 925. Long Pressed Name
// Difficulty: Easy
// Tags     : Two Pointers, String
// Link     : https://leetcode.com/problems/long-pressed-name/
// Runtime  : 1 ms (beats 87%)
// Memory   : 42784000 (beats 73%)
// Language : java
// Copyright: (c) 2026 Shweta-Sripathi. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public boolean isLongPressedName(String name, String typed) {
        int i = 0; // Pointer for name
        int j = 0; // Pointer for typed
        
        while (j < typed.length()) {
            // Match found: advance both pointers
            if (i < name.length() && name.charAt(i) == typed.charAt(j)) {
                i++;
                j++;
            } 
            // Long pressed key found: character matches previous char in name
            else if (j > 0 && typed.charAt(j) == typed.charAt(j - 1)) {
                j++;
            } 
            // Mismatch or invalid character
            else {
                return false;
            }
        }
        
        // Ensure all characters in name were matched
        return i == name.length();
    }
}