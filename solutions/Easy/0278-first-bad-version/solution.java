// ──────────────────────────────────────────────────
// Problem  : 278. First Bad Version
// Difficulty: Easy
// Tags     : Binary Search, Interactive
// Link     : https://leetcode.com/problems/first-bad-version/
// Runtime  : 13 ms (beats 100%)
// Memory   : 41656000 (beats 87%)
// Language : java
// Copyright: (c) 2026 Shweta-Sripathi. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int left = 1;
        int right = n;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (isBadVersion(mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}