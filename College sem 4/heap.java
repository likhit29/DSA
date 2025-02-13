/*
 Heap

 1. Add
 2. Peek
 3. Remove
 4. Check if empty
 5. Check if Heap is Valid
 */

 import java.util.ArrayList;
 import java.util.Scanner;
 
 public class heap {
     ArrayList<Integer> ar = new ArrayList<>();
 
     public boolean isEmpty() {
         return ar.size() == 0;
     }
 
     public void add(int data) {
         ar.add(data);
         int ch = ar.size() - 1;
         int par = (ch - 1) / 2;
         while (ch > 0 && ar.get(ch) < ar.get(par)) {
             int temp = ar.get(par);
             ar.set(par, ar.get(ch));
             ar.set(ch, temp);
 
             ch = par;
             par = (ch - 1) / 2;
         }
     }
 
     public int peek() {
         if (isEmpty()) {
             return Integer.MIN_VALUE;
         }
         return ar.get(0);
     }
 
     private void heapify(int i) {
         int minidx = i;
         int left = 2 * i + 1;
         int right = 2 * i + 2;
 
         if (left < ar.size() && ar.get(minidx) > ar.get(left)) {
             minidx = left;
         }
         if (right < ar.size() && ar.get(minidx) > ar.get(right)) {
             minidx = right;
         }
         if (minidx != i) {
             int temp = ar.get(i);
             ar.set(i, ar.get(minidx));
             ar.set(minidx, temp);
 
             heapify(minidx);
         }
     }
 
     public int remove() {
         if (isEmpty()) {
             return Integer.MIN_VALUE;
         }
         int data = ar.get(0);
         ar.set(0, ar.get(ar.size() - 1));
         ar.remove(ar.size() - 1);
 
         if (!ar.isEmpty()) {
             heapify(0);
         }
         return data;
     }
 
     public boolean checkHeap() {
         int n = ar.size();
         for (int i = 0; i < n / 2; i++) {
             int left = 2 * i + 1;
             int right = 2 * i + 2;
 
             if (left < n && ar.get(i) > ar.get(left)) {
                 return false; 
             }
             if (right < n && ar.get(i) > ar.get(right)) {
                 return false; 
             }
         }
         return true;
     }
 
     public static void main(String[] args) {
         Scanner sc = new Scanner(System.in);
         heap h1 = new heap();
 
         while (true) {
             System.out.println("\nHeap Menu:");
             System.out.println("1. Add Element");
             System.out.println("2. Peek Element");
             System.out.println("3. Remove Element");
             System.out.println("4. Check if Empty");
             System.out.println("5. Check if Heap is Valid");
             System.out.println("6. Exit");
             System.out.print("Enter your choice: ");
 
             int choice = sc.nextInt();
 
             switch (choice) {
                 case 1:
                     System.out.print("Enter element to add: ");
                     int data = sc.nextInt();
                     h1.add(data);
                     break;
                 case 2:
                     System.out.println("Peek Element: " + h1.peek());
                     break;
                 case 3:
                     int removed = h1.remove();
                     if (removed == Integer.MIN_VALUE) {
                         System.out.println("Heap is empty!");
                     } else {
                         System.out.println("Removed Element: " + removed);
                     }
                     break;
                 case 4:
                     System.out.println("Heap is " + (h1.isEmpty() ? "Empty" : "Not Empty"));
                     break;
                 case 5:
                     System.out.println("Heap is " + (h1.checkHeap() ? "valid" : "invalid"));
                     break;
                 case 6:
                     System.out.println("Exiting...");
                     sc.close();
                     return;
                 default:
                     System.out.println("Invalid choice! Please try again.");
             }
         }
     }
 }
 