public class Que2 {
    public class Node{
        int data;
        Node next;
        Node prev;
        Node(int data){
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }
    Node head = null;
    Node tail = null;

    public void add_last(int data){
        Node nn = new Node(data);
        if(head == null){
            head = tail = nn;
            return;
        }
        tail.next = nn;
        nn.prev = tail;
        tail = nn;
    }

    public void duplicate(){
        if(head == null){
            System.out.println("Empty");
            return;
        }
        Node temp = head;
        while(temp != null && temp.next != null){
            if(temp.data == temp.next.data){
                temp.next = temp.next.next;
            }
            else{
                temp = temp.next;
            }
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
        Que2 l1 = new Que2();

        l1.add_last(10);
        l1.add_last(15);
        l1.add_last(15);
        l1.add_last(30);
        l1.add_last(40);
        l1.add_last(15);
        l1.print();
        l1.duplicate();
        l1.print();

    }
}
