//38,44
public class Que38{

    public static void sort(int nums[]){
        int j = -1;
        for(int i=0; i<nums.length; i++){
            if(nums[i]%2==0){
                j++;
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
        }
    }

    public static void printArr(int nums[]) {
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int nums[] = {3,1,2,4};
        sort(nums);
        printArr(nums);
    }
}