// ──────────────────────────────────────────────────
// Problem  : 1604. Alert Using Same Key-Card Three or More Times in a One Hour Period
// Difficulty: Medium
// Tags     : Array, Hash Table, String, Sorting
// Link     : https://leetcode.com/problems/alert-using-same-key-card-three-or-more-times-in-a-one-hour-period/
// Runtime  : 51 ms (beats 91%)
// Memory   : 79280000 (beats 47%)
// Language : java
// Copyright: (c) 2026 Shweta-Sripathi. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

import java.util.*;

class Solution {
    public List<String> alertNames(String[] keyName, String[] keyTime) {
        Map<String, List<Integer>> nameToTimes = new HashMap<>();

        // Step 1: Group access times (converted to minutes) by worker name
        for (int i = 0; i < keyName.length; i++) {
            String name = keyName[i];
            String timeStr = keyTime[i];
            
            int hours = Integer.parseInt(timeStr.substring(0, 2));
            int minutes = Integer.parseInt(timeStr.substring(3, 5));
            int totalMinutes = hours * 60 + minutes;

            nameToTimes.computeIfAbsent(name, k -> new ArrayList<>()).add(totalMinutes);
        }

        List<String> alertedWorkers = new ArrayList<>();

        // Step 2: Check each worker's times for 3 uses within 60 minutes
        for (Map.Entry<String, List<Integer>> entry : nameToTimes.entrySet()) {
            List<Integer> times = entry.getValue();
            Collections.sort(times);

            for (int i = 2; i < times.size(); i++) {
                if (times.get(i) - times.get(i - 2) <= 60) {
                    alertedWorkers.add(entry.getKey());
                    break;
                }
            }
        }

        // Step 3: Sort result names alphabetically
        Collections.sort(alertedWorkers);
        return alertedWorkers;
    }
}