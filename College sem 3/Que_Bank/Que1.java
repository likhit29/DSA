public class Que1{
    
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

    public void cycle(){
        if(head==null){
            System.out.println("LL is empty");
            return;
        }
        Node slow = head;
        Node fast = head;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                System.out.println("Cycle deteted");
                return;
            }
        }
        System.out.println("No cycle");
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
    public void MakeCircular(){
        tail.next = head;
    }

    public static void main(String [] args){
        Que1 ll = new Que1();
        ll.add_Last(10);
        ll.add_Last(20);
        ll.add_Last(30);
        ll.add_Last(40);
        //ll.MakeCircular();
        ll.cycle();
        //ll.print();
    }
}