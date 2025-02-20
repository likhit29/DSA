public class graph {
    class Graph {
        int s;
        int arr[][];

        Graph(int s) {
            this.s = s;
            arr = new int[s][s]; 
            for (int i = 0; i < s; i++) {
                for (int j = 0; j < s; j++) {
                    arr[i][j] = 0; 
                }
            }
        }

        public void degreeOfNode(int i) {
            int degree = 0;
            for (int j = 0; j < s; j++) {
                if(arr[i][j] != 0){
                    degree++;
                }
                 
            }
            System.out.println("Degree of node " + i + " is -  " + degree);
        }

        public void display() {
            for (int i = 0; i < s; i++) {
                for (int j = 0; j < s; j++) {
                    System.out.print(arr[i][j] + " ");
                }
                System.out.println();
            }
        }
    }

    public static void main(String[] args) {
        
        graph o = new graph();
        int s = 4; 
        Graph graphObj = o.new Graph(s);
        //graphObj.arr[0][1] = 1;
        //graphObj.arr[0][1] = 1;
        graphObj.display();
        
        for (int i = 0; i < s; i++) {
            graphObj.degreeOfNode(i);
        }
    }
}