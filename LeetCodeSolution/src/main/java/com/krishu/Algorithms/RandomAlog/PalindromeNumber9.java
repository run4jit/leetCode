package com.krishu.Algorithms.RandomAlog;
/*
9. Palindrome Number
https://leetcode.com/problems/palindrome-number/description/
Given an integer x, return true if x is a palindrome, and false otherwise.



Example 1:

Input: x = 121
Output: true
Explanation: 121 reads as 121 from left to right and from right to left.
Example 2:

Input: x = -121
Output: false
Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
Example 3:

Input: x = 10
Output: false
Explanation: Reads 01 from right to left. Therefore it is not a palindrome.


Constraints:

-231 <= x <= 231 - 1


Follow up: Could you solve it without converting the integer to a string?


 */


import com.krishu.Utility;

public class PalindromeNumber9 {
    public static boolean isPalindrome(int x) {
       // base case
        if (x < 0) {
            return false;
        }

        // 'long' is used because while reversing it may cross the 'int' range.
        // reverse number will be stored
        long reverseNum = 0;
        // given number will be used to compute reverse number
        long num = x;

        // repeat each digit until number become zero
        while (num != 0) {
            // get the reminder
            long reminder = num % 10;
            // compute reverse number and store it.
            reverseNum = reverseNum * 10 + reminder;
            // remove the last digit from the given number
            num = num / 10;
        }

        // compare reversed number with original given number.
        return reverseNum == x;
    }
}

class Solution9 {
    public static void main(String[] args) {
        test1();
        test2();
        test3();
    }

    static void test1() {
        int num = 121;
        boolean expected = true;
        boolean actual = PalindromeNumber9.isPalindrome(num);

        Utility.printException(expected, actual);
    }

    static void test2() {
        int num = -121;
        boolean expected = false;
        boolean actual = PalindromeNumber9.isPalindrome(num);

        Utility.printException(expected, actual);
    }

    static void test3() {
        int num = 10;
        boolean expected = false;
        boolean actual = PalindromeNumber9.isPalindrome(num);

        Utility.printException(expected, actual);
    }
}