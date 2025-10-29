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
        System.out.println(TextColor.GREEN + Utility.toStringArray(arr) + TextColor.RESET);
    }

    public static void printArray(String msg, int[] arr) {
        System.out.println(TextColor.GREEN + msg + Utility.toStringArray(arr) + TextColor.RESET);
    }

    public static void printArray(String msg, List<Integer> arr) {
        int[] array = arr.stream()
                .mapToInt(Integer::intValue)
                .toArray();
        System.out.println(TextColor.GREEN + msg + Utility.toStringArray(array) + TextColor.RESET);
    }

    public static void printResult(String msg, Object result) {

        System.out.println(TextColor.GREEN + msg + result.toString() + TextColor.RESET);
    }

    public static void printException(Object expected, Object actual) {
        System.out.println(TextColor.RED
                + "Output of algorithm did not match with "
                + "expected: " + expected.toString()
                + " result: " + actual.toString()
                + TextColor.RESET);
    }

}
