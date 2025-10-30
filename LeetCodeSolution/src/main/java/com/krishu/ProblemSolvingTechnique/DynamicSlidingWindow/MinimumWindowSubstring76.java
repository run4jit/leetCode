package com.krishu.ProblemSolvingTechnique.DynamicSlidingWindow;

import com.krishu.Utility;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class MinimumWindowSubstring76 {
    public static String minWindow(String s, String t) {
        if (t.length() > s.length()) {
            return "";
        }

        StringBuilder minWind = new StringBuilder(s);
        int left = 0;
        int right = 0;
        Map<Character, Integer> expCharMap = new HashMap<>();
        Map<Character, Integer> actCharMap = new HashMap<>();

        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            expCharMap.put(ch, expCharMap.getOrDefault(ch, 0)+1);
        }

        while (right < s.length()) {
            char ch = s.charAt(right);
            right++;
            if (expCharMap.containsKey(ch)) {
                actCharMap.put(ch, actCharMap.getOrDefault(ch, 0)+1);
            }
            while (actCharMap.equals(expCharMap) && left <= right) {
                String window = s.substring(left, right);
                if (window.length() < minWind.length()) {
                    minWind = new StringBuilder(window);;
                }

                char lch = s.charAt(left);
                int c = actCharMap.getOrDefault(lch, 0) - 1;
                if (c <= 0) {
                    actCharMap.remove(lch);
                } else {
                    actCharMap.put(lch, c);
                }
                left++;
            }
        }
        return minWind.toString();
    }
}

class Solution76 {
    public static void main(String[] args) {
        test1();
    }

    static void test1() {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        String expected = "BANC";

        String actual = MinimumWindowSubstring76.minWindow(s, t);

        if (expected.equals(actual)) {
            Utility.printResult("Result: " , actual);
        } else {
            Utility.printException(expected, actual);
        }
    }
}