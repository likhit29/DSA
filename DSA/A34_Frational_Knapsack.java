//Frational_Knapsack - Greedy Algorithm
//We need to sort data in descending order 

import java.util.Arrays;
import java.util.Comparator;

public class A34_Frational_Knapsack {

    public void Frational_Knapsack() {
        int val[] = { 60, 100, 120 };
        int weight[] = { 10, 20, 30 };
        int W = 50;

        double ratio[][] = new double[val.length][2];
        for (int i = 0; i < val.length; i++) {
            ratio[i][0] = i;
            ratio[i][1] = val[i] / (double) weight[i];
        }

        // ascending order sorting
        Arrays.sort(ratio, Comparator.comparingDouble(o -> o[1]));

        int capacity = W;
        int cost = 0;

        // running loop as for descending order
        for (int i = ratio.length - 1; i >= 0; i--) {
            int idx = (int) ratio[i][0];
            if (capacity >= weight[idx]) {
                cost += val[idx];
                capacity -= weight[idx];
            } else {
                cost += (ratio[i][1] * capacity);
                capacity = 0;
                break;
            }
        }
        System.out.println(cost);
    }

    public static void main(String[] args) {
        A34_Frational_Knapsack o1 = new A34_Frational_Knapsack();
        o1.Frational_Knapsack();

    }
}
