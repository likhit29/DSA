import java.util.Scanner;

class Likhit_100_2B {
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

    public static void partition(Employee e[], int left, int right) {
        int mid = (left + right) / 2;
        if (left < right) {
            partition(e, left, mid);
            partition(e, mid + 1, right);
            MergeSort(e, left, right, mid);
        }
    }

    public static void MergeSort(Employee e[], int left, int right, int mid) {
        int i = left;
        int j = mid + 1;
        int k = 0;
        Employee merge[] = new Employee[right - left + 1];
        while (i <= mid && j <= right) {
            if (e[i].Name.compareTo(e[j].Name) <= 0) {
                merge[k] = e[i];
                i++;
                k++;
            } else {
                merge[k] = e[j];
                k++;
                j++;
            }

        }
        while (i <= mid) {
            merge[k] = e[i];
            k++;
            i++;
        }
        while (j <= right) {
            merge[k] = e[j];
            k++;
            j++;
        }
        for (int m = 0, n = left; m < k; m++, n++) {
            e[n] = merge[m];
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Likhit_100_2B s = new Likhit_100_2B();
        System.out.print("Enter the number of employees: ");
        int n = sc.nextInt();
        Employee[] e = new Employee[n];

        for (int i = 0; i < n; i++) {
            e[i] = s.new Employee();
            e[i].getData(sc);
            System.out.println();
        }
        System.out.println("Data After Sorting -  ");
        partition(e, 0, n - 1);

        for (int i = 0; i < n; i++) {
            e[i].display();
            System.out.println();
        }
        sc.close();
    }
}
