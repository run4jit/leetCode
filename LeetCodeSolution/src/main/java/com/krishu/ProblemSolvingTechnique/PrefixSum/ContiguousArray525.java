package com.krishu.ProblemSolvingTechnique.PrefixSum;

import com.krishu.Utility;

import java.util.HashMap;
import java.util.Map;
/*
525. Contiguous Array
https://leetcode.com/problems/contiguous-array/description/

Given a binary array nums, return the maximum length of a contiguous subarray with an equal number of 0 and 1.



Example 1:

Input: nums = [0,1]
Output: 2
Explanation: [0, 1] is the longest contiguous subarray with an equal number of 0 and 1.
Example 2:

Input: nums = [0,1,0]
Output: 2
Explanation: [0, 1] (or [1, 0]) is a longest contiguous subarray with equal number of 0 and 1.
Example 3:

Input: nums = [0,1,1,1,1,1,0,0,0]
Output: 6
Explanation: [1,1,1,0,0,0] is the longest contiguous subarray with equal number of 0 and 1.


Constraints:

1 <= nums.length <= 105
nums[i] is either 0 or 1.
 */
public class ContiguousArray525 {
    public static int brute_force_findMaxLength(int[] nums) {

        int max = 0;
        for (int i = 0; i < nums.length -1; i++) {
            int zeroCount = 0;
            int oneCount = 0;
            if (nums[i] == 0) {
                zeroCount++;
            } else {
                oneCount++;
            }
            for (int j = i+1; j < nums.length; j++) {
                if (nums[j] == 0) {
                    zeroCount++;
                } else {
                    oneCount++;
                }

                if (zeroCount == oneCount) {
                    max = Math.max(max, (zeroCount + oneCount));
                }
            }
        }
        return max;
    }

    public static int findMaxLength(int[] nums) {
        // base case
        if (nums.length < 1) {
            return 0;
        }
        // max lenght of index for 0 & 1 stored in sub array.
        int max = 0;
        // Map of pre fix sum with associated index
        Map<Integer, Integer> preFixSumIndexMap = new HashMap<>();
        // Initiate with 0 and index -1 for the sub array start with first element.
        preFixSumIndexMap.put(0,-1);
        int preFixSum = 0; // current running pre fix sum.
        // loop each number from numbers.
        for (int i = 0; i < nums.length; i++) {
            // replace 0 with -1 before computing pre fix sum.
            preFixSum += (nums[i] == 0 ? -1 : nums[i]);
            // check pre fix sum contains into map
            if (preFixSumIndexMap.containsKey(preFixSum)) {
                // get the index of pre fix sum
                int index = preFixSumIndexMap.get(preFixSum);
                // compute lenght of the sub array index which contain equal 0's and 1's.
                int lenght = i - index;
                // compute max length sub array
                max = Math.max(max, lenght);
            } else {
                // store index value only for new preFixSum.
                // do not update the index of same prefix sum.
                preFixSumIndexMap.put(preFixSum, i);
            }
        }
        // return the result
        return max;
    }
}

class Solution525 {
    public static void main(String[] args) {
        test1();
        test2();
        test3();
        test4();
    }

    static void test1() {
        int[] arr = {0,1,1,1,1,1,0,0,0};
        int expected = 6;
        int max = ContiguousArray525.brute_force_findMaxLength(arr);

        Utility.printException(expected, max);
    }
    static void test2() {
        int[] arr = {0,1,1,1,1,1,0,0,0};
        int expected = 6;
        int max = ContiguousArray525.findMaxLength(arr);

        Utility.printException(expected, max);
    }

    static void test3() {
        int[] arr = {0,1};
        int expected = 2;
        int max = ContiguousArray525.findMaxLength(arr);

        Utility.printException(expected, max);
    }

    static void test4() {
        int[] arr = {1,1,1,1,1,1,1,1};
        int expected = 0;
        int max = ContiguousArray525.findMaxLength(arr);

        Utility.printException(expected, max);
    }
}