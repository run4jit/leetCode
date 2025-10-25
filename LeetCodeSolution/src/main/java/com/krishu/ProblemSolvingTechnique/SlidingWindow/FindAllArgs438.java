package com.krishu.ProblemSolvingTechnique.SlidingWindow;

import com.krishu.Utility;

import java.util.*;

/*
438. Find All Anagrams in a String
https://leetcode.com/problems/find-all-anagrams-in-a-string/description/

Given two strings s and p, return an array of all the start indices of p's anagrams in s. You may return the answer in any order.



Example 1:

Input: s = "cbaebabacd", p = "abc"
Output: [0,6]
Explanation:
The substring with start index = 0 is "cba", which is an anagram of "abc".
The substring with start index = 6 is "bac", which is an anagram of "abc".
Example 2:

Input: s = "abab", p = "ab"
Output: [0,1,2]
Explanation:
The substring with start index = 0 is "ab", which is an anagram of "ab".
The substring with start index = 1 is "ba", which is an anagram of "ab".
The substring with start index = 2 is "ab", which is an anagram of "ab".


Constraints:

1 <= s.length, p.length <= 3 * 104
s and p consist of lowercase English letters.
 */
public class FindAllArgs438 {
    public static List<Integer> findAnagrams(String s, String p) {

        //termination point
        if (s.length() < p.length()) {
            return new ArrayList<Integer>();
        }

        List<Integer> result = new ArrayList<>();

        Map<Character, Integer> windowS = new HashMap<>();
        Map<Character, Integer> windowP = new HashMap<>();
        //create window 
        for (int i = 0; i < p.length(); i++) {
            windowS.put(s.charAt(i), windowS.getOrDefault(s.charAt(i), 0)+1);
            windowP.put(p.charAt(i), windowP.getOrDefault(p.charAt(i), 0)+1);
        }

        if (windowP.equals(windowS)) {
            result.add(0);
        }

        for (int i = p.length(); i < s.length(); i++) {
            char currentCh = s.charAt(i); // next element which about to go in window
            int removeIndex = i - p.length(); // index of first element
            char prevCh = s.charAt(removeIndex); //first element in window
            int x = windowS.getOrDefault(prevCh, 0) - 1;
            //decrease value of first element, if its zero then remove that key.
            if (x <= 0) {
                windowS.remove(prevCh);
            } else {
                windowS.put(prevCh, x);
            }
            //update with new element
            windowS.put(currentCh, windowS.getOrDefault(currentCh, 0)+1);
            // add into result
            if (windowP.equals(windowS)) {
                result.add(i - p.length() + 1);
            }
        }
        return result;
    }


}

class Solution438 {
    public static void main(String[] args) {
        String s = "ababababab";
        String p = "aab";

        List<Integer> result = FindAllArgs438.findAnagrams(s, p);
        Utility.printArray("Result: ", result);
    }
}

