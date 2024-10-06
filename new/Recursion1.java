public class Recursion1 {

    // Print numbers from n to 1
    public static void printDec(int n) {
        if (n == 1) {
            System.out.println(n);
            return;
        }
        System.out.print(n + " ");
        printDec(n - 1);
    }

    // Print numbers from 1 to n
    public static void printIncreasing(int n) {
        if (n == 1) {
            System.out.print(n + " ");
            return;
        }
        printIncreasing(n - 1);
        System.out.print(n + " ");
    }

    public static int factorial(int n) {
        if (n == 0) {
            return 1;
        }
        int fn = n * factorial(n - 1);
        return fn;

    }

    // Sum of n natural numbers
    public static int sumN(int n) {
        if (n == 1) {
            return 1;
        }
        int sn = n + sumN(n - 1);
        ;
        return sn;
    }

    // draw tree and stack analysis
    // Calculate nth term in fibonacci
    // time Complexity - O(2ⁿ)
    public static int fibonacci(int n) { // fib(n) = fib(n-1) + fib(n-2)
        if (n == 0 || n == 1) {
            return n;
        }
        int fn = fibonacci(n - 1) + fibonacci(n - 2);
        return fn;
    }

    // Check if array is sorted or not
    public static boolean isSorted(int arr[], int i) {
        if (i == arr.length - 1) {
            return true;
        }
        if (arr[i] > arr[i + 1]) {
            return false;
        }
        return isSorted(arr, i + 1);
    }

    // To find the first occurence of an element in an array
    public static int firstElement(int arr[], int n, int i) {

        if (i == arr.length) {
            return -1;
        }
        if (arr[i] == n) {
            return i;
        }
        return firstElement(arr, n, i + 1);
    }

    // To find the last occurence of an element in an array
    public static int lastElement1(int arr[], int n, int i) {

        if (i == -1) {
            return -1;
        }
        if (arr[i] == n) {
            return i;
        }
        return lastElement1(arr, n, i - 1);
    }

    public static int lastElement2(int arr[], int key, int i) {
        if (i == arr.length) {
            return -1;
        }

        int isFound = lastElement2(arr, key, i + 1);
        if (isFound == -1 && arr[i] == key) {
            return i;
        }
        return isFound;
    }

    // Print x to the power n - O(n)
    public static int power(int x, int n) {
        if (n == 0) {
            return 1;
        }
        return x * power(x, n - 1);
    }

    // Print x to the power n (Optimized) - O(logn)

    public static int powerOptimized(int x, int n) {
        if (n == 0) {
            return 1;
        }

        // 1
        if (n % 2 == 0) {
            return powerOptimized(x * x, n / 2);
        } else {
            return x * powerOptimized(x * x, (n - 1) / 2);
        }

    } /*  // 2
            int sq = powerOptimized(x , n / 2) * powerOptimized(x , n / 2);
            if (n % 2 != 0) {
            sq = x * sq;
            }
            return sq;    
        */




    public static void main(String args[]) {
        // printDec(10);
        // printIncreasing(10);
        // System.out.println(factorial(6));
        // System.out.println(sumN(10));
        // System.out.println(fibonacci(25));
        // int arr[] = { 1, 6, 3, 8, 6 };
        // System.out.println(isSorted(arr, 0));
        // System.out.println(firstElement(arr, 7, 0));
        // System.out.println(lastElement1(arr, 6, arr.length-1));
        // System.out.println(lastElement2(arr, 6, 0));
        // System.out.println(power(2, 4));
        // System.out.println(powerOptimized(2, 10));
            

    }
}