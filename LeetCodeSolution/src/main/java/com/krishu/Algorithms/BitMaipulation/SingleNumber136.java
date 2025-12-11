package com.krishu.Algorithms.BitMaipulation;

import com.krishu.Utility;

import java.util.HashMap;
import java.util.Map;
/*
136. Single Number
https://leetcode.com/problems/single-number/description/

Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.

You must implement a solution with a linear runtime complexity and use only constant extra space.



Example 1:

Input: nums = [2,2,1]

Output: 1

Example 2:

Input: nums = [4,1,2,1,2]

Output: 4

Example 3:

Input: nums = [1]

Output: 1



Constraints:

1 <= nums.length <= 3 * 104
-3 * 104 <= nums[i] <= 3 * 104
Each element in the array appears twice except for one element which appears only once.
 */
public class SingleNumber136 {
    public static int brute_force_singleNumber(int[] nums) {
        int ans = 0;
        Map<Integer, Integer> freqMap = new HashMap<>();
        System.out.println("hashcode hello: " + "hello".hashCode());
        System.out.println("Boolean true: " + Boolean.hashCode(true));
        System.out.println("Boolean false: " + Boolean.hashCode(false));
        System.out.println("Character a: " + Character.hashCode('a'));
        System.out.println("Double 10.9: " + Double.hashCode(10.9));
        System.out.println("Integer 10: " + Integer.hashCode(10));


        for (int n: nums) {
            if (!freqMap.containsKey(n)) {
                freqMap.put(n, 1);
            } else {
                int existingCount = freqMap.get(n);
                freqMap.put(n, (existingCount + 1));
            }

//            freqMap.put(n, freqMap.getOrDefault(n, 0)+1);
        }

        for (int key: freqMap.keySet()) {
            if (freqMap.get(key) == 1) {
                return key;
            }
        }
        return -1;
    }

    public static int singleNumber(int[] nums) {
        int x = 5 & 6;
        System.out.println("& " + x);
        x = 9 | 3;
        System.out.println("| " + x);
        x = ~7;
        System.out.println("~ " + x);
        x = 8 ^ 5;
        System.out.println("^ " + x);
        x = 0 ^ 5;
        System.out.println("^ " + x);

        String binary8 = Integer.toBinaryString(7);
        System.out.println(binary8);
        String binary_8 = Integer.toBinaryString(-8);
        System.out.println(binary_8);

        int xor = 0; // initial xor value must be zero
        // loop each element from nums array
        for (int n: nums) {
            // xor each element,
            // if its in pair then it will become zero
            // number of xor with zero will be the same number
            xor = xor ^ n;
        }
        // return the result
        return xor;
    }
}

class Solution136 {
    public static void main(String[] args) {
        test1();
        test2();
        test3();
    }

    static void test1() {
        int[] arr = {2,2,1};
        int expected = 1;
        int actual = SingleNumber136.singleNumber(arr);

        Utility.printException(expected, actual);
    }

    static void test2() {
        int[] arr = {4,1,2,1,2};
        int expected = 4;
        int actual = SingleNumber136.singleNumber(arr);

        Utility.printException(expected, actual);
    }

    static void test3() {
        int[] arr = {1};
        int expected = 1;
        int actual = SingleNumber136.singleNumber(arr);

        Utility.printException(expected, actual);
    }
}