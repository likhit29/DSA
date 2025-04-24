//Assignment 3
//Likhit Chaudhary
//123B1B100

import java.io.*;
import java.util.*;

class Queue {
    int[] A;
    int s, front, rear;

    public Queue(int size) {
        s = size;
        A = new int[s];
        front = rear = -1;
    }

    public boolean isFull() {
        return rear == s - 1;
    }

    public boolean isEmpty() {
        return front == -1;
    }

    public void enQueue(int key) {
        if (isEmpty()) front = 0;
        if (!isFull()) A[++rear] = key;
    }

    public int deQueue() {
        if (isEmpty()) return Integer.MIN_VALUE;
        int e = A[front];
        if (front == rear) front = rear = -1;
        else front++;
        return e;
    }
}

class Stack {
    int[] A;
    int s, top;

    public Stack(int size) {
        s = size;
        A = new int[s];
        top = -1;
    }

    public boolean isFull() {
        return top == s - 1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public void push(int key) {
        if (!isFull()) A[++top] = key;
    }

    public void pop() {
        if (!isEmpty()) top--;
    }

    public int peek() {
        return isEmpty() ? -1 : A[top];
    }
}

class Graph {
    int[][] A;
    int v;

    public Graph(String filename) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(filename));
        v = Integer.parseInt(br.readLine());
        A = new int[v][v];
        for (int i = 0; i < v; i++) {
            String[] row = br.readLine().split(" ");
            for (int j = 0; j < v; j++) {
                A[i][j] = Integer.parseInt(row[j]);
            }
        }
        br.close();
    }

    public void display() {
        for (int i = 0; i < v; i++) {
            for (int j = 0; j < v; j++) {
                System.out.print(A[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void BFS(int sv) {
        Queue Q = new Queue(v);
        boolean[] visited = new boolean[v];
        Q.enQueue(sv);
        visited[sv] = true;
        while (!Q.isEmpty()) {
            int x = Q.deQueue();
            System.out.print(x + " ");
            for (int j = 0; j < v; j++) {
                if (A[x][j] != 0 && !visited[j]) {
                    Q.enQueue(j);
                    visited[j] = true;
                }
            }
        }
        System.out.println();
    }

    public void DFS(int sv) {
        Stack st = new Stack(v);
        boolean[] visited = new boolean[v];
        st.push(sv);
        visited[sv] = true;
        System.out.print(sv + " ");
        while (!st.isEmpty()) {
            int x = st.peek();
            boolean found = false;
            for (int j = 0; j < v; j++) {
                if (A[x][j] != 0 && !visited[j]) {
                    System.out.print(j + " ");
                    st.push(j);
                    visited[j] = true;
                    found = true;
                    break;
                }
            }
            if (!found) st.pop();
        }
        System.out.println();
    }
}

public class Likhit_100_3 {
    public static void main(String[] args) {
        try {
            Graph G = new Graph("m1.txt");
            G.display();
            System.out.println("\nDFS Traversal:");
            G.DFS(0);
            System.out.println("\nBFS Traversal:");
            G.BFS(0);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
