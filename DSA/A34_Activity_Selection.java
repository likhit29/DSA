import java.util.*;

//sorting on basis of end time
public class A34_Activity_Selection {

    // Without Sorting - O(n)
    public void Activity_Selection1() {
        int start[] = { 1, 3, 0, 5, 8, 5 };
        int end[] = { 2, 4, 6, 7, 9, 9 };

        ArrayList<Integer> a = new ArrayList<>();
        int act = 0;

        // 1st Activity
        a.add(0);
        act = 1;
        int lastend = end[0];
        for (int i = 1; i < end.length; i++) {
            if (start[i] >= lastend) {
                act++;
                a.add(i);
                lastend = end[i];
            }
        }
        System.out.println("max activity = " + act);
        for (int i = 0; i < a.size(); i++) {
            System.out.print("A" + a.get(i) + " ");
        }
    }

    //With Sorting
    public void Activity_Selection2() {
        int start[] = { 1, 3, 0, 5, 8, 5 };
        int end[] = { 2, 4, 6, 7, 9, 9 };

        int activites[][] = new int[start.length][3];
        for(int i=0; i<start.length;i++){
            activites[i][0] = i;
            activites[i][1] = start[i];
            activites[i][2] = end[i];
        }

        //lambda function - short form
        Arrays.sort(activites, Comparator.comparingDouble(o -> o[2]));
        ArrayList<Integer> a = new ArrayList<>();
        int act = 0;

        // 1st Activity
        a.add(activites[0][0]);
        act = 1;
        int lastend = activites[0][2];
        for (int i = 1; i < end.length; i++) {
            if (activites[i][1] >= lastend) {
                act++;
                a.add(activites[i][0]);
                lastend = activites[i][2];
            }

        }
        System.out.println("max activity = " + act);
        for (int i = 0; i < a.size(); i++) {
            System.out.print("A" + a.get(i) + " ");
        }
    }
    public static void main(String[] args) {
        A34_Activity_Selection o1 = new A34_Activity_Selection();
        //o1.Activity_Selection1();
        o1.Activity_Selection2();

    }
}

