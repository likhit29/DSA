
//Delete all duplicate elements of a DLL
import java.util.Scanner;

public class Likhit_100_ass2B {

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
        head.prev = null;
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
        tail.next = null;
    }

    public void duplicate() {
        Node temp1 = head;

        while (temp1 != null) {
            Node temp2 = temp1.next;
            while (temp2 != null) {
                if (temp1.data == temp2.data) {
                    if (temp2.prev != null) {
                        temp2.prev.next = temp2.next;
                    }
                    if (temp2.next != null) {
                        temp2.next.prev = temp2.prev;
                    }
                    if (temp2 == tail) {
                        tail = temp2.prev;
                    }
                }
                temp2 = temp2.next;
            }
            temp1 = temp1.next;
        }
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

    public static void main(String[] args) {
        Likhit_100_ass2B o1 = new Likhit_100_ass2B();
        Scanner sc = new Scanner(System.in);
        System.out.println("\nDouble Linked List");
        int choice, value;

        do {
            System.out.println("\nMenu:");
            System.out.println("1. Add Last");
            System.out.println("2. Delete First");
            System.out.println("3. Delete Last");
            System.out.println("4. Delete Duplicates");
            System.out.println("5. Print List");
            System.out.println("6. Exit");
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
                    o1.duplicate();
                    break;
                case 5:
                    o1.print();
                    break;
                case 6:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        } while (choice != 6);

        sc.close();
    }
}
