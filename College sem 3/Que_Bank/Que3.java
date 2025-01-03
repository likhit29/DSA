public class Que3 {
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

    public void partitionList(int x){
        Node lessList = new Node(0);
        Node highList = new Node(0);
        Node less = lessList;
        Node high = highList;
        Node temp = head;
        while(temp != null){
            if(temp.data < x){
                less.next = temp;
                less = less.next;
            }
            else{
                high.next = temp;
                high = high.next;

            }
            temp = temp.next;
        }
        high.next = null;
        less.next = highList.next;
        head = lessList.next;
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
        Que3 l1 = new Que3();

        l1.add_last(3);
        l1.add_last(5);
        l1.add_last(8);
        l1.add_last(5);
        l1.add_last(10);
        l1.add_last(2);
        l1.add_last(1);
        l1.print();
        l1.partitionList(5);
        l1.print();

    }
}
