// ──────────────────────────────────────────────────
// Problem  : 202. Happy Number
// Difficulty: Easy
// Tags     : Hash Table, Math, Two Pointers, Floyd's Cycle Finding Algorithm
// Link     : https://leetcode.com/problems/happy-number/
// Runtime  : 1 ms (beats 78%)
// Memory   : 42176000 (beats 88%)
// Language : java
// Copyright: (c) 2026 Shweta-Sripathi. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public boolean isHappy(int n) {
        int slow = n;
        int fast = getNext(n);

        // Move slow pointer by 1 step and fast pointer by 2 steps
        while (fast != 1 && slow != fast) {
            slow = getNext(slow);
            fast = getNext(getNext(fast));
        }

        // If fast pointer reaches 1, the number is happy
        return fast == 1;
    }

    // Helper method to compute the sum of squares of digits
    private int getNext(int n) {
        int totalSum = 0;
        while (n > 0) {
            int digit = n % 10;
            totalSum += digit * digit;
            n /= 10;
        }
        return totalSum;
    }
}