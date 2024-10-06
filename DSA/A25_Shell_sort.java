public class A25_Shell_sort {
    // Method to perform shell sort
    public static void shellSort(int[] arr) {
        int n = arr.length;
        
        // Start with a big gap, then reduce the gap
        for (int gap = n / 2; gap > 0; gap /= 2) {
            // Perform gapped insertion sort for this gap size.
            for (int i = gap; i < n; i++) {
                // Save arr[i] in temp and make a hole at position i
                int temp = arr[i];
                                                                                           
                // Shift earlier gap-sorted elements up until the correct location
                // for arr[i] is found
                int j;
                for (j = i; j >= gap && arr[j - gap] > temp; j -= gap) {
                    arr[j] = arr[j - gap];
                }
                
                // Put temp (the original arr[i]) in its correct location
                arr[j] = temp;
            }
        }
    }

    // Method to print the array
    public static void printArray(int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    // Main method to test the shell sort
    public static void main(String[] args) {
        int[] arr = {12, 34, 54, 2, 3};
        
        System.out.println("Original array:");
        printArray(arr);
        
        shellSort(arr);
        
        System.out.println("Sorted array:");
        printArray(arr);
    }
}
