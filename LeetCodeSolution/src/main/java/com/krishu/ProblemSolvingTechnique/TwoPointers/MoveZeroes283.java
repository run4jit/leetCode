package com.krishu.DataStructure.Linear.Array;

import com.krishu.Utility;

/*
283. Move Zeroes
https://leetcode.com/problems/move-zeroes/description/
Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.

Note that you must do this in-place without making a copy of the array.



Example 1:

Input: nums = [0,1,0,3,12]
Output: [1,3,12,0,0]
Example 2:

Input: nums = [0]
Output: [0]


Constraints:

1 <= nums.length <= 104
-231 <= nums[i] <= 231 - 1
 */
public class MoveZeroes283 {
    public static void moveZeroes(int[] nums) {
        // Base case
        if (nums.length < 2) {
            return;
        }
        // Two pointer approach zero will point to 0 and non zero for any integer
        int zeroPointer = -1; // pointing to zeros
        int nonZeroPointer = 0; // pointing to Integer

        // loop through each element
        while (nonZeroPointer < nums.length) {
            // if element is non zero Integer then swap with pointer which points to 0.
            if (nums[nonZeroPointer] != 0) {
                // check zero pointer pointing to 0
                if (zeroPointer >= 0) {
                    int temp = nums[zeroPointer];
                    nums[zeroPointer] = nums[nonZeroPointer];
                    nums[nonZeroPointer] = temp;
                    zeroPointer++; // increment to next zero position
                }
            } else {
                // Encounter first zero
                if (zeroPointer == -1) {
                    zeroPointer = nonZeroPointer;
                }
            }
            // keep incrementing non zero pointer
            nonZeroPointer++;
        }
    }
}

class Solution283 {
    public static void main(String[] args) {
        test1();
    }

    static void test1() {
        int[] arr = {0,1,0,3,12};
        Utility.printArray("Before: ", arr);
        MoveZeroes283.moveZeroes(arr);
        Utility.printArray("After: ", arr);
    }
}