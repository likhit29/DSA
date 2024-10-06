//46
public class Que46 {

    public static boolean hasDuplicates(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    return true; // Duplicate found
                }
            }
        }
        return false; // No duplicates found
    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 4, 5, 2 }; // Example input
        System.out.println(hasDuplicates(nums)); // Output: false

    }
}
