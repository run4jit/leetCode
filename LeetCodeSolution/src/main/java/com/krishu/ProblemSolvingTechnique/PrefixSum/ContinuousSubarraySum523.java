package com.krishu.ProblemSolvingTechnique.PrefixSum;

import com.krishu.Utility;

import java.rmi.server.UID;
import java.util.HashMap;
import java.util.Map;
/*
523. Continuous Subarray Sum
https://leetcode.com/problems/continuous-subarray-sum/description/

Given an integer array nums and an integer k, return true if nums has a good subarray or false otherwise.

A good subarray is a subarray where:

its length is at least two, and
the sum of the elements of the subarray is a multiple of k.
Note that:

A subarray is a contiguous part of the array.
An integer x is a multiple of k if there exists an integer n such that x = n * k. 0 is always a multiple of k.


Example 1:

Input: nums = [23,2,4,6,7], k = 6
Output: true
Explanation: [2, 4] is a continuous subarray of size 2 whose elements sum up to 6.
Example 2:

Input: nums = [23,2,6,4,7], k = 6
Output: true
Explanation: [23, 2, 6, 4, 7] is an continuous subarray of size 5 whose elements sum up to 42.
42 is a multiple of 6 because 42 = 7 * 6 and 7 is an integer.
Example 3:

Input: nums = [23,2,6,4,7], k = 13
Output: false


Constraints:

1 <= nums.length <= 105
0 <= nums[i] <= 109
0 <= sum(nums[i]) <= 231 - 1
1 <= k <= 231 - 1
 */
public class ContinuousSubarraySum523 {
    public static boolean brute_force_checkSubarraySum(int[] nums, int k) {
        int count = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            int sum = nums[i];
            for (int j = i+1; j < nums.length; j++) {
                sum += nums[j];
                if (sum % k == 0) {
                    count++;
                }
            }
        }
        System.out.println(count);
        return count > 0;
    }

    public static boolean checkSubarraySum(int[] nums, int k) {
        // store the remender with associated index
        Map<Integer, Integer> remenderIndexMap = new HashMap<>();
        // store the remender 0 and index -1 for firs occurrence.
        remenderIndexMap.put(0,-1);
        int preFixSum = 0; // current running pre fix sum.
        // loop all numbers from array
        for (int i = 0; i < nums.length; i++) {
            // compute pre fix sum.
            preFixSum += nums[i];
            // compute remender
            int remender = preFixSum % k;
            // check if remender exist in map
            if (remenderIndexMap.containsKey(remender)) {
                // compute sub array length
                int subArrayLength = i - remenderIndexMap.get(remender);
                // return true, if sub array has at least two element.
                if (subArrayLength > 1) {
                    return true;
                }
            } else {
                // store the remender if does not exist.
                // Do not update the index value if same remender found.
                // Only first occurrence of remender will be store, so we can compute the largest sub array.
                remenderIndexMap.put(remender, i);
            }
        }
        return false;
    }
}

class Solution523 {
    public static void main(String[] args) {
        test1();
        test2();
        test3();
        test4();
    }

    static void test1() {
        int[] arr = {23,2,4,6,7};
        int k = 6;

        boolean expected = true;
        boolean actual = ContinuousSubarraySum523.brute_force_checkSubarraySum(arr, k);
        Utility.printException(expected, actual);
    }
    static void test2() {
        int[] arr = {23,2,4,6,7};
        int k = 6;

        boolean expected = true;
        boolean actual = ContinuousSubarraySum523.checkSubarraySum(arr, k);
        Utility.printException(expected, actual);
    }
    static void test3() {
        int[] arr = {23,2,6,4,7};
        int k = 6;

        boolean expected = true;
        boolean actual = ContinuousSubarraySum523.checkSubarraySum(arr, k);
        Utility.printException(expected, actual);
    }
    static void test4() {
        int[] arr = {23,2,6,4,7};
        int k = 13;

        boolean expected = false;
        boolean actual = ContinuousSubarraySum523.checkSubarraySum(arr, k);
        Utility.printException(expected, actual);
    }
}
