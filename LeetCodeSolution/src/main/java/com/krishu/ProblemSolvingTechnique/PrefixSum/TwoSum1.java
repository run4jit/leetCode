package com.krishu.ProblemSolvingTechnique.PrefixSum;

import com.krishu.Utility;

import java.util.HashMap;
import java.util.Map;

/*
1. Two Sum
https://leetcode.com/problems/two-sum/description/
Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

You can return the answer in any order.



Example 1:

Input: nums = [2,7,11,15], target = 9
Output: [0,1]
Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
Example 2:

Input: nums = [3,2,4], target = 6
Output: [1,2]
Example 3:

Input: nums = [3,3], target = 6
Output: [0,1]


Constraints:

2 <= nums.length <= 104
-109 <= nums[i] <= 109
-109 <= target <= 109
Only one valid answer exists.


Follow-up: Can you come up with an algorithm that is less than O(n2) time complexity?
 */
public class TwoSum1 {

    public static int[] twoSum(int[] nums, int target) {
        // base case
        if (nums.length < 2) {
            return new int[]{};
        }

        // map the integer and its index
        Map<Integer, Integer> indexMap = new HashMap<>();
        // loop each element of nums array.
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i]; // get the number
            int remainingNumber = target - num; // get the remaining number
            // check if remaining number exist in the map
            // if exist then found the result
            if (indexMap.containsKey(remainingNumber)) {
                // get index of remaining number
                int index = indexMap.get(remainingNumber);
                return new int[]{index, i}; // found result
            } else {
                // store the number with its index value.
                indexMap.put(num, i);
            }
        }
        // expected target does not matched.
        return new int[]{};
    }

}

class Solution1 {
    public static void main(String[] args) {
        test1();
        test2();
        test3();
    }

    static void test1() {
        int[]nums = {2,7,11,15};
        int target = 9;

        int[] expected = {0,1};
        int[] actual = TwoSum1.twoSum(nums, target);
        Utility.printArray("Expected: ", expected);
        Utility.printArray("Actual: ", actual);

    }

    static void test2() {
        int[]nums = {3,2,4};
        int target = 6;

        int[] expected = {1,2};
        int[] actual = TwoSum1.twoSum(nums, target);
        Utility.printArray("Expected: ", expected);
        Utility.printArray("Actual: ", actual);

    }

    static void test3() {
        int[]nums = {3,3};
        int target = 6;

        int[] expected = {0,1};
        int[] actual = TwoSum1.twoSum(nums, target);
        Utility.printArray("Expected: ", expected);
        Utility.printArray("Actual: ", actual);

    }
}
