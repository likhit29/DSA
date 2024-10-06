//39
public class Que39{

    public static void sort(int nums[]){
        int j = -1;
        for(int i=0; i<nums.length; i++){
            if(nums[i] == 0){
                j++;
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
        }
        for(int i=0; i<nums.length; i++){
            if(nums[i] == 1){
                j++;
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
        }
    }
    public static void Sort(int nums[]){
        for(int i = 0;i < nums.length;i++){
            int key = nums[i];
            int j = i - 1;
            while(j >= 0 && key < nums[j]){
                nums[j + 1] = nums[j];
                j--;
            }
            nums[j + 1] = key;

        }
    }
    

    public static void printnums(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int nums[] = {0,0,2,1,2,1,1,0,2};
        sort(nums);
        printnums(nums);
    }
}