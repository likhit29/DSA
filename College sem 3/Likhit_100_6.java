//Likhit Chaudhary
//123B1B100

/*

Assignment 6 - Consider two polynomial expressions of any degree. Design solution to perform addition of these two polynomials with suitable data structure and display results. 

1. Add term at First
2. Add term at Last
3. Print polynomial
4. Insert Element in sorted polynomial
5. Add both polynomials
6. Remove term at First
7. Remove term at Last
8. Evaluate result polynomial
9. Empty polynomial 
*/

import java.util.Scanner;

public class Likhit_100_6 {
    public class Node {

        int coeff;
        int exp;
        Node next;

        public Node(int coeff, int exp) {
            this.coeff = coeff;
            this.exp = exp;
            this.next = null;
        }
    }

    public Node head;
    public Node tail;
    public int size;

    public void addFirst(int coeff, int exp) {
        Node newNode = new Node(coeff, exp);
        size++;
        if (head == null) {
            head = tail = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;
    }

    public void addLast(int coeff, int exp) {
        Node newNode = new Node(coeff, exp);
        size++;
        if (head == null) {
            head = tail = newNode;
            return;
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
            System.out.print(temp.coeff + "x^" + temp.exp + " +" + " ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public void insert_sort(int coeff, int exp) {
        Node newNode = new Node(coeff, exp);
        if (head == null) {
            head = tail = newNode;
            return;
        }
        if (head.exp < exp) {
            addFirst(coeff, exp);
            return;
        }
        Node temp = head;
        while (temp.next != null) {
            if (temp.exp == exp) {
                temp.coeff += coeff;
                return;
            }
            if (temp.next.exp < exp) {
                newNode.next = temp.next;
                temp.next = newNode;
                if (newNode.next == null) {
                    tail = newNode;
                }
                return;
            }
            temp = temp.next;
        }
        addLast(coeff, exp);
    }

    public void addition(Likhit_100_6 l1, Likhit_100_6 l2) {
        Node temp1 = l1.head;
        Node temp2 = l2.head;
        while (temp1 != null) {
            insert_sort(temp1.coeff, temp1.exp);
            temp1 = temp1.next;
        }
        while (temp2 != null) {
            insert_sort(temp2.coeff, temp2.exp);
            temp2 = temp2.next;
        }
    }

    public void empty() {
        Node temp = head;
        while (size > 0) {
            removeFirst();
        }
        head = tail = null;
        size = 0;
    }

    public void value(int x) {
        if (head == null) {
            System.out.println("Empty Polynomial");
            return;
        }
        Node temp = head;
        int value = 0;
        while (temp != null) {
            value += temp.coeff * Math.pow(x, temp.exp);
            temp = temp.next;
        }
        System.out.println("Total Sum after putting x = " + x + " value is : " + value);
    }

    public void removeFirst() {
        if (size == 0) {
            System.out.println("LL is empty");
            return;
        } else if (size == 1) {
            head = tail = null;
            size = 0;
            return;
        }
        head = head.next;
        size--;
    }

    public void removeLast() {
        if (size == 0) {
            System.out.println("LL is empty");
            return;
        } else if (size == 1) {
            head = tail = null;
            size = 0;
            return;
        }
        Node prev = head;
        while (prev.next != tail) {
            prev = prev.next;
        }
        prev.next = null;
        tail = prev;
        size--;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Likhit_100_6 l1 = new Likhit_100_6();
        Likhit_100_6 l2 = new Likhit_100_6();
        Likhit_100_6 l3 = new Likhit_100_6();

        int choice;
        do {
            System.out.println("\n\nPolynomial Menu");
            System.out.println("1. Add term to first polynomial");
            System.out.println("2. Add term to second polynomial");
            System.out.println("3. Print first polynomial");
            System.out.println("4. Print second polynomial");
            System.out.println("5. Add both polynomials");
            System.out.println("6. Print result polynomial (l3)");
            System.out.println("7. Evaluate result polynomial (l3)");
            System.out.println("8. Clear result polynomial (l3)");
            System.out.println("9. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter coefficient: ");
                    int coeff1 = sc.nextInt();
                    System.out.print("Enter exponent: ");
                    int exp1 = sc.nextInt();
                    l1.addFirst(coeff1, exp1);
                    System.out.println("Term added to first polynomial.");
                    break;
                case 2:
                    System.out.print("Enter coefficient: ");
                    int coeff2 = sc.nextInt();
                    System.out.print("Enter exponent: ");
                    int exp2 = sc.nextInt();
                    l2.addFirst(coeff2, exp2);
                    System.out.println("Term added to second polynomial.");
                    break;
                case 3:
                    System.out.println("First Polynomial:");
                    l1.print();
                    break;
                case 4:
                    System.out.println("Second Polynomial:");
                    l2.print();
                    break;
                case 5:
                    l3 = new Likhit_100_6();
                    l3.addition(l1, l2);
                    System.out.println("Polynomials added.");
                    break;
                case 6:
                    System.out.println("Result Polynomial:");
                    l3.print();
                    break;
                case 7:
                    System.out.print("Enter the value of x: ");
                    int x = sc.nextInt();
                    l3.value(x);
                    break;
                case 8:
                    l3.empty();
                    System.out.println("Result polynomial cleared.");
                    break;
                case 9:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        } while (choice != 9);

        sc.close();
    }
}