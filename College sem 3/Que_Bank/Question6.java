public class Question6 {
    public static void Sort(int Arr[], int n) {
        for (int i = 0; i < n; i++) {
            int key = Arr[i];
            int j = i - 1;
            while (j >= 0 && key < Arr[j]) {
                Arr[j + 1] = Arr[j];
                j--;
            }
            Arr[j + 1] = key;
        }
    }

    public static void main(String[] args) {
        int arr[] = { 25, 7, 1, 1, 5, 8, 8, 10, 7 };
        int Temp1[] = new int[arr.length];
        int Temp2[] = new int[arr.length];
        int k = 0;
        int l = 0;

        for (int i = 0; i < arr.length; i++) {
            int count = 0;
            for (int j = 0; j < arr.length; j++) {
                if (arr[i] == arr[j] && i != j) {
                    count++;
                }
            }
            if (count == 0) {
                Temp2[k++] = arr[i];
            } else {
                int m;
                for (m = 0; m < l; m++) {
                    if (Temp1[m] == arr[i]) {
                        break;
                    }
                }
                if (m == l) {
                    Temp1[l++] = arr[i];
                }

            }

        }
        System.out.println("Unique elements:");
        for (int i = 0; i < k; i++) {
            System.out.print(Temp2[i] + " ");
        }
        System.out.println("\nDuplicate elements:");
        for (int i = 0; i < l; i++) {
            System.out.print(Temp1[i] + " ");
        }
        System.out.println("\nCombining Unique in Ascending Order and Duplicate in Descending order:");
        Sort(Temp1, l);
        Sort(Temp2, k);
        int x = 0;

        for (int i = 0; i < k; i++) {
            arr[x++] = Temp2[i];

        }
        for (int i = l - 1; i >= 0; i--) {
            arr[x++] = Temp1[i];
        }
        for (int i = 0; i < x; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
