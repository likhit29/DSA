import java.io.File;
import java.util.Scanner;

class Node{
    int start;
    int end;
    int weight;
    Node next;
}
class Edge{
    int start;
    int end;
    int weight;
}
class Heap{
    Edge A[];
    int size;
    Heap(int n){
        A = new Edge[n];
        this.size = 0;
    }
    public void insert(Edge e){
        A[size] = e;
        heapifyUp(size);
        size++;
    }
    public boolean isEmpty(){
        return size == 0;
    }
    public void heapifyUp(int n){
        while(n > 0){
            int parent = (n - 1) / 2;
            if(A[parent].weight > A[n].weight){
                Edge temp = A[parent];
                A[parent] = A[n];
                A[n] = temp;
                n = parent;
            }
            else{
                break;
            }
        }
    }
    public Edge deleteMin(){
        Edge min = A[0];
        A[0] = A[size - 1];
        heapifyDown(size);
        size--;
        return min;
    }
    public void heapifyDown(int n){
        while(true){
        int left = 2 * n + 1;
        int right = 2 * n + 2;
        int min = n;
        if(left < size && A[left].weight < A[min].weight){
            min = left;
        }
        if(right < size && A[right].weight < A[min].weight){
            min = right;
        }
        if(min != n){
            Edge temp = A[n];
            A[n] = A[min];
            A[min] = temp;
            n = min;
        }
        else{
            break;
        }
    }
        
    }


}
class Graph{
    int vertices;
    String[] v_name;
    Node[] A;
    Graph(String filename1 , String filename2) throws Exception{
        Scanner sc = new Scanner(new File(filename1));
        vertices = sc.nextInt();
        A = new Node[vertices];
        for(int i = 0; i < vertices;i++){
            A[i] = null;
        }
        for(int i = 0; i < vertices; i++){
            for(int j = 0; j < vertices;j++){
                int x = sc.nextInt();
                if(x != 0){
                    Node newNode = new Node();
                    newNode.start = i;
                    newNode.end = j;
                    newNode.weight = x;
                    newNode.next = A[i];
                    A[i] = newNode;
                }
            }
        }
        sc.close();
        Scanner sc2 = new Scanner(new File(filename2));
        int v2 = sc2.nextInt();
        v_name = new String[v2];
        for(int i = 0; i < v2; i++){
            v_name[i] = sc2.next();
        }
        sc2.close();
    }
    public void djkstra(int start){
        int[] cost = new int[vertices];
        for(int i = 0; i < vertices;i++){
            cost[i] = Integer.MAX_VALUE;
        }
        Heap h = new Heap(100);
        cost[start] = 0;
        Edge e = new Edge();
        e.start = -1;
        e.end = start;
        e.weight = 0;
        h.insert(e);
        while(!h.isEmpty()){
            Edge temp = h.deleteMin();
            Node p = A[temp.end];
            while(p != null){
                if(cost[p.end] > cost[p.start] + p.weight){
                    cost[p.end] = cost[p.start] + p.weight;
                    Edge e2 = new Edge();
                    e2.start = p.start;
                    e2.end = p.end;
                    e2.weight = cost[p.end];
                    h.insert(e2);

                }
                p = p.next;
            }
        }
        for(int i = 0; i < vertices; i++){
            System.out.println(v_name[start] + " -> " + v_name[i] + " = " + cost[i]);
    }
}
}
public class djktraAlgo {
    public static void main(String[] args) throws Exception {
        Graph g = new Graph("m1.txt", "m2.txt");
        g.djkstra(0);

    }
}
