import java.io.*;
import java.util.*;

public class Likhit_100_4 {
    static class Edge {
        int src, dest, wt;
        public Edge(int s, int d, int w) {
            src = s;
            dest = d;
            wt = w;
        }
    }

    static class MinHeap {
        ArrayList<Pair> ar = new ArrayList<>();
        public boolean isEmpty() {
            return ar.size() == 0;
        }

        public void add(Pair data) {
            ar.add(data);
            int ch = ar.size() - 1;
            int par = (ch - 1) / 2;
            while (ch > 0 && ar.get(ch).cost < ar.get(par).cost) {
                Pair temp = ar.get(par);
                ar.set(par, ar.get(ch));
                ar.set(ch, temp);
                ch = par;
                par = (ch - 1) / 2;
            }
        }

        private void heapify(int i) {
            int minidx = i;
            int left = 2 * i + 1;
            int right = 2 * i + 2;

            if (left < ar.size() && ar.get(minidx).cost > ar.get(left).cost) {
                minidx = left;
            }
            if (right < ar.size() && ar.get(minidx).cost > ar.get(right).cost) {
                minidx = right;
            }
            if (minidx != i) {
                Pair temp = ar.get(i);
                ar.set(i, ar.get(minidx));
                ar.set(minidx, temp);
                heapify(minidx);
            }
        }

        public Pair remove() {
            if (isEmpty()) return null;
            Pair data = ar.get(0);
            ar.set(0, ar.get(ar.size() - 1));
            ar.remove(ar.size() - 1);
            if (!ar.isEmpty()) heapify(0);
            return data;
        }
    }

    static class Pair {
        int v;
        int cost;
        int parent;

        public Pair(int v, int cost, int parent) {
            this.v = v;
            this.cost = cost;
            this.parent = parent;
        }
    }

    public static void prims(int[][] matrix) {
        int V = matrix.length;
        boolean[] vis = new boolean[V];
        MinHeap pq = new MinHeap();

        int[] parent = new int[V];
        Arrays.fill(parent, -1);

        pq.add(new Pair(0, 0, -1));

        int finalCost = 0;

        while (!pq.isEmpty()) {
            Pair curr = pq.remove();

            if (!vis[curr.v]) {
                vis[curr.v] = true;
                finalCost += curr.cost;
                parent[curr.v] = curr.parent;

                for (int j = 0; j < V; j++) {
                    if (matrix[curr.v][j] != 0 && !vis[j]) {
                        pq.add(new Pair(j, matrix[curr.v][j], curr.v));
                    }
                }
            }
        }

        System.out.println("Minimum Spanning Tree cost: " + finalCost);
        System.out.println("Edges in MST:");
        for (int i = 1; i < V; i++) {
            System.out.println(parent[i] + " - " + i + " -> " + matrix[i][parent[i]]);
        }
    }

    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(new File("m2.txt"));
            int n = sc.nextInt();
            int[][] matrix = new int[n][n];

            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++)
                    matrix[i][j] = sc.nextInt();

            prims(matrix);
        } catch (FileNotFoundException e) {
            System.out.println("File not found: m2.txt");
        }
    }
}
