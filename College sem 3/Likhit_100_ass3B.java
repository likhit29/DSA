//Create a Singly linked list of characters. Append each character of the string to the list
import java.util.Scanner;

public class Likhit_100_ass3B {
    class Node {
        char data;
        Node next;

        Node(char data) {
            this.data = data;
            this.next = null;
        }
    }

    Node head;
    Node tail;

    public void addLast(char data) {
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

    public void append(String s) {
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            addLast(c);
        }
    }

    public static void main(String[] args) {
        Likhit_100_ass3B list = new Likhit_100_ass3B();
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nMenu:");
            System.out.println("1. Append String to Linked List");
            System.out.println("2. Delete Last Character");
            System.out.println("3. Print Linked List");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine(); 

            switch (choice) {
                case 1:
                    System.out.print("Enter a string to append: ");
                    String str = sc.nextLine();
                    list.append(str);
                    System.out.println("String appended to the list.");
                    break;
                case 2:
                    list.deleteLast();
                    System.out.println("Last character deleted from the list.");
                    break;
                case 3:
                    list.print();
                    break;
                case 4:
                    System.out.println("Exiting program.");
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
                    break;
            }
        } while (choice != 4);

        sc.close();
    }
}