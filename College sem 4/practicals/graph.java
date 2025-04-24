package practicals;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class Queue {
    private int[] arr;
    private int front, rear, size, capacity;

    public Queue(int capacity) {
        this.capacity = capacity;
        arr = new int[capacity];
        front = 0;
        rear = -1;
        size = 0;
    }

    public boolean isFull() {
        return size == capacity;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void enqueue(int item) {
        if (isFull()) {
            System.out.println("Queue is full!");
            return;
        }
        rear = (rear + 1) % capacity;
        arr[rear] = item;
        size++;
        System.out.println(item + " enqueued.");
    }

    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty!");
            return -1;
        }
        int item = arr[front];
        front = (front + 1) % capacity;
        size--;
        return item;
    }

    public int peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty!");
            return -1;
        }
        return arr[front];
    }

    public int getSize() {
        return size;
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Queue is empty!");
            return;
        }
        System.out.print("Queue: ");
        for (int i = 0; i < size; i++) {
            System.out.print(arr[(front + i) % capacity] + " ");
        }
        System.out.println();
    }

}

public class graph { 
    private int s;
    private int[][] arr;

    public graph(String filename) {
        try {
            File file = new File(filename);
            Scanner scanner = new Scanner(file);

            if (scanner.hasNextInt()) {
                s = scanner.nextInt();
            }
            System.out.println("Number of vertices: " + s);

            arr = new int[s][s]; 

            for (int i = 0; i < s; i++) {
                for (int j = 0; j < s; j++) {
                    if (scanner.hasNextInt()) {
                        arr[i][j] = scanner.nextInt();
                    }
                }
            }

            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + filename);
        }
    }

    public void BDS(int v){
         Queue q;
         int[] visited = new int[v];
         for(int i = 0 ; i<v; i++){
            visited[i] = 0;
         }
         
    }

    public void display() {
        System.out.println("Adjacency Matrix:");
        for (int i = 0; i < s; i++) {
            for (int j = 0; j < s; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void degreeOfNode(int i) {
        if (i < 0 || i >= s) {
            System.out.println("Invalid node index: " + i);
            return;
        }
        
        int degree = 0;
        for (int j = 0; j < s; j++) {
            if (arr[i][j] != 0) {
                degree++;
            }
        }
        System.out.println("Degree of node " + i + " is: " + degree);
    }

    public static void main(String[] args) {
        // String filename = "g.txt"; 
        // graph graphObj = new graph(filename);
        // graphObj.display();

        // for (int i = 0; i < graphObj.s; i++) {
        //     graphObj.degreeOfNode(i);
        // }
    }
}
