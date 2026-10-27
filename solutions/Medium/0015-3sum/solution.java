// ──────────────────────────────────────────────────
// Problem  : 15. 3Sum
// Difficulty: Medium
// Tags     : Array, Two Pointers, Sorting
// Link     : https://leetcode.com/problems/3sum/
// Runtime  : 33 ms (beats 69%)
// Memory   : 58632000 (beats 89%)
// Language : java
// Copyright: (c) 2026 Shweta-Sripathi. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        
        // Step 1: Sort the array
        Arrays.sort(nums);
        
        // Step 2: Iterate through the array
        for (int i = 0; i < nums.length - 2; i++) {
            // Optimization: Since the array is sorted, if the first number is > 0, 
            // the sum of 3 numbers can never be 0.
            if (nums[i] > 0) {
                break;
            }
            
            // Step 3: Skip duplicate anchors
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            
            // Step 4: Two pointers
            int left = i + 1;
            int right = nums.length - 1;
            
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                
                if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    
                    // Skip duplicates for the left pointer
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    // Skip duplicates for the right pointer
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    
                    left++;
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        
        return result;
    }
}