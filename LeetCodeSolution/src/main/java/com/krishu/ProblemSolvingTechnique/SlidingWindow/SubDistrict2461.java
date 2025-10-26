package com.krishu.ProblemSolvingTechnique.SlidingWindow;
/*
2461. Maximum Sum of Distinct Subarrays With Length K
https://leetcode.com/problems/maximum-sum-of-distinct-subarrays-with-length-k/description/

You are given an integer array nums and an integer k. Find the maximum subarray sum of all the subarrays of nums that meet the following conditions:

The length of the subarray is k, and
All the elements of the subarray are distinct.
Return the maximum subarray sum of all the subarrays that meet the conditions. If no subarray meets the conditions, return 0.

A subarray is a contiguous non-empty sequence of elements within an array.



Example 1:

Input: nums = [1,5,4,2,9,9,9], k = 3
Output: 15
Explanation: The subarrays of nums with length 3 are:
- [1,5,4] which meets the requirements and has a sum of 10.
- [5,4,2] which meets the requirements and has a sum of 11.
- [4,2,9] which meets the requirements and has a sum of 15.
- [2,9,9] which does not meet the requirements because the element 9 is repeated.
- [9,9,9] which does not meet the requirements because the element 9 is repeated.
We return 15 because it is the maximum subarray sum of all the subarrays that meet the conditions
Example 2:

Input: nums = [4,4,4], k = 3
Output: 0
Explanation: The subarrays of nums with length 3 are:
- [4,4,4] which does not meet the requirements because the element 4 is repeated.
We return 0 because no subarrays meet the conditions.


Constraints:

1 <= k <= nums.length <= 105
1 <= nums[i] <= 105
 */


import com.krishu.Utility;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;


public class SubDistrict2461 {
    public static long maximumSubarraySum(int[] nums, int k) {
        //Termination condition
        if (nums.length < k) {
            return 0;
        }
        long maxSum = 0;
        long runningSum = 0;
        Map<Integer, Integer> distictNum = new HashMap<>();
        for (int i = 0; i < k; i++) {
            int n = nums[i];
            distictNum.put(n, distictNum.getOrDefault(n, 0) + 1);
            runningSum += n;
        }
        //Termination Condition 2
        if (distictNum.size() == k) {
            maxSum = runningSum;
        }

        for (int i = k; i < nums.length; i++) {
            int n = nums[i];
            int r = nums[i - k];
            runningSum = runningSum - r + n;
            int c = distictNum.getOrDefault(r, 0) - 1;
            if (c == 0) {
                distictNum.remove(r);
            } else {
                distictNum.put(r, c);
            }

            distictNum.put(n, distictNum.getOrDefault(n, 0) + 1);

            if (distictNum.size() == k) {
                maxSum = Math.max(runningSum, maxSum);
            }
        }
        return maxSum;
    }

    public static long maximumSubarraySum1(int[] nums, int k) {
        //termination case check
        if (nums.length < k) {
            return 0;
        }
        int start = 0; // window start pointer
        int end = 0; // window end pointer
        long sum = 0; // running sum
        long max = 0; // max sum
        Set<Integer> window = new HashSet<>(); // window to hold distict element of k size

        while (end < nums.length) { // check till tail of window reach to end of array.
            sum += nums[end]; // calculate running sum

            //Check if window contains same value or reach to max size of window
            while (window.contains(nums[end]) || (end - start + 1) > k) {
                //subtract first item of window from running sum
                sum -= nums[start];
                //remove first item from window
                window.remove(nums[start]);
                //increment start pointer
                start++;
            }

            //Since duplicate is removed, now we can add new item to window
            window.add(nums[end]);
            //increment end pointer
            end++;

            //first check the window range matches the k..
            if (window.size() == k) {
                //compute max value
                max = Math.max(max, sum);
            }
        }
        //return max value.
        return max;
    }
}


class Solution2461 {
    public static void main(String[] args) {
        test1();
        test11();
        test2();
        test21();
        test3();
        test31();
        test4();
        test41();
    }

    public static void test1() {
        int[] arr = {1,5,4,2,9,9,9};
        int k = 3;
        long result = SubDistrict2461.maximumSubarraySum(arr, k);
        Utility.printResult("Result: ", result);
    }

    public static void test11() {
        int[] arr = {1,5,4,2,9,9,9};
        int k = 3;
        long result = SubDistrict2461.maximumSubarraySum1(arr, k);
        Utility.printResult("Result: ", result);
    }
    public static void test2() {
        int[] arr = {9,9,9,1,2,3};
        int k = 3;
        long result = SubDistrict2461.maximumSubarraySum(arr, k);
        Utility.printResult("Result: ", result);
    }

    public static void test21() {
        int[] arr = {9,9,9,1,2,3};
        int k = 3;
        long result = SubDistrict2461.maximumSubarraySum1(arr, k);
        Utility.printResult("Result: ", result);
    }
    public static void test3() {
        int[] arr = {1,1,1,7,8,9};
        int k = 3;
        long result = SubDistrict2461.maximumSubarraySum(arr, k);
        Utility.printResult("Result: ", result);
    }

    public static void test31() {
        int[] arr = {1,1,1,7,8,9};
        int k = 3;
        long result = SubDistrict2461.maximumSubarraySum1(arr, k);
        Utility.printResult("Result: ", result);
    }
    public static void test4() {
        int[] arr = {1,2,1,1,3};//{1,1,1};
        int k = 2;
        long result = SubDistrict2461.maximumSubarraySum(arr, k);
        Utility.printResult("Result: ", result);
    }

    public static void test41() {
        int[] arr = {1,2,1,1,3};
        int k = 2;
        long result = SubDistrict2461.maximumSubarraySum1(arr, k);
        Utility.printResult("Result: ", result);
    }
}
