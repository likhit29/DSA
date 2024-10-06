//Question 16

// public int helper(Node head, int key) {

//     if (head == null) {
//         return -1;
//     }
//     if (head.data == key) {
//         return 0;
//     }
//     int idx = helper(head.next, key);
//     if (idx == -1) {
//         return -1;
//     }
//     return idx + 1;
// }
public class Que16 {
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

    public int recursive_search(Node head, int key) {
        if (head == null) {
            return 0;
        }

        if (head.data == key) {
            return 1;
        }
        return recursive_search(head.next, key);
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
        Que16 l1 = new Que16();
        l1.add_last(10);
        l1.add_last(25);
        l1.add_last(40);
        System.out.println(l1.recursive_search(l1.head, 20));
    }
}
