import java.io.*;
import java.util.*;

class Node {
    int s, e, w;
    Node next;
}

class Edge {
    int s, e, w;

    public Edge(int s, int e, int w) {
        this.s = s;
        this.e = e;
        this.w = w;
    }
}

class Likhit_100_4b {
    int v;
    Node[] A;
    String[] vName;

    public Likhit_100_4b(String filename, String filename1) {
        try {
            BufferedReader fin = new BufferedReader(new FileReader(filename));
            v = Integer.parseInt(fin.readLine());
            A = new Node[v];
            for (int i = 0; i < v; i++) {
                A[i] = null;
            }

            String line;
            for (int i = 0; i < v; i++) {
                line = fin.readLine();
                String[] tokens = line.split(" ");
                for (int j = 0; j < v; j++) {
                    int e = Integer.parseInt(tokens[j]);
                    if (e != 0) {
                        Node newNode = new Node();
                        newNode.s = i;
                        newNode.e = j;
                        newNode.w = e;
                        newNode.next = A[i];
                        A[i] = newNode;
                    }
                }
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

    public void prims(int start) {
        boolean[] visited = new boolean[v];
        int[] key = new int[v];
        Edge[] mst = new Edge[v - 1];

        Arrays.fill(key, Integer.MAX_VALUE);
        key[start] = 0;

        PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparingInt(e -> e.w));
        pq.add(new Edge(start, start, 0));

        int mstIndex = 0;
        while (!pq.isEmpty()) {
            Edge minEdge = pq.poll();
            int u = minEdge.e;

            if (visited[u]) continue;
            visited[u] = true;

            Node ptr = A[u];
            while (ptr != null) {
                int v = ptr.e;
                int weight = ptr.w;

                if (!visited[v] && weight < key[v]) {
                    key[v] = weight;
                    pq.add(new Edge(u, v, weight));
                    mst[mstIndex++] = new Edge(u, v, weight);
                }
                ptr = ptr.next;
            }
        }

        System.out.println("Minimum Spanning Tree:");
        for (int i = 0; i < v - 1; i++) {
            System.out.println(vName[mst[i].s] + " - " + vName[mst[i].e] + " = " + mst[i].w);
        }
    }

    public static void main(String[] args) {
        Likhit_100_4b G = new Likhit_100_4b("m2.txt", "m3.txt");
        G.prims(0);
    }
}
