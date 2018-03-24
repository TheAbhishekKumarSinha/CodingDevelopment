package code.geeksforgeek.sorting;

/**
 * @author abhsinha
 *
 */
public class RadixSort {

    static void print(int arr[], int n) {
        for (int i = 0; i < n; i++)
            System.out.print(arr[i] + " ");
    }

    public static void main(String[] args) {

        int arr[] = { 170, 45, 75, 90, 802, 24, 2, 801 };
        int n = arr.length;
        print(arr, n);
        radixsort(arr, n);
        System.out.println("\nSorted Array");
        print(arr, n);
    }

    /**
     * Method Description:
     * 
     * @param arr
     * @param n
     */
    private static void radixsort(int[] arr, int n) {
        // TODO Auto-generated method stub
        int maxNo = getmax(arr);

        for (int i = 1; (maxNo / i) > 0; i *= 10) {
            radixSort(arr, i);
        }
    }

    /**
     * Method Description:
     * 
     * @param arr
     * @param i
     */
    private static void radixSort(int[] arr, int place) {
        // TODO Auto-generated method stub
        int[] aux = new int[10];
        int[] newArray = new int[arr.length];

        for (int i = 0; i <= arr.length - 1; i++) {
            aux[(arr[i] / place) % 10]++;
        }
        for (int i = 1; i <= aux.length - 1; i++) {
            aux[i] += aux[i - 1];
        }

        for (int i = arr.length - 1; i >= 0; i--) {
            newArray[aux[(arr[i] / place) % 10] - 1] = arr[i];
            aux[(arr[i] / place) % 10]--;
        }

        for (int i = 0; i <= arr.length - 1; i++) {
            arr[i] = newArray[i];
        }
    }

    /**
     * Method Description:
     * 
     * @param arr
     * @return
     */
    private static int getmax(int[] arr) {
        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (max < arr[i]) {
                max = arr[i];
            }
        }
        return max;
    }
}
