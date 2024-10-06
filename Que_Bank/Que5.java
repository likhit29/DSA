public class Que5 {
    public static void print(int Arr[]){
        int size = Arr.length;
        for(int i = 0; i < size; i++){
            System.out.print(Arr[i] + " ");
        }
    }
    public static void shellSort(int Arr[]){
        int n = Arr.length;
        int gapSequence[] = {3,1};
        for(int i = 0; i < gapSequence.length;i++){
            int gap = gapSequence[i];
            for(int j = gap ; j < n;j++){
                for(int k = j-gap; k >=0 ; k-=gap){
                    int temp = 0;
                    if(Arr[k+gap] > Arr[k]){
                        break;
                    }
                    else{
                        temp = Arr[k];
                        Arr[k] = Arr[k+gap];
                        Arr[k+gap] = temp;
                    }
                }
            }
        }

    }
    public static void main(String args[]){
        int Arr[] = {22,7,2,19,10,18,15,13};
        System.out.print("Without Sorting:");
        print(Arr);
        System.out.println("After Sorting:");
        shellSort(Arr);
        print(Arr);
    }
}
