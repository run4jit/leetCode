package com.krishu.ProblemSolvingTechnique.DynamicSlidingWindow;

import com.krishu.Utility;

import java.util.HashSet;
import java.util.Set;

/*
3. Longest Substring Without Repeating Characters
https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
Given a string s, find the length of the longest substring without duplicate characters.



Example 1:

Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3. Note that "bca" and "cab" are also correct answers.
Example 2:

Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
Example 3:

Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.


Constraints:

0 <= s.length <= 5 * 104
s consists of English letters, digits, symbols and spaces.


 */
public class LongestSubString3 {
    public static int lengthOfLongestSubstring(String s) {
        //Termination case
        if (s == null){
            return 0;
        }
        if (s.length() == 1) {
            return 1;
        }


        int start = 0; // start index of window
        int end = 0; // end index of window
        int max = 0; // max sub string size
        // keep distinct char of sub string
        Set<Character> set = new HashSet<>();

        // loop from start to end of string
        while (end < s.length()) {
            //get the end age of char
            char ch = s.charAt(end);
            // check this char exist in set, then remove till this char.
            while (set.contains(ch) && start <= end) {
                //shrink the window till the duplicate
                set.remove(s.charAt(start));
                // increment the left side of window
                start++;
            }
            // add the char
            set.add(ch);
            end++; // increment the right side of window

            // compute the max of sub string.
            max = Math.max(set.size(), max);

        }
        // return max sub string size.
        return max;
    }
}

class Solution3 {
    public static void main(String[] args) {
        test1();
        test2();
        test3();
    }

    static void test1() {
        String str = "abcabcbb";
        int result = LongestSubString3.lengthOfLongestSubstring(str);
        Utility.printResult("Result: ", result);
    }

    static void test2() {
        String str = "bbbbb";
        int result = LongestSubString3.lengthOfLongestSubstring(str);
        Utility.printResult("Result: ", result);
    }

    static void test3() {
        String str = "pwwkew";
        int result = LongestSubString3.lengthOfLongestSubstring(str);
        Utility.printResult("Result: ", result);
    }
}