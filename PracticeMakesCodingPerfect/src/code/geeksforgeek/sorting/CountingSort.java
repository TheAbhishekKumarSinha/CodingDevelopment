package code.geeksforgeek.sorting;

/**
 * @author abhsinha
 *
 */
public class CountingSort {

    public static void main(String args[]) {
        CountingSort ob = new CountingSort();
        int arr[] = { 2, 3, 3, 1, 16, 15, 5, 11, 16, 6, 12, 2, 1 };

        arr = ob.sort(arr);

        System.out.print("Sorted character array is ");
        for (int i = 0; i < arr.length; ++i)
            System.out.print(arr[i] + ",");
    }

    /**
     * Method Description:
     * 
     * @param arr
     */
    private int[] sort(int[] arr) {
        int arrLength = arr.length;
        int[] newArray = new int[arr.length];
        int max = -1;
        for (int i = 0; i < arrLength - 1; i++) {
            if (arr[i] > max)
                max = arr[i];
        }

        int aux[] = new int[max + 1];

        for (int i = 0; i < arrLength - 1; i++) {
            aux[arr[i]]++;
        }

        for (int i = 1; i <= max; i++) {
            aux[i] = aux[i] + aux[i - 1];
        }
        int auxIndexValue = 0;
        for (int i = 0; i < arrLength; i++) {
            int arrValue = arr[i];
            auxIndexValue = aux[arrValue];
            newArray[auxIndexValue] = arr[i];
            aux[arrValue]--;
        }
        return newArray;
    }
}
