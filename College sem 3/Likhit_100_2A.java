import java.util.Scanner;

class Likhit_100_2A {
    class Employee {
        public int EmpID;
        public String Name;
        public int Salary;

        public void getData(Scanner sc) {
            System.out.print("Enter the id of employee - ");
            EmpID = sc.nextInt();
            sc.nextLine();
            System.out.print("Enter the name of employee - ");
            Name = sc.nextLine();
            System.out.print("Enter the salary of employee - ");
            Salary = sc.nextInt();
        }

        public void display() {
            System.out.println("The id of employee: " + EmpID);
            System.out.println("The name of employee: " + Name);
            System.out.println("The salary of employee: " + Salary);
        }
    }

    public static void quickSort(Employee[] e, int low, int high) {
        if (low < high) {
            int pivot = partition(e, low, high);
            quickSort(e, low, pivot - 1);
            quickSort(e, pivot + 1, high);
        }
    }

    private static int partition(Employee[] e, int low, int high) {
        int pivot = e[low].EmpID;
        int i = low + 1;
        int j = high;
        Employee temp;

        while (i <= j) {
            while (i <= high && e[i].EmpID <= pivot) {
                i++;
            }
            while (e[j].EmpID > pivot) {
                j--;
            }
            if (i < j) {
                temp = e[i];
                e[i] = e[j];
                e[j] = temp;
            }
        }

        temp = e[low];
        e[low] = e[j];
        e[j] = temp;

        return j;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Likhit_100_2A s = new Likhit_100_2A();
        System.out.print("Enter the number of employees: ");
        int n = sc.nextInt();
        Employee[] e = new Employee[n];

        for (int i = 0; i < n; i++) {
            e[i] = s.new Employee();
            e[i].getData(sc);
            System.out.println();
        }
        System.out.println("Data After Sorting -  ");
        quickSort(e, 0, n - 1);

        for (int i = 0; i < n; i++) {
            e[i].display();
            System.out.println();
        }
        sc.close();
    }
}
