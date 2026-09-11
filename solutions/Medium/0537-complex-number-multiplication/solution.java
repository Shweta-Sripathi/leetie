// ──────────────────────────────────────────────────
// Problem  : 537. Complex Number Multiplication
// Difficulty: Medium
// Tags     : Math, String, Simulation
// Link     : https://leetcode.com/problems/complex-number-multiplication/
// Runtime  : 3 ms (beats 60%)
// Memory   : 43292000 (beats 13%)
// Language : java
// Copyright: (c) 2026 Shweta-Sripathi. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public String complexNumberMultiply(String num1, String num2) {
        // Parse num1
        String[] parts1 = num1.split("\\+");
        int a1 = Integer.parseInt(parts1[0]);
        int b1 = Integer.parseInt(parts1[1].replace("i", ""));

        // Parse num2
        String[] parts2 = num2.split("\\+");
        int a2 = Integer.parseInt(parts2[0]);
        int b2 = Integer.parseInt(parts2[1].replace("i", ""));

        // Calculate real and imaginary parts
        int real = a1 * a2 - b1 * b2;
        int imaginary = a1 * b2 + a2 * b1;

        return real + "+" + imaginary + "i";
    }
}