package com.krishu.DataStructure.Linear.HashMap;

import com.krishu.Utility;

import java.util.HashMap;
import java.util.Map;

/*
1512. Number of Good Pairs
https://leetcode.com/problems/number-of-good-pairs/description/

Given an array of integers nums, return the number of good pairs.

A pair (i, j) is called good if nums[i] == nums[j] and i < j.



Example 1:

Input: nums = [1,2,3,1,1,3]
Output: 4
Explanation: There are 4 good pairs (0,3), (0,4), (3,4), (2,5) 0-indexed.
Example 2:

Input: nums = [1,1,1,1]
Output: 6
Explanation: Each pair in the array are good.
Example 3:

Input: nums = [1,2,3]
Output: 0


Constraints:

1 <= nums.length <= 100
1 <= nums[i] <= 100
 */
public class NumberOfGoodPairs1512 {
    public static int brute_force_numIdenticalPairs(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length-1; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    count++;
                }
            }
        }
        return count;
    }

    public static int numIdenticalPairs(int[] nums) {
        int count = 0; // keep count of pairs

        // keep number frequency
        Map<Integer, Integer> mapFeq = new HashMap<>();

        // loop each element
        for (int n: nums) {
            // check if number exist in map
            if (mapFeq.containsKey(n)) {
                // increment total count of pairs
                count += mapFeq.get(n); //  pairs = n*(n-1)/2; where n is frequency count.
                // increment the frequency count by 1
                mapFeq.put(n, mapFeq.get(n) + 1);
            } else {
                // firs time number encountered, so keep it with frequency 1;
                mapFeq.put(n, 1);
            }
        }
        // return total count of pairs
        return count;
    }
}

class Solution1512 {
    public static void main(String[] args) {
        test1();
        test2();
        test3();
    }

    static void test1() {
        int[] arr = {1,2,3,1,1,3};
        int expected = 4;
        int actual = NumberOfGoodPairs1512.numIdenticalPairs(arr);

        Utility.printException(expected, actual);
    }

    static void test2() {
        int[] arr = {1,1,1,1};
        int expected = 6;
        int actual = NumberOfGoodPairs1512.numIdenticalPairs(arr);

        Utility.printException(expected, actual);
    }

    static void test3() {
        int[] arr = {1,2,3};
        int expected = 0;
        int actual = NumberOfGoodPairs1512.numIdenticalPairs(arr);

        Utility.printException(expected, actual);
    }
}
