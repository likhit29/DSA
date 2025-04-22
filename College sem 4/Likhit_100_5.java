import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Likhit_100_5 {

    static class Edge {
        int src;
        int dest;
        int wt;

        public Edge(int s, int d, int w) {
            this.src = s;
            this.dest = d;
            this.wt = w;
        }
    }

    // static class Pair {
    //     int n;
    //     int path;

    //     public Pair(int n, int path) {
    //         this.n = n;
    //         this.path = path;
    //     }
    // }
    static class Pair implements Comparable<Pair> {
        int n;
        int path;

        public Pair(int n, int path) {
            this.n = n;
            this.path = path;
        }

        @Override
        public int compareTo(Pair other) {
            return this.path - other.path;
        }
    }


    // static class MinHeap {
    //     ArrayList<Pair> ar = new ArrayList<>();

    //     public boolean isEmpty() {
    //         return ar.size() == 0;
    //     }

    //     public void add(Pair data) {
    //         ar.add(data);
    //         int ch = ar.size() - 1;
    //         int par = (ch - 1) / 2;
    //         while (ch > 0 && ar.get(ch).path < ar.get(par).path) {
    //             Pair temp = ar.get(par);
    //             ar.set(par, ar.get(ch));
    //             ar.set(ch, temp);

    //             ch = par;
    //             par = (ch - 1) / 2;
    //         }
    //     }

    //     public Pair peek() {
    //         if (isEmpty()) {
    //             return null;
    //         }
    //         return ar.get(0);
    //     }

    //     private void heapify(int i) {
    //         int minidx = i;
    //         int left = 2 * i + 1;
    //         int right = 2 * i + 2;

    //         if (left < ar.size() && ar.get(minidx).path > ar.get(left).path) {
    //             minidx = left;
    //         }
    //         if (right < ar.size() && ar.get(minidx).path > ar.get(right).path) {
    //             minidx = right;
    //         }
    //         if (minidx != i) {
    //             Pair temp = ar.get(i);
    //             ar.set(i, ar.get(minidx));
    //             ar.set(minidx, temp);

    //             heapify(minidx);
    //         }
    //     }

    //     public Pair remove() {
    //         if (isEmpty()) {
    //             return null;
    //         }
    //         Pair data = ar.get(0);
    //         ar.set(0, ar.get(ar.size() - 1));
    //         ar.remove(ar.size() - 1);

    //         if (!ar.isEmpty()) {
    //             heapify(0);
    //         }
    //         return data;
    //     }

    //     public boolean checkHeap() {
    //         int n = ar.size();
    //         for (int i = 0; i < n / 2; i++) {
    //             int left = 2 * i + 1;
    //             int right = 2 * i + 2;

    //             if (left < n && ar.get(i).path > ar.get(left).path) {
    //                 return false;
    //             }
    //             if (right < n && ar.get(i).path > ar.get(right).path) {
    //                 return false;
    //             }
    //         }
    //         return true;
    //     }
    // }

    public static void dijkstra(ArrayList<Edge>[] graph, int src) {
        int[] dist = new int[graph.length];
        for(int i = 0; i<graph.length; i++){
            if(i != src){
                dist[i] = Integer.MAX_VALUE;      //infinity
            }
        }  
        boolean[] vis = new boolean[graph.length];
        //MinHeap pq = new MinHeap();
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(src, 0));

        while (!pq.isEmpty()) {
            Pair curr = pq.remove();
            if (!vis[curr.n]) {
                vis[curr.n] = true;

                for (Edge e : graph[curr.n]) {
                    int u = e.src;
                    int v = e.dest;
                    int wt = e.wt;

                    if (dist[u] + wt < dist[v]) {
                        dist[v] = dist[u] + wt;
                        pq.add(new Pair(v, dist[v]));
                    }
                }
            }
        }

        for (int i = 0; i < dist.length; i++) {
            System.out.println("Distance from " + src + " to " + i + " = " + dist[i]);
        }
    }

    public static void main(String[] args) throws Exception {
            Scanner sc = new Scanner(new File("m2.txt"));
            int V = sc.nextInt();
        
            ArrayList<Edge>[] graph = new ArrayList[V];
            for (int i = 0; i < V; i++) {
                graph[i] = new ArrayList<>();
                for (int j = 0; j < V; j++) {
                    int wt = sc.nextInt();
                    if (wt != 0) {
                        graph[i].add(new Edge(i, j, wt));
                    }
                }
            }
        
            dijkstra(graph, 0);
        

        
    }
}
