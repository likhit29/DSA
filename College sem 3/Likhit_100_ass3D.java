//Remove every alternate element from the list.

public class Likhit_100_ass3D {
    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    Node head;
    Node tail;

    public void addLast(int data) {
        Node nn = new Node(data);
        if (head == null) {
            head = tail = nn;
            return;
        }
        tail.next = nn;
        tail = nn;
    }

    public void deleteLast() {
        if (head == null) {
            System.out.println("LL is empty");
            return;
        }
        if (head == tail) {
            head = tail = null;
            return;
        }
        Node prev = head;
        while (prev.next != tail) {
            prev = prev.next;
        }
        prev.next = null;
        tail = prev;
    }

    public void print() {
        Node temp = head;
        if (head == null) {
            System.out.println("LL is empty");
            return;
        }
        while (temp != null) {
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public void alternate(){
        if(head==null && head.next == null){
            return;
        }
        Node temp = head;
        while(temp != null){
            temp.next = temp.next.next;
            if(temp.next.next != null){
            return;
        }
        temp = temp.next.next;
    }
    }
    public static void main(String[] args) {
        Likhit_100_ass3D o1 = new Likhit_100_ass3D();
        o1.addLast(10);
        o1.addLast(30);
        o1.addLast(40);
        o1.print();
        o1.alternate();
        o1.print();
    }
}
