package com.krishu;

import java.util.Arrays;
import java.util.List;

public class Utility {
    public static String toStringArray(int[] arr) {
        StringBuilder str = new StringBuilder();
        str.append("[");
        for (int val:  arr) {
            str.append(" " + val);
        }
        str.append(" ]");
        return str.toString();
    }

    public static void printArray(int[] arr) {
        System.out.println(Utility.toStringArray(arr));
    }

    public static void printArray(String msg, int[] arr) {
        System.out.println(msg + Utility.toStringArray(arr));
    }

    public static void printArray(String msg, List<Integer> arr) {
        int[] array = arr.stream()
                .mapToInt(Integer::intValue)
                .toArray();
        System.out.println(msg + Utility.toStringArray(array));
    }

    public static void printResult(String msg, Object result) {
        System.out.println(msg + result.toString());
    }

}
