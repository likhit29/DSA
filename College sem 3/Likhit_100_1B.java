import java.util.Scanner;

public class Likhit_100_1B {
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
    public static void shellSort(Student[] s) {
        int n = s.length;
        for (int gap = n / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < n; i++) {
                Student temp = s[i];
                int j;
                for (j = i; j >= gap && s[j - gap].name.compareTo(temp.name) > 0; j -= gap) {
                    s[j] = s[j - gap];
                }
                s[j] = temp;
            }
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
        shellSort(s);
        System.out.println("\nAfter Sorting:");
        for (int i = 0; i < size; i++) {
            s[i].showData();
        }
        sc.close();
    }
}
