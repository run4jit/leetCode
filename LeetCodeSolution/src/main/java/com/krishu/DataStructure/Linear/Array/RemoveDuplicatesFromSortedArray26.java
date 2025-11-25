package com.krishu.DataStructure.Linear.Array;

import com.krishu.Utility;

import java.util.LinkedHashSet;
import java.util.Set;

/*
26. Remove Duplicates from Sorted Array
https://leetcode.com/problems/remove-duplicates-from-sorted-array/description/
Given an integer array nums sorted in non-decreasing order, remove the duplicates in-place such that each unique element appears only once. The relative order of the elements should be kept the same.

Consider the number of unique elements in nums to be k​​​​​​​​​​​​​​. After removing duplicates, return the number of unique elements k.

The first k elements of nums should contain the unique numbers in sorted order. The remaining elements beyond index k - 1 can be ignored.

Custom Judge:

The judge will test your solution with the following code:

int[] nums = [...]; // Input array
int[] expectedNums = [...]; // The expected answer with correct length

int k = removeDuplicates(nums); // Calls your implementation

assert k == expectedNums.length;
for (int i = 0; i < k; i++) {
    assert nums[i] == expectedNums[i];
}
If all assertions pass, then your solution will be accepted.



Example 1:

Input: nums = [1,1,2]
Output: 2, nums = [1,2,_]
Explanation: Your function should return k = 2, with the first two elements of nums being 1 and 2 respectively.
It does not matter what you leave beyond the returned k (hence they are underscores).
Example 2:

Input: nums = [0,0,1,1,1,2,2,3,3,4]
Output: 5, nums = [0,1,2,3,4,_,_,_,_,_]
Explanation: Your function should return k = 5, with the first five elements of nums being 0, 1, 2, 3, and 4 respectively.
It does not matter what you leave beyond the returned k (hence they are underscores).


Constraints:

1 <= nums.length <= 3 * 104
-100 <= nums[i] <= 100
nums is sorted in non-decreasing order.
 */
public class RemoveDuplicatesFromSortedArray26 {
    public static int removeDuplicates(int[] nums) {
        // base case
        if (nums.length < 2) {
            return nums.length;
        }

        int start = 0; // keep track of the uniq element
        int end = 1; // read each element

        // loop through each element
        while (end < nums.length){
            // check if distinct element found
            if (nums[start] != nums[end]) {
                start++; // point to the next element in array
                nums[start] = nums[end]; // replace it with new distinct element.
            }
            // keep updating pointer to the next
            end++;
        }
        // return length of distinct element.
        int length = start+1;
        return length;
    }

    public static int brute_force_removeDuplicates(int[] nums) {
        // set keep only unique element.
        // Linked Hash Set will keep the order same as array.
        Set<Integer> uniqueElement = new LinkedHashSet<>();

        for (int n : nums) {
            uniqueElement.add(n);
        }
        int i = 0;
        for (int num: uniqueElement) {
            nums[i++] = num;
        }

        return uniqueElement.size();
    }
}

class Solution26 {
    public static void main(String[] args) {
        test1();
        test2();
    }

    static void test1() {
        int[] arr = {0,0,1,1,1,2,2,3,3,4};

        int expected = 5;
        int actual = RemoveDuplicatesFromSortedArray26.brute_force_removeDuplicates(arr);

        Utility.printException(expected, actual);
    }

    static void test2() {
        int[] arr = {0,0,1,1,1,2,2,3,3,4};

        int expected = 5;
        int actual = RemoveDuplicatesFromSortedArray26.removeDuplicates(arr);

        Utility.printException(expected, actual);
    }
}