-- ──────────────────────────────────────────────────
-- Problem  : 196. Delete Duplicate Emails
-- Difficulty: Easy
-- Tags     : Database
-- Link     : https://leetcode.com/problems/delete-duplicate-emails/
-- Runtime  : 82 ms (beats 0%)
-- Memory   : 0B (beats 0%)
-- Language : mysql
-- Copyright: (c) 2026 Shweta-Sripathi. All rights reserved.
-- Synced by: leetie
-- ──────────────────────────────────────────────────

DELETE p1 
FROM Person p1, Person p2
WHERE p1.email = p2.email 
  AND p1.id > p2.id;