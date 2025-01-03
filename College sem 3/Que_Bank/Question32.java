public class Question32 {
    class Node{
        int value;
        Node next;
        Node(int value){
            this.value = value;
        }
    }
    private Node head;
    private Node tail;
    Question32(){
        head = null;
        tail = null;
    }
    public void append(int value){
        Node newNode = new Node(value);
        if(head == null){
            head = newNode;
            tail = newNode;
        }
        else{
            tail.next = newNode;
            tail = newNode;
        }
    }
    public void print(){
        Node temp = head;
        while(temp != null){
            System.out.print(temp.value+" ");
            temp = temp.next;
        }
    }
    public void add_front(){
        Node newNode = new Node(tail.value);
        newNode.next = head;
        head = newNode;
        Node temp = head;
        Node pre = null;
        while(temp.next != null){
            pre = temp;
            temp = temp.next;
        }
        tail = pre;
        tail.next = null;
    }
    public static void main(String args[]){
        Question32 q = new Question32();
        for(int i = 1; i <= 10;i++){
            q.append(i);
        }
        q.print();
        System.out.println();
        q.add_front();
        q.print();
    }
}
