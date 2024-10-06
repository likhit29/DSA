// https://github.com/loveBabbar/CodeHelp-DSA-Busted-Series/blob/main/Lecture036%20Recursion%20Day6/QuickSort.java
// https://github.com/yashchavan02/DSA/blob/main/Search-Sort%2FQuickSort.cpp

public class A25_Quick_sort {

    // Function to print the array
    public static void printArr(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    // QuickSort function
    public static void quickSort(int arr[], int si, int ei) {
        if (si < ei) {

            // Partitioning the array

            int pIdx = partition1(arr, si, ei);
            // int pIdx = partition2(arr, si, ei);

            // Recursively sorting the left part of the partition
            quickSort(arr, si, pIdx - 1);

            // Recursively sorting the right part of the partition
            quickSort(arr, pIdx + 1, ei);
        }
    }

    // Partition function
    public static int partition1(int arr[], int si, int ei) {
        int pivot = arr[ei]; // Choosing the last element as the pivot
        int i = si - 1; // Index to keep track of elements smaller than pivot

        for (int j = si; j < ei; j++) {
            if (arr[j] <= pivot) {
                i++; // Increment index of smaller element

                // Swap arr[i] and arr[j]
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
            }
        }

        // Swap pivot with the element at i+1 position
        i++;
        int temp = arr[ei];
        arr[ei] = arr[i];
        arr[i] = temp;

        return i; // Returning the pivot index
    }

    public static int partition2(int arr[], int si, int ei) {
        int pivot = arr[si]; // Choosing the first element as the pivot
        int i = si + 1;
        int j = ei;

        while (i <= j) {
            // Find an element greater than the pivot on the left side
            while (i <= ei && arr[i] <= pivot) {
                i++;
            }
            // Find an element smaller than the pivot on the right side
            while (j >= si && arr[j] > pivot) {
                j--;
            }
            // Swap elements directly if i is less than j
            if (i < j) {
                // Swap without using a function
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // Swap the pivot with the element at j (correct position) directly
        int temp = arr[si];
        arr[si] = arr[j];
        arr[j] = temp;

        return j; // Returning the pivot's final position
    }

    public static int partition3(int arr[], int si, int ei) {
        // Choosing the middle element as the pivot
        int mid = si + (ei - si) / 2;
        int pivot = arr[mid];

        // Swap the pivot with the first element to make partition logic simpler
        int temp = arr[mid];
        arr[mid] = arr[si];
        arr[si] = temp;

        int i = si + 1;
        int j = ei;

        while (i <= j) {
            // Find an element greater than the pivot on the left side
            while (i <= ei && arr[i] <= pivot) {
                i++;
            }
            // Find an element smaller than the pivot on the right side
            while (j >= si && arr[j] > pivot) {
                j--;
            }
            // Swap elements directly if i is less than j
            if (i < j) {
                // Swap without using a function
                temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // Swap the pivot with the element at j (correct position) directly
        temp = arr[si];
        arr[si] = arr[j];
        arr[j] = temp;

        return j; // Returning the pivot's final position
    }

    public static void main(String[] args) {
        int arr[] = { 6, 3, 9, 8, 2, 5 };

        // Performing QuickSort on the array
        quickSort(arr, 0, arr.length - 1);

        // Printing the sorted array
        printArr(arr);
    }
}
