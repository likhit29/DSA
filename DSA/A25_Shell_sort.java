public class A25_Shell_sort {
    // Method to perform shell sort
    public static void shellSort(int[] arr) {
        int n = arr.length;
        
        for (int gap = n / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < n; i++) {
                int key = arr[i];
                                                                                                           
                int j = i;
                while (j >= gap && arr[j - gap] > key ) {
                    arr[j] = arr[j - gap];
                    j -= gap;
                }
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
