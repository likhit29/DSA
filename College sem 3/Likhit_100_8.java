import java.util.Scanner;
import java.util.Stack;

public class Likhit_100_8 {
 
    static int precedence(char c) {
        if (c == '+' || c == '-') {
            return 1;
        } else if (c == '*' || c == '/') {
            return 2;
        } else {
            return -1;
        }
    }
    
    static String infixToPostfix(String s1) {
        StringBuilder result = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s1.length(); i++) {
            char c = s1.charAt(i);

            if (Character.isLetterOrDigit(c)) {
                while (i < s1.length() && Character.isDigit(s1.charAt(i))) {
                    result.append(s1.charAt(i));
                    i++;
                }
                result.append(' '); 
                i--; 
            }
            
            else if (c == '(') {
                stack.push(c);
            }

            else if (c == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    result.append(stack.pop());
                }
                stack.pop();                                        // Pop opening bracket from stack
            }
            else if (c == '+' || c == '-' || c == '*' || c == '/') {
                while (!stack.isEmpty() && precedence(c) <= precedence(stack.peek())) {
                    result.append(stack.pop());
                    result.append(" ");
                }
                stack.push(c);                                       //Push higher precedence
            }
        }
        while (!stack.isEmpty()) {
            result.append(stack.pop());
            result.append(" ");
        }

        return result.toString().trim();
    }

    public static int evaluatePostfix(String postfix) {
        Stack<Integer> stack = new Stack<>();
        StringBuilder t = new StringBuilder();

        for (int i = 0; i < postfix.length(); i++) {
            char c = postfix.charAt(i);

            if (c == ' ') {
                continue;
            }
            else if (Character.isDigit(c)) {
                t.setLength(0);
                while (i < postfix.length() && Character.isDigit(postfix.charAt(i))) {
                    t.append(postfix.charAt(i));
                    i++;
                }
                i--;
                stack.push(Integer.parseInt(t.toString())); 
            } 
            else {
                int op2 = stack.pop(); 
                int op1 = stack.pop(); 

                int result = 0;
                switch (c) {
                    case '+':
                        result = op1 + op2;
                        break;
                    case '-':
                        result = op1 - op2;
                        break;
                    case '*':
                        result = op1 * op2;
                        break;
                    case '/':
                        result = op1 / op2;
                        break;
                }
                stack.push(result);
            }
        }
        
        return stack.pop();
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the Equation - ");
        String s1 = sc.nextLine();
        //String s1 = "44+50*13";
        String postfix = infixToPostfix(s1);
        System.out.println("Postfix: " + postfix);
        System.out.println("Value of Postfix is : "+evaluatePostfix(postfix));
        sc.close();

    }
}
