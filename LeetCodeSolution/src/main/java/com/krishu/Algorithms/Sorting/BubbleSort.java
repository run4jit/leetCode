package com.krishu.Algorithms.Sorting;

public class BubbleSort {
    public static void bubbleSort(int arr[])
    {
        for(int k = 0; k < arr.length; k++)
        {
            System.out.println(arr[k]);
        }

        for(int i = 1 ; i <= arr.length ; i++)
        {
            for(int j = 0; j < arr.length - i; j++)
            {
                if(arr[j] > arr[j + 1])
                {
                    arr[j] = arr[j + 1] + arr[j];
                    arr[j+1] = arr[j] - arr[j +1];
                    arr[j] = arr[j] - arr[j +1];

                }

            }

        }
        System.out.println();
        System.out.println();
        System.out.println();
        for(int k = 0; k < arr.length; k++)
        {
            System.out.println(arr[k]);


        }
    }
}

class BubbleTest
{
    public static void main(String[] args) {
        int[] arr = {9,7,5,3,1,-1,0};

        BubbleSort bubbleSort = new BubbleSort();
        bubbleSort.bubbleSort(arr);





    }

}