// ──────────────────────────────────────────────────
// Problem  : 2513. Minimize the Maximum of Two Arrays
// Difficulty: Medium
// Tags     : Math, Binary Search, Number Theory, Least Common Multiple, Inclusion-Exclusion Principle
// Link     : https://leetcode.com/problems/minimize-the-maximum-of-two-arrays/
// Runtime  : 0 ms (beats 0%)
// Memory   : 41996000 (beats 0%)
// Language : java
// Copyright: (c) 2026 Shweta-Sripathi. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int minimizeSet(int divisor1, int divisor2, int uniqueCnt1, int uniqueCnt2) {
        long low = 1;
        long high = 2_000_000_000L;
        long lcm = lcm((long) divisor1, (long) divisor2);
        
        long ans = high;
        
        while (low <= high) {
            long mid = low + (high - low) / 2;
            
            // Available numbers not divisible by divisor1
            long count1 = mid - mid / divisor1;
            
            // Available numbers not divisible by divisor2
            long count2 = mid - mid / divisor2;
            
            // Available numbers not divisible by BOTH (i.e., not divisible by lcm(d1, d2))
            long totalCombined = mid - mid / lcm;
            
            if (count1 >= uniqueCnt1 && count2 >= uniqueCnt2 && totalCombined >= (long) uniqueCnt1 + uniqueCnt2) {
                ans = mid;
                high = mid - 1; // Try to find a smaller maximum
            } else {
                low = mid + 1;  // Increase the maximum value
            }
        }
        
        return (int) ans;
    }
    
    private long gcd(long a, long b) {
        return b == 0 ? a : gcd(b, a % b);
    }
    
    private long lcm(long a, long b) {
        return (a / gcd(a, b)) * b;
    }
}