package code.geeksforgeek.sorting;

/**
 * @author abhsinha
 *
 */
/**
 * @author abhsinha
 *
 */
public class MergeSort {

    void printArray(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        int arr[] = { 12, 11, 13, 5, 6 };

        MergeSort ob = new MergeSort();
        ob.printArray(arr);
        ob.mergesort(arr, 0, arr.length - 1);

        ob.printArray(arr);
    }

    /**
     * Method Description:
     * 
     * @param arr
     * @param length
     * @param i
     */
    private void mergesort(int[] arr, int low, int high) {
        if (low < high) {
            int middleIndex = (low + high) / 2;
            mergesort(arr, low, middleIndex);

            // middleIndex+1 because the element till middleIndex is in lower array
            mergesort(arr, middleIndex + 1, high);

            merge(arr, low, high, middleIndex);
        }
    }

    /**
     * Method Description: Method below does the following operation: 1.
     * 
     * @param arr
     * @param i
     * @param high
     * @param middleIndex
     */
    private void merge(int[] arr, int low, int high, int middle) {
        int n1 = middle - low + 1;
        int n2 = high - middle;

        int[] lowerArray = new int[n1];
        int[] highArray = new int[n2];

        for (int i = 0; i < n1; i++)
            lowerArray[i] = arr[low + i];
        for (int i = 0; i < n2; i++)
            highArray[i] = arr[middle + 1 + i];

        int i = 0, j = 0;
        int k = low;

        while (i < n1 && j < n2) {
            if (lowerArray[i] <= highArray[j]) {
                arr[k] = lowerArray[i];
                k++;
                i++;
            }
            else {
                arr[k] = highArray[j];
                k++;
                j++;
            }

        }
        while (i < n1) {
            arr[k] = lowerArray[i];
            k++;
            i++;
        }
        while (j < n2) {
            arr[k] = highArray[j];
            k++;
            j++;
        }

    }
}
