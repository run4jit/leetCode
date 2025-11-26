package com.krishu.DataStructure.Linear.Array;
/*
238. Product of Array Except Self
https://leetcode.com/problems/product-of-array-except-self/description/

Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].

The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.

You must write an algorithm that runs in O(n) time and without using the division operation.



Example 1:

Input: nums = [1,2,3,4]
Output: [24,12,8,6]
Example 2:

Input: nums = [-1,1,0,-3,3]
Output: [0,0,9,0,0]


Constraints:

2 <= nums.length <= 105
-30 <= nums[i] <= 30
The input is generated such that answer[i] is guaranteed to fit in a 32-bit integer.


Follow up: Can you solve the problem in O(1) extra space complexity? (The output array does not count as extra space for space complexity analysis.)
 */

import com.krishu.Utility;

public class ProductArrayExceptSelf238 {
    public static int[] brute_force_productExceptSelf(int[] nums) {
        int[] ans = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int product = 1;
            for (int j = 0; j < nums.length; j++) {
                // if nums[i] is zero(0) then division can give exception,
                // So, It's better to skip the multiplication.
                if (i != j) {
                    product *= nums[j];
                }
            }
            ans[i] = product;
        }
        return ans;
    }

    public static int[] onlyForNonZeroElement_ProductExceptSelf(int[] nums) {
        int product = 1;
        for (int i = 0; i < nums.length; i++) {
            product *= nums[i];
        }
        int[] ans = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            ans[i] = product/nums[i];
        }
        return ans;
    }

    public static int[] productExceptSelf(int[] nums) {
        // left to right product array
        int[] leftToRightProducts = new int[nums.length];
        leftToRightProducts[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            leftToRightProducts[i] = leftToRightProducts[i-1] * nums[i-1];
        }

        // right to left product array
        int[] rightToLeftProducts = new int[nums.length];
        rightToLeftProducts[nums.length-1] = 1;
        for (int i = nums.length-2; i >=0; i--) {
            rightToLeftProducts[i] = rightToLeftProducts[i+1] * nums[i+1];
        }

        int[] ans = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            // ans = product of left multiply to right product.
            ans[i] = leftToRightProducts[i] * rightToLeftProducts[i];
        }
        return ans;
    }
}



class Solution238 {
    public static void main(String[] args) {
        test1();
        test2();
        test3();
        test4();
        test5();
    }

    static void test1() {
        int[] arr = {-1,1,0,-3,3};

        int[] expected = {0,0,9,0,0};
        int[] actual = ProductArrayExceptSelf238.brute_force_productExceptSelf(arr);
        Utility.printException(expected, actual);
    }

    static void test2() {
        int[] arr = {1,2,3,4};

        int[] expected = {24,12,8,6};
        int[] actual = ProductArrayExceptSelf238.onlyForNonZeroElement_ProductExceptSelf(arr);
        Utility.printException(expected, actual);
    }

    static void test3() {
        int[] arr = {-1,1,0,-3,3};

        int[] expected = {0,0,9,0,0};
        int[] actual = ProductArrayExceptSelf238.productExceptSelf(arr);
        Utility.printException(expected, actual);
    }

    static void test4() {
        int[] arr = {1,2,3,4};

        int[] expected = {24,12,8,6};
        int[] actual = ProductArrayExceptSelf238.productExceptSelf(arr);
        Utility.printException(expected, actual);
    }

    static void test5() {
        int[] arr = {0,0};

        int[] expected = {0,0};
        int[] actual = ProductArrayExceptSelf238.productExceptSelf(arr);
        Utility.printException(expected, actual);
    }


}
