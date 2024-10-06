import java.util.Arrays;

public class A25_Counting_sort {
    public static void countingSort(int[] arr) {
        // Find the maximum value in the array to determine the size of the count array
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }

        // Create the count array
        int[] count = new int[max + 1];

        // Initialize the count array (not really needed since default is 0)
        for (int i = 0; i < count.length; i++) {
            count[i] = 0;
        }

        // Store the count of each element in the original array
        for (int i = 0; i < arr.length; i++) {
            count[arr[i]]++;
        }

        // Modify the count array to store the cumulative sum
        for (int i = 1; i < count.length; i++) {
            count[i] = count[i] + count[i - 1];
        }

        // Create an output array to store the sorted elements
        int[] output = new int[arr.length];

        // Build the output array by placing elements in their correct positions
        for (int i = arr.length - 1; i >= 0; i--) {
            output[count[arr[i]] - 1] = arr[i];
            count[arr[i]]--;
        }

        // Copy the sorted elements from the output array back to the original array
        for (int i = 0; i < arr.length; i++) {
            arr[i] = output[i];
        }
    }
    
    static void countingSortnegative(int[] arr) {
        int n = arr.length;

        // Find the minimum and maximum value in the array
        int min = arr[0], max = arr[0];
        for (int i = 1; i < n; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
            if (arr[i] > max) {
                max = arr[i];
            }
        }

        // Define the range
        int range = max - min + 1;

        // Create frequency array
        int[] count = new int[range];

        // Store frequency of each element
        for (int i = 0; i < n; i++) {
            count[arr[i] - min]++;
        }

        // Modify the count array to store the cumulative sum
        for (int i = 1; i < count.length; i++) {
            count[i] += count[i - 1];
        }

        // Output array to store sorted elements
        int[] output = new int[n];

        // Build the output array from the count array (reverse for stability)
        for (int i = n - 1; i >= 0; i--) {
            output[count[arr[i] - min] - 1] = arr[i];
            count[arr[i] - min]--;
        }

        // Copy the sorted output array back to the original array
        System.arraycopy(output, 0, arr, 0, n);
    }

    public static void main(String[] args) {
        int arr[] = { 9, 6, 3, -5, 3, -4, 3, 9, 6, 4, 6, -5, 8, 9, 9 };
        System.out.println("Array before Sorting: " + Arrays.toString(arr));

        countingSort(arr);
        System.out.println("Array after Sorting: " + Arrays.toString(arr));
    }
}
