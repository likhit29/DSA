import java.util.ArrayList;
import java.util.Stack;
public class Likhit_100_Topological {

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

    
    public static void topological(ArrayList<Edge>[] graph) {
        boolean vis[] = new boolean[graph.length];
        Stack<Integer> s = new Stack<>();
        for (int i = 0; i < graph.length; i++) {
            if(!vis[i]){
                topologicalUtil(graph, i, vis,s);
            }
        }
        while(!s.isEmpty()){
            System.out.println(s.pop());
        }
    }
    
    public static void topologicalUtil(ArrayList<Edge>[] graph, int curr, boolean vis[],Stack<Integer> s) { // O(V + E)
        vis[curr] = true;
        
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (!vis[e.dest]) {
                topologicalUtil(graph, e.dest, vis,s);
            }
        } 
        s.push(curr);  
    }
    
    public static void main(String[] args) {
        Likhit_100_Topological o = new Likhit_100_Topological();
        int V = 6;
        ArrayList<Edge>[] graph =  new ArrayList[V];
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        graph[2].add(new Edge(2, 3, 1));
        graph[3].add(new Edge(3, 1, 1));
        graph[4].add(new Edge(4, 0, 1));
        graph[4].add(new Edge(4, 1, 1));
        graph[5].add(new Edge(5, 0, 1));
        graph[5].add(new Edge(5, 2, 1));
        o.topological(graph);
    }
}