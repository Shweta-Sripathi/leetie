// ──────────────────────────────────────────────────
// Problem  : 504. Base 7
// Difficulty: Easy
// Tags     : Math, String
// Link     : https://leetcode.com/problems/base-7/
// Runtime  : 0 ms (beats 0%)
// Memory   : 42748000 (beats 0%)
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