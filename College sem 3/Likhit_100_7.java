//Likhit Chaudhary
//123B1B100

/*
Assignment 7 - Implement a browser history management system using a stack data structure to track the user's browsing history.

1. Add Visited Page
2. View Current Webpage
3. Navigate Back
4. Navigate Forward
5. Delete History
6. History is Empty or not
7. Print History

*/
import java.util.Scanner;

public class Likhit_100_7 {
    public class Node {
        String data;
        Node next;

        Node(String data) {
            this.data = data;
            this.next = null;
        }
    }

    public Node top;
    public int size;

    public void New_URL(String data) {
        Node s = new Node(data);
        size++;
        if (top == null) {
            top = s;
            return;
        }
        s.next = top;
        top = s;
    }

    public String Navigate_Back(Likhit_100_7 o1, Likhit_100_7 o2) {
        if (o1.top == null) {
            return "No URL";
        }
        if (o1.size == 1) {
            o1.size--;
            o2.New_URL(o1.top.data);
            o1.top = null;
            return o1.top.data;
        }
        o1.size--;
        o2.New_URL(o1.top.data);
        o1.top = o1.top.next;
        return o1.top.data;

    }

    public String Navigate_Forward(Likhit_100_7 o1, Likhit_100_7 o2) {
        if (o2.top == null) {
            return "No Forward History";
        }
        String temp = o2.top.data;
        o1.New_URL(temp);
        o2.top = o2.top.next;
        return temp;
    }

    public void empty(Likhit_100_7 o1, Likhit_100_7 o2) {
        if (o1.top == null && o2.top == null) {
            System.out.println("History is Empty");
            return;
        }else{
        System.out.println("History is Not Empty");
    }
    }

    public String view() {
        if (top == null) {
            System.out.println();
            return "No Webpage opened";
        }
        return top.data;
    }

    public void empty_history(Likhit_100_7 o1, Likhit_100_7 o2) {
        while (o1.top != null) {
            o1.top = o1.top.next;
        }
        while (o2.top != null) {
            o2.top = o2.top.next;
        }
        o1.top = null;
        o2.top = null;
        o1.size = 0;
        o2.size = 0;
        System.out.println("History is Deleted");
    }

    public void print() {
        if (top == null) {
            System.out.println("Node is empty");
            return;
        }
        Node temp = top;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        Likhit_100_7 o1 = new Likhit_100_7();
        Likhit_100_7 o2 = new Likhit_100_7();

        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            System.out.println("\n\n1. Add Visited Page");
            System.out.println("2. View Current Webpage");
            System.out.println("3. Navigate Back");
            System.out.println("4. Navigate Forward");
            System.out.println("5. Delete History");
            System.out.println("6. History is Empty or not");
            System.out.println("7. Print History");
            System.out.println("0. Exit");
            System.out.print("Enter Your Choice - ");
            choice = sc.nextInt();

            switch (choice) {
                case 0:
                    System.out.println("Exiting");
                    break;
                case 1:
                    System.out.println("Enter the URL");
                    String add = sc.next();
                    o1.New_URL(add);
                    break;
                case 2:
                    System.out.println("Current Webpage - " + o1.view());
                    break;
                case 3:
                    System.out.println("Current Webpage - " + o1.Navigate_Back(o1, o2));
                    break;
                case 4:
                    System.out.println("Current Webpage - " + o1.Navigate_Forward(o1, o2));
                    break;
                case 5:
                    o1.empty_history(o1, o2);
                    break;
                case 6:
                    o1.empty(o1, o2);
                    break;
                case 7:
                    o1.print();
                    break;
                default:
                    System.out.println("\n\nInvalid choice! Please try again.");
            }
        } while (choice != 0);
        sc.close();
    }
}
