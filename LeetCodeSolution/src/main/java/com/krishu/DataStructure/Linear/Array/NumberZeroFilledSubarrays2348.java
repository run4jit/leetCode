package com.krishu.DataStructure.Linear.Array;

import com.krishu.Utility;
/*
2348. Number of Zero-Filled Subarrays
https://leetcode.com/problems/number-of-zero-filled-subarrays/description/

Given an integer array nums, return the number of subarrays filled with 0.

A subarray is a contiguous non-empty sequence of elements within an array.

Example 1:

Input: nums = [1,3,0,0,2,0,0,4]
Output: 6
Explanation:
There are 4 occurrences of [0] as a subarray.
There are 2 occurrences of [0,0] as a subarray.
There is no occurrence of a subarray with a size more than 2 filled with 0. Therefore, we return 6.
Example 2:

Input: nums = [0,0,0,2,0,0]
Output: 9
Explanation:
There are 5 occurrences of [0] as a subarray.
There are 3 occurrences of [0,0] as a subarray.
There is 1 occurrence of [0,0,0] as a subarray.
There is no occurrence of a subarray with a size more than 3 filled with 0. Therefore, we return 9.
Example 3:

Input: nums = [2,10,2019]
Output: 0
Explanation: There is no subarray filled with 0. Therefore, we return 0.


Constraints:

1 <= nums.length <= 105
-109 <= nums[i] <= 109


 */
public class NumberZeroFilledSubarrays2348 {
    public static long zeroFilledSubarray(int[] nums) {
        // total count of sub array
        long totalCount = 0;
        // current count
        int count = 0;
        // loop through each element
        for (int i =0; i < nums.length; i++) {
            // check each element with zero.
            if (nums[i] == 0) {
                count += 1; // update current count
                totalCount += count; // update total count
            } else {
                count = 0; // reset current count
            }
        }
        // return total count
        return totalCount;
    }
}

class Solution2348 {
    public static void main(String[] args) {
        test1();
        test2();
        test3();
    }
    static void test1() {
        int[] arr = {1,3,0,0,2,0,0,4};

        long expected = 6;
        long actual = NumberZeroFilledSubarrays2348.zeroFilledSubarray(arr);

        Utility.printException(expected, actual);
    }

    static void test2() {
        int[] arr = {0,0,0,2,0,0};

        long expected = 9;
        long actual = NumberZeroFilledSubarrays2348.zeroFilledSubarray(arr);

        Utility.printException(expected, actual);
    }

    static void test3() {
        int[] arr = {2,10,2019};

        long expected = 0;
        long actual = NumberZeroFilledSubarrays2348.zeroFilledSubarray(arr);

        Utility.printException(expected, actual);
    }
}