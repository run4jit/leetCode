package com.krishu.ProblemSolvingTechnique.DynamicSlidingWindow;

import com.krishu.Utility;

import java.util.HashMap;
import java.util.Map;
/*
424. Longest Repeating Character Replacement
https://leetcode.com/problems/longest-repeating-character-replacement/description/

You are given a string s and an integer k. You can choose any character of the string and change it to any other uppercase English character. You can perform this operation at most k times.

Return the length of the longest substring containing the same letter you can get after performing the above operations.



Example 1:

Input: s = "ABAB", k = 2
Output: 4
Explanation: Replace the two 'A's with two 'B's or vice versa.
Example 2:

Input: s = "AABABBA", k = 1
Output: 4
Explanation: Replace the one 'A' in the middle with 'B' and form "AABBBBA".
The substring "BBBB" has the longest repeating letters, which is 4.
There may exists other ways to achieve this answer too.


Constraints:

1 <= s.length <= 105
s consists of only uppercase English letters.
0 <= k <= s.length
 */
public class LongestRepeatingCharacter424 {
    public static int characterReplacement(String s, int k) {
        //Base case
        if (s == null || s.isBlank()) {
            return 0;
        }

        int left = 0; // left pointer of window
        int right = 0; // right pointer of window
        int maxFeq = 0; // any character having max frequency
        int maxWindow = 0; // hold max width of window after replacing given k.
        Map<Character, Integer> charFeqMap = new HashMap<>(); // hold each char frequency.

        // loop every char in string.
        while (right < s.length()) {
            char ch = s.charAt(right); // get the char from starting
            // add char to map, otherwise increase the frequency count.
            charFeqMap.put(ch, charFeqMap.getOrDefault(ch, 0)+1);
            // compute Max frequency of a char
            maxFeq = Math.max(maxFeq, charFeqMap.getOrDefault(ch, 0));
            // increment the window size.
            right++;

            // compute window size.
            int window = right - left;

            // when diff of window and max frequency is larger than k, shrink the window.
            if ((window - maxFeq) > k) {
                char lch = s.charAt(left); // char from left pointer
                // decrease the frequency of left pointing char.
                charFeqMap.put(lch, charFeqMap.getOrDefault(lch, 0)-1);
                // compute max char frequency.
                maxFeq = Math.max(maxFeq, charFeqMap.getOrDefault(lch, 0));
                left++; // shrink window size
                // compute window size
                window = right - left;
            }
            // compute max window size considering the replacement.
            maxWindow = Math.max(maxWindow, window);
        }
        // return the max window size as result.
        return maxWindow;
    }
}

class Solution424 {
    public static void main(String[] args) {
        test1();
        test2();
        test3();
    }

    static void test1() {
        String str = "ABAB";
        int k = 2;
        int result = LongestRepeatingCharacter424.characterReplacement(str, k);
        Utility.printResult("Result: ", result);
    }

    static void test2() {
        String str = "AABABBA";
        int k = 1;
        int result = LongestRepeatingCharacter424.characterReplacement(str, k);
        Utility.printResult("Result: ", result);
    }

    static void test3() {
        String str = "AABABBCCCA";
        int k = 0;
        int result = LongestRepeatingCharacter424.characterReplacement(str, k);
        Utility.printResult("Result: ", result);
    }
}
