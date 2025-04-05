/*
Topological Sorting
Directed Acyclic Graph(DAG) is a directed graph with no cycles. 
Topological sorting is used only for DAGs (not for non-DAGs)
 */
import java.util.ArrayList;
import java.util.Stack;
public class A44_Graphs_B {

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

        graph[2].add(new Edge(2, 3, 1));

        graph[3].add(new Edge(3, 1, 1));

        graph[4].add(new Edge(4, 0, 1));
        graph[4].add(new Edge(4, 1, 1));

        graph[5].add(new Edge(5, 0, 1));
        graph[5].add(new Edge(5, 2, 1));

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
        A44_Graphs_B o = new A44_Graphs_B();
        int V = 6;
        ArrayList<Edge>[] graph =  new ArrayList[V];
        o.createGraph(graph);
        o.topological(graph);
    }
}