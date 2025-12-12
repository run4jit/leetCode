package com.krishu.Algorithms.BitMaipulation;

import com.krishu.Utility;
/*
190. Reverse Bits
https://leetcode.com/problems/reverse-bits/description/

Reverse bits of a given 32 bits signed integer.



Example 1:

Input: n = 43261596

Output: 964176192

Explanation:

Integer	Binary
43261596	00000010100101000001111010011100
964176192	00111001011110000010100101000000
Example 2:

Input: n = 2147483644

Output: 1073741822

Explanation:

Integer	Binary
2147483644	01111111111111111111111111111100
1073741822	00111111111111111111111111111110


Constraints:

0 <= n <= 231 - 2
n is even.


Follow up: If this function is called many times, how would you optimize it?
 */
public class ReverseBits190 {
    public static int reverseBits(int n) {
        int result = 0;
        int intSize = Integer.SIZE; // 4 bytes or 32 bits integer size.
        // eg. n = 5 in 32-bit 0000000000000000000000000000101
        // loop all bits we need to rotate 31 bit. last bit is sign bit.
        for (int i = 1; i <= intSize; i++) {
            // n = 5(0000000000000000000000000000101) & 1(0000000000000000000000000000001) => 1(0000000000000000000000000000001)
            int leastSignificantBit = n & 1;

            //  1000000000000000000000000000000 << 31; <=(32 - i); i = 1;
            int reverseLSB = leastSignificantBit << (intSize - i);

            // reversed(0000000000000000000000000000000) | reverseLSB(1000000000000000000000000000000)
            result = result | reverseLSB; //reversed => 1000000000000000000000000000000

            // 5(0000000000000000000000000000101) >> 1 => 0000000000000000000000000000010
            n = n >> 1; // 0000000000000000000000000000010
        }
        return result;
    }
}

class Solution190 {
    public static void main(String[] args) {
        test1();
        test2();
        test3();
    }

    static void test1() {
        int num = 43261596;

        int expected = 964176192;
        int output = ReverseBits190.reverseBits(num);

        Utility.printException(expected, output);
    }

    static void test2() {
        int num = 2147483644;

        int expected = 1073741822;
        int output = ReverseBits190.reverseBits(num);

        Utility.printException(expected, output);
    }

    static void test3() {
        int num = 11;

        int expected = -805306368;
        int output = ReverseBits190.reverseBits(num);

        Utility.printException(expected, output);
    }
}