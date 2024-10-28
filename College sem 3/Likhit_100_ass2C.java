//Check a given expression has balanced Parenthesis or not

import java.util.Stack;
import java.util.Scanner;

public class Likhit_100_ass2C {
       public static boolean Valid_Parenteses(String c) {
        Stack<Character> s = new Stack<>();
        for (int i = 0; i < c.length(); i++) {
            char ch = c.charAt(i);
            if (ch == '{' || ch == '(' || ch == '[') {
                s.push(ch);
            }
            else if (ch == '}' || ch == ')' || ch == ']'){
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
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the string - ");
        String c = sc.nextLine();
        System.out.println(Valid_Parenteses(c));
        sc.close();
    }
}
