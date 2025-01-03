//priority queue
public class priority_Queue{

    public class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
            this.next = null;
        }
    }
        public Node front;
        public void enqueue(int data) {
            Node newNode = new Node(data);
            // > for desccending
            if (front == null || data < front.data) {
                newNode.next = front;
                front = newNode;
            } else {
                Node temp = front;
                // > for desccending
                while (temp.next != null && temp.next.data <= data) {
                    temp = temp.next;
                }
                newNode.next = temp.next;
                temp.next = newNode;
            }
        }
    
        public int dequeue() {
            if (front == null) {
                System.out.println("data Queue is empty.");
                return -1;
            }
            int d = front.data;
            //System.out.println("Dequeued data: " + front.data);
            front = front.next; // Move front to the next node
            return d;
        }

        public boolean isEmpty(){
            return front == null;
        }

        
    public static void main(String[] args) {
        priority_Queue o1 = new priority_Queue();
        priority_Queue o2 = new priority_Queue();
        priority_Queue o3 = new priority_Queue();
        o1.enqueue(10);
        o1.enqueue(80);
        o1.enqueue(60);
        o2.enqueue(30);
        o2.enqueue(90);
        o2.enqueue(100);

        while(!o1.isEmpty()){
            o3.enqueue(o1.dequeue());
        }
        while(!o2.isEmpty()){
            o3.enqueue(o2.dequeue());
        }
        System.out.println(o3.dequeue());
        System.out.println(o3.dequeue());
    }
}