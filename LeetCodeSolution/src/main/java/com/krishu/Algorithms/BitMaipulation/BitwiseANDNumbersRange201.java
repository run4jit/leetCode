package com.krishu.Algorithms.BitMaipulation;

import com.krishu.Utility;

/*
201. Bitwise AND of Numbers Range
https://leetcode.com/problems/bitwise-and-of-numbers-range/description/

Given two integers left and right that represent the range [left, right], return the bitwise AND of all numbers in this range, inclusive.



Example 1:

Input: left = 5, right = 7
Output: 4
Example 2:

Input: left = 0, right = 0
Output: 0
Example 3:

Input: left = 1, right = 2147483647
Output: 0


Constraints:

0 <= left <= right <= 231 - 1
 */
public class BitwiseANDNumbersRange201 {
    public static int brute_force_rangeBitwiseAnd(int left, int right) {
        int ans = left;
        for (int i = left+1; i <= right; i++) {
            ans = ans & i;
        }
        return ans;
    }

    public static int rangeBitwiseAnd(int left, int right) {
        // first find the left common bits after removing right bits one by one
        // keep count of right shift.
        // once both number matches, then left shift of any one numbe by right shifted bits count.
        int shiftCount = 0;
        while (left != right) {
            left = left >> 1; // remove right most bit
            right = right >> 1; // remove right most bit
            shiftCount++; // increment bits count.
        }
        return left << shiftCount; // left bits shifted as many right bit.
    }

    public static int rangeBitwiseAndTech2(int left, int right) {
        // remove the all right bits except the left most bit.
        // loop till right grater than left
        while (left < right) {
            right = right & (right-1);
        }
        return left & right; // finally and left and right number
    }
}

class Solution201 {
    public static void main(String[] args) {
        test1();
        test2();
        test3();
        test4();
        test5();
    }

    static void test1() {
        int left = 5;
        int right = 7;
        int expected = 4;

        int result = BitwiseANDNumbersRange201.rangeBitwiseAnd(left, right);

        Utility.printException(expected, result);
    }

    static void test2() {
        int left = 0;
        int right = 0;
        int expected = 0;

        int result = BitwiseANDNumbersRange201.rangeBitwiseAnd(left, right);

        Utility.printException(expected, result);
    }

    static void test3() {
        int left = 1;
        int right = 2147483647;
        int expected = 0;

        int result = BitwiseANDNumbersRange201.rangeBitwiseAndTech2(left, right);

        Utility.printException(expected, result);
    }

    static void test4() {
        int left = 1;
        int right = 1;
        int expected = 1;

        int result = BitwiseANDNumbersRange201.rangeBitwiseAndTech2(left, right);

        Utility.printException(expected, result);
    }
    static void test5() {
        int left = 1;
        int right = 2;
        int expected = 0;

        int result = BitwiseANDNumbersRange201.brute_force_rangeBitwiseAnd(left, right);

        Utility.printException(expected, result);
    }
}