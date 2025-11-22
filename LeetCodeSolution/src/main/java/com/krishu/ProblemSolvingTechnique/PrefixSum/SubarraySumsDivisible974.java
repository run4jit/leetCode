package com.krishu.ProblemSolvingTechnique.PrefixSum;

import com.krishu.Utility;

import java.util.HashMap;
import java.util.Map;
/*
974. Subarray Sums Divisible by K
https://leetcode.com/problems/subarray-sums-divisible-by-k/description/

Given an integer array nums and an integer k, return the number of non-empty subarrays that have a sum divisible by k.

A subarray is a contiguous part of an array.



Example 1:

Input: nums = [4,5,0,-2,-3,1], k = 5
Output: 7
Explanation: There are 7 subarrays with a sum divisible by k = 5:
[4, 5, 0, -2, -3, 1], [5], [5, 0], [5, 0, -2, -3], [0], [0, -2, -3], [-2, -3]
Example 2:

Input: nums = [5], k = 9
Output: 0


Constraints:

1 <= nums.length <= 3 * 104
-104 <= nums[i] <= 104
2 <= k <= 104
 */
public class SubarraySumsDivisible974 {
    public static int broot_force_subarraysDivByK(int[] nums, int k) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (sum % k == 0) {
                    count++;
                }
            }
        }
        return count;
    }

    public static int subarraysDivByK(int[] nums, int k) {
        // count of sub array divided by k
        int count = 0;
        // remender frequency
        Map<Integer, Integer> remenderFeqMap = new HashMap<>();
        remenderFeqMap.put(0, 1); // store the for first complete divisible feq.
        int preFixSum = 0; // current pre fix sum
        // loop all element from array
        for (int i = 0; i < nums.length; i++) {
            // compute pre fix sum
            preFixSum += nums[i];
            // remender
            int remender = preFixSum % k;
            // -ve remender convert into positive equivalent remender
            if (remender < 0) {
                System.out.println(remender);
                remender += k; // compute +ve remender
                System.out.println(remender);
            }
            // check remender contain, means sub array is divisible by k
            if (remenderFeqMap.containsKey(remender)) {
                // increment he count
                count += remenderFeqMap.get(remender);
            }
            // add/update the frequency of remender.
            remenderFeqMap.put(remender, remenderFeqMap.getOrDefault(remender, 0)+1);
        }
        return count;
    }

    public static int subarraysDivByK_01(int[] nums, int k) {
        // count of sub array divided by k
        int count = 0;
        // remender frequency
        int[] remenderFeq = new int[k];
        remenderFeq[0] = 1; // store the for first complete divisible feq.
        int preFixSum = 0; // current pre fix sum
        // loop all element from array
        for (int i = 0; i < nums.length; i++) {
            // compute pre fix sum
            preFixSum += nums[i];
            // remender
            int remender = preFixSum % k;
            // -ve remender convert into positive equivalent remender
            if (remender < 0) {
                System.out.println(remender);
                remender += k; // compute +ve remender
                System.out.println(remender);
            }
            // check remender contain, means sub array is divisible by k
            if (remenderFeq[remender] > 0) {
                // increment he count
                count += remenderFeq[remender];
            }
            // add/update the frequency of remender.
            remenderFeq[remender]++;
        }
        return count;
    }
}

class Solution974{
    public static void main(String[] args) {
        test1();
        test2();
        test3();
    }

    public static void test1() {
        int[] arr = {4,5,0,-2,-3,1};
        int k = 5;

        int expected = 7;
        int actual = SubarraySumsDivisible974.broot_force_subarraysDivByK(arr,k);
//        int actual = SubarraySumsDivisible974.subarraysDivByK(arr,k);

        Utility.printException(expected, actual);
    }
    public static void test2() {
        int[] arr = {4,5,0,-2,-3,1};
        int k = 5;

        int expected = 7;
//        int actual = SubarraySumsDivisible974.broot_force_subarraysDivByK(arr,k);
        int actual = SubarraySumsDivisible974.subarraysDivByK(arr,k);

        Utility.printException(expected, actual);
    }
    public static void test3() {
        int[] arr = {5};
        int k = 9;

        int expected = 0;
//        int actual = SubarraySumsDivisible974.broot_force_subarraysDivByK(arr,k);
        int actual = SubarraySumsDivisible974.subarraysDivByK(arr,k);

        Utility.printException(expected, actual);
    }
}
