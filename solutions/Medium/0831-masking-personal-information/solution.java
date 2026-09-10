// ──────────────────────────────────────────────────
// Problem  : 831. Masking Personal Information
// Difficulty: Medium
// Tags     : String
// Link     : https://leetcode.com/problems/masking-personal-information/
// Runtime  : 5 ms (beats 37%)
// Memory   : 48832000 (beats 18%)
// Language : java
// Copyright: (c) 2026 Shweta-Sripathi. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public String maskPII(String s) {
        if (s.contains("@")) {
            s = s.toLowerCase();
            int atIndex = s.indexOf('@');
            char firstChar = s.charAt(0);
            char lastChar = s.charAt(atIndex - 1);
            String domain = s.substring(atIndex);
            
            return firstChar + "*****" + lastChar + domain;
        } else {
            String digits = s.replaceAll("\\D", "");
            String localNumber = "***-***-" + digits.substring(digits.length() - 4);
            int countryCodeLength = digits.length() - 10;
            
            if (countryCodeLength == 0) {
                return localNumber;
            }
            
            StringBuilder sb = new StringBuilder("+");
            for (int i = 0; i < countryCodeLength; i++) {
                sb.append("*");
            }
            sb.append("-").append(localNumber);
            
            return sb.toString();
        }
    }
}