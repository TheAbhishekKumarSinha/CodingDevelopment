/**
 * 
 */
package code.geeksforgeek.sorting;

/**
 * @author abhsinha
 *
 */
public class SelectionSort {
    void selectionSort(int[] arr) {
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[minIndex] > arr[j]) {
                    minIndex = j;
                }
            }

            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;

        }
    }

    void printArray(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        SelectionSort ob = new SelectionSort();
        int arr[] = { 64, 25, 12, 22, 11 };
        ob.selectionSort(arr);
        System.out.println("Sorted array");
        ob.printArray(arr);

        int i = 5;
        int j = i / 2;
        System.out.println(j);
    }
}
