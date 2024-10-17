/*
Assignemnt 4

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
9. Reverse
10. Delete at ith index from end
11. Palindrome
12. Creating a Menu of all above operations

*/

import java.util.Scanner;

public class Likhit_100_4 {
    public class Node {
        String data;
        Node next;
        Node prev;

        public Node(String data) {
            this.data = data;
            this.next = null;
            this.prev = null;

        }
    }

    public Node head;
    public Node tail;
    public int count = 0;

    public void addfirst(String data) {
        Node nn = new Node(data);
        count++;
        if (head == null) {
            head = tail = nn;
            return;
        }
        nn.next = head;
        head.prev = nn;
        head = nn;
    }

    public void addlast(String data) {
        Node nn = new Node(data);
        count++;
        if (head == null) {
            head = tail = nn;
            return;
        }
        tail.next = nn;
        nn.prev = tail;
        tail = nn;
    }

    public void deletefirst() {
        if (head == null) {
            System.out.println("LL is empty");
            return;
        }
        if (count == 1) {
            count--;
            head = tail = null;
            return;
        }
        count--;
        head = head.next;
        head.prev = null;
    }

    public void deletelast() {
        if (head == null) {
            System.out.println("LL is empty");
            return;
        }
        if (count == 1) {
            count--;
            head = tail = null;
            return;
        }
        count--;
        tail = tail.prev;
        tail.next = null;
    }

    public void add_middle(int i, String data) {
        if (i == 0) {
            addfirst(data);
            return;
        }
        if (i == count) {
            addlast(data);
            return;
        }
        if (i > count) {
            System.out.println("Invalid Index");
            return;
        }
        Node nn = new Node(data);
        count++;
        int pos = 0;
        Node temp = head;
        while (pos < i - 1) {
            temp = temp.next;
            pos++;
        }
        nn.next = temp.next;
        nn.prev = temp;
        temp.next.prev = nn;
        temp.next = nn;

    }

    public void print() {
        Node temp = head;
        if (head == null) {
            System.out.println("LL is empty");
        }
        while (temp != null) {
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public void search(String data) {
        Node temp = head;
        int i = 0;
        while (temp != null) {
            if (temp.data.equals(data)) {                   //in string to check equal we use str1.equals(str2)
                System.out.println("Found at :" + i);
                return;
            }
            temp = temp.next;
            i++;
        }
        System.out.println("Not found");
    }

    public void reverse() {
        Node curr = head;
        Node prev = null;
        Node next;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            curr.prev = next;
            prev = curr;
            curr = next;
        }
        head = prev;
    }

    // Delete at ith index from end
    public void delete_ith_end(int key) {

        if (head == null) {
            System.out.println("LL is empty");
            return;
        }
        if (key >= count) {
            System.out.println("Invalid key: larger than the size of the list");
            return;
        }
        if (key == count - 1) {
            deletefirst();
            return;
        }
        if (key == 0) {
            deletelast();
            return;
        }
        Node temp = tail;
        int i = 0;
        while (i < key) {
            temp = temp.prev;
            i++;
        }
        temp.prev.next = temp.next;
        temp.next.prev = temp.prev;
        count--;
        System.out.println("Deleted element: " + temp.data);
    }

    public void empty() {
        if (head == null) {
            System.out.println("LL is empty");
            return;
        }
        Node temp = tail;
        while (temp.prev != null) {
            deletelast();
            temp = temp.prev;
        }
        head = tail = null;
        count = 0;
        System.out.println("LL is empty");  
    }

    public void palindrome() {
        if (head == null || count == 1) {
            System.out.println("\nPalindrome");
            return;
        }

        Node temp1 = head;
        Node temp2 = tail;
        int i = 0;
        while (i < count / 2) {
            if (!temp1.data.equals(temp2.data)) {
                System.out.println("\nNot Palindrome");
                return;
            }
            temp1 = temp1.next;
            temp2 = temp2.prev;
            i++;
        }
        System.out.println("\nPalindrome");
    }

    public static void main(String[] args) {
        Likhit_100_4 ll = new Likhit_100_4();
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nMenu:");
            System.out.println("1. Add (First, Last, or Middle)");
            System.out.println("2. Delete (First, Last, or ith from End)");
            System.out.println("3. Print List");
            System.out.println("4. Search for an Element");
            System.out.println("5. Reverse the List");
            System.out.println("6. Check Palindrome");
            System.out.println("7. Empty List");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                    System.out.println("\n1. Add First");
                    System.out.println("2. Add Last");
                    System.out.println("3. Add Middle");
                    System.out.print("Choose where to add : ");
                    int ad = sc.nextInt();
                    sc.nextLine();
                    if (ad == 1) {
                        System.out.print("Enter data to add at first: ");
                        ll.addfirst(sc.nextLine());
                    } else if (ad == 2) {
                        System.out.print("Enter data to add at last: ");
                        ll.addlast(sc.nextLine());
                    } else if (ad == 3) {
                        System.out.print("Enter index and data to add in the middle: ");
                        int index = sc.nextInt();
                        sc.nextLine();
                        ll.add_middle(index, sc.nextLine());
                    } else {
                        System.out.println("Invalid choice!");
                    }
                    break;

                case 2:
                    System.out.println("\n1. Delete First");
                    System.out.println("2. Delete Last");
                    System.out.println("3. Delete ith from End");
                    System.out.print("Choose what to delete:");
                    int del = sc.nextInt();
                    if (del == 1) {
                        ll.deletefirst();
                    } else if (del == 2) {
                        ll.deletelast();
                    } else if (del == 3) {
                        System.out.print("Enter the position (from end) to delete: ");
                        int key = sc.nextInt();
                        ll.delete_ith_end(key);
                    } else {
                        System.out.println("Invalid choice!");
                    }
                    break;

                case 3:
                    System.out.println("\n");
                    ll.print();
                    break;
                case 4:
                    System.out.print("\nEnter the element to search: ");
                    ll.search(sc.nextLine());
                    break;
                case 5:
                    ll.reverse();
                    System.out.println("\nList reversed.");
                    break;
                case 6:
                    ll.palindrome();
                    break;
                case 7:
                    ll.empty();
                    break;
                case 8:
                    System.out.println("\n\nExiting...");
                    break;
                default:
                    System.out.println("\n\nInvalid choice! Please try again.");
            }
        } while (choice != 8);
        sc.close();
    }
}