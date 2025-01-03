public class Question35 {
    class Node{
        int value;
        Node next;
        Node(int value){
            this.value = value;
        }
    }
    private Node head;
    private Node tail;
    Question35(){
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
    public void EvenNodes() {
        Node temp = head;
        if(temp != null) {
            temp = temp.next;
        while(temp != null) {
            System.out.print(temp.value + " ");
            if(temp.next != null) {
                temp = temp.next.next;
            } else {
                break;
            }
        }
    }

    }
    public void OddNodes(){
        Node temp = head;
        while(temp != null){
            System.out.print(temp.value+" ");
            temp = temp.next.next;
        }
    }
    public static void main(String args[]){
        Question35 q = new Question35();
        for(int i = 1; i <= 10;i++){
            q.append(i+5);
        }
        q.print();
        System.out.println();
        System.out.println("Even linkedlist:");
        q.EvenNodes();
        System.out.println();
        System.out.println("Odd Linkedlist:");
        q.OddNodes();

    }
    

}
