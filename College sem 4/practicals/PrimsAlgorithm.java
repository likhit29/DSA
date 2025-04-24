import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Arrays;

class Edge{
    int s, e, w;
}

class Graph{
    private int[][] A;
    private int v;
    private String[] departments = {"CSE", "ECE", "MECH", "CIVIL", "IT"};
    public Graph(String filename){
        try{
            Scanner sc = new Scanner(new File(filename));
            v = sc.nextInt();
            System.out.println("Number of vertices = " + v);
            A = new int[v][v];
            for (int i = 0; i < v; i++) {
                for (int j = 0; j < v; j++) {
                    A[i][j] = sc.nextInt();
                }
            }
            sc.close();
        } catch (FileNotFoundException e){
            e.printStackTrace();
        }
    }

    public void display(){
        for (int i = 0; i < v; i++){
            for (int j = 0; j < v; j++){
                System.out.print(A[i][j] + "\t");
            }
            System.out.println();
        }
    }

    public void prims(int start){
        int[] visited = new int[v];
        for(int i = 0; i < v; i++){
            visited[i] = 0;
        }
        visited[start] = 1;
        Edge[] MST = new Edge[v - 1];

        for(int n = 0; n < v - 1; n++){
            Edge minEdge = new Edge();
            minEdge.w = Integer.MAX_VALUE;

            for(int i = 0; i < v; i++){
                if (visited[i] == 1) {
                    for (int j = 0; j < v; j++){
                        if (visited[j] == 0 && A[i][j] != 0 && A[i][j] < minEdge.w) {
                            minEdge.s = i;
                            minEdge.e = j;
                            minEdge.w = A[i][j];
                        }
                    }
                }
            }

            MST[n] = minEdge;
            visited[minEdge.e] = 1;
        }

        for (Edge edge : MST){
            System.out.println(departments[edge.s] + " - " + departments[edge.e] + " : " + edge.w);

        }

        // for (int i = 0; i < MST.length; i++) {
        //     Edge edge = MST[i];
        //     System.out.println(departments[edge.s] + " - " + departments[edge.e] + " : " + edge.w);
        // }
        
        // int totalCost = 0;
        // for (int i = 0; i < MST.length; i++) {
        //     totalCost += MST[i].w;
        // }
        // System.out.println("Total cost of MST: " + totalCost);
        
    }
}

public class PrimsAlgorithm {
    public static void main(String[] args) {
        Graph G = new Graph("prims.txt");
        G.display();
        G.prims(0);
    }
}
