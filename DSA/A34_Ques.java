import java.util.*;

public class A34_Ques {

    // Minimum Sum Absoulte Difference Pairs
    // First we will sort both the arrays and make pair in which diiference in
    // numbers should be lesser
    public void Min_absolute_difference() {
        int A[] = { 2, 1, 3 };
        int B[] = { 5, 2, 1 };
        Arrays.sort(A);
        Arrays.sort(B);
        int val = 0;
        for (int i = 0; i < A.length; i++) {
            val += Math.abs(A[i] - B[i]);
        }
        System.out.println(val);
    }

    // same activity selection approach we will be using
    public void Maximum_length_chain_of_pairs() {
        int pairs[][] = { { 5, 24 }, { 39, 60 }, { 5, 28 }, { 27, 40 }, { 50, 90 } };
        Arrays.sort(pairs, Comparator.comparingDouble(o -> o[1]));

        int chainLen = 1;
        int chainEnd = pairs[0][1];

        for (int i = 1; i < pairs.length; i++) {
            if (pairs[i][0] > chainEnd) {
                chainLen++;
                chainEnd = pairs[i][1];
            }
        }
        System.out.println(chainLen);
    }

    
    public void Indian_coins() {
        int notes[] = { 1, 2, 5, 10, 20, 50, 100, 500, 2000 };
        int bal = 590;
        int count = 0;

        for (int i = notes.length - 1; i >= 0; i--) {
            if (bal >= notes[i]) {
                while (bal >= notes[i]) {
                    bal -= notes[i];
                    count++;
                    System.out.print(notes[i] + " ");
                }
            }
        }
        System.out.println("\n" + count);
    }

    

    public static void main(String[] args) {
        //A34_Ques o1 = new A34_Ques();
        // o1.Min_absolute_difference();
        // o1.Maximum_length_chain_of_pairs();
        //o1.Indian_coins();
    }
}