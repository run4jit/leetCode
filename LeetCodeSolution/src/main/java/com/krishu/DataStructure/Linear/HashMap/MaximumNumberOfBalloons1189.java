package com.krishu.DataStructure.Linear.HashMap;

import com.krishu.Utility;

import java.util.HashMap;
import java.util.Map;
/*
1189. Maximum Number of Balloons
https://leetcode.com/problems/maximum-number-of-balloons/description/

Given a string text, you want to use the characters of text to form as many instances of the word "balloon" as possible.

You can use each character in text at most once. Return the maximum number of instances that can be formed.



Example 1:



Input: text = "nlaebolko"
Output: 1
Example 2:



Input: text = "loonbalxballpoon"
Output: 2
Example 3:

Input: text = "leetcode"
Output: 0


Constraints:

1 <= text.length <= 104
text consists of lower case English letters only.


Note: This question is the same as 2287: Rearrange Characters to Make Target String.
 */
public class MaximumNumberOfBalloons1189 {
    public static int maxNumberOfBalloons(String text) {
        String balloon = "balloon"; // given string need to be recreated
        // base check
        if (balloon.length() > text.length()) {
            return 0;
        }

        // create char frequency of given word "ballon"
        Map<Character, Integer> wordFeq = new HashMap<>();
        for (int i = 0; i < balloon.length(); i++) {
            char ch = balloon.charAt(i);
            wordFeq.put(ch, wordFeq.getOrDefault(ch, 0) + 1);
        }

        // create char frequency of text
        Map<Character, Integer> textFeq = new HashMap<>();
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            textFeq.put(ch, textFeq.getOrDefault(ch, 0) + 1);
        }

        // min value stored
        int min = Integer.MAX_VALUE;
        //loop char by char of "balloon"
        for (int i = 0; i < balloon.length(); i++) {
            char ch = balloon.charAt(i); // char in balloon.
            if (textFeq.containsKey(ch)) { // check is this char exist in text
                // get the multiple of char exist in text
                int current = textFeq.get(ch) / wordFeq.get(ch);
                // if count is not match with word frequency then it will return zero.
                // otherwise calculate minimum of char can form word balloon.
                if (current > 0) {
                    min = Math.min(min, current);
                } else {
                    return 0; // word frequency not match. eg. expecte l-2 but it has only l-1
                }
            } else {
                return 0; // if char not found in the text
            }
        }
        return min; // minimum number of word can be formed
    }
}

class Solution1189 {
    public static void main(String[] args) {
        test1();
        test2();
        test3();
        test4();
    }

    public static void test1() {
        String text = "nlaebolko";
        int expected = 1;
        int actual = MaximumNumberOfBalloons1189.maxNumberOfBalloons(text);

        Utility.printException(expected, actual);
    }

    public static void test2() {
        String text = "loonbalxballpoon";
        int expected = 2;
        int actual = MaximumNumberOfBalloons1189.maxNumberOfBalloons(text);

        Utility.printException(expected, actual);
    }

    public static void test3() {
        String text = "leetcode";
        int expected = 0;
        int actual = MaximumNumberOfBalloons1189.maxNumberOfBalloons(text);

        Utility.printException(expected, actual);
    }

    public static void test4() {
        String text = "balonno";
        int expected = 0;
        int actual = MaximumNumberOfBalloons1189.maxNumberOfBalloons(text);

        Utility.printException(expected, actual);
    }
}