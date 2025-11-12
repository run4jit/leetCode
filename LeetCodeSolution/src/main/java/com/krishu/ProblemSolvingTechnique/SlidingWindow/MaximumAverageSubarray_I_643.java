package com.krishu.ProblemSolvingTechnique.SlidingWindow;

import com.krishu.Utility;

/*
643. Maximum Average Subarray I
https://leetcode.com/problems/maximum-average-subarray-i/description/
You are given an integer array nums consisting of n elements, and an integer k.

Find a contiguous subarray whose length is equal to k that has the maximum average value and return this value. Any answer with a calculation error less than 10-5 will be accepted.



Example 1:

Input: nums = [1,12,-5,-6,50,3], k = 4
Output: 12.75000
Explanation: Maximum average is (12 - 5 - 6 + 50) / 4 = 51 / 4 = 12.75
Example 2:

Input: nums = [5], k = 1
Output: 5.00000


Constraints:

n == nums.length
1 <= k <= n <= 105
-104 <= nums[i] <= 104
 */
public class MaximumAverageSubarray_I_643 {
    public static double findMaxAverage(int[] nums, int k) {
        double maxAvg = Double.MIN_VALUE;

        // Base case
        if (nums.length < k) {
            return maxAvg;
        }
        // store the summation of element
        double sum = 0.0;
        // computing sum of given window
        for (int i = 0; i < k; i++) {
            sum = sum + nums[i]; // compute sum
        }
        // compute average
        maxAvg = sum/k;

        // loop through each number till the end of array, starting from window end.
        // then subtract one by one element from start of windoow
        // and then add next element to window from array to compute sum
        // after that compute current average
        // store the maximum average
        for (int i = k, j = 0; i < nums.length; i++, j++) {
            sum = sum - nums[j]; // subtract one element from start
            sum = sum + nums[i]; // add next element
            double currentAvg = sum/k; // compute average
            maxAvg = Math.max(maxAvg, currentAvg); // store max average
        }
        // return max average
        return maxAvg;
    }
}

class Solution643 {
    public static void main(String[] args) {
        test1();
        test2();
    }

    static void test1() {
        int[] nums = {1,12,-5,-6,50,3};
        int k = 4;
        double expected = 12.75000;
        double actual = MaximumAverageSubarray_I_643.findMaxAverage(nums, k);

        Utility.printException(expected, actual);
    }

    static void test2() {
        int[] nums = {5};
        int k = 1;
        double expected = 5.0;
        double actual = MaximumAverageSubarray_I_643.findMaxAverage(nums, k);

        Utility.printException(expected, actual);
    }
}
