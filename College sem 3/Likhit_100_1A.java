import java.util.Scanner;

public class Likhit_100_1A {
    static class Student {
        String name;
        int rollNo;
        double cgpa;
    
        void getData(Scanner sc) {
            System.out.print("\nEnter Your Name: ");
            name = sc.nextLine();
            System.out.print("Enter Your Roll Number: ");
            rollNo = sc.nextInt();
            sc.nextLine();
            System.out.print("Enter CGPA: ");
            cgpa = sc.nextDouble();
            sc.nextLine();
        }
    
        void showData() {
            System.out.print("Name - " + name);
            System.out.print(", Roll Number - " + rollNo);
            System.out.print(", CGPA - " + cgpa);
            System.out.println();
        }
    }
    
    public static void insertionSort(Student[] s) {
        int n = s.length;
        for (int i = 1; i < n; i++) {
            Student current = s[i];
            int j = i - 1;
            while (j >= 0 && s[j].rollNo > current.rollNo) {
                s[j + 1] = s[j];
                j--;
            }
            s[j + 1] = current;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Number of Students: ");
        int size = sc.nextInt();
        sc.nextLine();
        Student[] s = new Student[size];
        for (int i = 0; i < size; i++) {
            s[i] = new Student();
            s[i].getData(sc);
        }
        System.out.println("\n\nBefore Sorting:");
        for (int i = 0; i < size; i++) {
            s[i].showData();
        }
        insertionSort(s);
        System.out.println("\nAfter Sorting:");
        for (int i = 0; i < size; i++) {
            s[i].showData();
        }
        sc.close();
    }
}

