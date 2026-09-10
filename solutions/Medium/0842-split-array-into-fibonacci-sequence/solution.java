// ──────────────────────────────────────────────────
// Problem  : 842. Split Array into Fibonacci Sequence
// Difficulty: Medium
// Tags     : String, Backtracking
// Link     : https://leetcode.com/problems/split-array-into-fibonacci-sequence/
// Runtime  : 0 ms (beats 0%)
// Memory   : 42532000 (beats 0%)
// Language : java
// Copyright: (c) 2026 Shweta-Sripathi. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> splitIntoFibonacci(String num) {
        List<Integer> result = new ArrayList<>();
        backtrack(num, 0, result);
        return result;
    }

    private boolean backtrack(String num, int index, List<Integer> result) {
        if (index == num.length() && result.size() >= 3) {
            return true;
        }

        long currentNum = 0;
        for (int i = index; i < num.length(); i++) {
            // Numbers with leading zeros are invalid (except 0 itself)
            if (i > index && num.charAt(index) == '0') {
                break;
            }

            currentNum = currentNum * 10 + (num.charAt(i) - '0');

            // Must fit within a 32-bit signed integer
            if (currentNum > Integer.MAX_VALUE) {
                break;
            }

            int size = result.size();
            if (size >= 2) {
                long sum = (long) result.get(size - 1) + result.get(size - 2);
                if (currentNum < sum) {
                    continue;
                } else if (currentNum > sum) {
                    break; // Exceeds expected sum, no need to extend further
                }
            }

            result.add((int) currentNum);
            if (backtrack(num, i + 1, result)) {
                return true;
            }
            result.remove(result.size() - 1);
        }

        return false;
    }
}