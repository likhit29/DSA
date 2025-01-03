//11
public class Que11 {
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

    public void merge(Que11 l1, Que11 l2){
        Node temp1 = l1.head;
        Node temp2 = l2.head;
        while(temp1!=null && temp2!=null){
            if(temp1.data<temp2.data){
                add_last(temp1.data);
                temp1=temp1.next;
            }
            else{
                add_last(temp2.data);
                temp2=temp2.next;
            }
        }
        while(temp1!=null){
            add_last(temp1.data);
            temp1=temp1.next;
        }
        while(temp2!=null){
            add_last(temp2.data);
            temp2=temp2.next;
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
        Que11 l1 = new Que11();
        Que11 l2 = new Que11();
        Que11 l3 = new Que11();
        l1.add_last(10);
        l1.add_last(25);
        l1.add_last(40);
        l2.add_last(15);
        l2.add_last(30);
        l2.add_last(40);
        l1.print();
        l2.print();
        l3.merge(l1, l2);
        l3.print();
    }
}
