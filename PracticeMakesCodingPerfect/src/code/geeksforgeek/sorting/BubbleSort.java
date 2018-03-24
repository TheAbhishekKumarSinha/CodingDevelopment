package code.geeksforgeek.sorting;

public class BubbleSort {
    void bubbleSort(int[] arr) {
        int arrLength = arr.length;
        for (int i = 0; i < arrLength - 1; i++) {
            // why arrLength-1-i --> because the largest element in the iteration is sorted and is
            // placed at the end so there is no use of comparing it in every iteration.
            for (int j = 0; j < arrLength - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
                // printArray(arr);
            }
        }
    }

    void printArray(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        BubbleSort ob = new BubbleSort();
        int arr[] = { 90, 34, 25, 12, 22, 11, 9 };
        System.out.println("Unsorted array");
        ob.printArray(arr);
        System.out.println();
        ob.bubbleSort(arr);
        System.out.println("Sorted array");
        ob.printArray(arr);
    }
}
