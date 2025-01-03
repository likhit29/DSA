public class A25_Radix_sort {
    
    static int getMax(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }

    static void countingSort(int[] arr, int exp) {
        int n = arr.length;
        int[] output = new int[n]; 
        int[] count = new int[10]; 
    
        for (int i = 0; i < count.length; i++) {
            count[i] = 0;
        }
    
        for (int i = 0; i < n; i++) {
            int index = (arr[i] / exp) % 10; 
            count[index]++;
        }
    
        for (int i = 1; i < count.length; i++) {
            count[i] += count[i - 1];
        }
    
        for (int i = n - 1; i >= 0; i--) {
            int index = (arr[i] / exp) % 10;
            output[count[index] - 1] = arr[i];
            count[index]--;
        }
    
        for (int i = 0; i < n; i++) {
            arr[i] = output[i];
        }
    }
    

    // Main function to implement Radix Sort
    public static void radixsort(int[] arr) {
        int max = getMax(arr);

        //exp = 1 means units place
        for (int exp = 1; max / exp > 0; exp *= 10) {
            countingSort(arr, exp);
        }
    }

    public static void main(String[] args) {
        int[] arr = {170, 45, 75, 90, 802, 24, 2, 66};
        System.out.println("Unsorted array: " + java.util.Arrays.toString(arr));

        radixsort(arr);

        System.out.println("Sorted array: " + java.util.Arrays.toString(arr));
    }
}
