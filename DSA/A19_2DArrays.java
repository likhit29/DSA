/*
2D Arrays
int numbers[] = {1, 2, 3}; 
int matrix[] [] = new int [3] [3];    //2d array

int matrix[] [] = {{1, 2, 3, 4},
                    {5, 6, 7, 8},
                        {9, 10, 11, 12},
                            {13, 14, 15, 16}};   

*/

// matrix[0].length returns the number of columns in the first row - For a 3x4 matrix (3 rows and 4 columns), endRow should be 2 but this code will mistakenly set endRow to 3
// matrix.length, which gives the number of rows.


public class A19_2DArrays {
    
 
    //Spiral Matrix

    public static void printSpiral(int matrix[][]) {

        int startRow = 0;
        int startCol = 0;
        int endRow = matrix.length - 1; 
        int endCol = matrix[0].length - 1;

        while (startRow <= endRow && startCol <= endCol) {
            // top
            for (int j = startCol; j <= endCol; j++) {
                System.out.print(matrix[startRow][j] + " ");
            }

            // right
            for (int i = startRow + 1; i <= endRow; i++) {
                System.out.print(matrix[i][endCol] + " ");
            }

            // bottom
            for (int j = endCol - 1; j >= startCol; j--) {
                System.out.print(matrix[endRow][j] + " ");
            }

            // left
            for (int i = endRow - 1; i >= startRow + 1; i--) {
                System.out.print(matrix[i][startCol] + " ");
            }
            startCol++;
            startRow++;
            endCol--;
            endRow--;         
        }
        System.out.println();
    }


    //Diagonal matrix -  problem are solved for only rows=column matrix
    public static void diagonalSum(int matrix[][]){
        int sum = 0;
        // for(int i = 0;i<matrix.length;i++){
        //     for(int j = 0; j<matrix[0].length;j++){
        //         if(i==j){
        //             sum += matrix[i][j];
        //         }
        //         else if (i+j==matrix.length-1){
        //             sum += matrix[i][j];
        //         }
        //     }
        // } 

        for(int i = 0; i<matrix.length;i++){
            //pd
            sum += matrix[i][i];
            //sd
            if(i!=matrix.length-1-i){
                sum += matrix[i][matrix.length-1-i];
            }
        }
        System.out.println(sum);
    }


    /*
    Search in sorted matrix
    1. Linear search - brute force - O(n²)
    2. Binary search - applying BS in each row  - O(nlogn)
    3. O(n+m)
    */
    public static boolean staircaseSearch(int[][] matrix, int key) {
        int row = 0;
        int col = matrix[0].length - 1;
    
        while (row < matrix.length && col >= 0) {
            if (matrix[row][col] == key) {
                System.out.println("Found key at (" + row + ", " + col + ")");
                return true;
            } else if (key < matrix[row][col]) {
                col--;  // Move left
            } else {
                row++;  // Move down
            }
        }
    
        System.out.println("Key not found!");
        return false;
    }
    

    public static void main(String args[]) {
        int matrix[][] = {{1, 2, 3, 4},
                         {5, 6, 7, 8},
                         {9, 10, 11, 12},
                         {13, 14, 15, 16}};

        //printSpiral(matrix);  
        //diagonalSum(matrix);
        staircaseSearch(matrix, 14);
    }
}


























