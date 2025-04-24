import java.io.*;
import java.util.*;

class Edge {
    int s, e, w;

    public Edge(int s, int e, int w) {
        this.s = s;
        this.e = e;
        this.w = w;
    }
}

class UnionFind {
    int[] parent, rank;

    public UnionFind(int n) {
        parent = new int[n];
        rank = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 0;
        }
    }

    public int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]); 
        }
        return parent[x];
    }

    public void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);

        if (rootX != rootY) {
            // Union by rank
            if (rank[rootX] > rank[rootY]) {
                parent[rootY] = rootX;
            } else if (rank[rootX] < rank[rootY]) {
                parent[rootX] = rootY;
            } else {
                parent[rootY] = rootX;
                rank[rootX]++;
            }
        }
    }
}

class Likhit_100_4 {
    List<Edge> edges;
    int v;
    String[] vName;

    public Likhit_100_4(String filename, String filename1) {
        try {
            BufferedReader fin = new BufferedReader(new FileReader(filename));
            v = Integer.parseInt(fin.readLine());
            edges = new ArrayList<>();

            String line;
            int row = 0;
            while ((line = fin.readLine()) != null && row < v) {
                String[] tokens = line.split(" ");
                for (int i = 0; i < v; i++) {
                    int weight = Integer.parseInt(tokens[i]);
                    if (weight != 0 && i > row) {  
                        edges.add(new Edge(row, i, weight));
                    }
                }
                row++;
            }

            BufferedReader fin1 = new BufferedReader(new FileReader(filename1));
            vName = new String[v];
            for (int i = 0; i < v; i++) {
                vName[i] = fin1.readLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void display() {
        for (Edge edge : edges) {
            System.out.println(edge.s + " " + edge.e + " " + edge.w);
        }
    }

    public void kruskals() {
        Collections.sort(edges, Comparator.comparingInt(e -> e.w));

        UnionFind uf = new UnionFind(v);
        List<Edge> mst = new ArrayList<>();

        for (Edge edge : edges) {
            int rootS = uf.find(edge.s);
            int rootE = uf.find(edge.e);

            if (rootS != rootE) {
                uf.union(rootS, rootE);
                mst.add(edge);
            }
        }

        System.out.println("Path for MST: ");
        for (Edge e : mst) {
            System.out.println(vName[e.s] + " - " + vName[e.e] + " = " + e.w);
        }
    }

    public static void main(String[] args) {
        Likhit_100_4 G = new Likhit_100_4("m2.txt", "m3.txt");
        G.kruskals();
    }
}
