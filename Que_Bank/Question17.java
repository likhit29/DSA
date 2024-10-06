public class Question17 {
    class Node{
        int value;
        Node next;
        Node(int value){
            this.value = value;
        }
    }
    private Node head;
    private Node tail;
    Question17(){
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
    public void FindNValue(int N){
        if(head == null){
            System.out.println("Empty List");
            return;
        }
        Node temp = head;
        int length = 0;
        while(temp != null){
            length++;
            temp = temp.next;
        }
        if(N > length){
            return;
        }
        else{
            temp = head;
            for(int i = 1; i < N;i++){
                temp = temp.next;
            }
            System.out.print("Nth Value is:"+temp.value);
        }
    }
    public void print(){
        Node temp = head;
        while(temp != null){
            System.out.print(temp.value+" ");
            temp = temp.next;
        }
    }
    public static void main(String args[]){
        Question17 q = new Question17();
        q.append(5);
        q.append(7);
        q.append(2);
        q.append(1);
        q.append(6);
        q.append(1);
        q.append(3);
        q.append(10);
        q.print();
        System.out.println();
        q.FindNValue(7);
    }
}
