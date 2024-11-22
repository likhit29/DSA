public class A25_Shell_sort {
    // Method to perform shell sort
    public static void shellSort(int[] arr) {
        int n = arr.length;
        
        // Start with a big gap, then reduce the gap
        for (int gap = n / 2; gap > 0; gap /= 2) {
            // Perform gapped insertion sort for this gap size.
            for (int i = gap; i < n; i++) {
                // Save arr[i] in key and make a hole at position i
                int key = arr[i];
                                                                                           
                // Shift earlier gap-sorted elements up until the correct location
                // for arr[i] is found
                int j = i;
                while (j >= gap && arr[j - gap] > key ) {
                    arr[j] = arr[j - gap];
                    j -= gap;
                }
                
                // Put key (the original arr[i]) in its correct location
                arr[j] = key;
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
