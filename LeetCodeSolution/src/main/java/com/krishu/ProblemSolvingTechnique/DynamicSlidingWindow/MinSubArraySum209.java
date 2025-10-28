package com.krishu.ProblemSolvingTechnique.DynamicSlidingWindow;

import com.krishu.Utility;

public class MinSubArraySum209 {
    public static int minSubArrayLen(int target, int[] nums) {
        // Base case
        if (nums.length < 1) {
            return 0;
        }

        int left = 0; // left pointer of the window
        int right = 0; // right pointer of the window
        int sum = 0; // total sum initialized
        int min = Integer.MAX_VALUE; // min is storing the max value

        // loop each element of the array to match target
        while (right < nums.length) {
            // compute Sum one by one.
            sum += nums[right];

            // Then decrease by one after moving pointer to left side of window.
            while (sum >= target && left <= right) {
                // compute min value before decrement.
                min = Math.min((right - left + 1), min);
                sum -= nums[left]; // decrease by left pointing value
                left++; // shrink window size
            }

            right++;
        }
        // target does not match
        if (min == Integer.MAX_VALUE) {
            min = 0;
        }
        // return the min value.
        return min;
    }
}

class Solution209 {
    public static void main(String[] args) {
        test1();
        test2();
        test3();
        test4();
    }

    static void test1() {
        int[] nums = {2,3,1,2,4,3};
        int target = 7;
        int result = MinSubArraySum209.minSubArrayLen(target, nums);
        Utility.printResult("Result: ", result);
    }

    static void test2() {
        int[] nums = {1,1,1,1,1,1,1,1};
        int target = 11;
        int result = MinSubArraySum209.minSubArrayLen(target, nums);
        Utility.printResult("Result: ", result);
    }

    static void test3() {
        int[] nums = {1,4,4};
        int target = 4;
        int result = MinSubArraySum209.minSubArrayLen(target, nums);
        Utility.printResult("Result: ", result);
    }

    static void test4() {
        int[] nums = {8};
        int target = 7;
        int result = MinSubArraySum209.minSubArrayLen(target, nums);
        Utility.printResult("Result: ", result);
    }

}