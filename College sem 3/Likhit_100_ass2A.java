
//Write a code to delete first and last element of a Circular Doubly Linked List
import java.util.Scanner;

public class Likhit_100_ass2A {

    class Node {
        int data;
        Node next;
        Node prev;

        Node(int data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    Node head;
    Node tail;

    public void addLast(int data) {
        Node nn = new Node(data);
        if (head == null) {
            head = tail = nn;
            return;
        }
        tail.next = nn;
        nn.prev = tail;
        tail = nn;
        tail.next = head;
    }

    public void deleteFirst() {
        if (head == null) {
            System.out.println("LL is empty");
            return;
        }
        if (head == tail) {
            head = tail = null;
            return;
        }
        head = head.next;
        tail.next = head;
        head.prev = tail;
    }

    public void deleteLast() {
        if (head == null) {
            System.out.println("LL is empty");
            return;
        }
        if (head == tail) {
            head = tail = null;
            return;
        }
        tail = tail.prev;
        tail.next = head;
        head.prev = tail;
    }

    public void print() {
        Node temp = head;
        if (head == null) {
            System.out.println("LL is empty");
            return;
        }
        do {
            System.out.print(temp.data + "->");
            temp = temp.next;
        } while (temp != head);
        System.out.println("null");
    }

    public static void main(String[] args) {
        Likhit_100_ass2A o1 = new Likhit_100_ass2A();
        System.out.println("\nCircular Doubly Linked List");
        Scanner sc = new Scanner(System.in);
        int choice, value;

        do {
            System.out.println("\nMenu:");
            System.out.println("1. Add Last");
            System.out.println("2. Delete First");
            System.out.println("3. Delete Last");
            System.out.println("4. Print List");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter value to add: ");
                    value = sc.nextInt();
                    o1.addLast(value);
                    break;
                case 2:
                    o1.deleteFirst();
                    break;
                case 3:
                    o1.deleteLast();
                    break;
                case 4:
                    o1.print();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        } while (choice != 5);

        sc.close();
    }
}