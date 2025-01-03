import java.util.Scanner;
public class Question10 {
    public static void print(int Arr[],int n){
        for(int i = 0; i < n;i++){
        System.out.print(Arr[i]+" ");
        }
    }
    public static void CompareBoyOrGirl(int A[],int n){
        int count = 0;
        for(int i = 0 ; i < n;i++){
            for(int j = 0; j < n;j++){
                if(A[i] == A[j] && i != j){
                    count++;
                }
            }
        }
        if(count == 0){
            System.out.println("GIRL");

        }
        else{
            System.out.println("BOY");
        }
    }

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the Size of Array: ");
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i = 0; i < n;i++){
            System.out.print("Enter the Element "+(i+1)+": ");
            arr[i] = sc.nextInt();
        }
        print(arr,n);
        System.out.println("\nGirls or Boys Party?:");
        CompareBoyOrGirl(arr,n);
        
        sc.close();
    }
}
