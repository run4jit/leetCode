package com.krishu.ProblemSolvingTechnique.DynamicSlidingWindow;

import com.krishu.Utility;

import java.util.HashMap;
import java.util.Map;
/*
76. Minimum Window Substring
https://leetcode.com/problems/minimum-window-substring/description/

Given two strings s and t of lengths m and n respectively, return the minimum window substring of s such that every character in t (including duplicates) is included in the window. If there is no such substring, return the empty string "".

The testcases will be generated such that the answer is unique.



Example 1:

Input: s = "ADOBECODEBANC", t = "ABC"
Output: "BANC"
Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C' from string t.
Example 2:

Input: s = "a", t = "a"
Output: "a"
Explanation: The entire string s is the minimum window.
Example 3:

Input: s = "a", t = "aa"
Output: ""
Explanation: Both 'a's from t must be included in the window.
Since the largest window of s only has one 'a', return empty string.


Constraints:

m == s.length
n == t.length
1 <= m, n <= 105
s and t consist of uppercase and lowercase English letters.


Follow up: Could you find an algorithm that runs in O(m + n) time?
 */

public class MinimumWindowSubstring76 {
    public static String minWindow(String s, String t) {
        int sLength = s.length(); // Main string length
        int tLength = t.length(); // sub string length

        // Base case
        if (tLength > sLength) {
            return "";
        }

        int left = 0; // left pointer of window
        int right = 0; // right pointer of window
        int minWindowSize = Integer.MAX_VALUE; // minimum window satisfied
        int count = 0; // count of the found char
        int startIndex = -1; // starting with negative, so we can check no result found
        Map<Character, Integer> charFeq = new HashMap<>();

        //loop through each char and store in the map with positive value
        for (int i = 0 ; i < tLength; i++) {
            char ch = t.charAt(i);
            charFeq.put(ch, charFeq.getOrDefault(ch, 0)+1);
        }

        // loop through each char in main string
        while (right < sLength) {
            char ch = s.charAt(right); // read each char

            // if char feq is positive then increment the count.
            if (charFeq.getOrDefault(ch, -1) > 0) {
                count++;
            }
            // decrease char frequency by 1.
            charFeq.put(ch, charFeq.getOrDefault(ch, 0)-1);

            // check if counter match the sub string length
            while (count == tLength && left <= right) {

                startIndex = left; // set the left pointer to start index
                int window = right - left + 1; // compute window size
                minWindowSize = Math.min(minWindowSize, window); //compute min window size

                char lch = s.charAt(left); // read left pointer char
                // update it with incrementing the frequency value.
                charFeq.put(lch, charFeq.getOrDefault(lch, 0)+1);
                // check if frequency is positive then decrement the counter.
                if (charFeq.getOrDefault(lch, charFeq.getOrDefault(lch, 0)) > 0) {
                    count--;
                }
                left++; // increment the left pointer
            }
            right++; // increment the right pointer
        }
        // if start index is negative then no match found.
        if (startIndex < 0) {
            return "";
        }
        else {
            // compute end index
            int endIndex = startIndex + minWindowSize;
            // return sub string from start to end index
            return s.substring(startIndex, endIndex);
        }
    }
}

class Solution76 {
    public static void main(String[] args) {
//        test1();
//        test2();
//        test3();
        test4();
    }

    static void test1() {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        String expected = "BANC";

        String actual = MinimumWindowSubstring76.minWindow(s, t);

        Utility.printException(expected, actual);
    }

    static void test2() {
        String s = "a";
        String t = "a";
        String expected = "a";

        String actual = MinimumWindowSubstring76.minWindow(s, t);

        Utility.printException(expected, actual);
    }

    static void test3() {
        String s = "a";
        String t = "aa";
        String expected = "";

        String actual = MinimumWindowSubstring76.minWindow(s, t);

        Utility.printException(expected, actual);
    }

    static void test4() {
        String s = "cabwefgewcwaefgcf";
        String t = "cae";
        String expected = "cwae";

        String actual = MinimumWindowSubstring76.minWindow(s, t);

        Utility.printException(expected, actual);
    }
}