package com.krishu.DataStructure.Linear.Array;

public class NumberZeroFilledSubarrays2348 {
    public static long zeroFilledSubarray(int[] nums) {
        int totalCount = 0;
        int count = 0;

        for (int i =0; i < nums.length; i++) {
            if (nums[i] == 0) {
                count += 1;
                totalCount += count;
            } else {
                count = 0;
            }
        }
        return totalCount;
    }
}

class Solution2348 {
    public static void main(String[] args) {
        test1();
    }
    static void test1() {
        int[] arr = {1,3,0,0,2,0,0,4};
        int k = 6;

        int expected = 0;
        int actual = NumberZeroFilledSubarrays2348.zeroFilledSubarray(arr);

    }
}