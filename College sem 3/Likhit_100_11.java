//Likhit Chaudhary
//123B1B100
//Assignment 11 
//Consider an employee database of N employees. Make use of a hash table implementation to quickly look up the employer's id number.

import java.util.Scanner;

class Employee {
    int id;
    String name;

    public Employee(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public String toString() {
        return "ID: " + id + ", Name: " + name;
    }
}

public class Likhit_100_11 {

    static class HashTable {
        private Employee[] table;

        public HashTable(int size) {
            table = new Employee[size];
        }

        private int hashFunction(int id) {
            return id % table.length;
        }

        public void insert(int id, String name) {
            int index = hashFunction(id);
            while (table[index] != null) {
                index = (index + 1) % table.length;
            }
            table[index] = new Employee(id, name);
            System.out.println("Inserted: " + name);
        }

        public void delete(int id) {
            int index = hashFunction(id);
            while (table[index] != null) {
                if (table[index].id == id) {
                    System.out.println("Deleted: " + table[index].name);
                    table[index] = null;
                    return;
                }
                index = (index + 1) % table.length;
            }
            System.out.println("Employee not found!");
        }

        public void search(int id) {
            int index = hashFunction(id);
            while (table[index] != null) {
                if (table[index].id == id) {
                    System.out.println("Found: " + table[index]);
                    return;
                }
                index = (index + 1) % table.length;
            }
            System.out.println("Employee not found!");
        }

        public void display() {
            System.out.println("Employees in the Hash Table:");
            for (int i = 0; i < table.length; i++) {
                if (table[i] != null) {
                    System.out.println("Index " + i + ": " + table[i]);
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashTable ht = new HashTable(5);

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Insert Employee");
            System.out.println("2. Delete Employee");
            System.out.println("3. Search Employee");
            System.out.println("4. Display Employees");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            if (choice == 1) {
                System.out.print("Enter Employee ID: ");
                int id = scanner.nextInt();
                System.out.print("Enter Employee Name: ");
                scanner.nextLine(); // consume newline
                String name = scanner.nextLine();
                ht.insert(id, name);
            } else if (choice == 2) {
                System.out.print("Enter Employee ID to delete: ");
                int id = scanner.nextInt();
                ht.delete(id);
            } else if (choice == 3) {
                System.out.print("Enter Employee ID to search: ");
                int id = scanner.nextInt();
                ht.search(id);
            } else if (choice == 4) {
                ht.display();
            } else if (choice == 5) {
                System.out.println("Exiting...");
                break;
            } else {
                System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();
    }
}
