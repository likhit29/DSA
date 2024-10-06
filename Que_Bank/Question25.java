public class Question25 {
    class Node{
        int value;
        Node next;
        Node(int value){
            this.value = value;
        }
    }
    private Node head;
    private Node tail;
    //private int length;
    Question25(){
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
    public void prepend(int value){
        Node newNode = new Node(value);
        if(head == newNode){
            head = newNode;
            tail = newNode;
        }
        else{
            newNode.next = head;
            head = newNode;
        }
        
    }
    public void print(){
        Node temp = head;
        while(temp != null){
            System.out.print(temp.value+" ");
            temp = temp.next;
        }
    }
    public void Reverse(Question25 q){
        Node temp = q.head;
        while(temp != null){
            this.prepend(temp.value);
            temp = temp.next;
        }
    }
    public void isPalindrome(Question25 q){
        Node temp1 = q.head;
        Question25 q2 = new Question25();
        q2.Reverse(q);
        Node temp2 = q2.head;
        while(temp1 != null && temp2 != null){
            if(temp1.value != temp2.value){
                System.out.println("Not a Palindrome");
                return;
            }
            else{
                temp1 = temp1.next;
                temp2 = temp2.next;
            }
        }
        System.out.print("List is Palindrome");

    }
    public static void main(String args[]){
        Question25 q = new Question25();
        q.append(1);
        q.append(2);
        q.append(2);
        q.append(1);
        q.print();
        System.out.println();
        q.isPalindrome(q);
    }
}
