package com.krishu.ProblemSolvingTechnique.DynamicSlidingWindow;

import com.krishu.Utility;
/*
1004. Max Consecutive Ones III
https://leetcode.com/problems/max-consecutive-ones-iii/description/


Given a binary array nums and an integer k, return the maximum number of consecutive 1's in the array if you can flip at most k 0's.



Example 1:

Input: nums = [1,1,1,0,0,0,1,1,1,1,0], k = 2
Output: 6
Explanation: [1,1,1,0,0,1,1,1,1,1,1]
Bolded numbers were flipped from 0 to 1. The longest subarray is underlined.
Example 2:

Input: nums = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], k = 3
Output: 10
Explanation: [0,0,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1]
Bolded numbers were flipped from 0 to 1. The longest subarray is underlined.


Constraints:

1 <= nums.length <= 105
nums[i] is either 0 or 1.
0 <= k <= nums.length
 */
public class MaxConsecutiveOnes1004 {
    public static int longestOnes(int[] nums, int k) {
        //Base case
        if (nums.length < 1) {
            return 0;
        }

        int left = 0; // left window pointer
        int right = 0; // right window pointer
        int zeroFeq = 0; // zero's frequency
        int maxWindow = 0; // max window size

        // run through each element
        while (right < nums.length) {
            int n = nums[right]; // get right element of window
            // if zero encountered
            if (n == 0) {
                zeroFeq++; // increment zero frequency
            }
            right++; // increment window size to the right
            // Since we have to replace zero with one,
            // so zero's frequency should never be more than k.
            while (zeroFeq > k && left <= right) {
                // check if left of window contain zero.
                if (nums[left] == 0){
                    zeroFeq--; // reduce zero frequency
                }
                left++; // shrink window
            }
            // calculate window size
            int window = right - left;
            // compute max window size
            maxWindow = Math.max(window, maxWindow);
        }
        // return max size of window as answer
        return maxWindow;
    }
}

class Solution1004 {
    public static void main(String[] args) {
        test1();
        test2();
    }

    static void test1() {
        int[] nums = {1,1,1,0,0,0,1,1,1,1,0};
        int k = 2;
        int expected = 6;
        int result = MaxConsecutiveOnes1004.longestOnes(nums, k);
        if (expected == result) {
            Utility.printResult("Result: ", result);
        } else {
            Utility.printException(expected, result);
        }
    }

    static void test2() {
        int[] nums = {0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1};
        int k = 3;
        int expected = 10;
        int result = MaxConsecutiveOnes1004.longestOnes(nums, k);
        if (expected == result) {
            Utility.printResult("Result: ", result);
        } else {
            Utility.printException(expected, result);
        }
    }
}