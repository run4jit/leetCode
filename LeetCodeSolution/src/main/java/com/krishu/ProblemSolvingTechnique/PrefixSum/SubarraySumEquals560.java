package com.krishu.ProblemSolvingTechnique.PrefixSum;

import com.krishu.Utility;

import java.util.HashMap;
import java.util.Map;

/*
560. Subarray Sum Equals K
https://leetcode.com/problems/subarray-sum-equals-k/description/
Given an array of integers nums and an integer k, return the total number of subarrays whose sum equals to k.

A subarray is a contiguous non-empty sequence of elements within an array.



Example 1:

Input: nums = [1,1,1], k = 2
Output: 2
Example 2:

Input: nums = [1,2,3], k = 3
Output: 2


Constraints:

1 <= nums.length <= 2 * 104
-1000 <= nums[i] <= 1000
-107 <= k <= 107
 */
public class SubarraySumEquals560 {
    public static int brute_force_subarraySum(int[] nums, int k) {

        int count = 0;
        for (int i = 0 ; i < nums.length; i++) {
            int sum = 0;
            for (int j = i;  j < nums.length; j++) {
                int n = nums[j];
                sum += n;
                if (sum == k) {
                    count++;
                }
            }
        }
        return count;
    }

    public static int subarraySum(int[] nums, int k) {
        // count result matches sub array
        int count = 0;
        // keep the prefix sum and frequency of number
        Map<Integer, Integer> preSumMap = new HashMap<>();
        preSumMap.put(0,1); // keep the default value 0 as with feq 1.
        int preSum = 0; // current running prefix sum
        // loop through all number in array
        for (int i = 0 ; i < nums.length; i++) {
            preSum += nums[i]; // compute prefix sum
            int diff = preSum - k; // check the difference
            // check diff of k is appeared in map
            if(preSumMap.containsKey(diff)) {
                count += preSumMap.get(diff); // add the frequency of that element.
            }
            // add/update the prefix sum and its frequency into map.
            preSumMap.put(preSum, preSumMap.getOrDefault(preSum, 0)+1);
        }
        // return the result
        return count;
    }
}

class Solution560 {
    public static void main(String[] args) {
        test1();
        test2();
        test3();
    }

    static void test1() {
        int[] arr = {1,2,3};
        int k = 3;

        int expected = 2;
        int actual = SubarraySumEquals560.brute_force_subarraySum(arr, k);

        Utility.printException(expected, actual);
    }

    static void test2() {
        int[] arr = {1,2,3};
        int k = 3;

        int expected = 2;
        int actual = SubarraySumEquals560.subarraySum(arr, k);

        Utility.printException(expected, actual);
    }

    static void test3() {
        int[] arr = {1,1,1};
        int k = 2;

        int expected = 2;
        int actual = SubarraySumEquals560.subarraySum(arr, k);

        Utility.printException(expected, actual);
    }
}
