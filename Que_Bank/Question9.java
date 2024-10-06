import java.util.*;

public class Question9 {
    public static void Sort(int Arr[], int n){
        for(int i = 0; i < n; i++){
            int key = Arr[i];
            int j = i - 1;
            while(j >= 0 && Arr[j] > key){
                Arr[j + 1] = Arr[j];
                j--;
            }
            Arr[j + 1] = key;
        }
    }
    public static int FindThirdMax(int Arr[] , int n){
         ;
        if(n-3 < 0){
            return Arr[n - 1];
        }
        else{
            return Arr[n - 3];
        }
    }
    
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the Size of Array:");
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i = 0; i < n ; i++){
            arr[i] = sc.nextInt();
        }
        Sort(arr , n);
        System.out.println("\nArray Printed in Sorted Manner");
        for(int i = 0 ;i < n;i++){
            System.out.print(arr[i] + " ");
        }
        System.out.print("\nThird Maximum No. of Array:");
        int result = FindThirdMax(arr, n);
        System.out.println(result);
        sc.close();
    }
}
