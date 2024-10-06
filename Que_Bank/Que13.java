public class Que13{
    
    public class Node{
        int name;
        int PhoneNumber;
        String email;
        Node next;
        Node(int name, int PhoneNumber, String email ){
            this.name = name;
            this.PhoneNumber = PhoneNumber;
            this.email = email;
            this.next = null;
        }
    }
    Node head = null;
    Node tail = null;

    public void add_Last(int name, int PhoneNumber, String email ){
        Node nn = new Node(name, PhoneNumber, email);
        if(head == null){
            head = tail = nn;
            return;
        }
        tail.next = nn;
        tail = nn;
        nn.next = null;
    }

    public int count(Node head){
        if(head == null){
            return 0;
        }
        return 1 + count(head.next);
    }
   

    public void print() {
        if (head == null) {
            System.out.println("LL is empty");
            return;
        }
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.name + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public static void main(String [] args){
        Que13 ll = new Que13();
        ll.add_Last(10,51,"lfe");
        ll.add_Last(20,50,"ru");
        ll.add_Last(30,5,"cddcv");
        System.out.println(ll.count(ll.head));

    }
}