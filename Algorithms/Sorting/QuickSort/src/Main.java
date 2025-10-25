import java.util.Arrays;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        int[] arr = {10, 7, 8, 9, 1, 5};
        printArray(arr);
        quickSort(arr, 0, arr.length-1);
        printArray(arr);
    }

    public static void printArray(int[] arr) {
        System.out.println();
        System.out.print("[ ");
       for (int val:  arr) {
           System.out.print(val + " ");
       }
        System.out.println("]");
    }

    public static void quickSort(int[] arr, int low, int high) {
        if (arr.length < 2) {
            return;
        }
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi-1);
            quickSort(arr, pi+1, high);
        }
    }

    public static int partition(int[] arr, int low, int high) {
        int pi = high; // taken last element as pivot
        int pivot = arr[pi];
        int i = low - 1; // point to the last lowest element in the array.

        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++; // increment first then swap
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
            }
        }
        //now i will be pointing to index of just smaller than pivot element
        // so now we can swap with next to i with pivot element.
        int temp = arr[i + 1];
        arr[i + 1] = arr[pi];
        arr[pi] = temp;
        pi = i+1;
        return pi;
    }
}