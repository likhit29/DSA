//All 3 have time complexity = O(n²)
//Selection sort - Pick the smallest element and put it in the beginning
//Bubble sort - large elements come to the end array by swapping with adjacent elements
//Insertion Sort - Pick an element from unsorted part and place it in the right position in sorted part
//Counting sort - Used for only +ve numbers, for short array length , less time complexity

/*  
Inbuilt sort - direct function to sort array
import java.util.Arrays;
Arrays.sort(arr)
Arrays.sort(arr, si, ei)           //start_index
Time complexity - O(n logn)        //less than O(n²)



For reverse order - 
import java.util.Collections;                           //int --> INTEGER
Arrays.sort(arr, Collections.reverseOrder())
Arrays.sort(arr, si, ei, Collections.reverseOrder())  
*/



public class A18_Sorting_Algorithms {
    public static void bubbleSort(int arr[]) {
        for (int turn = 0; turn < arr.length - 1; turn++) {
            for (int j = 0; j < arr.length - 1 - turn; j++) {
                if (arr[j] > arr[j + 1]) {
                    // swap
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public static void selectionSort(int arr[]) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minPos = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[minPos] > arr[j]) {
                    minPos = j;
                }
            }
            // swap
            int temp = arr[minPos];
            arr[minPos] = arr[i];
            arr[i] = temp;
        }
    }

    public static void insertionSort(int arr[]) {
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;
            // finding out the correct pos to insert
            while (j >= 0 && arr[j] > key) {
            arr[j + 1] = arr[j];
             j--;                                            //to exit while loop every time(-1)
            }
            // insertion
            arr[j + 1] = key;
        }
    }

    public static void countingSort(int arr[]) {
        int largest = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            largest = Math.max(largest, arr[i]);        //largest - largest number in array
        }
        int count[] = new int[largest + 1];             //we will take 0 number also(+ve)
        for (int i = 0; i < arr.length; i++) {
            count[arr[i]]++;
        }
        // sorting
        int j = 0;
        for (int i = 0; i < count.length; i++) {
            while (count[i] > 0) {
                arr[j] = i;
                j++;
                count[i]--;
            }
        }

    }

    public static void printArr(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String args[]) {
        int arr[] = { 5, 4, 1, 3, 2 };

        countingSort(arr);
        printArr(arr);

    }
}
