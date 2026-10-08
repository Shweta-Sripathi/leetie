// ──────────────────────────────────────────────────
// Problem  : 2162. Minimum Cost to Set Cooking Time
// Difficulty: Medium
// Tags     : Math, Enumeration
// Link     : https://leetcode.com/problems/minimum-cost-to-set-cooking-time/
// Runtime  : 9 ms (beats 14%)
// Memory   : 42592000 (beats 38%)
// Language : java
// Copyright: (c) 2026 Shweta-Sripathi. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int minCostSetTime(int startAt, int moveCost, int pushCost, int targetSeconds) {
        int minCost = Integer.MAX_VALUE;

        // Try standard split
        int maxMins = targetSeconds / 60;
        int maxSecs = targetSeconds % 60;

        if (maxMins <= 99) {
            minCost = Math.min(minCost, getCost(maxMins, maxSecs, startAt, moveCost, pushCost));
        }

        // Try shifted split (borrowing 1 minute into 60 seconds)
        if (maxMins > 0 && maxSecs + 60 <= 99) {
            minCost = Math.min(minCost, getCost(maxMins - 1, maxSecs + 60, startAt, moveCost, pushCost));
        }

        return minCost;
    }

    private int getCost(int mins, int secs, int startAt, int moveCost, int pushCost) {
        // Format as 4-digit representation: MMSS
        String timeStr = String.format("%02d%02d", mins, secs);

        // Remove leading zeroes
        int startIdx = 0;
        while (startIdx < timeStr.length() && timeStr.charAt(startIdx) == '0') {
            startIdx++;
        }
        
        String inputStr = timeStr.substring(startIdx);

        int cost = 0;
        int currDigit = startAt;

        for (char c : inputStr.toCharArray()) {
            int targetDigit = c - '0';
            if (currDigit != targetDigit) {
                cost += moveCost;
                currDigit = targetDigit;
            }
            cost += pushCost;
        }

        return cost;
    }
}