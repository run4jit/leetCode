package com.krishu;

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
}
