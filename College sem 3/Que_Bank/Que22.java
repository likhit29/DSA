public class Que22 {
    public class Node {
        int data;
        Node next;
        Node prev;
    
        Node(int data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }
    Node head = null;
    Node tail = null;

    public void add_last(int data) {
        Node nn = new Node(data);
        if (head == null) {
            head = tail = nn;
            return;
        }
        tail.next = nn;
        nn.prev = tail;
        tail = nn;
    }

    public void count(int key) {

        Node temp = head;
        int i = 0;
        while (temp != null) {
            if (temp.data == key) {
                i++;
            }
            temp = temp.next;
        }
        if (i == 0) {
            System.out.println("Not found any Occurence");
        } else {
            System.out.print("The given no. has total no. of Occurence are:" + i);
        }

    }

    public void print() {
        if (head == null) {
            System.out.println("LL is empty");
            return;
        }
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        Que22 l1 = new Que22();
        l1.add_last(40);
        l1.add_last(10);
        l1.add_last(40);
        l1.add_last(25);
        l1.count(40);

    }
}
