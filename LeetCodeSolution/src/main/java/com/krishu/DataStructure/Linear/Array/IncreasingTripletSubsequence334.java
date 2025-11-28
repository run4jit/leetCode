package com.krishu.DataStructure.Linear.Array;

/*
334. Increasing Triplet Subsequence
https://leetcode.com/problems/increasing-triplet-subsequence/description/

Given an integer array nums, return true if there exists a triple of indices (i, j, k) such that i < j < k and nums[i] < nums[j] < nums[k]. If no such indices exists, return false.

Example 1:

Input: nums = [1,2,3,4,5]
Output: true
Explanation: Any triplet where i < j < k is valid.
Example 2:

Input: nums = [5,4,3,2,1]
Output: false
Explanation: No triplet exists.
Example 3:

Input: nums = [2,1,5,0,4,6]
Output: true
Explanation: One of the valid triplet is (1, 4, 5), because nums[1] == 1 < nums[4] == 4 < nums[5] == 6.


Constraints:

1 <= nums.length <= 5 * 105
-231 <= nums[i] <= 231 - 1


Follow up: Could you implement a solution that runs in O(n) time complexity and O(1) space complexity?
 */

import com.krishu.Utility;

public class IncreasingTripletSubsequence334 {
    public static boolean increasingTriplet(int[] nums) {
        int first = Integer.MAX_VALUE;
        int second = Integer.MAX_VALUE;

        for (int i =0; i < nums.length; i++) {
            if (nums[i] <= first) {
                first = nums[i];
            } else if (nums[i] <= second) {
                second = nums[i];
            } else {
                return true;
            }
        }
        return false;
    }
}

class Solution334 {
    public static void main(String[] args) {
//        test1();
//        test2();
//        test3();
//        test4();
        test5();
    }

    static void test1() {
        int[] arr = {1,2,3,4,5};

        boolean expected = true;
        boolean actual = IncreasingTripletSubsequence334.increasingTriplet(arr);

        Utility.printException(expected, actual);
    }

    static void test2() {
        int[] arr = {5,4,3,2,1};

        boolean expected = false;
        boolean actual = IncreasingTripletSubsequence334.increasingTriplet(arr);

        Utility.printException(expected, actual);
    }

    static void test3() {
        int[] arr = {2,1,5,0,4,6};

        boolean expected = true;
        boolean actual = IncreasingTripletSubsequence334.increasingTriplet(arr);

        Utility.printException(expected, actual);
    }

    static void test4() {
        int[] arr = {6,7,1,2};

        boolean expected = false;
        boolean actual = IncreasingTripletSubsequence334.increasingTriplet(arr);

        Utility.printException(expected, actual);
    }
    static void test5() {
        int[] arr = {1,1,1,1};

        boolean expected = false;
        boolean actual = IncreasingTripletSubsequence334.increasingTriplet(arr);

        Utility.printException(expected, actual);
    }
}
