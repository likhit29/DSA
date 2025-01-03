import java.util.*;
import java.util.Stack;

public class test2 {

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

    public static void pushAtBottom(Stack<Integer> s, int data) {
        if (s.isEmpty()) {
            s.push(data);
            return;
        }
        int top = s.pop();
        pushAtBottom(s, data);
        s.push(top);
    }

    public static void Reverse(Stack<Integer> s) {
        if (s.isEmpty()) {
            return;
        }
        int top = s.pop();
        Reverse(s);
        pushAtBottom(s, top);
    }

    public static boolean Valid_Parenteses() {
        String c = "{[{}]}";
        Stack<Character> s = new Stack<>();
        for (int i = 0; i < c.length(); i++) {
            char ch = c.charAt(i);
            if (ch == '{' || ch == '(' || ch == '[') {
                s.push(ch);
            } else if (ch == '}' || ch == ')' || ch == ']') {
                if (s.isEmpty()) {
                    return false;
                }
                if ((s.peek() == '(' && ch == ')') ||
                        (s.peek() == '{' && ch == '}') ||
                        (s.peek() == '[' && ch == ']')) {
                    s.pop();
                } else {
                    return false;
                }
            }
        }
        return s.isEmpty();
    }

    public static boolean isPalindrome(String str) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            stack.push(str.charAt(i));
        }
        // Check palindrome by comparing characters with stack's top
        for (int i = 0; i < str.length(); i++) {
            if (stack.pop() != str.charAt(i)) {
                return false;
            }
        }

        return true; // No mismatches, it's a palindrome
    }

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


    public static void rev(Stack<Integer> s, Stack<Integer> clone ){
        if(s.isEmpty()){
            return;
        }
        int i = s.pop();
        rev(s, clone);
        clone.push(i);
        s.push(i);

    }

}