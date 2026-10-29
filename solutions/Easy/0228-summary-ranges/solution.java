// ──────────────────────────────────────────────────
// Problem  : 228. Summary Ranges
// Difficulty: Easy
// Tags     : Array
// Link     : https://leetcode.com/problems/summary-ranges/
// Runtime  : 3 ms (beats 79%)
// Memory   : 42512000 (beats 91%)
// Language : java
// Copyright: (c) 2026 Shweta-Sripathi. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();
        
        for (int i = 0; i < nums.length; i++) {
            int start = nums[i];
            
            while (i + 1 < nums.length && nums[i + 1] == nums[i] + 1) {
                i++;
            }
            
            if (start != nums[i]) {
                result.add(start + "->" + nums[i]);
            } else {
                result.add(String.valueOf(start));
            }
        }
        
        return result;
    }
}