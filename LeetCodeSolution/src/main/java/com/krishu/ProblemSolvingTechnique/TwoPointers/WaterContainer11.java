package com.krishu.ProblemSolvingTechnique.TwoPointers;

import com.krishu.ProblemSolvingTechnique.DynamicSlidingWindow.LongestSubString3;
import com.krishu.Utility;

/*
11. Container With Most Water
https://leetcode.com/problems/container-with-most-water/description/

You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).

Find two lines that together with the x-axis form a container, such that the container contains the most water.

Return the maximum amount of water a container can store.

Notice that you may not slant the container.



Example 1:


Input: height = [1,8,6,2,5,4,8,3,7]
Output: 49
Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case, the max area of water (blue section) the container can contain is 49.
Example 2:

Input: height = [1,1]
Output: 1


Constraints:

n == height.length
2 <= n <= 105
0 <= height[i] <= 104

 */
public class WaterContainer11 {
    public static int maxArea(int[] height) {
        //Termination scenario
        if (height.length < 1) {
            return 0;
        }

        int maxArea = 0; // inital max area
        int left = 0; // left pointer of the array
        int right = height.length-1; // right pointer of the array

        // run until both pointer meet
        while (left < right) {
            // width = diff of indices
            // heigh = min height of container.
            // area = width *  height;
            int area = (right - left) * Math.min(height[left], height[right]);
            // store the max area
            maxArea = Math.max(area, maxArea);

            // shift the point to the expected height value.
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        // return the final max area
         return maxArea;
    }
}

class Solution11 {
    public static void main(String[] args) {
        test1();
        test2();
    }

    static void test1() {
        int[] heights = {1,8,6,2,5,4,8,3,7};
        int result = WaterContainer11.maxArea(heights);
        Utility.printResult("Result: ", result);
    }

    static void test2() {
        int[] heights = {1,1};
        int result = WaterContainer11.maxArea(heights);
        Utility.printResult("Result: ", result);
    }
}