import java.util.*;

public class A32_Stack_Que {

    // Valid Parentheses
    public static boolean Valid_Parenteses() {
        String c = "{[{}]}";
        Stack<Character> s = new Stack<>();
        for (int i = 0; i < c.length(); i++) {
            char ch = c.charAt(i);
            if (ch == '{' || ch == '(' || ch == '[') {
                s.push(ch);
            }

            else {
                if (s.isEmpty()) {
                    return false;
                }
                if ((s.peek() == '(' && ch == ')')
                        || s.peek() == '{' && ch == '}'
                        || s.peek() == '[' && ch == ']') {
                    s.pop();
                } else {
                    return false;
                }

            }
        }
        if (s.isEmpty()) {
            return true;
        } else {
            return false;
        }

    }

    public static boolean Dulicate_Parenteses() {// O(n)
        String c = "(((a+b)+(c)))";
        Stack<Character> s = new Stack<>();
        for (int i = 0; i < c.length(); i++) {
            char ch = c.charAt(i);
            if (ch == ')') {
                int count = 0;
                while (s.pop() != '(') {
                    count++;
                }
                if (count < 1) {
                    return true;
                }
            } else {
                s.push(ch);
            }
        }
        return false;
    }

    // Max Area in Histogram

    // in stack we will be storing index

    public static void Histogram(int arr[]) {
        // j
        // Next_Smaller_Right
        Stack<Integer> s = new Stack<>();
        int right[] = new int[arr.length];
        for (int i = arr.length - 1; i >= 0; i--) {
            while (!s.isEmpty() && arr[i] <= arr[s.peek()]) {
                s.pop();
            }
            if (s.empty()) {
                right[i] = arr.length;
            } else {
                right[i] = s.peek();
            }
            s.push(i);
        }

        // i
        // Next_Smaller_Left
        s = new Stack<>();
        int left[] = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            while (!s.isEmpty() && arr[i] <= arr[s.peek()]) {
                s.pop();
            }
            if (s.empty()) {
                left[i] = -1;
            } else {
                left[i] = s.peek();
            }
            s.push(i);
        }

        // main histogram area code
        int max_area = 0;
        for (int k = 0; k < arr.length; k++) {
            int width = right[k] - left[k] - 1;
            int height = arr[k];
            int area = height * width;
            max_area = Math.max(max_area, area);
        }
        System.out.println(max_area);
    }

    public static void main(String[] args) {
        // System.out.println(Valid_Parenteses());
        // System.out.println(Dulicate_Parenteses());
        
        int arr[] = { 2, 1, 5, 6, 2, 3 };
        Histogram(arr);

    }
}