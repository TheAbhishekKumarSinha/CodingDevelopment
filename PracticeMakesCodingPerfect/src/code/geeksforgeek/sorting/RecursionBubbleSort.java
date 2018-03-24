package code.geeksforgeek.sorting;

/**
 * @author abhsinha
 *
 */
public class RecursionBubbleSort {

    void recursionBubbleSort(int[] arr, int n) {
        if (n == 1)
            return;
        for (int i = 0; i < n - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                int temp = arr[i];
                arr[i] = arr[i + 1];
                arr[i + 1] = temp;
            }
        }
        recursionBubbleSort(arr, n - 1);
    }

    void printArray(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        RecursionBubbleSort ob = new RecursionBubbleSort();
        int arr[] = { 64, 25, 12, 22, 11 };
        ob.recursionBubbleSort(arr, arr.length);
        System.out.println("Sorted array");
        ob.printArray(arr);
    }
}
