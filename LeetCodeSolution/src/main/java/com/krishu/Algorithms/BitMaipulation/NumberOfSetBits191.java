package com.krishu.Algorithms.BitMaipulation;

import com.krishu.Utility;
/*
191. Number of 1 Bits
https://leetcode.com/problems/number-of-1-bits/description/

Given a positive integer n, write a function that returns the number of set bits in its binary representation (also known as the Hamming weight).


Example 1:

Input: n = 11

Output: 3

Explanation:

The input binary string 1011 has a total of three set bits.

Example 2:

Input: n = 128

Output: 1

Explanation:

The input binary string 10000000 has a total of one set bit.

Example 3:

Input: n = 2147483645

Output: 30

Explanation:

The input binary string 1111111111111111111111111111101 has a total of thirty set bits.



Constraints:

1 <= n <= 231 - 1
 */
public class NumberOfSetBits191 {
    public static int brute_force_hammingWeight(int n) {
        int setBitCount = 0;
        while (n != 0) {
            int reminder = n % 2;
            if (reminder == 1) {
                setBitCount++;
            }
            n = n / 2;
        }
        return setBitCount;
    }

    public static int hammingWeight(int n) {
        int setBitCount = 0; // store the set bit count
        // loop till n become zero
        while (n != 0) {
            // every 5 & 4 -> 4, then 4 & 3 -> 0; so set bit count will be 2.
            n = n & (n-1); // bitwise and with one less number.
            setBitCount++; // increment count
        }
        // return result
        return setBitCount;
    }
}

class Solution191 {
    public static void main(String[] args) {
        test1();
        test2();
        test3();
    }

    static void test1() {
        int n = 11;
        int expected = 3;

        int actual = NumberOfSetBits191.hammingWeight(n);

        Utility.printException(expected, actual);
    }

    static void test2() {
        int n = 128;
        int expected = 1;

        int actual = NumberOfSetBits191.hammingWeight(n);

        Utility.printException(expected, actual);
    }

    static void test3() {
        int n = 2147483645;
        int expected = 30;

        int actual = NumberOfSetBits191.hammingWeight(n);

        Utility.printException(expected, actual);
    }
}
