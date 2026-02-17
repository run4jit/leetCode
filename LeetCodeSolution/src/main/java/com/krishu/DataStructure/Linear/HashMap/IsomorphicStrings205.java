package com.krishu.DataStructure.Linear.HashMap;

import com.krishu.Utility;

import java.util.HashMap;
import java.util.Map;

/*
205. Isomorphic Strings
https://leetcode.com/problems/isomorphic-strings/description/

Given two strings s and t, determine if they are isomorphic.

Two strings s and t are isomorphic if the characters in s can be replaced to get t.

All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character, but a character may map to itself.



Example 1:

Input: s = "egg", t = "add"

Output: true

Explanation:

The strings s and t can be made identical by:

Mapping 'e' to 'a'.
Mapping 'g' to 'd'.
Example 2:

Input: s = "f11", t = "b23"

Output: false

Explanation:

The strings s and t can not be made identical as '1' needs to be mapped to both '2' and '3'.

Example 3:

Input: s = "paper", t = "title"

Output: true



Constraints:

1 <= s.length <= 5 * 104
t.length == s.length
s and t consist of any valid ascii character.



 */
public class IsomorphicStrings205 {

    public static boolean isIsomorphic(String s, String t) {
        // base case
        if (s.length() != t.length()) {
            return false;
        }

        int sumForFirstString = 0; // sum value for first string
        int sumForSecondString = 0; // sum value for second string

        Map<Character, Integer> charIndexMap1 = new HashMap<>(); // char index map for first string
        Map<Character, Integer> charIndexMap2 = new HashMap<>(); // char index map for second string

        // loop each char from string anc compute sum
        for (int i = 0; i < s.length(); i++) {
            char ch1 = s.charAt(i); // get char from first string
            if (!charIndexMap1.containsKey(ch1)) { // check if char exist in first map
                charIndexMap1.put(ch1, i+1); // put the char with index value into first map
            }
            sumForFirstString += charIndexMap1.get(ch1) * (i+1); // compute sum for first string

            char ch2 = t.charAt(i); // get char from second string
            if (!charIndexMap2.containsKey(ch2)) { // check if char exist in second map
                charIndexMap2.put(ch2, i+1); // put the char with index value into second map
            }
            sumForSecondString += charIndexMap2.get(ch2) * (i+1); // compute sum for second string
        }
        return sumForFirstString == sumForSecondString; // compare both sum value. if true, means it is Isomorphic.
    }

}

class Solution205 {
    public static void main(String[] args) {
        test1();
        test2();
        test3();
        test4();
    }

    static void test1() {
        String firstString = "add";
        String secondString = "egg";
        boolean actual = IsomorphicStrings205.isIsomorphic(firstString, secondString);
        boolean expected = true;
        Utility.printException(expected, actual);
    }

    static void test2() {
        String firstString = "dda";
        String secondString = "egg";
        boolean actual = IsomorphicStrings205.isIsomorphic(firstString, secondString);
        boolean expected = false;
        Utility.printException(expected, actual);
    }

    static void test3() {
        String firstString = "foo";
        String secondString = "bar";
        boolean actual = IsomorphicStrings205.isIsomorphic(firstString, secondString);
        boolean expected = false;
        Utility.printException(expected, actual);
    }

    static void test4() {
        String firstString = "title";
        String secondString = "paper";
        boolean actual = IsomorphicStrings205.isIsomorphic(firstString, secondString);
        boolean expected = true;
        Utility.printException(expected, actual);
    }
}
