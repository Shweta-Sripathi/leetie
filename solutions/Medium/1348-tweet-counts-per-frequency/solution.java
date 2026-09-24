// ──────────────────────────────────────────────────
// Problem  : 1348. Tweet Counts Per Frequency
// Difficulty: Medium
// Tags     : Hash Table, String, Binary Search, Design, Sorting, Ordered Set
// Link     : https://leetcode.com/problems/tweet-counts-per-frequency/
// Runtime  : 99 ms (beats 71%)
// Memory   : 57492000 (beats 13%)
// Language : java
// Copyright: (c) 2026 Shweta-Sripathi. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

import java.util.*;

class TweetCounts {
    // Map tweet name to a TreeMap of (timestamp -> count)
    private Map<String, TreeMap<Integer, Integer>> map;

    public TweetCounts() {
        map = new HashMap<>();
    }
    
    public void recordTweet(String tweetName, int time) {
        map.putIfAbsent(tweetName, new TreeMap<>());
        TreeMap<Integer, Integer> timeMap = map.get(tweetName);
        timeMap.put(time, timeMap.getOrDefault(time, 0) + 1);
    }
    
    public List<Integer> getTweetCountsPerFrequency(String freq, String tweetName, int startTime, int endTime) {
        int interval;
        if (freq.equals("minute")) {
            interval = 60;
        } else if (freq.equals("hour")) {
            interval = 3600;
        } else { // "day"
            interval = 86400;
        }

        // Calculate the number of chunks needed
        int totalChunks = (endTime - startTime) / interval + 1;
        List<Integer> result = new ArrayList<>(Collections.nCopies(totalChunks, 0));

        TreeMap<Integer, Integer> timeMap = map.get(tweetName);
        if (timeMap == null) {
            return result;
        }

        // Retrieve only the timestamps in the range [startTime, endTime]
        SortedMap<Integer, Integer> subMap = timeMap.subMap(startTime, true, endTime, true);

        for (Map.Entry<Integer, Integer> entry : subMap.entrySet()) {
            int time = entry.getKey();
            int count = entry.getValue();
            
            // Map the timestamp to its corresponding chunk index
            int index = (time - startTime) / interval;
            result.set(index, result.get(index) + count);
        }

        return result;
    }
}

/**
 * Your TweetCounts object will be instantiated and called as such:
 * TweetCounts obj = new TweetCounts();
 * obj.recordTweet(tweetName,time);
 * List<Integer> param_2 = obj.getTweetCountsPerFrequency(freq,tweetName,startTime,endTime);
 */

/**
 * Your TweetCounts object will be instantiated and called as such:
 * TweetCounts obj = new TweetCounts();
 * obj.recordTweet(tweetName,time);
 * List<Integer> param_2 = obj.getTweetCountsPerFrequency(freq,tweetName,startTime,endTime);
 */