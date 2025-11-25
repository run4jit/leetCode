package com.krishu.DataStructure.Linear.Array;

/*
169. Majority Element
https://leetcode.com/problems/majority-element/description/
Given an array nums of size n, return the majority element.

The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.



Example 1:

Input: nums = [3,2,3]
Output: 3
Example 2:

Input: nums = [2,2,1,1,1,2,2]
Output: 2


Constraints:

n == nums.length
1 <= n <= 5 * 104
-109 <= nums[i] <= 109
The input is generated such that a majority element will exist in the array.


Follow-up: Could you solve the problem in linear time and in O(1) space?
 */

import com.krishu.Utility;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MajorityElement169 {
    public static int hashMap_majorityElement(int[] nums) {
        // This will find any majority element.
        // Even if majority is less than half

        // create frequency map
        Map<Integer, Integer> numFeqMap = new HashMap<>();
        // loop each element
        for (int n: nums) {
            // keep adding new element in frequency map and update the count.
            numFeqMap.put(n, numFeqMap.getOrDefault(n, 0)+1);
        }

        int max = -1; // use to store max count
        int k = -1; // use to store number which has repeated more
        // loop through frequency map
        for (int key: numFeqMap.keySet()) {
            // check for the max value
            if (numFeqMap.get(key) > max) {
                // update the max value
                max = numFeqMap.get(key);
                // update the element being used more repeatedly.
                k = key;
            }
        }
        // return the majority element.
        return k;
    }

    public static int sorted_majorityElement(int[] nums) {
        // This will work only for more than half has majority element
        // Otherwise, this logic will fail
        Arrays.sort(nums); // sort array
        return nums[nums.length/2]; // Majority element must be lies in middle of the array.
    }

    public static int final_majorityElement(int[] nums) {
        // This will work only for more than half majority element.
        // Otherwise, this logic will fail
        int vote = 0; // hold the vote value
        int candidate = -1; // wining candidate

        // loop through each element
        for (int n : nums) {
            // if vote is zero, then initialize candidate
            if (vote == 0) {
                candidate = n; // initialize candidate
                vote++; // increment the vote
            } else if (candidate == n) { // voting for same candidate
                vote++; // increment the vote count
            } else { // voting for any other candidate
                vote--; // decrease the vote count
            }
        }
        // return wining candidate with more than half vote.
        return candidate;
    }

}

class Solution169 {
    public static void main(String[] args) {
        test1();
        test2();
        test3();
        test4();
    }

    static void test1() {
        int[] arr = {2,2,1,1,1,2,2};

        int expected = 2;
        int actual = MajorityElement169.hashMap_majorityElement(arr);

        Utility.printException(expected, actual);
    }

    static void test2() {
        int[] arr = {2,2,1,1,1,2,2};

        int expected = 2;
        int actual = MajorityElement169.sorted_majorityElement(arr);

        Utility.printException(expected, actual);
    }

    static void test3() {
        int[] arr = {2,2,1,1,1,2,2};

        int expected = 2;
        int actual = MajorityElement169.final_majorityElement(arr);

        Utility.printException(expected, actual);
    }

    static void test4() {
        int[] arr = {3,2,3};

        int expected = 3;
        int actual = MajorityElement169.final_majorityElement(arr);

        Utility.printException(expected, actual);
    }
}
