import java.io.File;
import java.util.Scanner;

class Edge{
    int start;
    int end;
    int weight;
}
class Graph{
    int v;
    Edge[] edges;
    int edgeCount;
    Graph(String filename) throws Exception{
        Scanner sc = new Scanner(new File(filename));
        v = sc.nextInt();
        edges = new Edge[v * v];
        edgeCount = 0;
        for(int i = 0; i < v;i++){
            for(int j = 0; j < v;j++){
                int weight = sc.nextInt();
                if(weight != 0 && i < j){
                    Edge e = new Edge();
                    e.start = i;
                    e.end = j;
                    e.weight = weight;
                    edges[edgeCount++] = e;

                }
            }

        }
        sc.close();
    }
    public void kruskal(){
        //bubble sort
        for(int i = 0;i < v;i++){
            for(int j = 0; j < edgeCount - i - 1; j++){
                if(edges[j].weight > edges[j + 1].weight){
                    Edge temp = edges[j];
                    edges[j] = edges[j + 1];
                    edges[j + 1] = temp;
                }
            }
        }
        //union
        int[] parent = new int[v];
        for(int i = 0; i < v; i++){
            parent[i] = i;
        }
        int totalWeight = 0;
        for(int i = 0; i < edgeCount;i++){
            Edge e = edges[i];
            int root1 = find(parent,e.start);
            int root2 = find(parent,e.end);
            if(root1 != root2){
                System.out.println(e.start + " " + e.end + " " + e.weight);
                totalWeight += e.weight;
                union(parent,root1,root2);

            }
        }
        System.out.print("Total Weight: " + totalWeight);

    }
    public int find(int[] parent, int i){
        while(parent[i] != i){
            i = parent[i];
        }
        return i;
    }
    public void union(int[] parent,int a, int b){
        parent[b] = a;  
    }
}
public class kruskal {
    public static void main(String[] args) throws Exception {
        Graph g = new Graph("prims.txt");
        g.kruskal();
    }
}
