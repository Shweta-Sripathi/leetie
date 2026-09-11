// ──────────────────────────────────────────────────
// Problem  : 556. Next Greater Element III
// Difficulty: Medium
// Tags     : Math, Two Pointers, String
// Link     : https://leetcode.com/problems/next-greater-element-iii/
// Runtime  : 0 ms (beats 100%)
// Memory   : 42088000 (beats 59%)
// Language : java
// Copyright: (c) 2026 Shweta-Sripathi. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int nextGreaterElement(int n) {
        char[] digits = String.valueOf(n).toCharArray();
        int len = digits.length;
        
        // Step 1: Find first decreasing digit from right
        int i = len - 2;
        while (i >= 0 && digits[i] >= digits[i + 1]) {
            i--;
        }
        
        // If no such digit exists, n is the largest permutation
        if (i < 0) {
            return -1;
        }
        
        // Step 2: Find the smallest digit greater than digits[i] from right
        int j = len - 1;
        while (digits[j] <= digits[i]) {
            j--;
        }
        
        // Step 3: Swap digits at i and j
        swap(digits, i, j);
        
        // Step 4: Reverse suffix starting at i + 1
        reverse(digits, i + 1, len - 1);
        
        // Step 5: Convert back to integer and check 32-bit bound
        long result = Long.parseLong(new String(digits));
        return result <= Integer.MAX_VALUE ? (int) result : -1;
    }
    
    private void swap(char[] a, int i, int j) {
        char temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
    
    private void reverse(char[] a, int start, int end) {
        while (start < end) {
            swap(a, start, end);
            start++;
            end--;
        }
    }
}