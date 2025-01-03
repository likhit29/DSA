public class Queue_using_stack {
    public static class Stack {
        public static class Node {
            int data;
            Node next;

            Node(int data) {
                this.data = data;
                this.next = null;
            }
        }

        public Node top;

        Stack() {
            this.top = null;
        }

        public void push(int data) {
            Node nn = new Node(data);
            nn.next = top;
            top = nn;
        }

        public int pop() {
            if (top == null) {
                return -1;
            }
            int t = top.data;
            top = top.next;
            return t;
        }

        public int peek() {
            if (top == null) {
                return -1;
            }
            return top.data;
        }
    }

    Stack s1 = new Stack();
    Stack s2 = new Stack();

    public void enqueue(int data) {
        s1.push(data);
    }

    public int dequeue() {
        while(s1.top!=null){
        s2.push(s1.pop());
        }

        int d = s2.pop();
        while(s2.top!=null){
        s1.push(s2.pop());
        }
        return d;

    }

    public static void main(String[] args) {
        Queue_using_stack o = new Queue_using_stack();
        o.enqueue(50);
        o.enqueue(30);
        o.enqueue(10);
        System.out.println(o.dequeue());
        System.out.println(o.dequeue());
        o.enqueue(5);
        System.out.println(o.dequeue());

    }
}