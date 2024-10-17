import java.util.Scanner;
public class Likhit_100_1C {

    static class Student {
        String name;
        int rollNo;
        int marks;
    
        void getData(Scanner sc) {
            System.out.print("\nEnter Your Name: ");
            name = sc.nextLine();
            System.out.print("Enter Your Roll Number: ");
            rollNo = sc.nextInt();
            sc.nextLine();
            System.out.print("Enter marks: ");
            marks = sc.nextInt();
            sc.nextLine();
        }
    
        void showData() {
            System.out.print("Name - " + name);
            System.out.print(", Roll Number - " + rollNo);
            System.out.print(", marks - " + marks);
            System.out.println();
        }
    }
    static int getMax(Student[] s, int n) {
        int max = s[0].marks;
        for (int i = 1; i < n; i++) {
            if (s[i].marks > max)
                max = s[i].marks;
        }
        return max;
    }

    static void countingSort(Student[] s, int exp) {
        int n = s.length;
        Student[] output = new Student[n];
        int[] count = new int[10];
        for (int i = 0; i < count.length; i++) {
            count[i] = 0;
        }
        for (int i = 0; i < n; i++) {
            count[(s[i].marks / exp) % 10]++;
        }
        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }
        for (int i = n - 1; i >= 0; i--) {
            output[count[(s[i].marks / exp) % 10] - 1] = s[i];
            count[(s[i].marks / exp) % 10]--;
        }
        for (int i = 0; i < n; i++) {
            s[i] = output[i];
        }
    }

    static void radixSort(Student[] s) {
        int n = s.length;
        int max = getMax(s, n);

        for (int exp = 1; max / exp > 0; exp *= 10)
            countingSort(s, exp);
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

        radixSort(s);

        System.out.println("\nAfter Sorting:");
        for (int i = size-1; i >= 0; i--) {
            s[i].showData();
        }

        sc.close();
    }
}
