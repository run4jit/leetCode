package com.krishu.DataStructure.Linear.String;

import com.krishu.Utility;
import jdk.jshell.execution.Util;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/*
151. Reverse Words in a String
https://leetcode.com/problems/reverse-words-in-a-string/description/

Given an input string s, reverse the order of the words.

A word is defined as a sequence of non-space characters. The words in s will be separated by at least one space.

Return a string of the words in reverse order concatenated by a single space.

Note that s may contain leading or trailing spaces or multiple spaces between two words. The returned string should only have a single space separating the words. Do not include any extra spaces.



Example 1:

Input: s = "the sky is blue"
Output: "blue is sky the"
Example 2:

Input: s = "  hello world  "
Output: "world hello"
Explanation: Your reversed string should not contain leading or trailing spaces.
Example 3:

Input: s = "a good   example"
Output: "example good a"
Explanation: You need to reduce multiple spaces between two words to a single space in the reversed string.


Constraints:

1 <= s.length <= 104
s contains English letters (upper-case and lower-case), digits, and spaces ' '.
There is at least one word in s.
,
Follow-up: If the string data type is mutable in your language, can you solve it in-place with O(1) extra space?

 */

public class ReverseWordsInString151 {
    public static String reverseWords(String s) {
        String[] words = s.trim().split("\\s+");
        List<String> wordList = Arrays.asList(words);
        Collections.reverse(wordList);
        return String.join(" ", wordList);
    }

    public static String reverseWords2(String s) {
        int start = 0; // start pointer
        int end = 0; // end pointer
        StringBuilder revStr = new StringBuilder(); // string buffer to hold the reverse string
        while (end < s.length()) { // loop till the end of the given string
            if(s.charAt(start) == ' ') { // check if start point at empty string then move to next valid char
                start++; // move to next valid char
            } else if (start > end) { // start moved to more than end then make them eaqual
                end = start; // set pointer at same location
            } else if (s.charAt(end) == ' ') { // if end reach to space char, it's mean that end of one word
                if (!revStr.isEmpty()) { // we need to append space between two words
                    revStr.insert(0, " "); // add space before adding new word
                }
                revStr.insert(0, s.substring(start, end)); // insert new word at begging of the sentence
                start = end; // reset start and end pointer
            }
            end++; // keep incrementing end pointer
        }

        // out of the loop we need to check for the last word.
        if (end > start) {
            String str = s.substring(start, end).trim(); // the last wold
            if (!str.isEmpty()) { // check is it empty
                if (!revStr.isEmpty()) { // if sentence have more than one word.
                    revStr.insert(0, " "); // add empty before adding last word
                }
                revStr.insert(0, str); // add last word at begging
            }
        }
        // return the result
        return revStr.toString();
    }
}

class Solution151 {
    public static void main(String[] args) {
        test1();
        test2();
        test3();
        test4();
    }

    static void test1() {
        String str = "the sky is blue";
        String expected = "blue is sky the";
        String actual = ReverseWordsInString151.reverseWords(str);
        Utility.printException(expected, actual);
    }

    static void test2() {
        String str = "  hello world  ";
        String expected = "world hello";
        String actual = ReverseWordsInString151.reverseWords2(str);
        Utility.printException(expected, actual);
    }

    static void test3() {
        String str = "a good   example";
        String expected = "example good a";
        String actual = ReverseWordsInString151.reverseWords2(str);
        Utility.printException(expected, actual);
    }

    static void test4() {
        String str = "EPY2giL";
        String expected = "EPY2giL";
        String actual = ReverseWordsInString151.reverseWords2(str);
        Utility.printException(expected, actual);
    }
}