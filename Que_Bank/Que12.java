public class Que12{
    public class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
            this.next = null;
        }
    }
    Node head = null;
    Node tail = null;

    public void add_Last(int data){
        Node nn = new Node(data);
        if(head == null){
            head = tail = nn;
            return;
        }
        tail.next = nn;
        tail = nn;
        nn.next = null;
    }

    public void search(int idx){
        Node temp = head;
        int count = 0;
        if(head == null){
            System.out.println("Empty");
            return;
        }

        while(temp!=null){
            count++;
            temp = temp.next;
        }
        if(idx>count){
            System.out.println("error");
            return;
        }
        int i = 0;
        temp = head;
        while(i!=count-idx){
            temp = temp.next;
            i++;
        }
        System.out.println(temp.data);
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
    public static void main(String [] args){
        Que12 ll = new Que12();
        ll.add_Last(10);
        ll.add_Last(20);
        ll.add_Last(30);
        ll.add_Last(40);
        ll.search(4);
    }
}