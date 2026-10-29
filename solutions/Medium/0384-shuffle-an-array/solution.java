// ──────────────────────────────────────────────────
// Problem  : 384. Shuffle an Array
// Difficulty: Medium
// Tags     : Array, Math, Design, Randomized
// Link     : https://leetcode.com/problems/shuffle-an-array/
// Runtime  : 52 ms (beats 55%)
// Memory   : 51944000 (beats 87%)
// Language : java
// Copyright: (c) 2026 Shweta-Sripathi. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

import java.util.Random;

class Solution {
    private int[] original;
    private int[] array;
    private Random rand;

    public Solution(int[] nums) {
        this.original = nums;
        this.array = nums.clone();
        this.rand = new Random();
    }
    
    public int[] reset() {
        this.array = original.clone();
        return this.array;
    }
    
    public int[] shuffle() {
        for (int i = array.length - 1; i > 0; i--) {
            int j = rand.nextInt(i + 1);
            // Swap array[i] and array[j]
            int temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }
        return this.array;
    }
}