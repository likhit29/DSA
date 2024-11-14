//Likhit Chaudhary
//123B1B100
//Assignment 10
//Circular queue using array

import java.util.Scanner;

public class Likhit_100_10 {
    private int maxSize;
    private int[] queue;
    private int front;
    private int rear;

    public Likhit_100_10(int size) {
        maxSize = size;
        queue = new int[maxSize];
        front = -1;
        rear = -1;
    }

    public void enqueue(int data) {
        if ((rear + 1) % maxSize == front) {
            System.out.println("Queue is full. Cannot enqueue.");
        } else {
            if (isEmpty()) {
                front = 0;
                rear = 0;
            } else {
                rear = (rear + 1) % maxSize;
            }
            queue[rear] = data;
            System.out.println(data + " enqueued.");
        }
    }

    public int dequeue() {
        int data = -1;
        if (!isEmpty()) {
            data = queue[front];
            if (front == rear) {
                front = -1;
                rear = -1;
            } else {
                front = (front + 1) % maxSize;
            }
        } else {
            System.out.println("Queue is empty. Cannot dequeue.");
        }

        return data;
    }

    public int peek() {
        if (!isEmpty()) {
            return queue[front];
        } else {
            System.out.println("Queue is empty. No peek value.");
            return -1;
        }
    }

    public boolean isEmpty() {
        return front == -1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Likhit_100_10 circularQueue = new Likhit_100_10(5);

        while (true) {
            System.out.println("\nCircular Queue Menu:");
            System.out.println("1. Enqueue");
            System.out.println("2. Dequeue");
            System.out.println("3. Peek");
            System.out.println("4. Check if Queue is Empty");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter element to enqueue: ");
                    int data = scanner.nextInt();
                    circularQueue.enqueue(data);
                    break;
                case 2:
                    int dequeuedData = circularQueue.dequeue();
                    if (dequeuedData != -1) {
                        System.out.println(dequeuedData + " dequeued.");
                    }
                    break;
                case 3:
                    int peekData = circularQueue.peek();
                    if (peekData != -1) {
                        System.out.println("Peek: " + peekData);
                    }
                    break;
                case 4:
                    if (circularQueue.isEmpty()) {
                        System.out.println("Queue is empty.");
                    } else {
                        System.out.println("Queue is not empty.");
                    }
                    break;
                case 5:
                    System.out.println("Exiting program.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
