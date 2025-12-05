package com.krishu.DataStructure.Linear.String;

import com.krishu.Utility;

import java.lang.reflect.Array;
import java.util.Arrays;

public class LongestCommonPrefix14 {
    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 1) return strs[0];
        Arrays.sort(strs);
        String first = strs[0];
        int l = first.length();
        int i;
        for(i = 0; i < l; i++) {
            for(int j = 1; j < strs.length; j++) {
               if(strs[j].charAt(i) != first.charAt(i)) {
                   return first.substring(0, i);
               }
            }
        }
        return first;
    }
}

class Solution14 {
    public static void main(String[] args) {
        test1();
        test2();
        test3();

    }

    static void test1() {
        String[] strs = {"flower","flow","flight"};

        String expected = "fl";
        String actual = LongestCommonPrefix14.longestCommonPrefix(strs);

        Utility.printException(expected, actual);
    }

    static void test2() {
        String[] strs = {"dog","racecar","car"};

        String expected = "";
        String actual = LongestCommonPrefix14.longestCommonPrefix(strs);

        Utility.printException(expected, actual);
    }

    static void test3() {
        String[] strs = {"ab","a"};

        String expected = "a";
        String actual = LongestCommonPrefix14.longestCommonPrefix(strs);

        Utility.printException(expected, actual);
    }
}
