package com.krishu.Algorithms.BitMaipulation;

import com.krishu.Utility;
/*
338. Counting Bits
https://leetcode.com/problems/counting-bits/description/
Given an integer n, return an array ans of length n + 1 such that for each i (0 <= i <= n), ans[i] is the number of 1's in the binary representation of i.



Example 1:

Input: n = 2
Output: [0,1,1]
Explanation:
0 --> 0
1 --> 1
2 --> 10
Example 2:

Input: n = 5
Output: [0,1,1,2,1,2]
Explanation:
0 --> 0
1 --> 1
2 --> 10
3 --> 11
4 --> 100
5 --> 101


Constraints:

0 <= n <= 105


Follow up:

It is very easy to come up with a solution with a runtime of O(n log n). Can you do it in linear time O(n) and possibly in a single pass?
Can you do it without using any built-in function (i.e., like __builtin_popcount in C++)?
 */
public class CountingBits338 {
    public static int[] brute_force_countBits(int n) {
        // store the result
        int[] bits = new int[n+1];
        // loop each number 0 to n
        for (int i = 0; i <= n; i++) {
            int num = i; // get bit count for i
            int count = 0; // get bit count
            while (num !=0 ) {
                num = num & (num - 1); // get set bit number
                count++; // increment bit bit count
            }
            bits[i] = count; // store the bit count at same index
        }
        // return the result
        return bits;
    }

    public static int[] countBits(int n) {
        // store the result
        int[] bits = new int[n+1];
        // loop each number 0 to n
        for (int i = 0; i <= n; i++) {
            bits[i] = bits[i/2] + (i % 2);
        }
        // return the result
        return bits;
    }
}

class Solution338 {
    public static void main(String[] args) {
        test1();
        test2();
        test3();
    }

    static void test1() {
        int n = 2;
        int[] expected = {0,1,1};
        int[] actual = CountingBits338.countBits(n);

        Utility.printException(expected, actual);
    }

    static void test2() {
        int n = 5;
        int[] expected = {0,1,1,2,1,2};
        int[] actual = CountingBits338.countBits(n);

        Utility.printException(expected, actual);
    }

    static void test3() {
        int n = 17;
        int[] expected = {0, 1, 1, 2, 1, 2, 2, 3, 1, 2, 2, 3, 2, 3, 3, 4, 1, 2};
        int[] actual = CountingBits338.countBits(n);

        Utility.printException(expected, actual);
    }
}