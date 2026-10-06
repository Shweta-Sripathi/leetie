// ──────────────────────────────────────────────────
// Problem  : 917. Reverse Only Letters
// Difficulty: Easy
// Tags     : Two Pointers, String
// Link     : https://leetcode.com/problems/reverse-only-letters/
// Runtime  : 0 ms (beats 100%)
// Memory   : 43064000 (beats 28%)
// Language : java
// Copyright: (c) 2026 Shweta-Sripathi. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public String reverseOnlyLetters(String s) {
        char[] arr = s.toCharArray();
        int left = 0;
        int right = arr.length - 1;
        
        while (left < right) {
            // Move left pointer until it points to a letter
            if (!Character.isLetter(arr[left])) {
                left++;
            } 
            // Move right pointer until it points to a letter
            else if (!Character.isLetter(arr[right])) {
                right--;
            } 
            // Swap both letters and move both pointers inward
            else {
                char temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
                left++;
                right--;
            }
        }
        
        return new String(arr);
    }
}