// ──────────────────────────────────────────────────
// Problem  : 3633. Earliest Finish Time for Land and Water Rides I
// Difficulty: Easy
// Tags     : Array, Two Pointers, Binary Search, Greedy, Sorting
// Link     : https://leetcode.com/problems/earliest-finish-time-for-land-and-water-rides-i/
// Runtime  : 4 ms (beats 24%)
// Memory   : 46800000 (beats 84%)
// Language : java
// Copyright: (c) 2026 Shweta-Sripathi. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
        int minFinishTime = Integer.MAX_VALUE;
        
        int n = landStartTime.length;
        int m = waterStartTime.length;
        
        // Try all combinations of (Land Ride i -> Water Ride j) and (Water Ride j -> Land Ride i)
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // Order 1: Land Ride i then Water Ride j
                int finishLand1 = Math.max(landStartTime[i], 0) + landDuration[i];
                int finishWater1 = Math.max(waterStartTime[j], finishLand1) + waterDuration[j];
                minFinishTime = Math.min(minFinishTime, finishWater1);
                
                // Order 2: Water Ride j then Land Ride i
                int finishWater2 = Math.max(waterStartTime[j], 0) + waterDuration[j];
                int finishLand2 = Math.max(landStartTime[i], finishWater2) + landDuration[i];
                minFinishTime = Math.min(minFinishTime, finishLand2);
            }
        }
        
        return minFinishTime;
    }
}