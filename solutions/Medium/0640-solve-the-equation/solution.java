// ──────────────────────────────────────────────────
// Problem  : 640. Solve the Equation
// Difficulty: Medium
// Tags     : Math, String, Simulation, Linear Algebra
// Link     : https://leetcode.com/problems/solve-the-equation/
// Runtime  : 4 ms (beats 13%)
// Memory   : 43304000 (beats 7%)
// Language : java
// Copyright: (c) 2026 Shweta-Sripathi. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public String solveEquation(String equation) {
        String[] parts = equation.split("=");
        int[] left = evaluateSide(parts[0]);
        int[] right = evaluateSide(parts[1]);

        int totalX = left[0] - right[0];
        int totalNum = right[1] - left[1];

        if (totalX == 0) {
            return totalNum == 0 ? "Infinite solutions" : "No solution";
        }

        return "x=" + (totalNum / totalX);
    }

    private int[] evaluateSide(String side) {
        // Match terms separated by + or -
        String[] tokens = side.split("(?=[+-])");
        int xCount = 0;
        int numCount = 0;

        for (String token : tokens) {
            if (token.equals("+x") || token.equals("x")) {
                xCount += 1;
            } else if (token.equals("-x")) {
                xCount -= 1;
            } else if (token.endsWith("x")) {
                xCount += Integer.parseInt(token.substring(0, token.length() - 1));
            } else {
                numCount += Integer.parseInt(token);
            }
        }

        return new int[]{xCount, numCount};
    }
}