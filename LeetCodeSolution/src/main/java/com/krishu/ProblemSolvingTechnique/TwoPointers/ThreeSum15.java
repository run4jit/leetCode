package com.krishu.ProblemSolvingTechnique.TwoPointers;


import java.util.*;

/*
15. 3Sum
https://leetcode.com/problems/3sum/description/

Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.

Notice that the solution set must not contain duplicate triplets.



Example 1:

Input: nums = [-1,0,1,2,-1,-4]
Output: [[-1,-1,2],[-1,0,1]]
Explanation:
nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
The distinct triplets are [-1,0,1] and [-1,-1,2].
Notice that the order of the output and the order of the triplets does not matter.
Example 2:

Input: nums = [0,1,1]
Output: []
Explanation: The only possible triplet does not sum up to 0.
Example 3:

Input: nums = [0,0,0]
Output: [[0,0,0]]
Explanation: The only possible triplet sums up to 0.


Constraints:

3 <= nums.length <= 3000
-105 <= nums[i] <= 105


 */
public class ThreeSum15 {
    public static List<List<Integer>> threeSum(int[] nums) {
        // Base case
        if (nums.length < 3) {
            return new ArrayList<>();
        }
        // Sort element in the array. so we can apply two sum technique.
        Arrays.sort(nums);
        // create set to remove the duplicate result elements.
        Set<List<Integer>> result = new HashSet<>();
        int target = 0; // Target as given
        // Loop through the element.
        // first element will be i th position;
        // second element will be start;
        // third element will be ended;
        for (int i = 0; i < nums.length - 2; i++) {
            int start = i + 1;
            int end = nums.length - 1;
            // loop all between start and end as we did in two sum
            while (start < end) {
                // compute three sum;
                int sum = nums[i] + nums[start] + nums[end];
                // if sum less than target then increment start to get larger element.
                if (sum < target) {
                    start++; // increment to next larger element.
                }
                // if sum greater than target then decrement end pointer to get smaller element.
                else if (sum > target) {
                    end--; // decrement to get smaller element.
                } else {
                    // Found match
                    // add element into set
                    result.add(Arrays.asList(nums[i], nums[start], nums[end]));
                    start++; // increment the start pointer
                    end--; // decrease the end pointer.
                }
            }
        }
        // return the result
        return new ArrayList<>(result);
    }
}

class Solution15 {
    public static void main(String[] args) {
        test1();
    }

    static void test1() {

    }
}