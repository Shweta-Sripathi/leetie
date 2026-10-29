// ──────────────────────────────────────────────────
// Problem  : 706. Design HashMap
// Difficulty: Easy
// Tags     : Array, Hash Table, Linked List, Design, Hash Function
// Link     : https://leetcode.com/problems/design-hashmap/
// Runtime  : 14 ms (beats 99%)
// Memory   : 47772000 (beats 96%)
// Language : java
// Copyright: (c) 2026 Shweta-Sripathi. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class MyHashMap {
    private static class Node {
        int key, value;
        Node next;
        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private final int BUCKET_SIZE = 769;
    private Node[] buckets;

    public MyHashMap() {
        buckets = new Node[BUCKET_SIZE];
    }
    
    private int hash(int key) {
        return Integer.hashCode(key) % BUCKET_SIZE;
    }

    public void put(int key, int value) {
        int index = hash(key);
        if (buckets[index] == null) {
            buckets[index] = new Node(key, value);
            return;
        }
        Node curr = buckets[index];
        while (true) {
            if (curr.key == key) {
                curr.value = value;
                return;
            }
            if (curr.next == null) break;
            curr = curr.next;
        }
        curr.next = new Node(key, value);
    }
    
    public int get(int key) {
        int index = hash(key);
        Node curr = buckets[index];
        while (curr != null) {
            if (curr.key == key) {
                return curr.value;
            }
            curr = curr.next;
        }
        return -1;
    }
    
    public void remove(int key) {
        int index = hash(key);
        Node curr = buckets[index];
        if (curr == null) return;
        if (curr.key == key) {
            buckets[index] = curr.next;
            return;
        }
        while (curr.next != null) {
            if (curr.next.key == key) {
                curr.next = curr.next.next;
                return;
            }
            curr = curr.next;
        }
    }
}