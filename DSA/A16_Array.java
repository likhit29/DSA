/* 
Arrays - they are passes as argument it means whenever we pass array in function if we perform some action in  that function on array it will shown in main function also on same array

dataType arrayName[] = new dataType [size];  //we can change size further  
int marks[] = new int [50]; 
marks[0] = sc.nextInt();
marks[1] = sc.nextInt();
marks[1] = marks[1] + 4;
marks.length;          
functionname(marks)     //to call function and pass array as argument    
                            
                            
*/

public class A16_Array {

    // Binary search
    public static int binarySearch(int numbers[], int key) {
        int start = 0, end = numbers.length - 1;

        while (start <= end) {
            int mid = (start + end) / 2;

            // comparisons
            if (numbers[mid] == key) {
                return mid; // key found at index mid
            }

            if (numbers[mid] < key) {
                // move to the right half
                start = mid + 1;
            } else {
                // move to the left half
                end = mid - 1;
            }
        }

        // key not found
        return -1;
    }

    // Reverse an array - swap 1st and last element
    public static void reverse(int numbers[]) {
        int first = 0, last = numbers.length - 1;
        while (first < last) {
            // Swap
            int temp = numbers[last];
            numbers[last] = numbers[first];
            numbers[first] = temp;

            // Move the pointers
            first++;
            last--;
        }
    }

    public static void main(String[] args) {
        int numbers[] = { 2, 4, 6, 8, 15 };      
        System.out.println(binarySearch(numbers, 8));
        // reverse(numbers);
        for (int i = 0; i < numbers.length; i++) {
            System.out.println(numbers[i] + " ");
        }
    }
}
