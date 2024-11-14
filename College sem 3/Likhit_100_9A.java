//Likhit Chaudhary
//123B1B100
//Assignment 9A
//Restaurant waitlist system

import java.util.Scanner;

public class Likhit_100_9A {
    public class CustomerNode {
        String customerName;
        String phoneNumber;
        CustomerNode next;

        CustomerNode(String customerName, String phoneNumber) {
            this.customerName = customerName;
            this.phoneNumber = phoneNumber;
        }
    }

    public CustomerNode head;

    public void addCustomer(String customerName, String phoneNumber) {
        CustomerNode newCustomer = new CustomerNode(customerName, phoneNumber);
        if (head == null) {
            head = newCustomer;
        } else {
            CustomerNode current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newCustomer;
        }
    }

    public void removeCustomer() {
        if (head == null) {
            System.out.println("The waitlist is already empty.");
            return;
        } else {
            head = head.next;
        }
    }

    public void searchCustomer(String customerName) {
        int position = 0;
        CustomerNode current = head;
        while (current != null) {
            if (current.customerName.equals(customerName)) {
                System.out.println("Customer is at position: " + position);
                return;
            }
            current = current.next;
            position++;
        }
        System.out.println("Customer not found in the queue.");
    }

    public void displayQueue() {
        if (head == null) {
            System.out.println("The waitlist is empty.");
            return;
        }
        CustomerNode current = head;
        while (current != null) {
            System.out.println("Name: " + current.customerName + " Phone Number: " + current.phoneNumber);
            current = current.next;
        }
    }

    public static void main(String[] args) {
        Likhit_100_9A queue = new Likhit_100_9A();
        Scanner scanner = new Scanner(System.in);
        int continueChoice = 1;
        while (continueChoice == 1) {
            System.out.println("Waitlist Menu: ");
            System.out.println("1. Add Customer");
            System.out.println("2. Remove Customer from Queue");
            System.out.println("3. Search Customer Position");
            System.out.println("4. Display Waitlist");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Phone Number: ");
                    String phoneNumber = scanner.nextLine();
                    queue.addCustomer(name, phoneNumber);
                    break;
                case 2:
                    queue.removeCustomer();
                    break;
                case 3:
                    System.out.print("Enter the name to search: ");
                    String searchName = scanner.nextLine();
                    queue.searchCustomer(searchName);
                    break;
                case 4:
                    queue.displayQueue();
                    break;
                default:
                    System.out.println("Invalid choice.");
                    break;
            }
            System.out.print("Enter 1 to continue or 0 to stop: ");
            continueChoice = scanner.nextInt();
            scanner.nextLine();
        }
        scanner.close();
    }
}
