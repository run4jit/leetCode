package com.krishu.ProblemSolvingTechnique.PrefixSum;


import com.krishu.Utility;
/*
303. Range Sum Query - Immutable
Given an integer array nums, handle multiple queries of the following type:

Calculate the sum of the elements of nums between indices left and right inclusive where left <= right.
Implement the NumArray class:

NumArray(int[] nums) Initializes the object with the integer array nums.
int sumRange(int left, int right) Returns the sum of the elements of nums between indices left and right inclusive (i.e. nums[left] + nums[left + 1] + ... + nums[right]).


Example 1:

Input
["NumArray", "sumRange", "sumRange", "sumRange"]
[[[-2, 0, 3, -5, 2, -1]], [0, 2], [2, 5], [0, 5]]
Output
[null, 1, -1, -3]

Explanation
NumArray numArray = new NumArray([-2, 0, 3, -5, 2, -1]);
numArray.sumRange(0, 2); // return (-2) + 0 + 3 = 1
numArray.sumRange(2, 5); // return 3 + (-5) + 2 + (-1) = -1
numArray.sumRange(0, 5); // return (-2) + 0 + 3 + (-5) + 2 + (-1) = -3

 */
class NumArray {
    int[] preSum;
    public NumArray(int[] nums) {
        this.preSum = new int[nums.length]; // create pre sum array of same length of input array.
        this.preSum[0] = nums[0]; // intialize first element with first value of nums.
        // loop nums
        for (int i = 1; i < nums.length; i++) {
            // compute pre sum.
            this.preSum[i] = this.preSum[i-1] + nums[i];
        }
    }

    public int sumRange(int left, int right) {
        // if left is zero rerun the last element.
        if (left == 0) {
            return this.preSum[right];
        }
        // sum range is equal to last pinter value subtracted from one index lesser than left pointer.
        return this.preSum[right] - this.preSum[left-1];
    }
}

public class RangeSumQuery303 {
    public static void main(String[] args) {
        test1();
    }

    static void test1() {
        int[] nums = {-2,0,3,-5,2,-1};
        NumArray obj = new NumArray(nums);
        int[][] subArr = { {0,2}, {2,5}, {0,5} };

        for(int[] sub: subArr) {
            int sum = obj.sumRange(sub[0], sub[1]);
            Utility.printResult("(sub[0]) + sub[1] = " , sum);
        }
    }
}