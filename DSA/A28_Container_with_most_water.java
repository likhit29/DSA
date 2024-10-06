//Container with most water - 

/*
height will minimum of 2 bars (left and right)
width = right bar index(j) - left bar index(i)    
water = height * width                                           (calculating area not volume)  
*/

import java.util.*;

public class A28_Container_with_most_water {

    // Brute force - O(n²)
    public static int CMW(ArrayList<Integer> height) {
        int maxwater = 0;
        for (int i = 0; i < height.size()-1; i++) {
            for (int j = i + 1; j < height.size(); j++) {
                int width = j - i;
                int ht = Math.min(height.get(i), height.get(j));
                int currwater = width * ht;
                maxwater = Math.max(maxwater, currwater);
            }
        }
        return maxwater;
    }

    //O(n)
    public static int pointer2(ArrayList<Integer> height) {
        int maxWater = 0;
        int lp = 0;
        int rp = height.size() - 1;
        while (lp < rp) {

            // calculate water area
            int ht = Math.min(height.get(lp), height.get(rp));
            int width = rp - lp;
            int currWater = ht * width;
            maxWater = Math.max(maxWater, currWater);
            // update ptr
            if (height.get(lp) < height.get(rp)) {
                lp++;
            } else {

                rp--;
            }
        }
        return maxWater;
    }

    public static void main(String[] args) {
        ArrayList<Integer> height = new ArrayList<>();
        height.add(1);
        height.add(8);
        height.add(6);
        height.add(2);
        height.add(5);
        height.add(4);
        height.add(8);
        height.add(3);
        height.add(7);
        System.out.println(CMW(height));
        System.out.println(pointer2(height));

    }

}
