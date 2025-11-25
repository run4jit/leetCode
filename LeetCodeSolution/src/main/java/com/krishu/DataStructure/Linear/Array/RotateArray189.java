package com.krishu.DataStructure.Linear.Array;

/*
189. Rotate Array
https://leetcode.com/problems/rotate-array/description/

Given an integer array nums, rotate the array to the right by k steps, where k is non-negative.



Example 1:

Input: nums = [1,2,3,4,5,6,7], k = 3
Output: [5,6,7,1,2,3,4]
Explanation:
rotate 1 steps to the right: [7,1,2,3,4,5,6]
rotate 2 steps to the right: [6,7,1,2,3,4,5]
rotate 3 steps to the right: [5,6,7,1,2,3,4]
Example 2:

Input: nums = [-1,-100,3,99], k = 2
Output: [3,99,-1,-100]
Explanation:
rotate 1 steps to the right: [99,-1,-100,3]
rotate 2 steps to the right: [3,99,-1,-100]


Constraints:

1 <= nums.length <= 105
-231 <= nums[i] <= 231 - 1
0 <= k <= 105


Follow up:

Try to come up with as many solutions as you can. There are at least three different ways to solve this problem.
Could you do it in-place with O(1) extra space?
 */

import com.krishu.Utility;

public class RotateArray189 {
    public static void brute_force_rotate(int[] nums, int k) {
        if (k > nums.length) {
            k =  k % nums.length;
        }

        for (int i = 0; i < k; i++) {
            int temp = nums[nums.length -1];
            for (int j = nums.length -2; j >= 0; j--) {
                nums[j+1] = nums[j];
            }
            nums[0] = temp;
        }
    }

    public static void rotate(int[] nums, int k) {
        if (k > nums.length) {
            k =  k % nums.length;
        }
        int[] arr = new int[k];
        for (int i = 0; i < k; i++) {
            arr[i] = nums[nums.length -k + i];
        }

        for (int j = 0; j < nums.length -k; j++) {
            nums[nums.length-1 - j] = nums[nums.length -1 -k - j];
        }

        for (int i = 0; i < k; i++) {
            nums[i] = arr[i];
        }
    }

    public static void optimized_rotate(int[] nums, int k) {
        if (k > nums.length) {
            k =  k % nums.length;
        }
        // reverse complete array
        reverse(nums, 0, nums.length-1);

        // reverse last length - k  element
        reverse(nums, k, nums.length-1);

        // reverse first k element
        reverse(nums, 0, k-1);
    }

    private static void reverse(int[] arr, int start, int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
}

class Solution189 {
    public static void main(String[] args) {
        test1();
        test1();
        test3();
        test4();
        test5();
        test6();
    }

    static void test1() {
        int[] arr = {1,2,3,4,5,6,7};
        int k = 3;

        Utility.printArray("Before rotation: ", arr);
        RotateArray189.brute_force_rotate(arr, k);
        Utility.printArray("After rotation: ", arr);
    }
    static void test2() {
        int[] arr = {1,2,3,4,5,6,7};
        int k = 3;

        Utility.printArray("Before rotation: ", arr);
        RotateArray189.rotate(arr, k);
        Utility.printArray("After rotation: ", arr);
    }
    static void test3() {
        int[] arr = {1,2,3,4,5,6,7};
        int k = 3;

        Utility.printArray("Before rotation: ", arr);
        RotateArray189.optimized_rotate(arr, k);
        Utility.printArray("After rotation: ", arr);
    }

    static void test4() {
        int[] arr = {1,-100,3,99};
        int k = 2;

        Utility.printArray("Before rotation: ", arr);
        RotateArray189.brute_force_rotate(arr, k);
        Utility.printArray("After rotation: ", arr);
    }
    static void test5() {
        int[] arr = {1,-100,3,99};
        int k = 2;

        Utility.printArray("Before rotation: ", arr);
        RotateArray189.rotate(arr, k);
        Utility.printArray("After rotation: ", arr);
    }
    static void test6() {
        int[] arr = {1,-100,3,99};
        int k = 2;

        Utility.printArray("Before rotation: ", arr);
        RotateArray189.optimized_rotate(arr, k);
        Utility.printArray("After rotation: ", arr);
    }
}
