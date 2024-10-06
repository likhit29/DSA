// Pair sum 1 - [1,4,7,8,9,10]
// Pair sum 2 - [12,15,6,8,9,10]     sorted but rotated

import java.util.*;

public class A28_Pair_sum {

    // Pair sum 1 - Brute force - O(n²)
    // Applicable for pair sum 2 also
    public static boolean brute(ArrayList<Integer> list, int target) {
        for (int i = 0; i < list.size() - 1; i++) {
            for (int j = i + 1; j < list.size(); j++) {

                if (list.get(i) + list.get(j) == target) {
                    return true;
                }

            }
        }
        return false;
    }

    // only pair sum 1
    public static boolean pointer(ArrayList<Integer> list, int target) {
        int lp = 0;
        int rp = list.size() - 1;
        while (lp != rp) {
            // case 1
            if (list.get(lp) + list.get(rp) == target) {
                return true;
            }
            if (list.get(lp) + list.get(rp) < target) {
                lp++;
            } else {
                rp--;
            }
        }
        return false;
    }

    public static boolean sum_2(ArrayList<Integer> list, int target) {
        int n = list.size();
        int bp = -1;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) > list.get(i + 1)) {
                bp = i;
                break;
            }
        }
        int rp = bp;
        int lp = bp + 1;

        while (lp != rp) {
            // case 1
            if (list.get(lp) + list.get(rp) == target) {
                return true;
            }
            if (list.get(lp) + list.get(rp) < target) {
                lp = (lp + 1) % n;
            } else {
                rp = (n + rp - 1) % n;

            }
        }
        return false;

    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        int target = 14;
        // System.out.println(brute(list, target));
        // System.out.println(pointer(list, target));
        System.out.println(sum_2(list, target));

    }
}
