-- ──────────────────────────────────────────────────
-- Problem  : 183. Customers Who Never Order
-- Difficulty: Easy
-- Tags     : Database
-- Link     : https://leetcode.com/problems/customers-who-never-order/
-- Runtime  : 656 ms (beats 36%)
-- Memory   : 0B (beats 100%)
-- Language : mysql
-- Copyright: (c) 2026 Shweta-Sripathi. All rights reserved.
-- Synced by: leetie
-- ──────────────────────────────────────────────────

# Write your MySQL query statement below
SELECT name AS Customers 
FROM Customers 
WHERE id NOT IN (SELECT customerId FROM Orders);