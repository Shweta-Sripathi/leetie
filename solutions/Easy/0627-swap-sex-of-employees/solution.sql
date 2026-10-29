-- ──────────────────────────────────────────────────
-- Problem  : 627. Swap Sex of Employees
-- Difficulty: Easy
-- Tags     : Database
-- Link     : https://leetcode.com/problems/swap-sex-of-employees/
-- Runtime  : 298 ms (beats 26%)
-- Memory   : 0B (beats 100%)
-- Language : mysql
-- Copyright: (c) 2026 Shweta-Sripathi. All rights reserved.
-- Synced by: leetie
-- ──────────────────────────────────────────────────

# Write your MySQL query statement below
UPDATE Salary 
SET sex = CASE 
    WHEN sex = 'm' THEN 'f' 
    ELSE 'm' 
END;