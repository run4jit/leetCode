package com.krishu.ProblemSolvingTechnique.DynamicSlidingWindow;

import com.krishu.Utility;

import java.util.HashMap;
import java.util.Map;

/*
395. Longest Substring with At Least K Repeating Characters
https://leetcode.com/problems/longest-substring-with-at-least-k-repeating-characters/description/
 */
public class LongestSubstringAtLeastKRepeatingChar395 {
    public static int longestSubstring(String s, int k) {

        int start = 0;
        int end = 0;
        int maxLength = -1;

        Map<Character, Integer> feqMap = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            feqMap.put(ch, feqMap.getOrDefault(ch, 0)+1);
        }

        while (end < s.length()) {
            char ch = s.charAt(end);
            int feq = feqMap.get(ch);
            if (feq < k) {
                maxLength = Math.max(maxLength, end - start);
                start = end + 1;
            }
            end++;
        }
        if (maxLength < 0) {
            maxLength = Math.max(maxLength, end - start);
        }
        return maxLength;
    }
}

class  Soluion395 {
    public static void main(String[] args) {
//        test1();
//        test2();
        test3();
    }

    static void test1() {
        String str = "aaabb";
        int k = 3;
        int expected = 3;

        int actual = LongestSubstringAtLeastKRepeatingChar395.longestSubstring(str, k);
        Utility.printException(expected, actual);

    }

    static void test2() {
        String str = "ababbc";
        int k = 2;
        int expected = 5;

        int actual = LongestSubstringAtLeastKRepeatingChar395.longestSubstring(str, k);
        Utility.printException(expected, actual);

    }

    static void test3() {
        String str = "aaabbb";
        int k = 3;
        int expected = 6;

        int actual = LongestSubstringAtLeastKRepeatingChar395.longestSubstring(str, k);
        Utility.printException(expected, actual);

    }

    static void test4() {
        String str = "ababacb";
        int k = 3;
        int expected = 0;

        int actual = LongestSubstringAtLeastKRepeatingChar395.longestSubstring(str, k);
        Utility.printException(expected, actual);

    }
}