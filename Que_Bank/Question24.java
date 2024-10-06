public class Question24 {
    class Node{
        int value;
        Node next;
        Node(int value){
            this.value = value;
        }
    }
    private Node head;
    private Node tail;
    Question24(){
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
    public void get_length(){
        int length = 0;
        Node temp = head;
        while(temp != null){
            length++;
            temp = temp.next;
        }
        System.out.print("Length of list is: "+length);
    }
    public static void main(String args[]){
        Question24 q = new Question24();
        for(int i = 1 ; i <= 80;i++){
            q.append(i);
        }
        q.print();
        System.out.println();
        q.get_length();
    }

}
