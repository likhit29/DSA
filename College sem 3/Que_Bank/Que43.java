//43
public class Que43{

    public static void printArr(int result[]) {
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }
        System.out.println();
    }

    public static void sort(int nums[], int result[]){
        for(int i=0; i<nums.length; i++){
            int count = 0;
            for(int j=0; j<nums.length; j++){
                if(nums[i] > nums[j]){
                    count++;
                }
            }
            result[i] = count;
        }
    }


    public static void main(String[] args) {
        int nums[] = {8,1,2,2,3};
        int result[]  = new int[nums.length];
        sort(nums, result);
        printArr(result);


    }
}