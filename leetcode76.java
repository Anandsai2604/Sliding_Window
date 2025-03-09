package sliding_window;

// 76. Minimum Window Substring

// Hard

// Given two strings s and t of lengths m and n respectively, return the minimum window substring of s such that every character in t (including duplicates) is included in the window. If there is no such substring, return the empty string "".

// The testcases will be generated such that the answer is unique.

 

// Example 1:

// Input: s = "ADOBECODEBANC", t = "ABC"
// Output: "BANC"
// Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C' from string t.
// Example 2:

// Input: s = "a", t = "a"
// Output: "a"
// Explanation: The entire string s is the minimum window.
// Example 3:

// Input: s = "a", t = "aa"
// Output: ""
// Explanation: Both 'a's from t must be included in the window.
// Since the largest window of s only has one 'a', return empty string.
 

// Constraints:

// m == s.length
// n == t.length
// 1 <= m, n <= 105
// s and t consist of uppercase and lowercase English letters.


import java.util.*;

public class leetcode76 {
    public String minWindow(String s, String t) {
        if(s.length() < t.length()) return "";

        Map<Character,Integer> mp = new HashMap<>();
        for(char c : t.toCharArray()){
            mp.put(c, mp.getOrDefault(c,0)+1);
        }

        int left = 0, right = 0;
        int res = Integer.MAX_VALUE;
        int cnt  = 0;   
        int start = 0;

        Map<Character,Integer> s_map = new HashMap<>();
        while(right < s.length()){
            char c = s.charAt(right);

            s_map.put(c,s_map.getOrDefault(c,0)+1);

            if(mp.containsKey(c) && s_map.get(c) <= mp.get(c)){
                cnt++;
            }

            while(cnt == t.length()){
                if(right - left + 1 < res){
                    res = right - left + 1;
                    start = left;
                }
                char l = s.charAt(left);
                s_map.put(l,s_map.get(l) - 1);

                if(mp.containsKey(l) && s_map.get(l) < mp.get(l)){
                    cnt--;
                }

                left++;
                
            }

            
            right++;
            
        }
        return res == Integer.MAX_VALUE ? "" : s.substring(start,start+res);
    }
}