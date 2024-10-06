public class Recursion2 {

    // Tiling Problem
    // Given a “2 x n” board and tiles of size “2 x 1”, count the number of ways to
    // tile the given board using the 2 x 1 tiles.(A tile can either be placed
    // horizontally or vertically.)
    public static int tilingProblem(int n) { // 2 x n (floor size)
        // base case
        if (n == 0 || n == 1) {
            return 1;
        }
        // vertical choice
        int fnml = tilingProblem(n - 1);
        // horizontal choice
        int fnm2 = tilingProblem(n - 2);
        int totWays = fnml + fnm2;
        return totWays;
    }

    // Remove duplicates in a string (alphabets 'a'-'z')
    public static void removeDuplicates(String str) {
        
    }



    public static void main(String args[]) {

        System.out.println(tilingProblem(4));

    }

}