
/// Implementation of stack using Java collection framework - push, peek, pop
// isempty check whether head == null , if true means stack is empty
// !s.isEmpty() is used to check if the stack is not empty. , if false means stack is empty


/*
1.Push At Bottom
2.Reverse a string
3.Reverse a stack
4.Stock Span
5.Next Greater Element (Right Side)

Variation of 5 - 
Next Greater Right
Next Greater Left (for loop will start from 0)
Next Smaller Right (while loop condition greter than sign will change)
Next Smaller Left

*/
import java.util.Stack;

public class A31_Stack_QUE {

    // Push at the bottom of the stack
    public static void pushAtBottom(Stack<Integer> s, int data) {
        if (s.isEmpty()) {
            s.push(data);
            return;
        }
        int top = s.pop();
        pushAtBottom(s, data);
        s.push(top);
    }

    // Reverse a stringggg using stack
    public static String reverseString(String str) {
        Stack<Character> s = new Stack<>(); 
        for (int idx = 0; idx < str.length(); idx++) {
            s.push(str.charAt(idx));
        }
        StringBuilder result = new StringBuilder();
        while (!s.isEmpty()) {
            char curr = s.pop();
            result.append(curr);
        }
        return result.toString();
    }

    // Reverse a stack
    public static void Reverse(Stack<Integer> s) {
        if (s.isEmpty()) {
            return;
        }
        int top = s.pop();
        Reverse(s);
        pushAtBottom(s, top);
    }


    // Stock Span - O(n)
    // There is one brute force mtd also but O(n²)
    public static void stockSpan(int stocks[], int span[]) {
        Stack<Integer> s = new Stack<>(); // Stack to store indices of stock prices

        // The span of the first day is always 1
        span[0] = 1;
        s.push(0); // Push the index of the first element

        // Iterate over the remaining stock prices
        for (int i = 1; i < stocks.length; i++) {
            int currPrice = stocks[i];

            // Pop elements from the stack while the stack is not empty and the current
            // price is greater than the stock price at the index stored in the stack
            while (!s.isEmpty() && currPrice >= stocks[s.peek()]) {
                s.pop();
            }

            // If the stack becomes empty, it means all previous prices are smaller, so
            // span[i] = i + 1
            if (s.isEmpty()) {
                span[i] = i + 1;
            } else {
                // If the stack is not empty, calculate the span as the difference between the
                // current index and the index of the previous higher stock price
                span[i] = i - s.peek(); // prevhigh = s.peek()
            }

            // Push the current index onto the stack
            s.push(i);
        }
    }

    // Next Greater Element (Right Side)
    // 1. Brute Force - do self - O(n²)
    // 2. O(n) - - starting array loop from end
    public static void Greater(int arr[]) {
        Stack<Integer> s = new Stack<>();
        int nxtgreater[] = new int[arr.length];
        for (int i = arr.length - 1; i >= 0; i--) {
            while (!s.empty() && arr[i] >= arr[s.peek()]) {
                s.pop();
            }
            if (s.empty()) {
                nxtgreater[i] = -1;
            } else {
                nxtgreater[i] = arr[s.peek()];
            }
            s.push(i);

        }
        for (int i = 0; i < nxtgreater.length; i++) {
            System.out.print(nxtgreater[i] + " ");
        }
        System.out.println();

    }

    public static void print(Stack<Integer> s) {
        while (!s.isEmpty()) {
            System.out.println(s.pop());
        }

    }

    public static void main(String[] args) {
        // Stack<Integer> s = new Stack<>();
        // s.push(1);
        // s.push(2);
        // s.push(3);
        // //pushAtBottom(s,4);
        // //Reverse(s);
        // print(s);

        // System.out.println(reverseString("abcde")); //reverse

        // Stock span
        // int stocks[] = {100, 80, 60, 70, 60, 85, 100};
        // int span[] = new int[stocks.length];

        // stockSpan(stocks, span);

        // // Print the span for each day
        // for (int i = 0; i < span.length; i++) {
        // System.out.print(span[i] + " ");
        // }

        // Next Greater Element
        int arr[] = { 6, 8, 0, 1, 3 };
        Greater(arr);

    }
}