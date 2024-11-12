// Move the largest element to the end of the Singly Linked List
import java.util.Scanner;

public class Likhit_100_ass3A {
    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
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
        tail = nn;
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
        Node prev = head;
        while (prev.next != tail) {
            prev = prev.next;
        }
        prev.next = null;
        tail = prev;
    }

    public void print() {
        Node temp = head;
        if (head == null) {
            System.out.println("LL is empty");
            return;
        }
        while (temp != null) {
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public void largest() {
        if (head == null || head.next == null) {
            return;
        }
        Node temp = head;
        int element = temp.data;

        while (temp != null) {
            element = Math.max(element, temp.data);
            temp = temp.next;
        }
        if (element == tail.data) {
            return;
        }
        if (element == head.data) {
            head = head.next;
            addLast(element);
            return;
        }
        Node prev = head;
        while (prev.next != null && prev.next.data != element) {
            prev = prev.next;
        }
        if (prev.next != null) {
            prev.next = prev.next.next;
        }
        addLast(element);
    }

    public static void main(String[] args) {
        Likhit_100_ass3A list = new Likhit_100_ass3A();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nMenu:");
            System.out.println("1. Add an element to the end");
            System.out.println("2. Delete the last element");
            System.out.println("3. Move the largest element to the end");
            System.out.println("4. Print the list");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter the element to add: ");
                    int data = scanner.nextInt();
                    list.addLast(data);
                    break;

                case 2:
                    list.deleteLast();
                    System.out.println("Last element deleted.");
                    break;

                case 3:
                    list.largest();
                    System.out.println("Largest element moved to the end.");
                    break;

                case 4:
                    list.print();
                    break;

                case 5:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 5);

        scanner.close();
    }
}
