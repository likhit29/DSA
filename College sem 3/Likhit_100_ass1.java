//Likhit Chaudhary
//123B1B100

/*Write a code to determine two arrays are identical or not. 
Arrays are identical if they both have exactly same element. 
Order of elements is insignificant. 
Assume the highest element in any array is 100 and max number of elements each array has 50. Expected time complexity - O(n) */
import java.util.Scanner;

public class Likhit_100_ass1 {

    public static boolean identical(int arr1[], int arr2[]) {
        if (arr1.length != arr2.length) {
            return false;
        }
        int count1[] = new int[101];
        for (int i = 0; i < arr1.length; i++) {
            count1[arr1[i]]++;
            count1[arr2[i]]--;
        }

        for (int i = 0; i < count1.length; i++) {
            if (count1[i] != 0) {
                return false;
            }
        }
        return true;

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr1 = null;
        int[] arr2 = null;

        while (true) {
            System.out.println("\n---- Menu ----");
            System.out.println("1. Enter Array 1");
            System.out.println("2. Enter Array 2");
            System.out.println("3. Check if Arrays are Identical");
            System.out.print("Choose an option: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Enter number of elements in Array 1:");
                    int n1 = sc.nextInt();
                    arr1 = new int[n1];
                    System.out.println("Enter elements of Array 1:");
                    for (int i = 0; i < n1; i++) {
                        arr1[i] = sc.nextInt();
                    }
                    System.out.print("Array 1: ");
                    for (int i = 0; i < n1; i++) {
                        System.out.print(arr1[i] + " ");
                    }
                    System.out.println();

                    break;
                case 2:
                    System.out.println("Enter number of elements in Array 2:");
                    int n2 = sc.nextInt();
                    arr2 = new int[n2];
                    System.out.println("Enter elements of Array 2:");
                    for (int i = 0; i < n2; i++) {
                        arr2[i] = sc.nextInt();
                    }
                    System.out.print("Array 2: ");
                    for (int i = 0; i < n2; i++) {
                        System.out.print(arr2[i] + " ");
                    }
                    System.out.println();

                    break;
                case 3:
                    if (arr1 == null || arr2 == null) {
                        System.out.println("\nPlease enter both arrays first.");
                    } else if (identical(arr1, arr2)) {
                        System.out.println("\nArrays are identical.");
                    } else {
                        System.out.println("\nArrays are not identical.");
                    }
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");

            }
        }

    }

}