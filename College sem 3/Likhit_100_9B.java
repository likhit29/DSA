//Likhit Chaudhary
//123B1B100
//Assignment 9B
//Queue using Stack

import java.util.Scanner;

class node {
    int data;
    node next;

    node(int data) {
        this.data = data;
    }
}

class Stack {
    public node top;

    public void push(int data) {
        node newnode = new node(data);
        newnode.next = top;
        top = newnode;
    }

    public int pop() {
        if (top == null) {
            return -1;
        }
        int result = top.data;
        top = top.next;
        return result;
    }

    public boolean isEmpty() {
        return top == null;
    }

    public void print() {
        node temp = top;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }
}

public class Likhit_100_9B {
    private Stack s1;
    private Stack s2;

    Likhit_100_9B() {
        s1 = new Stack();
        s2 = new Stack();
    }

    public void add(int data) {
        s1.push(data);
    }

    public int remove() {
        if (s2.isEmpty()) {
            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }
        }
        return s2.pop();
    }

    public void show() {
        s2.print();
        s1.print();
        System.out.println();
    }

    public static void main(String[] args) {
        Likhit_100_9B queue = new Likhit_100_9B();
        Scanner sc = new Scanner(System.in);
        int cont = 1;
        while (cont == 1) {
            System.out.println("1. Add element to Queue");
            System.out.println("2. Remove element from Queue");
            System.out.println("3. Show Queue");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter element: ");
                    int data = sc.nextInt();
                    queue.add(data);
                    break;
                case 2:
                    int removed = queue.remove();
                    if (removed == -1) {
                        System.out.println("Queue is empty.");
                    } else {
                        System.out.println("Removed: " + removed);
                    }
                    break;
                case 3:
                    System.out.println("Queue contents:");
                    queue.show();
                    break;
                default:
                    System.out.println("Invalid choice.");
                    break;
            }
            System.out.print("Continue? 1-Yes / 0-No: ");
            cont = sc.nextInt();
        }
        queue.show();
        sc.close();
    }
}
