public class A30_Double_ll {

    public class Node {
        int data;
        Node prev;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    public static Node head;
    public static Node tail;
    public static int size;

    public void addFirst(int data) {
        Node newnNode = new Node(data);
        size++;
        if (head == null) {
            head = tail = newnNode;
            return;
        }
        newnNode.next = head;
        head.prev = newnNode;
        head = newnNode;
    }

    public void print() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " <-> ");
            temp = temp.next;
        }
        System.out.println("null");

    }

    public int removeFirst() {
        if (head == null) {
            System.out.println("DL is empty");
            return Integer.MIN_VALUE;
        }
        if (size == 1) {
            int val = head.data;
            head = tail = null;
            size--;
            return val;
        }
        int val = head.data;
        head = head.next;
        head.prev = null;
        size--;
        return val;

    }

    public void reverse() {

        Node curr = head;
        Node prev = null;
        Node next;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            curr.prev = next; // new line

            prev = curr;
            curr = next;
        }
        head = prev;
    }

    public static void main(String[] args) {
        A30_Double_ll oz = new A30_Double_ll();
        oz.addFirst(3);
        oz.addFirst(2);
        oz.addFirst(1);
        oz.print();
        //System.out.println(oz.size);
        // oz.removeFirst();
        oz.reverse();
        oz.print();

    }

}