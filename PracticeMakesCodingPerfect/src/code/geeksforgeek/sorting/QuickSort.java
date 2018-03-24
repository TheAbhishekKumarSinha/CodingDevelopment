package code.geeksforgeek.sorting;

/**
 * @author abhsinha
 *
 */
// Java program for implementation of QuickSort
class QuickSort {
    /*
     * This function takes last element as pivot, places the pivot element at its correct position
     * in sorted array, and places all smaller (smaller than pivot) to left of pivot and all greater
     * elements to right of pivot
     */

    /*
     * The main function that implements QuickSort() arr[] --> Array to be sorted, low --> Starting
     * index, high --> Ending index
     */
    void sort(int arr[], int low, int high) {
        if (low < high) {
            /*
             * pi is partitioning index, arr[pi] is now at right place
             */
            int pi = partition(arr, low, high);
            sort(arr, low, pi - 1);
            sort(arr, pi + 1, high);
        }
    }

    /**
     * Method Description:
     * 
     * @param arr
     * @param low
     * @param high
     * @return
     */
    private int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low;
        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
                i++;
            }
        }
        int temp = arr[i];
        arr[i] = arr[high];
        arr[high] = temp;
        return i;
    }

    /* A utility function to print array of size n */
    static void printArray(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    // Driver program
    public static void main(String args[]) {
        int arr[] = { 10, 50, 30, 40, 20 };
        int n = arr.length;

        QuickSort ob = new QuickSort();
        ob.sort(arr, 0, n - 1);

        System.out.println("sorted array");
        printArray(arr);
    }
}
/* This code is contributed by Rajat Mishra */
