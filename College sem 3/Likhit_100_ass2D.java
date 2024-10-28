//Reverse a Stack using a Queue

import java.util.Scanner;

public class Likhit_100_ass2D {

    public static class Stack {
        class Node {
            int data;
            Node next;

            Node(int data) {
                this.data = data;
                this.next = null;
            }
        }

        Node top;

        public void push(int data) {
            Node nn = new Node(data);
            if (top == null) {
                top = nn;
                return;
            }
            nn.next = top;
            top = nn;
        }

        public int pop() {
            if (top == null) {
                System.out.println("Stack is emoty");
                return 0;
            }
            int element = top.data;
            top = top.next;
            return element;
        }

        public void print() {
            Node temp = top;
            while (temp != null) {
                System.out.println(temp.data);
                temp = temp.next;
            }
        }
    }

    public static class Queue {
        class Node {
            int data;
            Node next;

            Node(int data) {
                this.data = data;
                this.next = null;
            }
        }

        Node front;
        Node rear;

        public void enque(int data) {
            Node nn = new Node(data);
            if (front == null) {
                front = rear = nn;
                return;
            }
            rear.next = nn;
            rear = nn;
        }

        public int deque() {
            if (front == null) {
                return -1;
            }
            int element = front.data;
            front = front.next;
            return element;
        }
    }

    public static void main(String[] args) {
        Stack s1 = new Stack();
        Queue q1 = new Queue();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of elements in stack: ");
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            System.out.print("Enter element " + (i + 1) + " - ");
            int element = scanner.nextInt();
            s1.push(element);
        }
        while (s1.top != null) {
            q1.enque(s1.pop());
        }
        while (q1.front != null) {
            s1.push(q1.deque());
        }
        System.out.println("\nStack elements after reversing:");
        s1.print();
        scanner.close();

    }

}
