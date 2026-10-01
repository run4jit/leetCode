package com.krishu.DataStructure.Linear.HashMap;

import com.krishu.Utility;

import java.util.HashMap;

/*
383. Ransom Note
https://leetcode.com/problems/ransom-note/description/


Given two strings ransomNote and magazine, return true if ransomNote can be constructed by using the letters from magazine and false otherwise.

Each letter in magazine can only be used once in ransomNote.



Example 1:

Input: ransomNote = "a", magazine = "b"
Output: false
Example 2:

Input: ransomNote = "aa", magazine = "ab"
Output: false
Example 3:

Input: ransomNote = "aa", magazine = "aab"
Output: true


Constraints:

1 <= ransomNote.length, magazine.length <= 105
ransomNote and magazine consist of lowercase English letters.



 */
public class RansomNote383 {
    public static boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character, Integer> freqRansomNote = new HashMap<>();

        for (Character ch: ransomNote.toCharArray()) {
            freqRansomNote.put(ch, freqRansomNote.getOrDefault(ch, 0) + 1);
        }

        HashMap<Character, Integer> freqMagazine = new HashMap<>();

        for (Character ch: magazine.toCharArray()) {
            freqMagazine.put(ch, freqMagazine.getOrDefault(ch, 0) + 1);
        }

        for (Character key: freqRansomNote.keySet()) {
            if (freqRansomNote.getOrDefault(key, -1) > freqMagazine.getOrDefault(key, 0)) {
                return false;
            }
        }

        return true;
    }
}

class Solution383 {
    public static void main(String[] args) {
        test1();
        test2();
        test3();
    }

    public static void test1() {
        String ransomNote = "a";
        String magazine = "b";
        boolean expected = false;
        boolean actual = RansomNote383.canConstruct(ransomNote, magazine);

        Utility.printException(expected, actual);
    }

    public static void test2() {
        String ransomNote = "aa";
        String magazine = "ab";
        boolean expected = false;
        boolean actual = RansomNote383.canConstruct(ransomNote, magazine);

        Utility.printException(expected, actual);
    }

    public static void test3() {
        String ransomNote = "aa";
        String magazine = "aab";
        boolean expected = true;
        boolean actual = RansomNote383.canConstruct(ransomNote, magazine);

        Utility.printException(expected, actual);
    }
}