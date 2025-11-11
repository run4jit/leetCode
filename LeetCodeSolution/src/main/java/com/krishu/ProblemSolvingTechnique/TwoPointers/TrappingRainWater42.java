package com.krishu.ProblemSolvingTechnique.TwoPointers;

import com.krishu.Utility;

/*
42. Trapping Rain Water
https://leetcode.com/problems/trapping-rain-water/description/

Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.



Example 1:


Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
Output: 6
Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped.
Example 2:

Input: height = [4,2,0,3,2,5]
Output: 9


Constraints:

n == height.length
1 <= n <= 2 * 104
0 <= height[i] <= 105
 */
public class TrappingRainWater42 {

    public static int trap(int[] height) {
        // Base case
        if (height.length < 2) {
            return 0;
        }
        // Compute Max height from left
        int[] maxHeightFromLeft = new int[height.length];
        int max = -1; // max value stored
        for (int i = 0; i < height.length; i++) {
            max = Math.max(max, height[i]); // get max value
            maxHeightFromLeft[i] = max; // store max int new array
        }

        max = -1; // reset Msx value
        int[] maxHeightFromRight = new int[height.length]; // create new max array
        for (int i = height.length-1; i >= 0 ; i--) {
            max = Math.max(max, height[i]); // compute max value
            maxHeightFromRight[i] = max; // store max value
        }

        int dropCount = 0; // drop count value
        for (int i = 0; i < height.length; i++) {
            // compute max count
            dropCount += Math.min(maxHeightFromLeft[i], maxHeightFromRight[i]) - height[i];
        }
        // return max count
        return dropCount;
    }
}

class Solution42 {
    public static void main(String[] args) {
        test1();
        test2();
    }

    public static void test1() {
        int[] heights = {0,1,0,2,1,0,1,3,2,1,2,1};
        int expected = 6;
        int actual = TrappingRainWater42.trap(heights);

        Utility.printException(expected, actual);
    }

    public static void test2() {
        int[] heights = {4,2,0,3,2,5};
        int expected = 9;
        int actual = TrappingRainWater42.trap(heights);

        Utility.printException(expected, actual);
    }
}