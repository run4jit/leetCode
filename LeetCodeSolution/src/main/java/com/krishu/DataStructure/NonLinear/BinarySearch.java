package com.krishu.DataStructure.NonLinear;

import com.krishu.Utility;

public class BinarySearch {
    //int arr[] = {10,20,30,40,50,60,70};
    // searchTerm = 90
    public static boolean binarySearch(int[] arr, int searchTerm) {

        int low = 0;
        int high = arr.length;
        int mid = (low + high) / 2;

        while (mid >= low && mid < high) {
            if (arr[mid] < searchTerm) {
               low = mid + 1;
               mid = (low + high) / 2;
            } else if (arr[mid] > searchTerm) {
                high = mid ;
                mid = (low + high) / 2;
            } else {
                return true; //mid;
            }
        }
        return false;// -1;
    }
}

class SolutioinTest {

    public static void main(String[] args) {

        test0();
        test1();
        test2();
        test3();
        test4();
    }

    public static void test0() {
        int arr[] = {10,20,30,40,50,60,70};
        int searchTerm = 1;
        boolean expected = false;
        boolean result =  BinarySearch.binarySearch(arr, searchTerm);

        Utility.printException(expected, result);
    }

    public static void test1() {
        int[] arr = {10,20,30,40,50,60,70};
        int searchTerm = 90;
        boolean expected = false;
        boolean result =  BinarySearch.binarySearch(arr, searchTerm);

        Utility.printException(expected, result);
    }

    public static void test2() {
        int arr[] = {10,20,30,40,50,60,70};
        int searchTerm = 10;
        boolean expected = true;
        boolean result =  BinarySearch.binarySearch(arr, searchTerm);

        Utility.printException(expected, result);
    }

    public static void test3() {
        int arr[] = {10,20,30,40,50,60,70};
        int searchTerm = 70;
        boolean expected = true;
        boolean result =  BinarySearch.binarySearch(arr, searchTerm);

        Utility.printException(expected, result);
    }

    public static void test4() {
        int arr[] = {10,20,30,40,50,60,70};
        int searchTerm = 40;
        boolean expected = true;
        boolean result =  BinarySearch.binarySearch(arr, searchTerm);

        Utility.printException(expected, result);
    }
}
