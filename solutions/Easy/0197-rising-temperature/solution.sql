-- ──────────────────────────────────────────────────
-- Problem  : 197. Rising Temperature
-- Difficulty: Easy
-- Tags     : Database
-- Link     : https://leetcode.com/problems/rising-temperature/
-- Runtime  : 80 ms (beats 0%)
-- Memory   : 0B (beats 0%)
-- Language : mysql
-- Copyright: (c) 2026 Shweta-Sripathi. All rights reserved.
-- Synced by: leetie
-- ──────────────────────────────────────────────────

# Write your MySQL query statement below
SELECT w1.id
FROM Weather w1
JOIN Weather w2
  ON DATEDIFF(w1.recordDate, w2.recordDate) = 1
WHERE w1.temperature > w2.temperature;