package com.krishu.DataStructure.Linear.String;

import com.krishu.Utility;

import java.util.Locale;

public class ValidPalindrome125 {
    public static boolean isPalindrome(String s) {
        // base case
        if (s.length() <= 1) {
            return true;
        }
        // convert to lower case
        s = s.toLowerCase();
        // create string to only alphanumerical value from sentence.
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch >= 'a' && ch <= 'z') {
                stringBuilder.append(ch);
            } else if (ch >= '0' && ch <= '9') {
                stringBuilder.append(ch);
            }
        }

        // printing alphanumerical value after conversion
        System.out.println(stringBuilder.toString());

        int start = 0; // starting index of string
        int end = stringBuilder.length() - 1; // end index of string
        // loop string char by char from start and end edge.
        while (start < end) {
            // check if both side char is not matched then it's not palindrome.
            if (stringBuilder.charAt(start++) != stringBuilder.charAt(end--)) {
                return false;
            }
        }
        // return string is palindrome
        return true;
    }
}

class Solution125 {
    public static void main(String[] args) {
        test1();
        test2();
        test3();
        test4();
    }

    static void test1() {
        String str = "{ pa ? pa p,";
        boolean expected = true;
        boolean actual = ValidPalindrome125.isPalindrome(str);

        Utility.printException(expected, actual);
    }

    static void test2() {
        String str = "A man, a plan, a canal: Panama";
        boolean expected = true;
        boolean actual = ValidPalindrome125.isPalindrome(str);

        Utility.printException(expected, actual);
    }

    static void test3() {
        String str = "race a car";
        boolean expected = false;
        boolean actual = ValidPalindrome125.isPalindrome(str);

        Utility.printException(expected, actual);
    }

    static void test4() {
        String str = " ";
        boolean expected = true;
        boolean actual = ValidPalindrome125.isPalindrome(str);

        Utility.printException(expected, actual);
    }
}