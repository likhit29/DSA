// MST of a graph connect all nodes with minimum total edge weight (No cycles, all nodes connected)
// in mst if there are v vertices then there will be v-1 edges
import java.util.ArrayList;
import java.util.PriorityQueue;

public class A46_Graphs_prims   {

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

    static void createGraph(ArrayList<Edge>[] graph) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }


        graph[0].add(new Edge(0, 1,10));
        graph[0].add(new Edge(0, 2,15));
        graph[0].add(new Edge(0,3,30));
        graph[1].add(new Edge(1,0,10));
        graph[1].add(new Edge(1,3,40));
       
        graph[2].add(new Edge(2, 0,15));
        graph[2].add(new Edge(2, 3,50));

        graph[3].add(new Edge(3, 1,40));
        graph[3].add(new Edge(3, 2,50));

    }

    static class Pair implements Comparable<Pair>{
        int n;
        int cost;

        public Pair(int n, int cost){
            this.n = n;
            this.cost = cost;
        }
        @Override
        public int compareTo(Pair p2){
            return this.cost - p2.cost;   
        }
    }

    public static void prims(ArrayList<Edge> graph[], int src){
        boolean vis[] = new boolean[graph.length];
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(src, 0));
        int finalcost = 0;
        while(!pq.isEmpty()){
            Pair curr = pq.remove();
            if(!vis[curr.n]){
                vis[curr.n] = true;
                finalcost += curr.cost;
                for(int i = 0; i<graph[curr.n].size() ; i++){
                    Edge e = graph[curr.n].get(i);
                    pq.add(new Pair(e.dest, e.wt));
                }
            }
        }

        System.out.print(finalcost);
    }

    
    public static void main(String[] args) {
        int V = 6;
        // int [] arr = new int[V];
        ArrayList<Edge>[] graph = new ArrayList[V];
        createGraph(graph);
        int src = 0;
        prims(graph, src);

    }

}                                    