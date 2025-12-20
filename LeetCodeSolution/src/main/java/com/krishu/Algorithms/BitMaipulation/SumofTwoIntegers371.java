package com.krishu.Algorithms.BitMaipulation;

import com.krishu.Utility;

/*
371. Sum of Two Integers
https://leetcode.com/problems/sum-of-two-integers/description/

Given two integers a and b, return the sum of the two integers without using the operators + and -.



Example 1:

Input: a = 1, b = 2
Output: 3
Example 2:

Input: a = 2, b = 3
Output: 5


Constraints:

-1000 <= a, b <= 1000
 */
public class SumofTwoIntegers371 {

    public static int getSum(int a, int b) {
        // loop till carry value is not zero
        while (b != 0) {
            // keep original a
            int tempA = a;
            a = a ^ b; // a xor b
            b = (tempA & b) << 1; // compute carry
        }
        return a; // return sum;
    }


}

class Solution {
    public static void main(String[] args) {
        test1();
        test2();
        test3();
    }

    public static void test1() {
        int a = 9;
        int b = 11;
        int expected = 20;
        int actual = SumofTwoIntegers371.getSum(a, b);

        Utility.printException(expected, actual);
    }

    public static void test2() {
        int a = 1;
        int b = 2;
        int expected = 3;
        int actual = SumofTwoIntegers371.getSum(a, b);

        Utility.printException(expected, actual);
    }

    public static void test3() {
        int a = -2;
        int b = 3;
        int expected = 1;
        int actual = SumofTwoIntegers371.getSum(a, b);

        Utility.printException(expected, actual);
    }
}