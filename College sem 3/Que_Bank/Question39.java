public class Question39 {
    public static void Sort(int Arr[], int n){
        for(int i = 0;i < n;i++){
            int key = Arr[i];
            int j = i - 1;
            while(j >= 0 && key < Arr[j]){
                Arr[j + 1] = Arr[j];
                j--;
            }
            Arr[j + 1] = key;

        }
    }
    public static void main(String args[]){
        int Color[] = {0,0,2,1,2,1,1,0,2};
        int n = Color.length;
        Sort(Color, n);
        for(int i = 0; i < n;i++){
            System.out.print(Color[i]+ " ");
        }
    }
}
