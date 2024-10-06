/*
Assignemnt 5

Likhit Chaudhary
123B1B100
B-2


1. Add_at_start
2. Add_at_End
3. Add_at_index
4. Delete_at_start
5. Delete_at_end
6. Display
7. Empty whole list
8. Search
9. Search and remove
10. Creating a Menu of all above operations

*/

import java.util.*;
public class Likhit_100_5 {
    public class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static Node head = null;
    public static Node tail;
    public int count = 0;

    public void addFirst(int data) {
        Node nn = new Node(data);
        count++;
        if (head == null) {
            head = tail = nn;
            tail.next = head;
            return;
        }
        nn.next = head;
        head = nn;
        tail.next = head;
    }

    public void addLast(int data) {
        Node nn = new Node(data);
        count++;
        if (head == null) {
            head = tail = nn;
            tail.next = head;
            return;
        }
        nn.next = head;
        tail.next = nn;
        tail = nn;

    }

    public void removeFirst() {
        if (head == null) {
            System.out.println("LL is empty");
            return;
        } else if (count == 1) {
            head = tail = null;
            count = 0;
            return;
        }
        count--;
        head = head.next;
        tail.next = head;
    }

    public void removeLast() {
        if (head == null) {
            System.out.println("LL is empty");
            return;
        } else if (count == 1) {
            head = tail = null;
            count = 0;
            return;
        }
        count--;
        Node temp = head;
        while (temp.next != tail) {
            temp = temp.next;
        }
        tail = temp;
        tail.next = head;
    }

    public void display() {
        if (head == null) {
            System.out.println("LL is empty");
            return;
        }
        Node temp = head;
        do {
            System.out.print(temp.data + "  -> ");
            temp = temp.next;
        } while (temp != head);
        System.out.println("head");
    }

    public void empty() {
        if (head == null) {
            System.out.println("LL is empty");
            return;
        }
        Node temp = head;
        while (temp.next != head) {
            removeFirst();
            temp = temp.next;
        }
        head = tail = null;
        count = 0;
        System.out.println("LL is empty");
    }

    public void addMiddle(int idx, int data) {
        if (idx < 0 || idx > count) {
            System.out.println("Invalid index");
            return;
        }
        if (idx == 0) {
            addFirst(data);
            return;
        }
        if (idx == count) {
            addLast(data);
            return;
        }
        Node nn = new Node(data);
        count++;
        Node temp = head;
        int i = 0;
        while (i < idx - 1) {
            temp = temp.next;
            i++;
        }
        nn.next = temp.next;
        temp.next = nn;
    }

    void search(int key) {
        if (head == null) {
            System.out.println("Key not Found");
            return;
        }
        Node temp = head;
        int i = 0;
        do {
            if (temp.data == key) {
                System.out.println("Key Found at index - " + i + 1);
                return;
            }
            temp = temp.next;
            i++;
        } while (temp != head);
        System.out.println("Key not Found");
    }

    void search_delete(int key) {
        if (head == null) {
            System.out.println("Key not found");
            return;
        }
        if (key == head.data) {
            removeFirst();
            return;
        }
        if (key == tail.data) {
            removeLast();
            return;
        }
        Node temp = head;
        Node q = null;
        do {
            if (temp.data == key) {
                q.next = temp.next;
                count--;
                System.out.println("Key Deleted");
                return;
            }
            q = temp;
            temp = temp.next;
        } while (temp != head);
        System.out.println("Key not Found"); 
    }

    public static void main(String[] args) {
        Likhit_100_5 list = new Likhit_100_5();
        Scanner sc = new Scanner(System.in);
        int n = 1;

        while (n >= 1) {
            System.out.println("\n\nMenu:");
            System.out.println("Press 1 for Insert element");
            System.out.println("Press 2 for Delete element");
            System.out.println("Press 3 for Search");
            System.out.println("Press 4 to Display");
            System.out.println("Press 5 to Empty the list");
            System.out.print("Enter the choice: ");
            int c1 = sc.nextInt();

            switch (c1) {
                case 1:
                    System.out.println("\nPress 1 to Append Element");
                    System.out.println("Press 2 to Prepend Element");
                    System.out.println("Press 3 to Insert Element at Specific Index");
                    System.out.print("Enter your choice: ");
                    int c2 = sc.nextInt();
                    switch (c2) {
                        case 1:
                            System.out.print("Enter Value to Append: ");
                            int appendValue = sc.nextInt();
                            list.addLast(appendValue);
                            System.out.println("Appended Successfully");
                            break;
                        case 2:
                            System.out.print("Enter Value to Prepend: ");
                            int prependValue = sc.nextInt();
                            list.addFirst(prependValue);
                            System.out.println("Prepended Successfully");
                            break;
                        case 3:
                            System.out.print("Enter the index where you want to insert: ");
                            int index = sc.nextInt();
                            System.out.print("Enter the value to insert: ");
                            int middleValue = sc.nextInt();
                            list.addMiddle(index, middleValue);
                            System.out.println("Element inserted at index " + index);
                            break;
                        default:
                            System.out.println("Invalid choice");
                            break;
                    }
                    break;

                case 2:
                    System.out.print("\nPress 1 to Delete from End or Press 2 to Delete from Beginning: ");
                    int c3 = sc.nextInt();
                    switch (c3) {
                        case 1:
                            list.removeLast();
                            System.out.println("Deleted Last Element");
                            break;
                        case 2:
                            list.removeFirst();
                            System.out.println("Deleted First Element");
                            break;
                        default:
                            System.out.println("Invalid choice");
                            break;
                    }
                    break;

                case 3:
                    System.out.print("\nEnter value to Search: ");
                    int Search = sc.nextInt();
                    System.out.print("\nPress 1 for Search and Delete the element, Press 2 for Search only: ");
                    int choice4 = sc.nextInt();
                    switch (choice4) {
                        case 1:
                            list.search_delete(Search);
                            break;
                        case 2:
                            list.search(Search);
                            break;
                        default:
                            System.out.println("Invalid choice");
                            break;
                    }
                    break;

                case 4:
                    list.display();
                    break;

                case 5: 
                    list.empty();
                    System.out.println("The list has been emptied.");
                    break;

                default:
                    System.out.println("Invalid choice");
                    break;
            }

            System.out.print("\nEnter 1 to Continue or 0 to Exit: ");
            n = sc.nextInt();
        }
        sc.close();
    }
}