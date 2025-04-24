import java.io.*;
import java.util.*;

class Edge {
    int s, e, w;
    
    Edge(int s, int e, int w) {
        this.s = s;
        this.e = e;
        this.w = w;
    }
}

class Node {
    int s, e, w;
    Node next;
    
    Node(int s, int e, int w) {
        this.s = s;
        this.e = e;
        this.w = w;
        this.next = null;
    }
}

class MinHeap {
    private PriorityQueue<Edge> pq;
    
    MinHeap() {
        pq = new PriorityQueue<>(Comparator.comparingInt(edge -> edge.w));
    }
    
    boolean isEmpty() {
        return pq.isEmpty();
    }
    
    void insert(Edge x) {
        pq.add(x);
    }
    
    Edge deleteMin() {
        return pq.poll();
    }
}

class Graph {
    private Node[] adjacencyList;
    private String[] vertexNames;
    private int v;

    Graph(String matrixFile, String namesFile) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(matrixFile));
        v = Integer.parseInt(br.readLine().trim());
        adjacencyList = new Node[v];
        
        for (int i = 0; i < v; i++) {
            adjacencyList[i] = null;
        }
        
        for (int i = 0; i < v; i++) {
            String[] row = br.readLine().split(" ");
            for (int j = 0; j < v; j++) {
                int weight = Integer.parseInt(row[j]);
                if (weight > 0) {
                    Node newNode = new Node(i, j, weight);
                    newNode.next = adjacencyList[i];
                    adjacencyList[i] = newNode;
                }
            }
        }
        br.close();
        
        BufferedReader brNames = new BufferedReader(new FileReader(namesFile));
        vertexNames = new String[v];
        brNames.readLine();
        for (int i = 0; i < v; i++) {
            vertexNames[i] = brNames.readLine().trim();
        }
        brNames.close();
    }

    void dijkstra(int start) {
        int[] cost = new int[v];
        Arrays.fill(cost, Integer.MAX_VALUE);
        
        MinHeap heap = new MinHeap();
        cost[start] = 0;
        heap.insert(new Edge(start, start, 0));

        while (!heap.isEmpty()) {
            Edge current = heap.deleteMin();
            Node temp = adjacencyList[current.e];
            
            while (temp != null) {
                if (cost[current.e] + temp.w < cost[temp.e]) {
                    cost[temp.e] = cost[current.e] + temp.w;
                    heap.insert(new Edge(temp.s, temp.e, cost[temp.e]));
                }
                temp = temp.next;
            }
        }
        
        System.out.println("Start from " + vertexNames[start] + ":");
        for (int i = 0; i < v; i++) {
            System.out.println(vertexNames[start] + " TO " + vertexNames[i] + " = " + cost[i]);
        }
    }
}

public class Likhit_100_5b {
    public static void main(String[] args) {
        try {
            Graph G = new Graph("m2.txt", "m3.txt");
            G.dijkstra(0);
        } catch (IOException e) {
            System.err.println("Error reading files: " + e.getMessage());
        }
    }
}
