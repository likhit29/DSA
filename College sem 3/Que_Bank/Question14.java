public class Question14 {
    class Node{
        int value;
        Node next;
        Node(int value){
            this.value = value;
        }
    }
    private Node head;
    private Node tail;
    public void append(int value){
        Node newNode = new Node(value);
        if(head == null){
            head = newNode;
            tail = newNode;
            tail.next = newNode;
        }
        else{
            tail.next = newNode;
            tail = newNode;
            tail.next = head;
        }
        
    }
    public void removeDuplicates(){
        if(head == null){
            System.out.print("Empty List");
            return;
        }
        else{
            Node slow = head;
            do{
                Node fast = slow;
                do{
                        if(fast.value == fast.next.value){
                            fast.next = fast.next.next;
                        }
                        else{
                            fast = fast.next;
                        }
                }
                while(fast.next != head);
                slow = slow.next;
            }
            while(slow != head);
            
        }
    }
    public void print(){
        Node temp = head;
        do{
            System.out.print(temp.value + " ");
            temp = temp.next;
        }
        while(temp != head);
    }
    public static void main(String args[]){
        Question14 q = new Question14();
        for(int i = 1;i <= 6;i++){
            q.append(i);
            q.append(i);
        }
        q.print();
        System.out.println();
        q.removeDuplicates();
        q.print();
    }
}
