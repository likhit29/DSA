// in ascending or desceding type condition water is not trapped
// Trappeed water = (water level - barheight[i]) * width
// water level = min of (max_height_bar_left, max_height_bar_right)
// we will be crerating 2 left and right arrays - left array will store all the leftmax boundarry for every element.
// O(n)

public class A17_Trapping_rainwater {
    public static int trappedRainwater(int height[]) {
        int n = height.length;                      //array size
        // calculate left max boundary - array
        int leftMax[] = new int[n];
        leftMax[0] = height[0];
        for (int i = 1; i < n; i++) {
            leftMax[i] = Math.max(height[i], leftMax[i - 1]);
        }
        // calculate right max boundary - array
        int rightMax[] = new int[n];
        rightMax[n - 1] = height[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rightMax[i] = Math.max(height[i], rightMax[i + 1]);
        }
        int trappedWater = 0;
        // loop
        for (int i = 0; i < n; i++) {
            // waterLevel = min(leftmax bound, rightmax bound)
            int waterLevel = Math.min(leftMax[i], rightMax[i]);
            // trapped water = waterLevel - height[i]             -  width = 1
            trappedWater += waterLevel - height[i];
        }
        return trappedWater;
    }

    public static void main(String argsl[]) {
        int height[] = { 4, 2, 0, 6, 3, 1, 5 };
        System.out.println(trappedRainwater(height));
    }
}
