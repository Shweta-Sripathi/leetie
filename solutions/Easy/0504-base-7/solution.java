// ──────────────────────────────────────────────────
// Problem  : 504. Base 7
// Difficulty: Easy
// Tags     : Math, String
// Link     : https://leetcode.com/problems/base-7/
// Runtime  : 1 ms (beats 74%)
// Memory   : 42892000 (beats 41%)
// Language : java
// Copyright: (c) 2026 Shweta-Sripathi. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public String convertToBase7(int num) {
        if (num == 0) {
            return "0";
        }
        
        StringBuilder sb = new StringBuilder();
        boolean isNegative = num < 0;
        num = Math.abs(num);
        
        while (num > 0) {
            sb.append(num % 7);
            num /= 7;
        }
        
        if (isNegative) {
            sb.append("-");
        }
        
        return sb.reverse().toString();
    }
}