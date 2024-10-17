//Likhit Chaudhary
//123B1B100

/* 
MOCK TEST 1 - Define class LinkedList with functions - constructor, insert and display only. 
Write a non-member function that takes 2 singly linked lists a parameter and returns a list that is intersection on these list.
*/

import java.util.Scanner;

public class Likhit_100_Mocktest {

    public static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public Node head;
    public Node tail;
    public int size;

    public void addFirst(int data) {
        Node newNode = new Node(data);
        size++;
        if (head == null) {
            head = tail = newNode;
            return;
        }
        Node temp = head;
        while (temp != null) {
            if (temp.data == newNode.data) {
                return;
            }
            temp = temp.next;
        }
        newNode.next = head;
        head = newNode;
    }

    public void addLast(int data) {
        Node newNode = new Node(data);
        size++;
        if (head == null) {
            head = tail = newNode;
            return;
        }
        Node temp = head;
        while (temp != null) {
            if (temp.data == newNode.data) {
                return;
            }
            temp = temp.next;
        }
        tail.next = newNode;
        tail = newNode;

    }

    public void print() {
        if (head == null) {
            System.out.println("LL is empty");
            return;
        }
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public void removeFirst() {
        if (size == 0) {
            System.out.println("a1 is empty");
            return;
        } else if (size == 1) {
            head = tail = null;
            size = 0;
            return;
        }
        head = head.next;
        size--;
        return;
    }

    public void removeLast() {
        if (size == 0) {
            System.out.println("a1 is empty");
            return;
        } else if (size == 1) {
            head = tail = null;
            size = 0;
            return;
        }
        Node prev = head;
        for (int i = 0; i < size - 2; i++) {
            prev = prev.next;
        }
        prev.next = null;
        tail = prev;
        size--;
        return;

    }

    public void intersection(Likhit_100_Mocktest a1, Likhit_100_Mocktest a2) {
        Node temp1 = a1.head;
        while (temp1 != null) {
            Node temp2 = a2.head;
            while (temp2 != null) {
                if (temp1.data == temp2.data) {
                    addLast(temp1.data);
                }
                temp2 = temp2.next;
            }
            temp1 = temp1.next;
        }
        print();
    }

    public static void main(String[] args) {
        Likhit_100_Mocktest a1 = new Likhit_100_Mocktest();
        Likhit_100_Mocktest a2 = new Likhit_100_Mocktest();
        Likhit_100_Mocktest a3 = new Likhit_100_Mocktest();
        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            System.out.println("\nMenu:");
            System.out.println("1. Linked List 1");
            System.out.println("2. Linked List 2");
            System.out.println("3. Print List");
            System.out.println("4. Intersection of list");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("\n1. Add First");
                    System.out.println("2. Add Last");
                    System.out.println("3. Delete First");
                    System.out.println("4. Delete Last");
                    System.out.print("Enter your choice: ");
                    int ad = sc.nextInt();
                    if (ad == 1) {
                        System.out.print("Enter data to add at first: ");
                        a1.addFirst(sc.nextInt());
                    } else if (ad == 2) {
                        System.out.print("Enter data to add at last: ");
                        a1.addLast(sc.nextInt());
                    } else if (ad == 3) {
                        a1.removeFirst();
                    } else if (ad == 4) {
                        a1.removeLast();
                    } else {
                        System.out.println("Invalid choice!");
                    }
                    break;
                case 2:
                    System.out.println("\n1. Add First");
                    System.out.println("2. Add Last");
                    System.out.println("3. Delete First");
                    System.out.println("4. Delete Last");
                    System.out.print("Enter your choice: ");
                    int ad2 = sc.nextInt();
                    if (ad2 == 1) {
                        System.out.print("Enter data to add at first: ");
                        a2.addFirst(sc.nextInt());
                    } else if (ad2 == 2) {
                        System.out.print("Enter data to add at last: ");
                        a2.addLast(sc.nextInt());
                    } else if (ad2 == 3) {
                        a2.removeFirst();
                    } else if (ad2 == 4) {
                        a2.removeLast();
                    } else {
                        System.out.println("Invalid choice!");
                    }
                    break;

                case 3:
                    System.out.println("\n1. Print Linked List 1");
                    System.out.println("2. Print Linked List 2");
                    System.out.println("3. Print Intersected Linked List ");
                    System.out.print("Enter your choice: ");
                    int c = sc.nextInt();
                    if (c == 1) {
                        a1.print();
                    } else if (c == 2) {
                        a2.print();
                    } else if (c == 3) {
                        a3.print();
                    }
                    break;
                case 4:
                    a3.intersection(a1, a2);
                    break;
                case 5:
                    System.out.println("\n\nExiting...");
                    break;
                default:
                    System.out.println("\n\nInvalid choice! Please try again.");
            }
        } while (choice != 5);
        sc.close();

    }
}