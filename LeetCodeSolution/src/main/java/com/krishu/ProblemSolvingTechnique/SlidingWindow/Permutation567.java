package com.krishu.ProblemSolvingTechnique.SlidingWindow;

import com.krishu.Utility;

import java.util.HashMap;
import java.util.Map;

/*
567. Permutation in String
https://leetcode.com/problems/permutation-in-string/description/
Given two strings s1 and s2, return true if s2 contains a permutation of s1, or false otherwise.

In other words, return true if one of s1's permutations is the substring of s2.



Example 1:

Input: s1 = "ab", s2 = "eidbaooo"
Output: true
Explanation: s2 contains one permutation of s1 ("ba").
Example 2:

Input: s1 = "ab", s2 = "eidboaoo"
Output: false


Constraints:

1 <= s1.length, s2.length <= 104
s1 and s2 consist of lowercase English letters.
 */
public class Permutation567 {
    public static boolean checkInclusion(String s1, String s2) {
        //termination point
        if (s1.length() > s2.length()) {
            return false;
        }
        Map<Character, Integer> s1Map = new HashMap<>();
        Map<Character, Integer> s2Map = new HashMap<>();

        for (int  i = 0; i < s1.length(); i++) {
            s1Map.put(s1.charAt(i), s1Map.getOrDefault(s1.charAt(i), 0)+1);
            s2Map.put(s2.charAt(i), s2Map.getOrDefault(s2.charAt(i), 0)+1);
        }

        if (s1Map.equals(s2Map)) {
            return true;
        }

        for (int i = s1.length(); i < s2.length(); i++) {
            char nextCh = s2.charAt(i);
            char removeCh = s2.charAt(i - s1.length());
            //remove previous item
            int c = s2Map.getOrDefault(removeCh, 0) - 1;
            if (c <= 0) {
                s2Map.remove(removeCh);
            } else {
                s2Map.put(removeCh, c);
            }
            //add next item
            s2Map.put(nextCh, s2Map.getOrDefault(nextCh, 0)+1);

            //compare and update result
            if (s1Map.equals(s2Map)) {
                return true;
            }
        }
        return false;
    }
}

class Solution567 {
    public static void main(String[] args) {
        testSuccess();
        testFail();
    }

    public static void testSuccess() {
        String s1 = "ab";
        String s2 = "eidbaooo";
        Utility.printResult("result: ", Permutation567.checkInclusion(s1, s2));
    }

    public static void testFail() {
        String s1 = "ab";
        String s2 = "eidboaoo";
        Utility.printResult("result: ", Permutation567.checkInclusion(s1, s2));
    }
}