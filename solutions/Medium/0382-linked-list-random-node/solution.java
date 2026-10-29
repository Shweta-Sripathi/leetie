// ──────────────────────────────────────────────────
// Problem  : 382. Linked List Random Node
// Difficulty: Medium
// Tags     : Linked List, Math, Reservoir Sampling, Randomized
// Link     : https://leetcode.com/problems/linked-list-random-node/
// Runtime  : 13 ms (beats 26%)
// Memory   : 47788000 (beats 87%)
// Language : java
// Copyright: (c) 2026 Shweta-Sripathi. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

import java.util.Random;

class Solution {
    private ListNode head;
    private Random rand;

    public Solution(ListNode head) {
        this.head = head;
        this.rand = new Random();
    }
    
    public int getRandom() {
        int scope = 1;
        int chosenValue = 0;
        ListNode curr = this.head;
        
        while (curr != null) {
            // Reservoir Sampling: with probability 1/scope, replace the chosen value
            if (rand.nextInt(scope) == 0) {
                chosenValue = curr.val;
            }
            scope++;
            curr = curr.next;
        }
        
        return chosenValue;
    }
}