// Implementation of stack using Linkedlist
// head = top

public class A31_Stack_ll {

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    static class Stack {
        static Node head = null;

        //addFirst
        public static void push(int data) {
            Node newNode = new Node(data);

            if (head == null) {
                head = newNode;
                return;
            }
            newNode.next = head;
            head = newNode;
        }

        //removeFirst
        public static int pop() {
            if (head == null) {
                return -1;
            }
            int top = head.data;
            head = head.next;
            return top;
        }

        public static int peek() {
            if (head == null) {
                return -1;
            }
            return head.data;
        }
    }

    public static void main(String[] args) {
        // Stack s = new Stack();
        // s.push(1);
        // s.push(2);
        // s.push(3);

        // while (Stack.head!=null) {
        //     System.out.println(s.peek());
        //     s.pop();
        // }

    }
}