// ──────────────────────────────────────────────────
// Problem  : 2183. Count Array Pairs Divisible by K
// Difficulty: Hard
// Tags     : Array, Hash Table, Math, Counting, Number Theory, Euclidean Algorithm, Greatest Common Divisor
// Link     : https://leetcode.com/problems/count-array-pairs-divisible-by-k/
// Runtime  : 37 ms (beats 89%)
// Memory   : 75812000 (beats 87%)
// Language : java
// Copyright: (c) 2026 Shweta-Sripathi. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

import java.util.*;

class Solution {
    public long countPairs(int[] nums, int k) {
        Map<Integer, Long> gcdCounts = new HashMap<>();

        // Store frequency of gcd(num, k)
        for (int num : nums) {
            int g = gcd(num, k);
            gcdCounts.put(g, gcdCounts.getOrDefault(g, 0L) + 1);
        }

        List<Integer> divisors = new ArrayList<>(gcdCounts.keySet());
        long ans = 0;

        // Iterate over all unique divisor pairs
        for (int i = 0; i < divisors.size(); i++) {
            int d1 = divisors.get(i);
            long count1 = gcdCounts.get(d1);

            // Pair with itself
            if ((long) d1 * d1 % k == 0) {
                ans += count1 * (count1 - 1) / 2;
            }

            // Pair with distinct divisors
            for (int j = i + 1; j < divisors.size(); j++) {
                int d2 = divisors.get(j);
                long count2 = gcdCounts.get(d2);

                if ((long) d1 * d2 % k == 0) {
                    ans += count1 * count2;
                }
            }
        }

        return ans;
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