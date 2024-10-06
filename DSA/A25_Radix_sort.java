public class A25_Radix_sort {
    
    // Function to get the maximum value in the array
    static int getMax(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }

    // Function to perform counting sort based on a specific digit
    static void countingSort(int[] arr, int exp) {
        int n = arr.length;
        int[] output = new int[n]; // output array
        int[] count = new int[10]; // count array for digits 0-9

        // Initialize count array
        for (int i = 0; i < count.length; i++) {
            count[i] = 0;
        }

        // Store count of occurrences of digits
        for (int i = 0; i < n; i++) {
            count[(arr[i] / exp) % 10]++;
        }

        // Modify the count array to store the cumulative sum
        for (int i = 1; i < count.length; i++) {
            count[i] += count[i - 1];
        }

        // Build the output array by placing elements in their correct positions
        for (int i = n - 1; i >= 0; i--) {
            output[count[(arr[i] / exp) % 10] - 1] = arr[i];
            count[(arr[i] / exp) % 10]--;
        }

        // Copy the sorted elements from the output array back to the original array
        for (int i = 0; i < n; i++) {
            arr[i] = output[i];
        }
    }

    // Main function to implement Radix Sort
    public static void radixsort(int[] arr) {
        // Find the maximum value to know the number of digits
        int max = getMax(arr);

        // Do counting sort for every digit
        //exp = 1 means units place
        for (int exp = 1; max / exp > 0; exp *= 10) {
            countingSort(arr, exp);
        }
    }

    // Test the Radix Sort implementation
    public static void main(String[] args) {
        int[] arr = {170, 45, 75, 90, 802, 24, 2, 66};
        System.out.println("Unsorted array: " + java.util.Arrays.toString(arr));

        radixsort(arr);

        System.out.println("Sorted array: " + java.util.Arrays.toString(arr));
    }
}
