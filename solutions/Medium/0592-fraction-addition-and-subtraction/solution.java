// ──────────────────────────────────────────────────
// Problem  : 592. Fraction Addition and Subtraction
// Difficulty: Medium
// Tags     : Math, String, Simulation, Euclidean Algorithm, Greatest Common Divisor
// Link     : https://leetcode.com/problems/fraction-addition-and-subtraction/
// Runtime  : 10 ms (beats 0%)
// Memory   : 43236000 (beats 0%)
// Language : java
// Copyright: (c) 2026 Shweta-Sripathi. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

import java.util.Scanner;

class Solution {
    public String fractionAddition(String expression) {
        Scanner scanner = new Scanner(expression);
        // Use delimiter that matches '/' or positions before '+' or '-'
        scanner.useDelimiter("/|(?=[+-])");
        
        int A = 0, B = 1; // Represents the running fraction A / B
        
        while (scanner.hasNextInt()) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            
            // Add fraction a/b to A/B: (A * b + a * B) / (B * b)
            A = A * b + a * B;
            B = B * b;
            
            // Reduce by greatest common divisor
            int gcd = gcd(Math.abs(A), B);
            A /= gcd;
            B /= gcd;
        }
        
        return A + "/" + B;
    }
    
    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}